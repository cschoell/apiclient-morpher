package org.cschoell.postman;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cschoell.apiclient.converter.api.ApiConfigurationType;
import org.cschoell.apiclient.converter.api.ModelReader;
import org.cschoell.postman.model.PostmanCollection;
import org.cschoell.postman.schematoobject.PostmanObjectMapperBuilder;

import java.io.File;
import java.io.IOException;

public class PostmanModelReader implements ModelReader<PostmanConfigurationModel> {
    private final ObjectMapper mapper = new PostmanObjectMapperBuilder().build();
    @Override
    public PostmanConfigurationModel readModel(File source) {
        try {
            final PostmanCollection postmanCollection = mapper.readValue(source, PostmanCollection.class);
            return new PostmanConfigurationModel(postmanCollection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiConfigurationType getType() {
        return ApiConfigurationType.postman;
    }
}
