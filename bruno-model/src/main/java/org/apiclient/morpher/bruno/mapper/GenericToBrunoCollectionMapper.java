package org.apiclient.morpher.bruno.mapper;

import org.apiclient.morpher.bruno.model.*;
import org.apiclient.morpher.generic.model.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

@Mapper()
public interface GenericToBrunoCollectionMapper {

    GenericToBrunoCollectionMapper INSTANCE = Mappers.getMapper(GenericToBrunoCollectionMapper.class);

    @Mapping(target = "meta.seq", source = "info.version.minor")
    @Mapping(target = "meta.type", constant = "http")
    BrunoCollection toBrunoCollection(GCollection in);

    @Mapping(target = "xmlBody", source = "body.text", conditionExpression = "java(request.getBody().getContentType() == GBodyContentType.xml)")
    @Mapping(target = "textBody", source = "body.text", conditionExpression = "java(request.getBody().getContentType() == GBodyContentType.text)")
    @Mapping(target = "request", ignore = true)
    @Mapping(target = "request.body", source = "body.contentType")
    @Mapping(target = "request.auth", source = "auth.authType")
    @Mapping(target = "request.url", source = "url.raw")
    @Mapping(target = "request.method", source = "method")
    @Mapping(target = "urlEncodedBody", source = "body.urlencoded.keyValueBody")
    @Mapping(target = "multipartFormBody", source = "body.formdata.keyValueBody")
    @Mapping(target = "jsonBody", source = "body.text", conditionExpression = "java(request.getBody().getContentType() == GBodyContentType.json)")
    @Mapping(target = "headers", source = "header")
    @Mapping(target = "asserts", source = "asserts")
    @Mapping(target = "graphqlBody", source = "body.graphql.query")
    @Mapping(target = "graphqlVarsBody", source = "body.graphql.variables")
    BrunoRequestFile toBrunoRequestFile(GRequest request);

    @AfterMapping
    default void afterToBrunoRequestFile(@MappingTarget BrunoRequestFile to, GRequest from) {
        System.out.println(to);
    }

    default FormBody toFormBody(Map<String, GValue> value) {
        if(value == null || value.isEmpty()) return null;
        FormBody formBody = new FormBody();
        value.forEach((s, value1) -> formBody.put(s, value1.getValue()));
        return formBody;
    }

    default Headers mapHeaders(List<GHeader> value) {
        Headers headers = new Headers();
        value.forEach(gHeader -> headers.put(gHeader.getKey(), gHeader.getValue()));
        return headers;
    }

    default AuthType mapToAuthType(GAuth.Type from) {
        return switch (from) {
            case NOAUTH -> AuthType.none;
            case BASIC -> AuthType.basic;
            case BEARER -> AuthType.bearer;
            default -> AuthType.none;
        };
    }

    @Mapping(target = "value", source = "value")
    @Mapping(target = "bodyType", constant = "text")
    RawBody mapRawBody(String value);

    default Query mapQuery(List<GQuery> value) {
        final Query query = new Query();
        value.forEach(query1 -> query.put(query1.getKey(), query1.getValue()));
        return query;
    }


    Auth mapAuth(GAuth value);

}
