package org.apiclient.morpher.generic.module;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apiclient.morpher.api.ApiConfigurationType;
import org.apiclient.morpher.api.ModelWriter;

import java.io.File;
import java.io.IOException;

public class GenericModuleWriter implements ModelWriter<GenericConfigurationModel> {
    private static JsonMapper mapper = new GenericObjectMapperBuilder().build();


    @Override
    public void writeModel(GenericConfigurationModel model, File target) {
        try {
            mapper.writeValue(target, model.getContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiConfigurationType getType() {
        return ApiConfigurationType.generic;
    }
}
