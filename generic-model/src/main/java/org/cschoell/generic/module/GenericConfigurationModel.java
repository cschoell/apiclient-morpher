package org.cschoell.generic.module;


import org.cschoell.apiclient.converter.api.ApiConfigurationType;
import org.cschoell.apiclient.converter.api.ConfigurationModel;
import org.cschoell.generic.model.GCollection;

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
