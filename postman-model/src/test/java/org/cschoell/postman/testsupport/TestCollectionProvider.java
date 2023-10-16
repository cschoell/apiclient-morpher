package org.cschoell.postman.testsupport;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.cschoell.postman.model.PostmanCollection;
import org.cschoell.postman.module.schematoobject.PostmanObjectMapperBuilder;

import java.io.IOException;
import java.net.URL;

public class TestCollectionProvider {

    private static TestCollectionProvider myInstance = new TestCollectionProvider();
    private final JsonMapper objectMapper = new PostmanObjectMapperBuilder().build();

    public static TestCollectionProvider instance() {
        return myInstance;
    }

    public static enum TestCollectionFile {
        postmanecho("/postmanecho.json"),
        testcollection1("/TestCollection1.json");
        String file;

        TestCollectionFile(String file) {
            this.file = file;
        }
    }


    public PostmanCollection getCollection(TestCollectionFile collection) {
        final URL resource = TestCollectionProvider.class.getResource(collection.file);
        try {
            return objectMapper.readValue(resource, PostmanCollection.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
