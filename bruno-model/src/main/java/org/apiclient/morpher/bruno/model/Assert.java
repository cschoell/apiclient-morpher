package org.apiclient.morpher.bruno.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class Assert extends BrunoValueBase {
    @Override
    public String getComponentRootName() {
        return "assert";
    }
}
