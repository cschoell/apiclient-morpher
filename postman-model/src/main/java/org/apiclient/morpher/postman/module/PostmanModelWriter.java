package org.apiclient.morpher.postman.module;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apiclient.morpher.api.ApiConfigurationType;
import org.apiclient.morpher.api.ModelWriter;
import org.apiclient.morpher.postman.module.schematoobject.PostmanObjectMapperBuilder;

import java.io.File;
import java.io.IOException;

public class PostmanModelWriter implements ModelWriter<PostmanConfigurationModel> {
    private final JsonMapper mapper = new PostmanObjectMapperBuilder().build();

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
