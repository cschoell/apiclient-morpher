
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
 * An object containing path to file certificate, on the file system
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "src"
})
@Data
public class Cert {

    /**
     * The path to file containing key for certificate, on the file system
     * 
     */
    @JsonProperty("src")
    @JsonPropertyDescription("The path to file containing key for certificate, on the file system")
    private Object src;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
