package org.cschoell.generic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GRequestMeta extends GenericModelBase {
    private String name;
    private String requestType = "http";
    private String seq = "1";

}
