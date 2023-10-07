package org.cschoell.bruno.model;

import lombok.Data;

@Data
public class PreRequestScript extends BrunoValueBase {

    @Override
    public String getComponentRootName() {
        return "script:pre-request";
    }

}
