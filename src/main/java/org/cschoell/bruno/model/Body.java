package org.cschoell.bruno.model;

import lombok.Data;

@Data
public class Body extends BrunoValueBase {

    private BodyType type;

    @Override
    public String getComponentRootName() {
        return type == BodyType.none ? "body" : "body:" + type.inBrunoStyle();
    }


}
