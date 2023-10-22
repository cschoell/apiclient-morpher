package org.apiclient.morpher.postman.module;

import org.apiclient.morpher.api.*;
import org.apiclient.morpher.generic.module.GenericConfigurationModel;
import org.apiclient.morpher.postman.mapper.GenericCollectionToPostmanMapper;
import org.apiclient.morpher.postman.mapper.PostmanToGenericCollectionMapper;

public class PostmanModule implements ConverterModule<PostmanConfigurationModel, GenericConfigurationModel> {

    private PostmanToGenericCollectionMapper postmanToGenericCollectionMapper = PostmanToGenericCollectionMapper.INSTANCE;
    private GenericCollectionToPostmanMapper genericCollectionToPostmanMapper = GenericCollectionToPostmanMapper.INSTANCE;
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
    public ApiConfigurationType getTargetType() {
        return ApiConfigurationType.generic;
    }

    @Override
    public ApiConfigurationType getSourceType() {
        return ApiConfigurationType.postman;
    }

    @Override
    public ModelMapper<PostmanConfigurationModel, GenericConfigurationModel> getMapper() {
        return new ModelMapper<>() {
            @Override
            public GenericConfigurationModel map(PostmanConfigurationModel src) {
                return new GenericConfigurationModel(postmanToGenericCollectionMapper.toGenericCollection(src.getContent()));
            }

            @Override
            public PostmanConfigurationModel mapReverse(GenericConfigurationModel target) {
                return new PostmanConfigurationModel(genericCollectionToPostmanMapper.toPostmanCollection(target.getContent()));
            }
        };
    }


}
