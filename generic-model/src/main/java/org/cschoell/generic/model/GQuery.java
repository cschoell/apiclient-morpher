package org.cschoell.generic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GQuery extends GenericModelBase {

    @JsonProperty("key")
    private String key;
    @JsonProperty("value")
    private String value;
    /**
     * If set to true, the current query parameter will not be sent with the request.
     *
     */
    @JsonProperty("disabled")
    @JsonPropertyDescription("If set to true, the current query parameter will not be sent with the request.")
    private Boolean disabled = false;

}
