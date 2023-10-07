
package org.cschoell.postman.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


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
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The content of the description goes here, as a raw string.
     * 
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * The content of the description goes here, as a raw string.
     * 
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Holds the mime type of the raw description content. E.g: 'text/markdown' or 'text/html'.
     * The type is used to correctly render the description when generating documentation, or in the Postman app.
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Holds the mime type of the raw description content. E.g: 'text/markdown' or 'text/html'.
     * The type is used to correctly render the description when generating documentation, or in the Postman app.
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Description can have versions associated with it, which should be put in this property.
     * 
     */
    @JsonProperty("version")
    public Object getVersion() {
        return version;
    }

    /**
     * Description can have versions associated with it, which should be put in this property.
     * 
     */
    @JsonProperty("version")
    public void setVersion(Object version) {
        this.version = version;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
