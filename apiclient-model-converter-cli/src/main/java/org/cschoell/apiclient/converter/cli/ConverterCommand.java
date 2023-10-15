package org.cschoell.apiclient.converter.cli;

import org.cschoell.apiclient.converter.api.*;
import org.cschoell.bruno.module.BrunoConfigurationModel;
import org.cschoell.bruno.module.BrunoModule;
import org.cschoell.postman.module.PostmanModule;
import org.cschoell.generic.model.GCollection;
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
        final BrunoModule module = new BrunoModule();
        final PostmanModule postmanModule = new PostmanModule();
        instance.registerModule(module);
        instance.registerModule(postmanModule);

        final GCollection gCollection = postmanModule.getMapper().mapToGeneric(postmanModule.getReader().readModel(source));
        System.out.println(gCollection);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        final BrunoConfigurationModel brunoConfigurationModel = module.getMapper().mapFromGeneric(gCollection);
        module.getWriter().writeModel(brunoConfigurationModel, target);

//        System.out.println(brunoConfigurationModel.getContent());

        return "Success";
    }

}
