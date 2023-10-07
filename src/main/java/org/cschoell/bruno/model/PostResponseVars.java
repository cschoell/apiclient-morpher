package org.cschoell.bruno.model;

import lombok.Data;

@Data
public class PostResponseVars extends BrunoValueBase {

    @Override
    public String getComponentRootName() {
        return "vars:post-response";
    }

}
