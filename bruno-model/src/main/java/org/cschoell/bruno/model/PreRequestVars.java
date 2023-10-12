package org.cschoell.bruno.model;

import lombok.Data;

@Data
public class PreRequestVars extends BrunoValueBase {

    @Override
    public String getComponentRootName() {
        return "vars:pre-request";
    }

}
