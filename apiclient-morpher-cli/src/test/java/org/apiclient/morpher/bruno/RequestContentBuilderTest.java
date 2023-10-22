package org.apiclient.morpher.bruno;

import org.apiclient.morpher.bruno.mapper.GenericToBrunoCollectionMapper;
import org.apiclient.morpher.bruno.model.BrunoCollection;
import org.apiclient.morpher.bruno.module.writer.RequestContentBuilder;
import org.apiclient.morpher.generic.model.GCollection;
import org.apiclient.morpher.postman.mapper.PostmanToGenericCollectionMapper;
import org.apiclient.morpher.postman.model.PostmanCollection;
import org.apiclient.morpher.postman.testsupport.TestCollectionProvider;
import org.junit.jupiter.api.Test;

class RequestContentBuilderTest {

    private PostmanToGenericCollectionMapper postmanMapper = PostmanToGenericCollectionMapper.INSTANCE;
    private GenericToBrunoCollectionMapper brunoMapper = GenericToBrunoCollectionMapper.INSTANCE;
    private TestCollectionProvider testCollectionProvider = new TestCollectionProvider();

    @Test
    void runPostmanEcho() {
        final PostmanCollection collection = testCollectionProvider.getCollection(TestCollectionProvider.TestCollectionFile.postmanecho);
        runCollection(collection);

    }

    @Test
    void runTestCollection1() {
        final PostmanCollection collection = testCollectionProvider.getCollection(TestCollectionProvider.TestCollectionFile.testcollection1);
        runCollection(collection);

    }

    private void runCollection(PostmanCollection collection) {
        final GCollection genericCollection = postmanMapper.toGenericCollection(collection);
        final BrunoCollection brunoCollection = brunoMapper.toBrunoCollection(genericCollection);
        brunoCollection.getRequests().forEach(brunoRequestFile -> {
            mapItem(new RequestContentBuilder(brunoRequestFile));
        });
    }

    private void mapItem(RequestContentBuilder builder) {
        final String requestConfig = builder.build();
        System.out.println(requestConfig);
    }

}