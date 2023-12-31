
package org.apiclient.morpher.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
public class Key {

    /**
     * The path to file containing key for certificate, on the file system
     * 
     */
    @JsonProperty("src")
    @JsonPropertyDescription("The path to file containing key for certificate, on the file system")
    private String src;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

}
