package org.cschoell.bruno.model;

import org.apache.commons.lang3.StringUtils;

public interface BrunoModelComponentRoot {
    default String getComponentRootName()  {
        return StringUtils.lowerCase(getClass().getSimpleName());
    }

    default boolean hidden() {
        return false;
    }
}
