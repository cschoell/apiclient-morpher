
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Information
 * <p>
 * Detailed description of the info block
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "_postman_id",
    "description",
    "version",
    "schema"
})
@Data
public class Info {

    /**
     * Name of the collection
     * <p>
     * A collection's friendly name is defined by this field. You would want to set this field to a value that would allow you to easily identify this collection among a bunch of other collections, as such outlining its usage or content.
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("A collection's friendly name is defined by this field. You would want to set this field to a value that would allow you to easily identify this collection among a bunch of other collections, as such outlining its usage or content.")
    private String name;
    /**
     * Every collection is identified by the unique value of this field. The value of this field is usually easiest to generate using a UID generator function. If you already have a collection, it is recommended that you maintain the same id since changing the id usually implies that is a different collection than it was originally.
     *  *Note: This field exists for compatibility reasons with Collection Format V1.*
     * 
     */
    @JsonProperty("_postman_id")
    @JsonPropertyDescription("Every collection is identified by the unique value of this field. The value of this field is usually easiest to generate using a UID generator function. If you already have a collection, it is recommended that you maintain the same id since changing the id usually implies that is a different collection than it was originally.\n *Note: This field exists for compatibility reasons with Collection Format V1.*")
    private String postmanId;
    /**
     * Description
     * <p>
     * A Description can be a raw text, or be an object, which holds the description along with its format.
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("A Description can be a raw text, or be an object, which holds the description along with its format.")
    private Description description;
    /**
     * Collection Version
     * <p>
     * Postman allows you to version your collections as they grow, and this field holds the version number. While optional, it is recommended that you use this field to its fullest extent!
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("Postman allows you to version your collections as they grow, and this field holds the version number. While optional, it is recommended that you use this field to its fullest extent!")
    private Version version;
    /**
     * This should ideally hold a link to the Postman schema that is used to validate this collection. E.g: https://schema.getpostman.com/collection/v1
     * (Required)
     * 
     */
    @JsonProperty("schema")
    @JsonPropertyDescription("This should ideally hold a link to the Postman schema that is used to validate this collection. E.g: https://schema.getpostman.com/collection/v1")
    private String schema;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    /**
     * Name of the collection
     * <p>
     * A collection's friendly name is defined by this field. You would want to set this field to a value that would allow you to easily identify this collection among a bunch of other collections, as such outlining its usage or content.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the collection
     * <p>
     * A collection's friendly name is defined by this field. You would want to set this field to a value that would allow you to easily identify this collection among a bunch of other collections, as such outlining its usage or content.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Every collection is identified by the unique value of this field. The value of this field is usually easiest to generate using a UID generator function. If you already have a collection, it is recommended that you maintain the same id since changing the id usually implies that is a different collection than it was originally.
     *  *Note: This field exists for compatibility reasons with Collection Format V1.*
     * 
     */
    @JsonProperty("_postman_id")
    public String getPostmanId() {
        return postmanId;
    }

    /**
     * Every collection is identified by the unique value of this field. The value of this field is usually easiest to generate using a UID generator function. If you already have a collection, it is recommended that you maintain the same id since changing the id usually implies that is a different collection than it was originally.
     *  *Note: This field exists for compatibility reasons with Collection Format V1.*
     * 
     */
    @JsonProperty("_postman_id")
    public void setPostmanId(String postmanId) {
        this.postmanId = postmanId;
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

    /**
     * Collection Version
     * <p>
     * Postman allows you to version your collections as they grow, and this field holds the version number. While optional, it is recommended that you use this field to its fullest extent!
     * 
     */
    @JsonProperty("version")
    public Version getVersion() {
        return version;
    }

    /**
     * Collection Version
     * <p>
     * Postman allows you to version your collections as they grow, and this field holds the version number. While optional, it is recommended that you use this field to its fullest extent!
     * 
     */
    @JsonProperty("version")
    public void setVersion(Version version) {
        this.version = version;
    }

    /**
     * This should ideally hold a link to the Postman schema that is used to validate this collection. E.g: https://schema.getpostman.com/collection/v1
     * (Required)
     * 
     */
    @JsonProperty("schema")
    public String getSchema() {
        return schema;
    }

    /**
     * This should ideally hold a link to the Postman schema that is used to validate this collection. E.g: https://schema.getpostman.com/collection/v1
     * (Required)
     * 
     */
    @JsonProperty("schema")
    public void setSchema(String schema) {
        this.schema = schema;
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
