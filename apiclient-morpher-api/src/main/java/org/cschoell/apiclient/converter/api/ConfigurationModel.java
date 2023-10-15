package org.cschoell.apiclient.converter.api;

import java.io.File;

public interface ConfigurationModel<T> {

    ApiConfigurationType getType();

    T getContent();

}
