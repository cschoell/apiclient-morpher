package org.cschoell.postman.converter.postmanconverter;

import org.cschoell.bruno.BrunoCollectionWriter;
import org.cschoell.bruno.mapper.PostmanToBrunoCollectionMapper;
import org.cschoell.testsupport.TestCollectionProvider;

import java.io.File;
import java.io.IOException;

class ConverterRunner {


    static File targetDirectory = new java.io.File("G:\\postman\\bruno\\test\\Generated");

    static TestCollectionProvider testCollectionProvider = new TestCollectionProvider();

    private PostmanToBrunoCollectionMapper mapper = PostmanToBrunoCollectionMapper.INSTANCE;

    public static void main(String[] args) throws IOException {
        final BrunoCollectionWriter brunoCollectionWriter = new BrunoCollectionWriter();
        brunoCollectionWriter.writeCollection(new File(targetDirectory, "postmanecho"), testCollectionProvider.getCollection(TestCollectionProvider.TestCollectionFile.postmanecho));
        brunoCollectionWriter.writeCollection(new File(targetDirectory, "testcollection"), testCollectionProvider.getCollection(TestCollectionProvider.TestCollectionFile.testcollection1));
    }

}
