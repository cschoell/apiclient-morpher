package org.apiclient.morpher.postman.mapper;

import org.apache.commons.lang3.StringUtils;
import org.apiclient.morpher.generic.model.*;
import org.apiclient.morpher.generic.model.body.GBody;
import org.apiclient.morpher.generic.model.body.GBodyContentType;
import org.apiclient.morpher.generic.model.body.GKeyValueBody;
import org.apiclient.morpher.postman.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Mapper(imports = PostmanToGenericCollectionMapper.class)
public interface GenericCollectionToPostmanMapper {

    GenericCollectionToPostmanMapper INSTANCE = Mappers.getMapper(GenericCollectionToPostmanMapper.class);


    @Mapping(target = "variable", ignore = true)
    @Mapping(target = "event", ignore = true)
    @Mapping(target = "item", source = ".", qualifiedByName = "collectItems")
    PostmanCollection toPostmanCollection(GCollection in);

    @Named("collectItems")
    default List<PostmanPolymorphicBase> collectItems(GCollection in) {
        final List<PostmanPolymorphicBase> items = mapFoldersToPostmanList(in.getFolders());
        items.addAll(mapToPostmanList(in.getRequests()));
        return items;
    }

    @Mapping(target = "event", ignore = true)
    @Mapping(target = "item", source = ".", qualifiedByName = "collectItemsFromFolder")
    VirtualFolder toFolder(GFolder gFolder);

    @Named("collectItemsFromFolder")
    default List<Item> collectItemsFromFolder(GFolder in) {
        return mapToPostmanList(in.getRequests());
    }

    default List<PostmanPolymorphicBase> mapFoldersToPostmanList(List<GFolder> folders) {
        return folders.stream().map(this::toFolder).collect(Collectors.toList());
    }

    @Mapping(target = "oauth2", source = "authAttributes", conditionExpression = "java(gAuth.getAuthType() == GAuth.Type.OAUTH_2)")
    @Mapping(target = "oauth1", source = "authAttributes", conditionExpression = "java(gAuth.getAuthType() == GAuth.Type.OAUTH_1)")
    @Mapping(target = "ntlm", source = "authAttributes", conditionExpression = "java(gAuth.getAuthType() == GAuth.Type.NTLM)")
    @Mapping(target = "hawk", source = "authAttributes", conditionExpression = "java(gAuth.getAuthType() == GAuth.Type.HAWK)")
    @Mapping(target = "edgegrid", source = "authAttributes", conditionExpression = "java(gAuth.getAuthType() == GAuth.Type.EDGEGRID)")
    @Mapping(target = "digest", source = "authAttributes", conditionExpression = "java(gAuth.getAuthType() == GAuth.Type.DIGEST)")
    @Mapping(target = "bearer", source = "authAttributes", conditionExpression = "java(gAuth.getAuthType() == GAuth.Type.BEARER)")
    @Mapping(target = "basic", source = "authAttributes", conditionExpression = "java(gAuth.getAuthType() == GAuth.Type.BASIC)")
    @Mapping(target = "awsv4", source = "authAttributes", conditionExpression = "java(gAuth.getAuthType() == GAuth.Type.AWSV_4)")
    @Mapping(target = "apikey", ignore = true)
    @Mapping(target = "type", source = "authType")
    Auth toAuth(GAuth gAuth);

    @Named("item")
    default List<Item> mapToPostmanList(List<GRequest> value) {
        return value.stream().map(this::toItem).collect(Collectors.toList());
    }

    @Mapping(target = "event", source = ".")
    @Mapping(target = "request", source = ".")
    @Named("item")
    Item toItem(GRequest gRequest);

    @InheritInverseConfiguration
    @Mapping(target = "url", source = "url.raw")
    Request toRequest(GRequest from);


    default List<Event> toEventList(GRequest request) {
        List<Event> events = new ArrayList<>();
        if (request.getTests() != null) events.add(toEvent(request.getTests(), "test"));
        if (request.getPostResponseScript() != null) events.add(toEvent(request.getPostResponseScript(), "postresponse"));
        if (request.getPreRequestScript() != null) events.add(toEvent(request.getPreRequestScript(), "prerequest"));
        return events;
    }

    @Mapping(target = "listen", source = "listen")
    @Mapping(target = "script.src", source = "from.srcUrl")
    @Mapping(target = "script.type", source = "from.contentType")
    @Mapping(target = "script.exec", source = "from.exec")
    Event toEvent(GScript from, String listen);


    default List<String> toLines(String from) {
        return from == null ? Collections.emptyList() : from.lines().toList();
    }

    default Url toUrl(String from) {
        try {
            URL url = new URL(from);
            return new Url(from,
                    url.getProtocol(),
                    Arrays.stream(StringUtils.split(url.getHost(), ".")).collect(Collectors.toList()),
                    Arrays.stream(StringUtils.split(url.getPath(), "/")).collect(Collectors.toList()),
                    url.getPort() >= 0 ? String.valueOf(url.getPort()) : "",
                    toQueries(url.getQuery()),
                    null,
                    Collections.emptyList(),
                    new HashMap<>()
            );
        } catch (MalformedURLException e) {
            final Url url = new Url();
            url.setRaw(from);
            return url;
        }
    }

    default List<Query> toQueries(String query) {
        return Arrays.stream(StringUtils.split(query, "&")).map(this::toQuery).toList();
    }

    default Query toQuery(String s) {
        final String[] keyvalue = StringUtils.split(s, "=", 2);
        Query q = new Query();
        q.setKey(keyvalue[0]);
        if (keyvalue.length > 1) {
            q.setValue(keyvalue[1]);
        }
        return q;
    }


    @Mapping(target = "disabled", ignore = true)
    @Mapping(target = "options", ignore = true)
    @Mapping(target = "raw", source = "text.value")
    @Mapping(target = "mode", source = "contentType")
    Body toBody(GBody gBody);

    @AfterMapping
    default void afterToBody(@MappingTarget Body to, GBody from) {
    }

    default Body.Mode toBodyMode(GBodyContentType contentType) {
        if (contentType == null) return null;
        Body.Mode mode = switch (contentType) {
            case none -> null;
            case json -> Body.Mode.RAW;
            case text -> Body.Mode.RAW;
            case xml -> Body.Mode.RAW;
            case formUrlencoded -> Body.Mode.URLENCODED;
            case multipartForm -> Body.Mode.FORMDATA;
            case graphql -> Body.Mode.GRAPHQL;
        };
        return mode;
    }


    default List<Urlencoded> mapListToUrlEncoded(GKeyValueBody value) {
        if (value == null) return Collections.emptyList();
        return value.getKeyValueBody().entrySet().stream().map(this::toUrlencoded).collect(Collectors.toList());
    }

    default List<Formdatum> mapListToFormdata(GKeyValueBody value) {
        if (value == null) return Collections.emptyList();
        return value.getKeyValueBody().entrySet().stream().map(this::toFormData).collect(Collectors.toList());
    }

    @Mapping(target = "description", source = "value.description")
    @Mapping(target = "disabled", source = "value.disabled")
    @Mapping(target = "additionalProperties", source = "value.additionalProperties")
    @Mapping(target = "value", source = "value.value")
    Urlencoded toUrlencoded(Map.Entry<String, GValue> entry);


    @Mapping(target = "contentType", ignore = true)
    @Mapping(target = "description", source = "value.description")
    @Mapping(target = "disabled", source = "value.disabled")
    @Mapping(target = "additionalProperties", source = "value.additionalProperties")
    @Mapping(target = "value", source = "value.value")
    Formdatum toFormData(Map.Entry<String, GValue> entry);
}
