package org.cschoell.apiclient.converter.api;

public interface ConverterModule<W extends ConfigurationModel<?>> {

    ModelReader<W> getReader();

    ModelWriter<W> getWriter();

    ApiConfigurationType getType();

    ModelMapper<W> getMapper();
}
