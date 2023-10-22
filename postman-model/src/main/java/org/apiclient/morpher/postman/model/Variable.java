
package org.apiclient.morpher.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Variable
 * <p>
 * Using variables in your Postman requests eliminates the need to duplicate requests, which can save a lot of time. Variables can be defined, and referenced to from any part of a request.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "key",
    "value",
    "type",
    "name",
    "description",
    "system",
    "disabled"
})
@Data
public class Variable {

    /**
     * A variable ID is a unique user-defined value that identifies the variable within a collection. In traditional terms, this would be a variable name.
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("A variable ID is a unique user-defined value that identifies the variable within a collection. In traditional terms, this would be a variable name.")
    private String id;
    /**
     * A variable key is a human friendly value that identifies the variable within a collection. In traditional terms, this would be a variable name.
     * 
     */
    @JsonProperty("key")
    @JsonPropertyDescription("A variable key is a human friendly value that identifies the variable within a collection. In traditional terms, this would be a variable name.")
    private String key;
    /**
     * The value that a variable holds in this collection. Ultimately, the variables will be replaced by this value, when say running a set of requests from a collection
     * 
     */
    @JsonProperty("value")
    @JsonPropertyDescription("The value that a variable holds in this collection. Ultimately, the variables will be replaced by this value, when say running a set of requests from a collection")
    private String value;
    /**
     * A variable may have multiple types. This field specifies the type of the variable.
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("A variable may have multiple types. This field specifies the type of the variable.")
    private Variable.Type type;
    /**
     * Variable name
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Variable name")
    private String name;
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
     * When set to true, indicates that this variable has been set by Postman
     * 
     */
    @JsonProperty("system")
    @JsonPropertyDescription("When set to true, indicates that this variable has been set by Postman")
    private Boolean system = false;
    @JsonProperty("disabled")
    private Boolean disabled = false;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();


    /**
     * A variable may have multiple types. This field specifies the type of the variable.
     * 
     */
    public enum Type {

        STRING("string"),
        BOOLEAN("boolean"),
        ANY("any"),
        NUMBER("number");
        private final String value;
        private final static Map<String, Variable.Type> CONSTANTS = new HashMap<>();

        static {
            for (Variable.Type c: values()) {
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
        public static Variable.Type fromValue(String value) {
            Variable.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
