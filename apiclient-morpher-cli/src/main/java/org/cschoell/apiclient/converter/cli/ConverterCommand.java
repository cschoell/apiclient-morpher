package org.cschoell.apiclient.converter.cli;

import org.cschoell.apiclient.converter.api.*;
import org.cschoell.bruno.module.BrunoModule;
import org.cschoell.generic.module.GenericModule;
import org.cschoell.postman.module.PostmanModule;
import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command(mixinStandardHelpOptions = true)
public class ConverterCommand implements Callable<String> {

    @CommandLine.Option(names = {"-s", "--source"}, paramLabel = "SOURCE", description = "source file or directory to map from", required = true)
    private File source;

    @CommandLine.Option(names = {"-st", "--sourceType"}, paramLabel = "SOURCE_TYPE", description = "type of the configuration that the model is read from (defaults to postman)")
    private String sourceClient = ApiConfigurationType.postman.getType();

    @CommandLine.Option(names = {"-t", "--target"}, paramLabel = "TARGET", description = "target file or directory to map to", required = true)
    private File target;

    @CommandLine.Option(names = {"-tt", "--targetType"}, paramLabel = "TARGET_TYPE", description = "type of the configuration that the model is written to (defaults to bruno)")
    private String targetClient = ApiConfigurationType.bruno.getType();

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;

    @Override
    public String call() {
        final ConverterRegistry instance = ConverterRegistry.getInstance();
        final BrunoModule module = new BrunoModule();
        final PostmanModule postmanModule = new PostmanModule();
        final GenericModule genericModule = new GenericModule();
        instance.registerModule(module);
        instance.registerModule(postmanModule);
        instance.registerModule(genericModule);

        ApiConfigurationType sourceType = new ApiConfigurationType(sourceClient);
        ApiConfigurationType targetType = new ApiConfigurationType(targetClient);

        final ModelMapper mapperForTuple = instance.getMapperForTuple(new ConverterTuple(sourceType, targetType));
        final ModelReader reader = instance.getReader(sourceType);
        final ModelWriter writer = instance.getWriter(targetType);

        ConfigurationModel sourceModel;
        ConfigurationModel targetModel = null;
        if (mapperForTuple != null) {
            sourceModel = reader.readModel(source);
            targetModel = mapperForTuple.map(sourceModel);
        } else {
            ModelMapper mapperToGeneric = instance.getMapperForTuple(new ConverterTuple(sourceType, ApiConfigurationType.generic));
            ModelMapper genericToTarget = instance.getMapperForTuple(new ConverterTuple(targetType, ApiConfigurationType.generic));

            if (mapperToGeneric != null && genericToTarget != null) {
                sourceModel = reader.readModel(source);
                ConfigurationModel genericModel = mapperToGeneric.map(sourceModel);
                targetModel = genericToTarget.mapReverse(genericModel);
            } else {
                final String message = "Could not find a conversion path for given source and target";
                System.out.println(message);
                return message;
            }

        }

        writer.writeModel(targetModel, target);

//        System.out.println(brunoConfigurationModel.getContent());

        return "Success";
    }

}
