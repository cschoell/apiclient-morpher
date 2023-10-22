package org.apiclient.morpher.postman.converter.postmanconverter;

import org.apiclient.morpher.bruno.mapper.GenericToBrunoCollectionMapper;
import org.apiclient.morpher.bruno.module.BrunoConfigurationModel;
import org.apiclient.morpher.bruno.module.writer.BrunoConfigurationModelWriter;
import org.apiclient.morpher.postman.mapper.PostmanToGenericCollectionMapper;
import org.apiclient.morpher.postman.testsupport.TestCollectionProvider;

import java.io.File;
import java.io.IOException;

class ConverterRunner {


    static File targetDirectory = new File("G:\\postman\\bruno\\test\\GeneratedNew");

    static TestCollectionProvider testCollectionProvider = new TestCollectionProvider();

    private static PostmanToGenericCollectionMapper postmanMapper = PostmanToGenericCollectionMapper.INSTANCE;
    private static GenericToBrunoCollectionMapper brunoMapper = GenericToBrunoCollectionMapper.INSTANCE;

    public static void main(String[] args) throws IOException {
        final BrunoConfigurationModelWriter brunoConfigurationModelWriter = new BrunoConfigurationModelWriter();
        brunoConfigurationModelWriter.writeModel(new BrunoConfigurationModel(brunoMapper.toBrunoCollection(postmanMapper.toGenericCollection(testCollectionProvider.getCollection(TestCollectionProvider.TestCollectionFile.postmanecho)))), new File(targetDirectory, "postmanecho"));
        brunoConfigurationModelWriter.writeModel(new BrunoConfigurationModel(brunoMapper.toBrunoCollection(postmanMapper.toGenericCollection(testCollectionProvider.getCollection(TestCollectionProvider.TestCollectionFile.testcollection1)))), new File(targetDirectory, "testcollection"));
    }

}
