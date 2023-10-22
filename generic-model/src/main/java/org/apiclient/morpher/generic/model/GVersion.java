package org.apiclient.morpher.generic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GVersion extends GenericModelBase {
    /**
     * Increment this number if you make changes to the collection that changes its behaviour. E.g: Removing or adding new test scripts. (partly or completely).
     * (Required)
     */
    @JsonProperty("major")
    @JsonPropertyDescription("Increment this number if you make changes to the collection that changes its behaviour. E.g: Removing or adding new test scripts. (partly or completely).")
    private Integer major;
    /**
     * You should increment this number if you make changes that will not break anything that uses the collection. E.g: removing a folder.
     * (Required)
     */
    @JsonProperty("minor")
    @JsonPropertyDescription("You should increment this number if you make changes that will not break anything that uses the collection. E.g: removing a folder.")
    private Integer minor;
    /**
     * Ideally, minor changes to a collection should result in the increment of this number.
     * (Required)
     */
    @JsonProperty("patch")
    @JsonPropertyDescription("Ideally, minor changes to a collection should result in the increment of this number.")
    private Integer patch;
    /**
     * A human friendly identifier to make sense of the version numbers. E.g: 'beta-3'
     */
    @JsonProperty("identifier")
    @JsonPropertyDescription("A human friendly identifier to make sense of the version numbers. E.g: 'beta-3'")
    private String identifier;
}
