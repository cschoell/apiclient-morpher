package org.cschoell.apiclient.converter.api;

import java.io.File;

public interface ModelWriter<T extends ConfigurationModel<?>> {

    void writeModel(T model, File target);

    ApiConfigurationType getType();
}
