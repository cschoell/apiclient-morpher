package org.apiclient.morpher.postman.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalProperty {
    Map<String, String> properties = new LinkedHashMap<>();
    String value;
    Boolean enabled;

    public AdditionalProperty(String value) {
        this.value = value;
    }
    public AdditionalProperty(Boolean enabled) {
        this.enabled = enabled;
    }
}
