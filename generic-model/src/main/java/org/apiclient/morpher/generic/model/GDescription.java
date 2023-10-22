package org.apiclient.morpher.generic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class GDescription {


    /**
     * The content of the description goes here, as a raw string.
     */
    @JsonProperty("content")
    @JsonPropertyDescription("The content of the description goes here, as a raw string.")
    private String content;
    /**
     * Holds the mime type of the raw description content. E.g: 'text/markdown' or 'text/html'.
     * The type is used to correctly render the description when generating documentation, or in the Postman app.
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Holds the mime type of the raw description content. E.g: 'text/markdown' or 'text/html'.\nThe type is used to correctly render the description when generating documentation, or in the Postman app.")
    private String type;
}
