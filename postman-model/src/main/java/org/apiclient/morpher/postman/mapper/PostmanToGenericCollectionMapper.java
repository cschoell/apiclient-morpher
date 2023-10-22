package org.apiclient.morpher.postman.mapper;

import org.apache.commons.lang3.StringUtils;
import org.apiclient.morpher.generic.model.*;
import org.apiclient.morpher.generic.model.body.GBody;
import org.apiclient.morpher.generic.model.body.GBodyContentType;
import org.apiclient.morpher.generic.model.body.GKeyValueBody;
import org.apiclient.morpher.postman.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Mapper()
public interface PostmanToGenericCollectionMapper {

    PostmanToGenericCollectionMapper INSTANCE = Mappers.getMapper(PostmanToGenericCollectionMapper.class);

    @Mapping(target = "type", ignore = true)
    @Mapping(target = "description", source = "info.description")
    @Mapping(target = "variables", source = "variable")
    @Mapping(target = "requests", source = "item", qualifiedByName = "item")
    @Mapping(target = "folders", source = "item", qualifiedByName = "item")
    GCollection toGenericCollection(PostmanCollection in);


    @AfterMapping
    @Named("item")
    default List<GRequest> afterRequestsMapping(@MappingTarget List<GRequest> requests) {
        return requests.stream().filter(Objects::nonNull).toList();
    }

    @AfterMapping
    @Named("item")
    default List<GFolder> afterFolderMapping(@MappingTarget List<GFolder> folders) {
        return folders.stream().filter(Objects::nonNull).toList();
    }

    @Named("item")
    default GRequest toRequest(PostmanPolymorphicBase fromPoly) {
        if (fromPoly instanceof Item) {
            return toGenericRequest((Item) fromPoly);
        }
        return null;
    }

    @Named("item")
    default GFolder toRequestFolder(PostmanPolymorphicBase fromPoly) {
        if (fromPoly instanceof VirtualFolder) {
            return toFolder((VirtualFolder) fromPoly);
        }
        return null;
    }

    @Mapping(target = "requests", source = "item", qualifiedByName = "item")
    @Mapping(target = "subFolders", source = "item", qualifiedByName = "item")
    GFolder toFolder(VirtualFolder from);

    @Mapping(target = "tests", ignore = true)
    @Mapping(target = "asserts", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "proxy", ignore = true)
    @Mapping(target = "preRequestVars", ignore = true)
    @Mapping(target = "preRequestScript", ignore = true)
    @Mapping(target = "postResponseVars", ignore = true)
    @Mapping(target = "postResponseScript", ignore = true)
    @Mapping(target = "url.raw", source = "request.url")
    @Mapping(target = "method", source = "request.method")
    @Mapping(target = "certificate", source = "request.certificate")
    @Mapping(target = "query", source = "request.url.query")
    @Mapping(target = "meta", source = "item")
    @Mapping(target = "header", source = "request.header")
    @Mapping(target = "body", source = "request.body")
    @Mapping(target = "auth", source = "request.auth")
    GRequest toGenericRequest(Item item);

    @Mapping(target = "type", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "text", source = "raw")
    @Mapping(target = "contentType", source = "mode")
    GBody toBody(Body body);

    default GKeyValueBody mapUrlEncoded(List<Urlencoded> value) {
        if (value == null || value.isEmpty()) return null;
        GKeyValueBody body = new GKeyValueBody();
        for (Urlencoded urlencoded : value) {
            body.getKeyValueBody().put(urlencoded.getKey(), toValue(urlencoded));
        }
        return body;
    }
    default GKeyValueBody mapFormdatum(List<Formdatum> value) {
        if (value == null || value.isEmpty()) return null;
        GKeyValueBody body = new GKeyValueBody();
        for (Formdatum formdatum : value) {
            body.getKeyValueBody().put(formdatum.getKey(), toValue(formdatum));
        }
        return body;
    }

    @Mapping(target = "type", ignore = true)
    GValue toValue(Urlencoded source);

    @Mapping(target = "type", ignore = true)
    GValue toValue(Formdatum source);

    @AfterMapping
    default void afterToRequestFile(@MappingTarget GRequest request, Item item) {
        handleEvents(request, item);
        final Body.Mode mode = item.getRequest().getBody().getMode();
        GBodyContentType type = toBodyType(mode);
        if (mode == Body.Mode.RAW) {
            type = mapBodyLanguage(item.getRequest().getBody().getAdditionalProperties());
            type = mapBodyLanguageViaHeader(type, item.getRequest().getHeader());
        }
        request.getBody().setContentType(type);

    }

    default void handleEvents(GRequest request, Item item) {
        final List<Event> events = item.getEvent();
        for (Event event : events) {
            final GScript script = toGScript(event.getScript());
            script.setDisabled(event.getDisabled());
            switch (event.getListen()) {
                case "test" -> {
                    request.setTests(script);
                }
                case "prerequest" -> {
                    request.setPreRequestScript(script);
                }
                case "postresponse" -> {
                    request.setPostResponseScript(script);
                }
            }
        }
    }


    @Mapping(target = "disabled", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "srcUrl", source = "src")
    @Mapping(target = "scriptOriginClient", constant = "postman")
    @Mapping(target = "contentType", source = "type")
    GScript toGScript(Script script);

    @Mapping(target = "type", ignore = true)
    @Mapping(target = "disabled", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "additionalProperties", ignore = true)
    @Mapping(target = "value", source = "val")
    GValue toValue(String val);

    default void toValue(@MappingTarget GValue value, List<String> val) {
        value.setValue(mapStringListToString(val));
    }

    @Mapping(target = "value", source = "val")
    default String mapStringListToString(List<String> val) {
        return StringUtils.join(val, "\n");
    }

    @Mapping(target = "description", ignore = true)
    @Mapping(target = "authAttributes", ignore = true)
    @Mapping(target = "authType", source = "type")
    GAuth mapAuth(Auth value);

    @AfterMapping
    default void afterAuthMapping(@MappingTarget GAuth target, Auth source) {
        List<AuthAttribute> authAttributes;
        switch (source.getType()) {
            case APIKEY -> authAttributes = source.getApikey();
            case AWSV_4 -> authAttributes = source.getAwsv4();
            case BASIC -> authAttributes = source.getBasic();
            case BEARER -> authAttributes = source.getBearer();
            case DIGEST -> authAttributes = source.getDigest();
            case EDGEGRID -> authAttributes = source.getEdgegrid();
            case HAWK -> authAttributes = source.getHawk();
            case OAUTH_1 -> authAttributes = source.getOauth1();
            case OAUTH_2 -> authAttributes = source.getOauth2();
            case NTLM -> authAttributes = source.getNtlm();
            default ->  authAttributes = Collections.emptyList();
        }
        target.setAuthAttributes(toAuthAttributes(authAttributes));
    }

    List<GAuthAttribute> toAuthAttributes(List<AuthAttribute> apikey);


    @Named("language")
    default GBodyContentType mapBodyLanguage(Map<String, AdditionalProperty> value) {
        if (value == null) return GBodyContentType.text;
        final AdditionalProperty raw = value.get("raw");
        if (raw == null) return GBodyContentType.text;
        String language = raw.getProperties().get("language");
        return StringUtils.isBlank(language) ? GBodyContentType.text : toBodyType(language);
    }

    default GBodyContentType mapBodyLanguageViaHeader(GBodyContentType currentType, List<Header> headers) {
        String contentHeader = headers.stream().filter(header -> StringUtils.equalsIgnoreCase(header.getKey(), "content-type")).map(Header::getValue).findFirst().orElse(null);
        if (StringUtils.contains(contentHeader, "json")) return GBodyContentType.json;
        if (StringUtils.contains(contentHeader, "xml")) return GBodyContentType.xml;
        if (StringUtils.contains(contentHeader, "text")) return GBodyContentType.text;
        return currentType;
    }

    default GBodyContentType toBodyType(Body.Mode mode) {
        return switch (mode) {
            case FILE -> GBodyContentType.none;
            case RAW -> GBodyContentType.text;
            case GRAPHQL -> GBodyContentType.graphql;
            case FORMDATA -> GBodyContentType.multipartForm;
            case URLENCODED -> GBodyContentType.formUrlencoded;
        };
    }

    default GBodyContentType toBodyType(String language) {
        return switch (language) {
            case "xml" -> GBodyContentType.xml;
            case "text" -> GBodyContentType.text;
            case "json" -> GBodyContentType.json;
            default -> GBodyContentType.text;
        };
    }


    default String buildUrlString(Url url) {
        if (url == null) return null;
        if (url.getHost() == null || url.getHost().isEmpty()) return url.getRaw();
        String portString = StringUtils.isNotBlank(url.getPort()) ? ":" + url.getPort() : "";
        String queryString = url.getQuery().isEmpty() ? "" : "?" + url.getQuery().stream().map(query -> query.getKey() + "=" + query.getValue()).collect(Collectors.joining("&"));
        return url.getProtocol() + "://" + StringUtils.join(url.getHost(), ".") + portString + "/" + StringUtils.join(url.getPath(), "/") + queryString;
    }

}
