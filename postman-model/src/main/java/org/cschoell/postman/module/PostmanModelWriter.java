package org.cschoell.postman.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cschoell.apiclient.converter.api.ApiConfigurationType;
import org.cschoell.apiclient.converter.api.ModelWriter;
import org.cschoell.postman.module.schematoobject.PostmanObjectMapperBuilder;

import java.io.File;
import java.io.IOException;

public class PostmanModelWriter implements ModelWriter<PostmanConfigurationModel> {
    private final ObjectMapper mapper = new PostmanObjectMapperBuilder().build();

    @Override
    public void writeModel(PostmanConfigurationModel model, File target) {
        try {
            mapper.writeValue(target, model.getContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiConfigurationType getType() {
        return ApiConfigurationType.postman;
    }
}
