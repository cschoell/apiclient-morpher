package org.cschoell.bruno.model;

import lombok.Data;

@Data
public class PostResponseScript extends BrunoValueBase {

    @Override
    public String getComponentRootName() {
        return "script:post-response";
    }

}
