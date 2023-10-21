package org.cschoell.apiclient.converter.api;

/**
 * Mapper to map between different @{@link ConfigurationModel} implementations.
 * It is recommended to always map from a specific ApiClient to the Generic Model.
 * That way conversion from / to any target is possible via the intermediary generic model.
 * @param <SOURCE> Source Model to map from
 * @param <TARGET> The target model to map to (usually the generic model)
 */
public interface ModelMapper<SOURCE extends ConfigurationModel<?>, TARGET extends ConfigurationModel<?>> {

    TARGET map(SOURCE src);
    SOURCE mapReverse(TARGET target);

}
