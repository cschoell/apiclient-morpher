package org.apiclient.morpher.bruno.module;

import lombok.extern.slf4j.Slf4j;
import org.apiclient.morpher.api.ApiConfigurationType;
import org.apiclient.morpher.api.ConfigurationModel;
import org.apiclient.morpher.bruno.model.BrunoCollection;

@Slf4j
public class BrunoConfigurationModel implements ConfigurationModel<BrunoCollection> {

    BrunoCollection brunoCollection;

    public BrunoConfigurationModel(BrunoCollection brunoCollection) {
        this.brunoCollection = brunoCollection;
    }

    @Override
    public ApiConfigurationType getType() {
        return ApiConfigurationType.bruno;
    }

    @Override
    public BrunoCollection getContent() {
        return brunoCollection;
    }
}
