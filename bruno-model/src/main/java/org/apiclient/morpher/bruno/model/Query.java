package org.apiclient.morpher.bruno.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedHashMap;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class Query extends LinkedHashMap<String, String> implements BrunoModelComponentRoot {

    @Override
    public boolean hidden() {
        return isEmpty();
    }
}
