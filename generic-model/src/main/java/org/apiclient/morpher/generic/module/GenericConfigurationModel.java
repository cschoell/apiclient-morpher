package org.apiclient.morpher.generic.module;


import org.apiclient.morpher.api.ApiConfigurationType;
import org.apiclient.morpher.api.ConfigurationModel;
import org.apiclient.morpher.generic.model.GCollection;

public class GenericConfigurationModel implements ConfigurationModel<GCollection> {

    private GCollection collection;

    public GenericConfigurationModel(GCollection collection) {
        this.collection = collection;
    }

    @Override
    public ApiConfigurationType getType() {
        return ApiConfigurationType.generic;
    }

    @Override
    public GCollection getContent() {
        return collection;
    }
}
