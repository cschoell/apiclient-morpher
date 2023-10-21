package org.cschoell.bruno.module;

import org.cschoell.apiclient.converter.api.*;
import org.cschoell.bruno.model.BrunoCollection;
import org.cschoell.bruno.module.reader.BrunoConfigurationModelReader;
import org.cschoell.bruno.module.writer.BrunoConfigurationModelWriter;
import org.cschoell.bruno.mapper.GenericToBrunoCollectionMapper;
import org.cschoell.generic.module.GenericConfigurationModel;

public class BrunoModule implements ConverterModule<BrunoConfigurationModel, GenericConfigurationModel> {

    private GenericToBrunoCollectionMapper genericToBrunoCollectionMapper = GenericToBrunoCollectionMapper.INSTANCE;
//    private BrunoCollectionToGenericMapper brunoCollectionToGenericMapper = BrunoCollectionToGenericMapper.INSTANCE;

    public BrunoModule() {
    }

    @Override
    public ModelReader<BrunoConfigurationModel> getReader() {
        return new BrunoConfigurationModelReader();
    }

    @Override
    public ModelWriter<BrunoConfigurationModel> getWriter() {
        return new BrunoConfigurationModelWriter();
    }

    @Override
    public ApiConfigurationType getTargetType() {
        return ApiConfigurationType.generic;
    }

    @Override
    public ApiConfigurationType getSourceType() {
        return ApiConfigurationType.bruno;
    }

    @Override
    public ModelMapper<BrunoConfigurationModel, GenericConfigurationModel> getMapper() {
        return new ModelMapper<>() {
            @Override
            public GenericConfigurationModel map(BrunoConfigurationModel src) {
//                    BrunoCollection target = genericToBrunoCollectionMapper.toBrunoCollection(from);
//                    return new BrunoConfigurationModel(target);
                throw new UnsupportedOperationException("Bruno to generic not implemented yet");

            }

            @Override
            public BrunoConfigurationModel mapReverse(GenericConfigurationModel target) {
                BrunoCollection model = genericToBrunoCollectionMapper.toBrunoCollection(target.getContent());
                return new BrunoConfigurationModel(model);
            }
        };
    }


}
