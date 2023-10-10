package org.cschoell.bruno.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class BrunoValueBase extends BrunoModelBase {
    private String value;

    @Override
    public boolean hidden() {
        return StringUtils.isBlank(value);
    }
}
