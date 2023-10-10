
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "info",
    "item",
    "event",
    "variable",
    "auth",
    "protocolProfileBehavior"
})
@Data
public class PostmanCollection {

    /**
     * Information
     * <p>
     * Detailed description of the info block
     * (Required)
     * 
     */
    @JsonProperty("info")
    @JsonPropertyDescription("Detailed description of the info block")
    private Info info;
    /**
     * Items are the basic unit for a Postman collection. You can think of them as corresponding to a single API endpoint. Each Item has one request and may have multiple API responses associated with it.
     * (Required)
     * 
     */
    @JsonProperty("item")
    @JsonPropertyDescription("Items are the basic unit for a Postman collection. You can think of them as corresponding to a single API endpoint. Each Item has one request and may have multiple API responses associated with it.")
    private List<PostmanPolymorphicBase> item = new ArrayList<>();


    /**
     * Event List
     * <p>
     * Postman allows you to configure scripts to run when specific events occur. These scripts are stored here, and can be referenced in the collection by their ID.
     * 
     */
    @JsonProperty("event")
    @JsonPropertyDescription("Postman allows you to configure scripts to run when specific events occur. These scripts are stored here, and can be referenced in the collection by their ID.")
    private List<Event> event = new ArrayList<Event>();
    /**
     * Variable List
     * <p>
     * Collection variables allow you to define a set of variables, that are a *part of the collection*, as opposed to environments, which are separate entities.
     * *Note: Collection variables must not contain any sensitive information.*
     * 
     */
    @JsonProperty("variable")
    @JsonPropertyDescription("Collection variables allow you to define a set of variables, that are a *part of the collection*, as opposed to environments, which are separate entities.\n*Note: Collection variables must not contain any sensitive information.*")
    private List<Variable> variable = new ArrayList<Variable>();
    /**
     * Auth
     * <p>
     * Represents authentication helpers provided by Postman
     *
     */
    @JsonProperty("auth")
    @JsonPropertyDescription("Represents authentication helpers provided by Postman")
    private Auth auth;
    /**
     * Protocol Profile Behavior
     * <p>
     * Set of configurations used to alter the usual behavior of sending the request
     * 
     */
    @JsonProperty("protocolProfileBehavior")
    @JsonPropertyDescription("Set of configurations used to alter the usual behavior of sending the request")
    private ProtocolProfileBehavior protocolProfileBehavior;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    public List<Item> getRequestItem() {
        return item.stream().map(this::mapItem).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public List<VirtualFolder> getFolder() {
        return item.stream().map(this::mapFolder).filter(Objects::nonNull).collect(Collectors.toList());
    }
    private Item mapItem(PostmanPolymorphicBase itemBase) {
        return itemBase instanceof Item ? (Item) itemBase : null;
    }

    private VirtualFolder mapFolder(PostmanPolymorphicBase itemBase) {
        return itemBase instanceof VirtualFolder ? (VirtualFolder) itemBase : null;
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
