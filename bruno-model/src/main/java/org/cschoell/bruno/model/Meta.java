package org.cschoell.bruno.model;

import lombok.Data;
import lombok.ToString;

@ToString(callSuper = true)
@Data
public class Meta extends BrunoModelBase {
    private String name;
    private String type = "http";
    private String seq = "1";
}
