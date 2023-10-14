package org.cschoell.bruno.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class BrunoValueBase extends BrunoModelBase {

    private String value;

    @Override
    public boolean hidden() {
        return StringUtils.isBlank(value);
    }
}
