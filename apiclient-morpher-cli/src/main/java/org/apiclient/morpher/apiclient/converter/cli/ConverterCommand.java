package org.apiclient.morpher.apiclient.converter.cli;

import org.apiclient.morpher.api.*;
import org.apiclient.morpher.apiclient.context.SpringContextConfiguration;
import picocli.CommandLine;

import java.io.File;
import java.util.Optional;
import java.util.concurrent.Callable;

@CommandLine.Command(mixinStandardHelpOptions = true)
public class ConverterCommand implements Callable<String> {

    @CommandLine.Option(names = {"-s", "--source"}, paramLabel = "SOURCE", description = "source file or directory to toFormBody from", required = true)
    private File source;

    @CommandLine.Option(names = {"-st", "--sourceType"}, paramLabel = "SOURCE_TYPE", description = "type of the configuration that the model is read from (defaults to postman)")
    private String sourceClient = ApiConfigurationType.postman.getType();

    @CommandLine.Option(names = {"-t", "--target"}, paramLabel = "TARGET", description = "target file or directory to toFormBody to", required = true)
    private File target;

    @CommandLine.Option(names = {"-tt", "--targetType"}, paramLabel = "TARGET_TYPE", description = "type of the configuration that the model is written to (defaults to bruno)")
    private String targetClient = ApiConfigurationType.bruno.getType();

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;
    private ConverterRegistry instance;

    public ConverterCommand() {
        instance = SpringContextConfiguration.getInstance().getBean(ConverterRegistry.class);
    }

    @Override
    public String call() {

        ApiConfigurationType sourceType = new ApiConfigurationType(sourceClient);
        ApiConfigurationType targetType = new ApiConfigurationType(targetClient);

        Optional<ConfigurationModel> targetModel = mapConfiguration(sourceType, targetType);

        return targetModel.map(configurationModel -> {
            writeToTarget(configurationModel, targetType);
            return "Success";
        }).orElseGet(() -> {
            System.out.println("Could not find a conversion path for given source and target");
            return "Fail";
        });
    }

    private Optional<ConfigurationModel> mapConfiguration(ApiConfigurationType sourceType, ApiConfigurationType targetType) {
        ModelReader reader = instance.getReader(sourceType);
        final ModelMapper mapperForTuple = this.instance.getMapperForTuple(new ConverterTuple(sourceType, targetType));
        if (mapperForTuple != null) {
            ConfigurationModel targetModel = mapperForTuple.map(reader.readModel(source));
            return Optional.of(targetModel);
        }
        return mapConfigurationViaIntermediaryModel(sourceType, targetType);
    }

    private Optional<ConfigurationModel> mapConfigurationViaIntermediaryModel(ApiConfigurationType sourceType, ApiConfigurationType targetType) {
        ModelMapper mapperToGeneric = this.instance.getMapperForTuple(new ConverterTuple(sourceType, ApiConfigurationType.generic));
        ModelMapper genericToTarget = this.instance.getMapperForTuple(new ConverterTuple(targetType, ApiConfigurationType.generic));

        if (mapperToGeneric != null && genericToTarget != null) {
            ConfigurationModel sourceModel = ((ModelReader) instance.getReader(sourceType)).readModel(source);
            ConfigurationModel genericModel = mapperToGeneric.map(sourceModel);
            return Optional.of(genericToTarget.mapReverse(genericModel));
        }
        return Optional.empty();
    }


    private void writeToTarget(ConfigurationModel configurationModel, ApiConfigurationType targetType) {
        final ModelWriter writer = this.instance.getWriter(targetType);
        writer.writeModel(configurationModel, target);
    }
}
