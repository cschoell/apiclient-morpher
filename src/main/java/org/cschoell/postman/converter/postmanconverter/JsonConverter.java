package org.cschoell.postman.converter.postmanconverter;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class JsonConverter {

    public static void main(String[] args) throws IOException {
        JCodeModel codeModel = new JCodeModel();
        URL source = JsonConverter.class.getResource("/postmanschemaNoOneOf.json");
        GenerationConfig config = new DefaultGenerationConfig() {
            @Override public boolean isGenerateBuilders() { // set config option by overriding method
                return false;
            }

            @Override
            public boolean isIncludeHashcodeAndEquals() {
                return false;
            }

            @Override
            public boolean isIncludeToString() {
                return false;
            }

            @Override
            public boolean isIncludeGeneratedAnnotation() {
                return false;
            }

            @Override
            public Class<? extends Annotator> getCustomAnnotator() {
                return LombokAnnotator.class;
            }


            @Override
            public SourceType getSourceType() {
                return SourceType.JSONSCHEMA;
            }
        };



        SchemaMapper mapper = new SchemaMapper(
                new RuleFactory(config, new CompositeAnnotator(new Jackson2Annotator(config), new LombokAnnotator()), new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, "Collection", "org.cschoell.postman.model", source);
        File file = Files.createTempDirectory("required").toFile();
        codeModel.build(file);
        System.out.println("path is " + file);
    }
}
