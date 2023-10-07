package org.cschoell.testsupport;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.cschoell.postman.converter.PostmanObjectMapperBuilder;
import org.cschoell.postman.model.PostmanCollection;

import java.io.IOException;
import java.net.URL;

public class TestCollectionProvider {

    private final JsonMapper objectMapper = new PostmanObjectMapperBuilder().build();


    public PostmanCollection getCollection() {
        final URL resource = TestCollectionProvider.class.getResource("/postmanecho.json");
        try {
            return objectMapper.readValue(resource, PostmanCollection.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
