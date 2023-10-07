package org.cschoell.bruno;

import org.cschoell.postman.model.PostmanCollection;

import java.io.File;

public class BrunoCollectionWriter {

    public void writeCollection(File targetPath, PostmanCollection collection) {
        if (targetPath.exists()) {
            targetPath.mkdirs();
        }
        collection.getRequestItem().forEach(item -> {
//            String fileContent = createRequestConfig(item);

            final String name = item.getName();
            File bruFile = new File(targetPath, name + ".bru");



        });
    }



}
