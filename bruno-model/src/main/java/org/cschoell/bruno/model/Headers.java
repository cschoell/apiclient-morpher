package org.cschoell.bruno.model;

import lombok.ToString;

import java.util.LinkedHashMap;

@ToString(callSuper = true)
public class Headers extends LinkedHashMap<String, String> implements BrunoModelComponentRoot {

}
