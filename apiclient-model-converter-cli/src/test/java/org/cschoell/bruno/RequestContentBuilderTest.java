package org.cschoell.bruno;

import org.cschoell.bruno.mapper.GenericToBrunoCollectionMapper;
import org.cschoell.bruno.model.BrunoCollection;
import org.cschoell.bruno.module.writer.RequestContentBuilder;
import org.cschoell.generic.model.GCollection;
import org.cschoell.postman.mapper.PostmanToGenericCollectionMapper;
import org.cschoell.postman.model.PostmanCollection;
import org.cschoell.testsupport.TestCollectionProvider;
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