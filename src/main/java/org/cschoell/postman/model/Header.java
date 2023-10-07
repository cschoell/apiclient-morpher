
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Header
 * <p>
 * Represents a single HTTP Header
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "value",
    "disabled",
    "description"
})
@Data
public class Header {

    /**
     * This holds the LHS of the HTTP Header, e.g ``Content-Type`` or ``X-Custom-Header``
     * (Required)
     * 
     */
    @JsonProperty("key")
    @JsonPropertyDescription("This holds the LHS of the HTTP Header, e.g ``Content-Type`` or ``X-Custom-Header``")
    private String key;
    /**
     * The value (or the RHS) of the Header is stored in this field.
     * (Required)
     * 
     */
    @JsonProperty("value")
    @JsonPropertyDescription("The value (or the RHS) of the Header is stored in this field.")
    private String value;
    /**
     * If set to true, the current header will not be sent with requests.
     * 
     */
    @JsonProperty("disabled")
    @JsonPropertyDescription("If set to true, the current header will not be sent with requests.")
    private Boolean disabled = false;
    /**
     * Description
     * <p>
     * A Description can be a raw text, or be an object, which holds the description along with its format.
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("A Description can be a raw text, or be an object, which holds the description along with its format.")
    private Description description;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    public Header() {
    }

    public Header(String value) {
        this.value = value;
    }

    @JsonAnyGetter
    public Map<String, AdditionalProperty> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, AdditionalProperty value) {
        this.additionalProperties.put(name, value);
    }



}
