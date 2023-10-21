package org.cschoell.apiclient.converter.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class ConverterTuple {
    private ApiConfigurationType from;
    private ApiConfigurationType to;
}
