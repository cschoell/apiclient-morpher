package org.cschoell.postman.converter.postmanconverter;

import org.cschoell.bruno.BrunoConfigurationModel;
import org.cschoell.bruno.writer.BrunoConfigurationModelWriter;
import org.cschoell.convert.mapper.PostmanToBrunoCollectionMapper;
import org.cschoell.testsupport.TestCollectionProvider;

import java.io.File;
import java.io.IOException;

class ConverterRunner {


    static File targetDirectory = new java.io.File("G:\\postman\\bruno\\test\\Generated");

    static TestCollectionProvider testCollectionProvider = new TestCollectionProvider();

    private static final PostmanToBrunoCollectionMapper mapper = PostmanToBrunoCollectionMapper.INSTANCE;

    public static void main(String[] args) throws IOException {
        final BrunoConfigurationModelWriter brunoConfigurationModelWriter = new BrunoConfigurationModelWriter();
        brunoConfigurationModelWriter.writeModel(new BrunoConfigurationModel(mapper.toBrunoCollection(testCollectionProvider.getCollection(TestCollectionProvider.TestCollectionFile.postmanecho))), new File(targetDirectory, "postmanecho"));
        brunoConfigurationModelWriter.writeModel(new BrunoConfigurationModel(mapper.toBrunoCollection(testCollectionProvider.getCollection(TestCollectionProvider.TestCollectionFile.testcollection1))), new File(targetDirectory, "testcollection"));
    }

}
