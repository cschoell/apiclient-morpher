package org.cschoell.postman.converter.postmanconverter;

import org.apache.commons.io.FileUtils;
import org.cschoell.bruno.RequestContentBuilder;
import org.cschoell.bruno.mapper.PostmanToBrunoCollectionMapper;
import org.cschoell.bruno.model.BrunoCollection;
import org.cschoell.postman.model.PostmanCollection;
import org.cschoell.testsupport.TestCollectionProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

class ConverterRunnerMain {


    File targetDirectory = new java.io.File("G:\\postman\\bruno\\test\\Generated");

    TestCollectionProvider testCollectionProvider = new TestCollectionProvider();

    private PostmanToBrunoCollectionMapper mapper = PostmanToBrunoCollectionMapper.INSTANCE;

    public static void main(String[] args) {
        new ConverterRunnerMain().run();
    }

    private void run() {
        final PostmanCollection collection = testCollectionProvider.getCollection();
        final BrunoCollection brunoCollection = mapper.toBrunoCollection(collection);

        brunoCollection.getRequests().forEach(brunoRequestFile -> {
            final String build = new RequestContentBuilder(brunoRequestFile).build();
            File targetFile = new File(targetDirectory, brunoRequestFile.getMeta().getName() + ".bru");
            try {
                FileUtils.write(targetFile, build, StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
