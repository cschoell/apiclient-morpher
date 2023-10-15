package org.cschoell.bruno.model;

public interface Body extends BrunoModelComponentRoot{

    BodyType getBodyType();
    void setBodyType(BodyType bodyType);

    boolean hasContent();
}
