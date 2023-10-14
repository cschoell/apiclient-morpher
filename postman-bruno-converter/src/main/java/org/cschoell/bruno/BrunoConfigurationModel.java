package org.cschoell.bruno;

import lombok.extern.slf4j.Slf4j;
import org.cschoell.apiclient.converter.api.ApiConfigurationType;
import org.cschoell.apiclient.converter.api.ConfigurationModel;
import org.cschoell.bruno.model.BrunoCollection;

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
