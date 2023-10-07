
package org.cschoell.postman.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


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
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * This holds the LHS of the HTTP Header, e.g ``Content-Type`` or ``X-Custom-Header``
     * (Required)
     * 
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * This holds the LHS of the HTTP Header, e.g ``Content-Type`` or ``X-Custom-Header``
     * (Required)
     * 
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * The value (or the RHS) of the Header is stored in this field.
     * (Required)
     * 
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * The value (or the RHS) of the Header is stored in this field.
     * (Required)
     * 
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * If set to true, the current header will not be sent with requests.
     * 
     */
    @JsonProperty("disabled")
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * If set to true, the current header will not be sent with requests.
     * 
     */
    @JsonProperty("disabled")
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * Description
     * <p>
     * A Description can be a raw text, or be an object, which holds the description along with its format.
     * 
     */
    @JsonProperty("description")
    public Description getDescription() {
        return description;
    }

    /**
     * Description
     * <p>
     * A Description can be a raw text, or be an object, which holds the description along with its format.
     * 
     */
    @JsonProperty("description")
    public void setDescription(Description description) {
        this.description = description;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
