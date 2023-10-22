package org.apiclient.morpher.bruno.model;

import lombok.Data;

@Data
public class PreRequestVars extends BrunoValueBase {

    public static final String NAME = "vars:pre-request";

    @Override
    public String getComponentRootName() {
        return NAME;
    }

}
