package org.cschoell.generic.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GAuth extends GenericModelBase {

    private GAuth.Type authType;

    List<GAuthAttribute> authAttributes = new LinkedList<>();

    public enum Type {

        NOAUTH("noauth"),
        APIKEY("apikey"),
        @JsonProperty("awsv4")
        AWSV_4("awsv4"),
        BASIC("basic"),
        BEARER("bearer"),
        DIGEST("digest"),
        EDGEGRID("edgegrid"),
        HAWK("hawk"),
        @JsonProperty("oauth1")
        OAUTH_1("oauth1"),
        @JsonProperty("oauth2")
        OAUTH_2("oauth2"),
        NTLM("ntlm");
        private final String value;
        private final static Map<String, GAuth.Type> CONSTANTS = new HashMap<>();

        static {
            for (GAuth.Type c: values()) {
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
        public static GAuth.Type fromValue(String value) {
            GAuth.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
