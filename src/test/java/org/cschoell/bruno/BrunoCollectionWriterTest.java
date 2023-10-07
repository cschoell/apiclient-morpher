package org.cschoell.bruno;

import org.cschoell.postman.model.Item;
import org.cschoell.postman.model.PostmanCollection;
import org.cschoell.testsupport.TestCollectionProvider;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BrunoCollectionWriterTest {

    BrunoCollectionWriter underTest = new BrunoCollectionWriter();
    private TestCollectionProvider testCollectionProvider = new TestCollectionProvider();

    @Test
    void name() {
        final PostmanCollection collection = testCollectionProvider.getCollection();
        final Item item = collection.getItem().get(0);
        final String requestConfig = underTest.createRequestConfig(item);
        System.out.println(requestConfig);
    }
}