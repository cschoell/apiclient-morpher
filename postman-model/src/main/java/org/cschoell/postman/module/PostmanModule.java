package org.cschoell.postman.module;

import org.cschoell.apiclient.converter.api.*;
import org.cschoell.postman.mapper.PostmanToGenericCollectionMapper;
import org.cschoell.generic.model.GCollection;

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
        return new ModelMapper<>() {
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
