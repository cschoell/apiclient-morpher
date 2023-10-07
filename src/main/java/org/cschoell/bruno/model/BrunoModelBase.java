package org.cschoell.bruno.model;

public abstract class BrunoModelBase implements BrunoModelComponentRoot {

    @Override
    public String getComponentRootName() {
        return getClass().getSimpleName().toLowerCase();
    }

}
