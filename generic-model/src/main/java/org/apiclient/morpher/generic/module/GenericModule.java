package org.apiclient.morpher.generic.module;

import org.apiclient.morpher.api.*;

public class GenericModule implements ConverterModule<GenericConfigurationModel, GenericConfigurationModel> {
    @Override
    public ModelReader<GenericConfigurationModel> getReader() {
        return new GenericModelReader();
    }

    @Override
    public ModelWriter<GenericConfigurationModel> getWriter() {
        return new GenericModuleWriter();
    }

    @Override
    public ApiConfigurationType getTargetType() {
        return ApiConfigurationType.generic;
    }

    @Override
    public ApiConfigurationType getSourceType() {
        return ApiConfigurationType.generic;
    }

    @Override
    public ModelMapper<GenericConfigurationModel, GenericConfigurationModel> getMapper() {
        return new ModelMapper<>() {
            @Override
            public GenericConfigurationModel map(GenericConfigurationModel src) {
                return src;
            }

            @Override
            public GenericConfigurationModel mapReverse(GenericConfigurationModel target) {
                return target;
            }
        };
    }
}
