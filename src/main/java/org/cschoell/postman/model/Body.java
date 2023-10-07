
package org.cschoell.postman.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;


/**
 * This field contains the data usually contained in the request body.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mode",
    "raw",
    "urlencoded",
    "formdata",
    "file",
    "graphql",
    "options",
    "disabled"
})
@Data
public class Body {

    /**
     * Postman stores the type of data associated with this request in this field.
     * 
     */
    @JsonProperty("mode")
    @JsonPropertyDescription("Postman stores the type of data associated with this request in this field.")
    private Body.Mode mode;
    @JsonProperty("raw")
    private String raw;
    @JsonProperty("urlencoded")
    private List<Urlencoded> urlencoded = new ArrayList<Urlencoded>();
    @JsonProperty("formdata")
    private List<Formdatum> formdata = new ArrayList<Formdatum>();
    @JsonProperty("file")
    private File file;
    @JsonProperty("graphql")
    private Graphql graphql;
    /**
     * Additional configurations and options set for various body modes.
     * 
     */
    @JsonProperty("options")
    @JsonPropertyDescription("Additional configurations and options set for various body modes.")
    private Options options;
    /**
     * When set to true, prevents request body from being sent.
     * 
     */
    @JsonProperty("disabled")
    @JsonPropertyDescription("When set to true, prevents request body from being sent.")
    private Boolean disabled = false;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Postman stores the type of data associated with this request in this field.
     * 
     */
    @JsonProperty("mode")
    public Body.Mode getMode() {
        return mode;
    }

    /**
     * Postman stores the type of data associated with this request in this field.
     * 
     */
    @JsonProperty("mode")
    public void setMode(Body.Mode mode) {
        this.mode = mode;
    }

    @JsonProperty("raw")
    public String getRaw() {
        return raw;
    }

    @JsonProperty("raw")
    public void setRaw(String raw) {
        this.raw = raw;
    }

    @JsonProperty("urlencoded")
    public List<Urlencoded> getUrlencoded() {
        return urlencoded;
    }

    @JsonProperty("urlencoded")
    public void setUrlencoded(List<Urlencoded> urlencoded) {
        this.urlencoded = urlencoded;
    }

    @JsonProperty("formdata")
    public List<Formdatum> getFormdata() {
        return formdata;
    }

    @JsonProperty("formdata")
    public void setFormdata(List<Formdatum> formdata) {
        this.formdata = formdata;
    }

    @JsonProperty("file")
    public File getFile() {
        return file;
    }

    @JsonProperty("file")
    public void setFile(File file) {
        this.file = file;
    }

    @JsonProperty("graphql")
    public Graphql getGraphql() {
        return graphql;
    }

    @JsonProperty("graphql")
    public void setGraphql(Graphql graphql) {
        this.graphql = graphql;
    }

    /**
     * Additional configurations and options set for various body modes.
     * 
     */
    @JsonProperty("options")
    public Options getOptions() {
        return options;
    }

    /**
     * Additional configurations and options set for various body modes.
     * 
     */
    @JsonProperty("options")
    public void setOptions(Options options) {
        this.options = options;
    }

    /**
     * When set to true, prevents request body from being sent.
     * 
     */
    @JsonProperty("disabled")
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * When set to true, prevents request body from being sent.
     * 
     */
    @JsonProperty("disabled")
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    /**
     * Postman stores the type of data associated with this request in this field.
     * 
     */
    public enum Mode {

        raw("raw"),
        urlencoded("urlencoded"),
        formdata("formdata"),
        file("file"),
        graphql("graphql");
        private final String value;
        private final static Map<String, Body.Mode> CONSTANTS = new HashMap<String, Body.Mode>();

        static {
            for (Body.Mode c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Mode(String value) {
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
        public static Body.Mode fromValue(String value) {
            Body.Mode constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
