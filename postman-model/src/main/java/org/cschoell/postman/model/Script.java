
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Script
 * <p>
 * A script is a snippet of Javascript code that can be used to to perform setup or teardown operations on a particular response.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "type",
    "exec",
    "src",
    "name"
})
@Data
public class Script {

    /**
     * A unique, user defined identifier that can  be used to refer to this script from requests.
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("A unique, user defined identifier that can  be used to refer to this script from requests.")
    private String id;
    /**
     * Type of the script. E.g: 'text/javascript'
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of the script. E.g: 'text/javascript'")
    private String type;
    /**
     * This is an array of strings, where each line represents a single line of code. Having lines separate makes it possible to easily track changes made to scripts.
     * 
     */
    @JsonProperty("exec")
    @JsonPropertyDescription("This is an array of strings, where each line represents a single line of code. Having lines separate makes it possible to easily track changes made to scripts.")
    private List<String> exec = new ArrayList<String>();
    /**
     * Url
     * <p>
     * If object, contains the complete broken-down URL for this request. If string, contains the literal request URL.
     * 
     */
    @JsonProperty("src")
    @JsonPropertyDescription("If object, contains the complete broken-down URL for this request. If string, contains the literal request URL.")
    private Url src;
    /**
     * Script name
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Script name")
    private String name;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    /**
     * A unique, user defined identifier that can  be used to refer to this script from requests.
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * A unique, user defined identifier that can  be used to refer to this script from requests.
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Type of the script. E.g: 'text/javascript'
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type of the script. E.g: 'text/javascript'
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This is an array of strings, where each line represents a single line of code. Having lines separate makes it possible to easily track changes made to scripts.
     * 
     */
    @JsonProperty("exec")
    public List<String> getExec() {
        return exec;
    }

    /**
     * This is an array of strings, where each line represents a single line of code. Having lines separate makes it possible to easily track changes made to scripts.
     * 
     */
    @JsonProperty("exec")
    public void setExec(List<String> exec) {
        this.exec = exec;
    }

    /**
     * Url
     * <p>
     * If object, contains the complete broken-down URL for this request. If string, contains the literal request URL.
     * 
     */
    @JsonProperty("src")
    public Url getSrc() {
        return src;
    }

    /**
     * Url
     * <p>
     * If object, contains the complete broken-down URL for this request. If string, contains the literal request URL.
     * 
     */
    @JsonProperty("src")
    public void setSrc(Url src) {
        this.src = src;
    }

    /**
     * Script name
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Script name
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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
