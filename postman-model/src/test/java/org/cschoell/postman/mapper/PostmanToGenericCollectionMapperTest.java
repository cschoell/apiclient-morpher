package org.cschoell.postman.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cschoell.generic.model.GCollection;
import org.cschoell.postman.model.PostmanCollection;
import org.cschoell.postman.module.schematoobject.PostmanObjectMapperBuilder;
import org.cschoell.postman.testsupport.TestCollectionProvider;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.*;

class PostmanToGenericCollectionMapperTest {

    ObjectMapper objectMapper = new PostmanObjectMapperBuilder().build();

    TestCollectionProvider provider = TestCollectionProvider.instance();
    PostmanToGenericCollectionMapper mapper = PostmanToGenericCollectionMapper.INSTANCE;



    @Test
    void allmappedCorrectly() throws IOException {
        final PostmanCollection postmanCollection = new SourcePostmanCollection().generateCollection();
        final GCollection genericCollection = mapper.toGenericCollection(postmanCollection);

        final StringWriter w = new StringWriter();
        objectMapper.writeValue(w,genericCollection);

        System.out.println(w);

    }
}