package org.cschoell.bruno.writer;

import org.apache.commons.io.FileSystem;
import org.apache.commons.io.FileUtils;
import org.cschoell.apiclient.converter.api.ApiConfigurationType;
import org.cschoell.apiclient.converter.api.ModelWriter;
import org.cschoell.bruno.BrunoConfigurationModel;
import org.cschoell.bruno.RequestContentBuilder;
import org.cschoell.bruno.model.BrunoCollection;
import org.cschoell.bruno.model.BrunoRequestFile;
import org.cschoell.bruno.model.Folder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BrunoConfigurationModelWriter implements ModelWriter<BrunoConfigurationModel> {


    @Override
    public void writeModel(BrunoConfigurationModel model, File targetPath) {
        try {
            BrunoCollection brunoCollection = model.getContent();
            brunoCollection.getRequests().forEach(brunoRequestFile -> {
                writeRequestFile(brunoRequestFile, targetPath);
            });
            brunoCollection.getFolders().forEach(folder -> {
                writeFolder(folder, targetPath);
            });

            File brunoMeta = new File(targetPath, "bruno.json");


            FileUtils.write(brunoMeta, "{\n" +
                    "  \"version\": \"1\",\n" +
                    "  \"name\": \"" + brunoCollection.getMeta().getName() + "\",\n" +
                    "  \"type\": \"collection\"\n" +
                    "}", StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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


    @Override
    public ApiConfigurationType getType() {
        return ApiConfigurationType.bruno;
    }
}
