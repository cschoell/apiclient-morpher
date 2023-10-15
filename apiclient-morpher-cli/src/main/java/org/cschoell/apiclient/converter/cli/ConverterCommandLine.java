package org.cschoell.apiclient.converter.cli;

import picocli.CommandLine;

public class ConverterCommandLine {


    public static void main(String[] args) {
        int exitcode = new CommandLine(new ConverterCommand()).execute(args);
        System.exit(exitcode);
    }



}
