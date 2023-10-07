package org.cschoell.testsupport;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.cschoell.postman.model.PostmanCollection;

import java.io.IOException;
import java.net.URL;

public class TestCollectionProvider {

    private final JsonMapper objectMapper = JsonMapper.builder()
            .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
            .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES).build();


    public PostmanCollection getCollection() {
        final URL resource = TestCollectionProvider.class.getResource("/TestCollection1.json");
        try {
            return objectMapper.readValue(resource, PostmanCollection.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
