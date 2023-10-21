package org.cschoell.apiclient.converter.api;

import java.util.HashMap;
import java.util.Map;

public class ConverterRegistry {

    private static final ConverterRegistry INSTANCE = new ConverterRegistry();

    public static ConverterRegistry getInstance() {
        return INSTANCE;
    }

    private final Map<ConverterTuple, ModelMapper> registeredConverters = new HashMap<>();

    private final Map<ApiConfigurationType, ModelReader<?>> readers = new HashMap<>();
    private final Map<ApiConfigurationType, ModelWriter<?>> writers = new HashMap<>();

    public void registerModule(ConverterModule module) {
        writers.put(module.getWriter().getType(), module.getWriter());
        readers.put(module.getReader().getType(), module.getReader());
        final ConverterTuple tuple = new ConverterTuple(module.getSourceType(), module.getTargetType());
        registerMapper(tuple, module.getMapper());
    }
    public ModelReader<?> getReader(ApiConfigurationType type) {
        return readers.get(type);
    }
    public ModelWriter<?> getWriter(ApiConfigurationType type) {
        return writers.get(type);
    }

    public void registerMapper(ConverterTuple tuple, ModelMapper modelMapper) {
        registeredConverters.put(tuple, modelMapper);
    }

    public ModelMapper getMapperForTuple(ConverterTuple tuple) {
        return registeredConverters.get(tuple);
    }
}
