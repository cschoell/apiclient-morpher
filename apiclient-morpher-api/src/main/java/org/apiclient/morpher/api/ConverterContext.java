package org.apiclient.morpher.api;

import lombok.Data;

import java.io.File;

@Data
public class ConverterContext {

    ApiConfigurationType type;
    File configurationPath;
}
