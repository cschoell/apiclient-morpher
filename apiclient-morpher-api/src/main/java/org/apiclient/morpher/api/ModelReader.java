package org.apiclient.morpher.api;

import java.io.File;

public interface ModelReader<T extends ConfigurationModel> {

    T readModel(File source);

    ApiConfigurationType getType();
}
