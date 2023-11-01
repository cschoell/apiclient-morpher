package org.apiclient.morpher.generic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class GValue extends GenericModelBase {
    private boolean disabled;
    private String value;
    private String contentType;
    private String src;

    public GValue(String value) {
        this.value = value;
    }
}
