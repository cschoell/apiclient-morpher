
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


/**
 * Auth
 * <p>
 * Represents authentication helpers provided by Postman
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "noauth",
    "apikey",
    "awsv4",
    "basic",
    "bearer",
    "digest",
    "edgegrid",
    "hawk",
    "ntlm",
    "oauth1",
    "oauth2"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auth {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    private Auth.Type type;

    /**
     * API Key Authentication
     * <p>
     * The attributes for API Key Authentication.
     * 
     */
    @JsonProperty("apikey")
    @JsonPropertyDescription("The attributes for API Key Authentication.")
    private List<AuthAttribute> apikey = new ArrayList<>();
    /**
     * AWS Signature v4
     * <p>
     * The attributes for [AWS Auth](http://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html).
     * 
     */
    @JsonProperty("awsv4")
    @JsonPropertyDescription("The attributes for [AWS Auth](http://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html).")
    private List<AuthAttribute> awsv4 = new ArrayList<>();
    /**
     * Basic Authentication
     * <p>
     * The attributes for [Basic Authentication](https://en.wikipedia.org/wiki/Basic_access_authentication).
     * 
     */
    @JsonProperty("basic")
    @JsonPropertyDescription("The attributes for [Basic Authentication](https://en.wikipedia.org/wiki/Basic_access_authentication).")
    private List<AuthAttribute> basic = new ArrayList<>();
    /**
     * Bearer Token Authentication
     * <p>
     * The helper attributes for [Bearer Token Authentication](https://tools.ietf.org/html/rfc6750)
     * 
     */
    @JsonProperty("bearer")
    @JsonPropertyDescription("The helper attributes for [Bearer Token Authentication](https://tools.ietf.org/html/rfc6750)")
    private List<AuthAttribute> bearer = new ArrayList<>();
    /**
     * Digest Authentication
     * <p>
     * The attributes for [Digest Authentication](https://en.wikipedia.org/wiki/Digest_access_authentication).
     * 
     */
    @JsonProperty("digest")
    @JsonPropertyDescription("The attributes for [Digest Authentication](https://en.wikipedia.org/wiki/Digest_access_authentication).")
    private List<AuthAttribute> digest = new ArrayList<>();
    /**
     * EdgeGrid Authentication
     * <p>
     * The attributes for [Akamai EdgeGrid Authentication](https://developer.akamai.com/legacy/introduction/Client_Auth.html).
     * 
     */
    @JsonProperty("edgegrid")
    @JsonPropertyDescription("The attributes for [Akamai EdgeGrid Authentication](https://developer.akamai.com/legacy/introduction/Client_Auth.html).")
    private List<AuthAttribute> edgegrid = new ArrayList<>();
    /**
     * Hawk Authentication
     * <p>
     * The attributes for [Hawk Authentication](https://github.com/hueniverse/hawk)
     * 
     */
    @JsonProperty("hawk")
    @JsonPropertyDescription("The attributes for [Hawk Authentication](https://github.com/hueniverse/hawk)")
    private List<AuthAttribute> hawk = new ArrayList<>();
    /**
     * NTLM Authentication
     * <p>
     * The attributes for [NTLM Authentication](https://msdn.microsoft.com/en-us/library/cc237488.aspx)
     * 
     */
    @JsonProperty("ntlm")
    @JsonPropertyDescription("The attributes for [NTLM Authentication](https://msdn.microsoft.com/en-us/library/cc237488.aspx)")
    private List<AuthAttribute> ntlm = new ArrayList<>();
    /**
     * OAuth1
     * <p>
     * The attributes for [OAuth2](https://oauth.net/1/)
     * 
     */
    @JsonProperty("oauth1")
    @JsonPropertyDescription("The attributes for [OAuth2](https://oauth.net/1/)")
    private List<AuthAttribute> oauth1 = new ArrayList<>();
    /**
     * OAuth2
     * <p>
     * Helper attributes for [OAuth2](https://oauth.net/2/)
     * 
     */
    @JsonProperty("oauth2")
    @JsonPropertyDescription("Helper attributes for [OAuth2](https://oauth.net/2/)")
    private List<AuthAttribute> oauth2 = new ArrayList<>();
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();


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
        private final static Map<String, Auth.Type> CONSTANTS = new HashMap<>();

        static {
            for (Auth.Type c: values()) {
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
        public static Auth.Type fromValue(String value) {
            Auth.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
