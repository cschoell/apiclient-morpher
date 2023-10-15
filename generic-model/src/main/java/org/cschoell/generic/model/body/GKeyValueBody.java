package org.cschoell.generic.model.body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.cschoell.generic.model.GValue;
import org.cschoell.generic.model.GenericModelBase;

import java.util.LinkedHashMap;
import java.util.Map;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GKeyValueBody extends GenericModelBase {

    private Map<String, GValue> keyValueBody = new LinkedHashMap<>();

}
