package org.cschoell.postman.model;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
@Data
public class AdditionalProperty {
    Map<String, String> properties = new LinkedHashMap<>();
    String value;
    Boolean enabled;

    public AdditionalProperty() {
    }

    public AdditionalProperty(String value) {
        this.value = value;
    }
    public AdditionalProperty(Boolean enabled) {
        this.enabled = enabled;
    }
}
