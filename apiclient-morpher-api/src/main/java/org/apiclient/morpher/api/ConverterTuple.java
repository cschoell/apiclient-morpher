package org.apiclient.morpher.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConverterTuple {
    private ApiConfigurationType from;
    private ApiConfigurationType to;
}
