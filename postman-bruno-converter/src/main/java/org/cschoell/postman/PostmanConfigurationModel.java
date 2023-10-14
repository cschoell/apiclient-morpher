package org.cschoell.postman;

import lombok.extern.slf4j.Slf4j;
import org.cschoell.apiclient.converter.api.ApiConfigurationType;
import org.cschoell.apiclient.converter.api.ConfigurationModel;
import org.cschoell.postman.model.PostmanCollection;

@Slf4j
public class PostmanConfigurationModel implements ConfigurationModel<PostmanCollection> {

    PostmanCollection postmanCollection;


    public PostmanConfigurationModel(PostmanCollection postmanCollection) {
        this.postmanCollection = postmanCollection;
    }

    @Override
    public ApiConfigurationType getType() {
        return ApiConfigurationType.bruno;
    }

    @Override
    public PostmanCollection getContent() {
        return postmanCollection;
    }
}
