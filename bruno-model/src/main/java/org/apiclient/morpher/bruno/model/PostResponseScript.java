package org.apiclient.morpher.bruno.model;

import lombok.Data;

@Data
public class PostResponseScript extends BrunoValueBase {

    public static final String NAME = "script:post-response";

    @Override
    public String getComponentRootName() {
        return NAME;
    }

}
