package org.apiclient.morpher.bruno.model;

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
