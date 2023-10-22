
package org.apiclient.morpher.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Event
 * <p>
 * Defines a script associated with an associated event name
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "listen",
    "script",
    "disabled"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    /**
     * A unique identifier for the enclosing event.
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("A unique identifier for the enclosing event.")
    private String id;
    /**
     * Can be set to `test` or `prerequest` for test scripts or pre-request scripts respectively.
     * (Required)
     * 
     */
    @JsonProperty("listen")
    @JsonPropertyDescription("Can be set to `test` or `prerequest` for test scripts or pre-request scripts respectively.")
    private String listen;
    /**
     * Script
     * <p>
     * A script is a snippet of Javascript code that can be used to to perform setup or teardown operations on a particular response.
     * 
     */
    @JsonProperty("script")
    @JsonPropertyDescription("A script is a snippet of Javascript code that can be used to to perform setup or teardown operations on a particular response.")
    private Script script;
    /**
     * Indicates whether the event is disabled. If absent, the event is assumed to be enabled.
     * 
     */
    @JsonProperty("disabled")
    @JsonPropertyDescription("Indicates whether the event is disabled. If absent, the event is assumed to be enabled.")
    private Boolean disabled = false;

    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

}
