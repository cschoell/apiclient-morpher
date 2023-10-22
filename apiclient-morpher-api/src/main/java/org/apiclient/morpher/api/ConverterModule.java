package org.apiclient.morpher.api;

/**
 * The Converter Module allows to Map from / to a Generic Collection and adds support for reading / writing the module to a backend
 * @param <SOURCE> the @{@link ConfigurationModel this ConverterModule is converting from (and stored in)
 * @param <TARGET> the @{@link ConfigurationModel this ConverterModule is converting to
 */
public interface ConverterModule<SOURCE extends ConfigurationModel<?>, TARGET extends ConfigurationModel<?>> {

    /**
     * Provides an implementation of Model Reader, reading the model from storage
     */
    ModelReader<SOURCE> getReader();

    ModelWriter<SOURCE> getWriter();

    /**
     * The Type of the Model / ApiClient the model is converted to/from - usually the generic model
     */
    ApiConfigurationType getTargetType();

    /**
     * The Type of the Model / ApiClient the model is read from / written to.
     */
    ApiConfigurationType getSourceType();

    ModelMapper<SOURCE, TARGET> getMapper();
}
