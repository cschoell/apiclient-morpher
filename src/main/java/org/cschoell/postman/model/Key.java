
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * An object containing path to file containing private key, on the file system
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "src"
})
@Data
public class Key {

    /**
     * The path to file containing key for certificate, on the file system
     * 
     */
    @JsonProperty("src")
    @JsonPropertyDescription("The path to file containing key for certificate, on the file system")
    private Object src;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    /**
     * The path to file containing key for certificate, on the file system
     * 
     */
    @JsonProperty("src")
    public Object getSrc() {
        return src;
    }

    /**
     * The path to file containing key for certificate, on the file system
     * 
     */
    @JsonProperty("src")
    public void setSrc(Object src) {
        this.src = src;
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
