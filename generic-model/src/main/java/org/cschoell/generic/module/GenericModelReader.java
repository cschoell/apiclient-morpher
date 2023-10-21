package org.cschoell.generic.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cschoell.apiclient.converter.api.ApiConfigurationType;
import org.cschoell.apiclient.converter.api.ModelReader;
import org.cschoell.generic.model.GCollection;

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
