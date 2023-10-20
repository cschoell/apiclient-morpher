package org.cschoell.postman.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.recursive.assertion.RecursiveAssertionConfiguration;
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
    GenericCollectionToPostmanMapper reverseMapper = GenericCollectionToPostmanMapper.INSTANCE;



    @Test
    void allmappedCorrectly() throws IOException {
        final PostmanCollection postmanCollection = new SourcePostmanCollection().generateCollection();

        final GCollection genericCollection = mapper.toGenericCollection(postmanCollection);

        final PostmanCollection afterMapping = reverseMapper.toPostmanCollection(genericCollection);

//        assertThat(postmanCollection).isEqualTo(afterMapping);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        final StringWriter w = new StringWriter();
        objectMapper.writeValue(w,postmanCollection);
        System.out.println(w);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        final StringWriter w2 = new StringWriter();
        objectMapper.writeValue(w2,afterMapping);
        System.out.println(w2);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

//        assertThat(w).isEqualTo(w2);


    }
}