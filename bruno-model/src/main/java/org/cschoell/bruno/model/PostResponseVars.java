package org.cschoell.bruno.model;

import lombok.Data;

@Data
public class PostResponseVars extends BrunoValueBase {

    public static final String NAME = "vars:post-response";

    @Override
    public String getComponentRootName() {
        return NAME;
    }

}
