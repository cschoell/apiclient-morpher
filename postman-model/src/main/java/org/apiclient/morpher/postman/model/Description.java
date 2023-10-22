
package org.apiclient.morpher.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Description
 * <p>
 * A Description can be a raw text, or be an object, which holds the description along with its format.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "content",
    "type",
    "version"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Description {

    /**
     * The content of the description goes here, as a raw string.
     * 
     */
    @JsonProperty("content")
    @JsonPropertyDescription("The content of the description goes here, as a raw string.")
    private String content;
    /**
     * Holds the mime type of the raw description content. E.g: 'text/markdown' or 'text/html'.
     * The type is used to correctly render the description when generating documentation, or in the Postman app.
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Holds the mime type of the raw description content. E.g: 'text/markdown' or 'text/html'.\nThe type is used to correctly render the description when generating documentation, or in the Postman app.")
    private String type;
    /**
     * Description can have versions associated with it, which should be put in this property.
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("Description can have versions associated with it, which should be put in this property.")
    private Object version;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();


    public Description(String content) {
        this.content = content;
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
