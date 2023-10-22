
package org.apiclient.morpher.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * FormParameter
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "value",
    "src",
    "disabled",
    "type",
    "contentType",
    "description"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formdatum {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    private String key;
    @JsonProperty("value")
    private String value;
    @JsonProperty("src")
    private String src;
    /**
     * When set to true, prevents this form data entity from being sent.
     * 
     */
    @JsonProperty("disabled")
    @JsonPropertyDescription("When set to true, prevents this form data entity from being sent.")
    private Boolean disabled = false;
    @JsonProperty("type")
    private Formdatum.Type type;
    /**
     * Override Content-Type header of this form data entity.
     * 
     */
    @JsonProperty("contentType")
    @JsonPropertyDescription("Override Content-Type header of this form data entity.")
    private String contentType;
    /**
     * Description
     * <p>
     * A Description can be a raw text, or be an object, which holds the description along with its format.
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("A Description can be a raw text, or be an object, which holds the description along with its format.")
    private Description description;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    public Formdatum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public enum Type {

        TEXT("text"),
        FILE("file");
        private final String value;
        private final static Map<String, Formdatum.Type> CONSTANTS = new HashMap<>();

        static {
            for (Formdatum.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Formdatum.Type fromValue(String value) {
            Formdatum.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
