package org.cschoell.bruno.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashMap;

@EqualsAndHashCode(callSuper = true)
@Data
public class Query extends LinkedHashMap<String, String> implements BrunoModelComponentRoot {

}
