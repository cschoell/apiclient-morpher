package org.apiclient.morpher.bruno.module.reader;

import org.apiclient.morpher.api.ApiConfigurationType;
import org.apiclient.morpher.api.ModelReader;
import org.apiclient.morpher.bruno.module.BrunoConfigurationModel;
import org.apiclient.morpher.bruno.model.BrunoCollection;

import java.io.File;

public class BrunoConfigurationModelReader implements ModelReader<BrunoConfigurationModel> {
    @Override
    public BrunoConfigurationModel readModel(File source) {
        final BrunoCollection brunoCollection = new BrunoCollection();
        new BrunoCollectionParser(brunoCollection, source).readCollection();
        return new BrunoConfigurationModel(brunoCollection);
    }

    @Override
    public ApiConfigurationType getType() {
        return ApiConfigurationType.bruno;
    }

    public static void main(String[] args) {
        BrunoConfigurationModelReader reader = new BrunoConfigurationModelReader();
        reader.readModel(new File("G:\\postman\\bruno\\test\\GeneratedByCli\\"));
    }
}
