package org.cschoell.apiclient.converter.api;

public interface ConverterModule<R extends ConfigurationModel<?>, W extends ConfigurationModel<?>> {

    ModelReader<R> getReader();

    ModelWriter<W> getWriter();

    ApiConfigurationType getType();

    ModelMapper<R, W> getMapper();
}
