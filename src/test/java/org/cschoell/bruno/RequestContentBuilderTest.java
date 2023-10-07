package org.cschoell.bruno;

import org.cschoell.bruno.mapper.PostmanToBrunoCollectionMapper;
import org.cschoell.bruno.model.BrunoCollection;
import org.cschoell.postman.model.PostmanCollection;
import org.cschoell.testsupport.TestCollectionProvider;
import org.junit.jupiter.api.Test;

class RequestContentBuilderTest {

    private PostmanToBrunoCollectionMapper mapper = PostmanToBrunoCollectionMapper.INSTANCE;
    private TestCollectionProvider testCollectionProvider = new TestCollectionProvider();

    @Test
    void name() {
        final PostmanCollection collection = testCollectionProvider.getCollection();
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