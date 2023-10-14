package org.cschoell.apiclient.converter.cli;

import org.cschoell.apiclient.converter.api.*;
import org.cschoell.bruno.BrunoConfigurationModel;
import org.cschoell.convert.PostmanBrunoModule;
import org.cschoell.postman.PostmanConfigurationModel;
import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command(mixinStandardHelpOptions = true)
public class ConverterCommand implements Callable<String> {

    @CommandLine.Option(names = {"-s", "--source"}, paramLabel = "SOURCE", description = "source file or directory to map from", required = true)
    private File source;

    @CommandLine.Option(names = {"-st", "--sourceType"}, paramLabel = "SOURCE_TYPE", description = "type of the configuration that the model is read from (defaults to postman)")
    private ApiConfigurationType sourceClient = ApiConfigurationType.postman;

    @CommandLine.Option(names = {"-t", "--target"}, paramLabel = "TARGET", description = "target file or directory to map to", required = true)
    private File target;

    @CommandLine.Option(names = {"-tt", "--targetType"}, paramLabel = "TARGET_TYPE", description = "type of the configuration that the model is written to (defaults to bruno)")
    private ApiConfigurationType targetClient = ApiConfigurationType.bruno;

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;

    @Override
    public String call() {
        final ConverterRegistry instance = ConverterRegistry.getInstance();
        final PostmanBrunoModule module = new PostmanBrunoModule();
        instance.registerModule(module);

        module.getWriter().writeModel(module.getMapper().map(module.getReader().readModel(source)), target);

        return "Success";
    }

}
