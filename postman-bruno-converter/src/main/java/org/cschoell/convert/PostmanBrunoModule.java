package org.cschoell.convert;

import org.cschoell.apiclient.converter.api.*;
import org.cschoell.bruno.BrunoConfigurationModel;
import org.cschoell.convert.mapper.PostmanToBrunoCollectionMapper;
import org.cschoell.bruno.model.BrunoCollection;
import org.cschoell.bruno.writer.BrunoConfigurationModelWriter;
import org.cschoell.postman.PostmanConfigurationModel;
import org.cschoell.postman.PostmanModelReader;

public class PostmanBrunoModule implements ConverterModule<PostmanConfigurationModel, BrunoConfigurationModel> {

    private PostmanToBrunoCollectionMapper postmanToBrunoCollectionMapper = PostmanToBrunoCollectionMapper.INSTANCE;

    public PostmanBrunoModule() {
    }

    @Override
    public ModelReader<PostmanConfigurationModel> getReader() {
        return new PostmanModelReader();
    }

    @Override
    public ModelWriter<BrunoConfigurationModel> getWriter() {
        return new BrunoConfigurationModelWriter();
    }

    @Override
    public ApiConfigurationType getType() {
        return ApiConfigurationType.bruno;
    }

    @Override
    public ModelMapper<PostmanConfigurationModel, BrunoConfigurationModel> getMapper() {
        return from -> {
            BrunoCollection target = postmanToBrunoCollectionMapper.toBrunoCollection(from.getContent());
            return new BrunoConfigurationModel(target);
        };
    }


}
