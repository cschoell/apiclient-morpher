package org.cschoell.bruno.model;

import lombok.ToString;

public abstract class BrunoModelBase implements BrunoModelComponentRoot {

    @Override
    public String getComponentRootName() {
        return getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String toString() {
        return getComponentRootName();
    }
}
