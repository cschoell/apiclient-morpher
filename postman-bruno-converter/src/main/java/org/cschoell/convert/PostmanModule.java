package org.cschoell.convert;

import org.cschoell.apiclient.converter.api.*;
import org.cschoell.bruno.BrunoConfigurationModel;
import org.cschoell.bruno.model.BrunoCollection;
import org.cschoell.bruno.reader.BrunoConfigurationModelReader;
import org.cschoell.bruno.writer.BrunoConfigurationModelWriter;
import org.cschoell.convert.mapper.GenericToBrunoCollectionMapper;
import org.cschoell.convert.mapper.PostmanToGenericCollectionMapper;
import org.cschoell.generic.model.GCollection;
import org.cschoell.postman.PostmanConfigurationModel;
import org.cschoell.postman.PostmanModelReader;
import org.cschoell.postman.PostmanModelWriter;

public class PostmanModule implements ConverterModule<PostmanConfigurationModel> {

    private PostmanToGenericCollectionMapper postmanToGenericCollectionMapper = PostmanToGenericCollectionMapper.INSTANCE;
//    private BrunoCollectionToGenericMapper brunoCollectionToGenericMapper = BrunoCollectionToGenericMapper.INSTANCE;

    public PostmanModule() {
    }

    @Override
    public ModelReader<PostmanConfigurationModel> getReader() {
        return new PostmanModelReader();
    }

    @Override
    public ModelWriter<PostmanConfigurationModel> getWriter() {
        return new PostmanModelWriter();
    }

    @Override
    public ApiConfigurationType getType() {
        return ApiConfigurationType.bruno;
    }

    @Override
    public ModelMapper<PostmanConfigurationModel> getMapper() {
        return new ModelMapper<PostmanConfigurationModel>() {
            @Override
            public GCollection mapToGeneric(PostmanConfigurationModel from) {
                return postmanToGenericCollectionMapper.toGenericCollection(from.getContent());
            }

            @Override
            public PostmanConfigurationModel mapFromGeneric(GCollection from) {
                throw new UnsupportedOperationException("Generic to postman not implemented yet");
            }
        };
    }


}
