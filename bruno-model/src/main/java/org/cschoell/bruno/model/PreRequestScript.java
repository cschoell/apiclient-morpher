package org.cschoell.bruno.model;

import lombok.Data;

@Data
public class PreRequestScript extends BrunoValueBase {

    public static final String NAME = "script:pre-request";

    @Override
    public String getComponentRootName() {
        return NAME;
    }

}
