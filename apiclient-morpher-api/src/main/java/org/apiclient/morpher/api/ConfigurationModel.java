package org.apiclient.morpher.api;

public interface ConfigurationModel<T> {

    ApiConfigurationType getType();

    T getContent();

}
