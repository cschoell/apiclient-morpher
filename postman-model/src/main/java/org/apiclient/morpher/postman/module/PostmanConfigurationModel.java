package org.apiclient.morpher.postman.module;

import lombok.extern.slf4j.Slf4j;
import org.apiclient.morpher.api.ApiConfigurationType;
import org.apiclient.morpher.api.ConfigurationModel;
import org.apiclient.morpher.postman.model.PostmanCollection;

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
