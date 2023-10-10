package org.cschoell.bruno;

import org.apache.commons.io.FileSystem;
import org.apache.commons.io.FileUtils;
import org.cschoell.bruno.mapper.PostmanToBrunoCollectionMapper;
import org.cschoell.bruno.model.BrunoCollection;
import org.cschoell.bruno.model.BrunoRequestFile;
import org.cschoell.bruno.model.Folder;
import org.cschoell.postman.model.PostmanCollection;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BrunoCollectionWriter {

    private PostmanToBrunoCollectionMapper mapper = PostmanToBrunoCollectionMapper.INSTANCE;

    public void writeCollection(File targetPath, PostmanCollection collection) throws IOException {
        final BrunoCollection brunoCollection = mapper.toBrunoCollection(collection);

        brunoCollection.getRequests().forEach(brunoRequestFile -> {
            writeRequestFile(brunoRequestFile, targetPath);
        });
        brunoCollection.getFolders().forEach(folder -> {
            writeFolder(folder, targetPath);
        });

        File brunoMeta = new File(targetPath, "bruno.json");

        FileUtils.write(brunoMeta, "{\n" +
                "  \"version\": \"1\",\n" +
                "  \"name\": \""+ collection.getInfo().getName() +"\",\n" +
                "  \"type\": \"collection\"\n" +
                "}", StandardCharsets.UTF_8);
    }

    private void writeFolder(Folder folder, File parentFolder) {
        File subFolder = new File(parentFolder, folder.getFolderName());
        folder.getRequests().forEach(brunoRequestFile -> writeRequestFile(brunoRequestFile, subFolder));
        folder.getSubFolder().forEach(sub -> writeFolder(sub, subFolder));
    }

    private void writeRequestFile(BrunoRequestFile brunoRequestFile, File targetDirectory) {
        final String build = new RequestContentBuilder(brunoRequestFile).build();
        File targetFile = new File(targetDirectory, FileSystem.getCurrent().toLegalFileName(brunoRequestFile.getMeta().getName(), '_') + ".bru");
        try {
            FileUtils.write(targetFile, build, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
