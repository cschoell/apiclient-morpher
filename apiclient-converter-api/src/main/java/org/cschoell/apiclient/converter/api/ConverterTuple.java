package org.cschoell.apiclient.converter.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConverterTuple {
    private ApiConfigurationType from;
    private ApiConfigurationType to;
}
