package org.apiclient.morpher.generic.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apiclient.morpher.api.ApiConfigurationType;
import org.apiclient.morpher.api.ModelReader;
import org.apiclient.morpher.generic.model.GCollection;

import java.io.File;
import java.io.IOException;

public class GenericModelReader implements ModelReader<GenericConfigurationModel> {
    private final ObjectMapper mapper = new GenericObjectMapperBuilder().build();
    @Override
    public GenericConfigurationModel readModel(File source) {
        try {
            final GCollection collection = mapper.readValue(source, GCollection.class);
            return new GenericConfigurationModel(collection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiConfigurationType getType() {
        return ApiConfigurationType.generic;
    }
}
