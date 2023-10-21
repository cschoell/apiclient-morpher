package org.cschoell.bruno.mapper;

import org.cschoell.bruno.model.*;
import org.cschoell.generic.model.*;
import org.cschoell.generic.model.body.GKeyValueBody;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(imports = GenericToBrunoCollectionMapper.class)
public interface BrunoToGenericCollectionMapper {

    BrunoToGenericCollectionMapper INSTANCE = Mappers.getMapper(BrunoToGenericCollectionMapper.class);

    @InheritInverseConfiguration
    GCollection toGenericCollection(BrunoCollection in);

    @InheritInverseConfiguration
    @Mapping(target = "body.text.value", source = "textBody.value")
    @Mapping(target = "body.formdata", source = "multipartFormBody")
    @Mapping(target = "body.urlencoded", source = "urlEncodedBody")
    @Mapping(target = "body.graphql", source = "graphqlBody")
    @Mapping(target = "header", source = "headers")
    @Mapping(target = "url.raw", source = "request.url")
    GRequest toGenericRequest(BrunoRequestFile from);



    default GKeyValueBody mapFromFormBody(FormBody value) {
        if(value == null || value.isEmpty()) return null;
        Map<String, GValue> map = new LinkedHashMap<>();
        value.forEach((s, s2) -> map.put(s, new GValue(s2)));
        return new GKeyValueBody(map);
    }

    default List<GHeader> mapHeaderList(Headers value) {
        List<GHeader> headers = new LinkedList<>();
        value.forEach((key, val) -> headers.add(new GHeader(key, val)));
        return headers;
    }

    default GAuth.Type mapToGAuthType(AuthType from) {
        return switch (from) {
            case none  -> GAuth.Type.NOAUTH;
            case basic  -> GAuth.Type.BASIC;
            case bearer  -> GAuth.Type.BEARER;
        };
    }

    default List<GQuery> mapToQueryList(Query value) {
        if (value == null) return Collections.emptyList();
        List<GQuery> queries = new LinkedList<>();
        value.forEach((s, s2) -> queries.add(new GQuery(s, s2, false)));
        return queries;
    }


    @Mapping(target = "authType", source = "type")
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "authAttributes", source = ".")
    @InheritInverseConfiguration
    GAuth mapGAuth(Auth value);

    default List<GAuthAttribute> mapAuthAttributes(Auth from) {
        if (from == null) return null;
        return from.entrySet().stream().map(this::mapFromEntry).collect(Collectors.toList());
    }

    GAuthAttribute mapFromEntry(Map.Entry<String, String> from);

}
