package org.cschoell.generic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GAdditionalProperty extends GenericModelBase {
    boolean enabled = true;
    String value;
}