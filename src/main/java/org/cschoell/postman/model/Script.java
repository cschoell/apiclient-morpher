
package org.cschoell.postman.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
