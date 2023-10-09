package org.cschoell.bruno.model;

public interface Body extends BrunoModelComponentRoot{

    BodyType getType();
    void setType(BodyType bodyType);

    boolean hasContent();
}
