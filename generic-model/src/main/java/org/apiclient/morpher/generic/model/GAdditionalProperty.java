package org.apiclient.morpher.generic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GAdditionalProperty extends GenericModelBase {
    Map<String, String> properties = new LinkedHashMap<>();
    String value;
    boolean enabled = true;
}
