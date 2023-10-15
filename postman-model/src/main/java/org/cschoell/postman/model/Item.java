
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Item
 * <p>
 * Items are entities which contain an actual HTTP request, and sample responses attached to it.
 * 
 */
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "description",
    "variable",
    "event",
    "request",
    "response",
    "protocolProfileBehavior"
})
@Data
public class Item extends ItemBase{

    /**
     * A unique ID that is used to identify collections internally
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("A unique ID that is used to identify collections internally")
    private String id;
    /**
     * Request
     * <p>
     * A request represents an HTTP request. If a string, the string is assumed to be the request URL and the method is assumed to be 'GET'.
     * (Required)
     * 
     */
    @JsonProperty("request")
    @JsonPropertyDescription("A request represents an HTTP request. If a string, the string is assumed to be the request URL and the method is assumed to be 'GET'.")
    private Request request;
    /**
     * Responses
     * <p>
     * 
     * 
     */
    @JsonProperty("response")
    private List<Response> response = new ArrayList<>();
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

}
