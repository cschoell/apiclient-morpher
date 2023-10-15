package org.cschoell.generic.model.body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.cschoell.generic.model.GenericModelBase;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GValueBody extends GenericModelBase {
    private String value;
}
