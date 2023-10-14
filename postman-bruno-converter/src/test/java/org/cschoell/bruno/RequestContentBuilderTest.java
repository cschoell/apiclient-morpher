package org.cschoell.bruno;

import org.cschoell.convert.mapper.PostmanToBrunoCollectionMapper;
import org.cschoell.bruno.model.BrunoCollection;
import org.cschoell.postman.model.PostmanCollection;
import org.cschoell.testsupport.TestCollectionProvider;
import org.junit.jupiter.api.Test;

class RequestContentBuilderTest {

    private PostmanToBrunoCollectionMapper mapper = PostmanToBrunoCollectionMapper.INSTANCE;
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
        final BrunoCollection brunoCollection = mapper.toBrunoCollection(collection);
        brunoCollection.getRequests().forEach(brunoRequestFile -> {
            mapItem(new RequestContentBuilder(brunoRequestFile));
        });
    }

    private void mapItem(RequestContentBuilder builder) {
        final String requestConfig = builder.build();
        System.out.println(requestConfig);
    }

}