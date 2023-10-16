
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Collection Version
 * <p>
 * Postman allows you to version your collections as they grow, and this field holds the version number. While optional, it is recommended that you use this field to its fullest extent!
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "major",
    "minor",
    "patch",
    "identifier",
    "meta"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Version {

    /**
     * Increment this number if you make changes to the collection that changes its behaviour. E.g: Removing or adding new test scripts. (partly or completely).
     * (Required)
     * 
     */
    @JsonProperty("major")
    @JsonPropertyDescription("Increment this number if you make changes to the collection that changes its behaviour. E.g: Removing or adding new test scripts. (partly or completely).")
    private Integer major;
    /**
     * You should increment this number if you make changes that will not break anything that uses the collection. E.g: removing a folder.
     * (Required)
     * 
     */
    @JsonProperty("minor")
    @JsonPropertyDescription("You should increment this number if you make changes that will not break anything that uses the collection. E.g: removing a folder.")
    private Integer minor;
    /**
     * Ideally, minor changes to a collection should result in the increment of this number.
     * (Required)
     * 
     */
    @JsonProperty("patch")
    @JsonPropertyDescription("Ideally, minor changes to a collection should result in the increment of this number.")
    private Integer patch;
    /**
     * A human friendly identifier to make sense of the version numbers. E.g: 'beta-3'
     * 
     */
    @JsonProperty("identifier")
    @JsonPropertyDescription("A human friendly identifier to make sense of the version numbers. E.g: 'beta-3'")
    private String identifier;
    @JsonProperty("meta")
    private Object meta;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    /**
     * Increment this number if you make changes to the collection that changes its behaviour. E.g: Removing or adding new test scripts. (partly or completely).
     * (Required)
     * 
     */
    @JsonProperty("major")
    public Integer getMajor() {
        return major;
    }

    /**
     * Increment this number if you make changes to the collection that changes its behaviour. E.g: Removing or adding new test scripts. (partly or completely).
     * (Required)
     * 
     */
    @JsonProperty("major")
    public void setMajor(Integer major) {
        this.major = major;
    }

    /**
     * You should increment this number if you make changes that will not break anything that uses the collection. E.g: removing a folder.
     * (Required)
     * 
     */
    @JsonProperty("minor")
    public Integer getMinor() {
        return minor;
    }

    /**
     * You should increment this number if you make changes that will not break anything that uses the collection. E.g: removing a folder.
     * (Required)
     * 
     */
    @JsonProperty("minor")
    public void setMinor(Integer minor) {
        this.minor = minor;
    }

    /**
     * Ideally, minor changes to a collection should result in the increment of this number.
     * (Required)
     * 
     */
    @JsonProperty("patch")
    public Integer getPatch() {
        return patch;
    }

    /**
     * Ideally, minor changes to a collection should result in the increment of this number.
     * (Required)
     * 
     */
    @JsonProperty("patch")
    public void setPatch(Integer patch) {
        this.patch = patch;
    }

    /**
     * A human friendly identifier to make sense of the version numbers. E.g: 'beta-3'
     * 
     */
    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    /**
     * A human friendly identifier to make sense of the version numbers. E.g: 'beta-3'
     * 
     */
    @JsonProperty("identifier")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @JsonProperty("meta")
    public Object getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(Object meta) {
        this.meta = meta;
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
