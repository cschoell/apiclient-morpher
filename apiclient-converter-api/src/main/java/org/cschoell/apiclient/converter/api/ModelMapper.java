package org.cschoell.apiclient.converter.api;

public interface ModelMapper<R extends ConfigurationModel<?>, T extends ConfigurationModel<?>> {

    T map(R from);

}
