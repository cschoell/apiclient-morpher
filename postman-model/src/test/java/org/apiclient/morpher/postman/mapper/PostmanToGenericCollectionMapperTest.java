package org.apiclient.morpher.postman.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apiclient.morpher.generic.model.GCollection;
import org.apiclient.morpher.postman.model.PostmanCollection;
import org.apiclient.morpher.postman.module.schematoobject.PostmanObjectMapperBuilder;
import org.apiclient.morpher.postman.testsupport.TestCollectionProvider;
import org.apiclient.morpher.properties.PropertyAccessReport;
import org.apiclient.morpher.properties.PropertyAccessDescription;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.SortedSet;

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

        PropertyAccessReport propertyAccessReport = PropertyAccessReport.getInstance();
        final SortedSet<PropertyAccessDescription> convertedToPropertyDescriptions = propertyAccessReport.getConvertedToPropertyDescriptions();
//        propertyAccessReport.getPropertiesAccessed().forEach(System.out::println);


        convertedToPropertyDescriptions.forEach(System.out::println);

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