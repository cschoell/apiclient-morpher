package org.apiclient.morpher.bruno.module.writer;

import org.apache.commons.io.FileSystem;
import org.apache.commons.io.FileUtils;
import org.apiclient.morpher.api.ApiConfigurationType;
import org.apiclient.morpher.api.ModelWriter;
import org.apiclient.morpher.bruno.module.BrunoConfigurationModel;
import org.apiclient.morpher.bruno.model.BrunoCollection;
import org.apiclient.morpher.bruno.model.BrunoRequestFile;
import org.apiclient.morpher.bruno.model.Folder;

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
