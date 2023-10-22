
package org.apiclient.morpher.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
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
    private List<String> exec = new ArrayList<>();
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

}
