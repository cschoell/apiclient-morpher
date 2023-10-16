
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "src",
    "content"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {

    /**
     * Contains the name of the file to upload. _Not the path_.
     * 
     */
    @JsonProperty("src")
    @JsonPropertyDescription("Contains the name of the file to upload. _Not the path_.")
    private String src;
    @JsonProperty("content")
    private String content;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    /**
     * Contains the name of the file to upload. _Not the path_.
     * 
     */
    @JsonProperty("src")
    public String getSrc() {
        return src;
    }

    /**
     * Contains the name of the file to upload. _Not the path_.
     * 
     */
    @JsonProperty("src")
    public void setSrc(String src) {
        this.src = src;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
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
