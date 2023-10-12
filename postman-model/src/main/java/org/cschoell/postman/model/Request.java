
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.*;


/**
 * Request
 * <p>
 * A request represents an HTTP request. If a string, the string is assumed to be the request URL and the method is assumed to be 'GET'.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "auth",
    "proxy",
    "certificate",
    "method",
    "description",
    "header",
    "body"
})
@Data
public class Request {

    /**
     * Url
     * <p>
     * If object, contains the complete broken-down URL for this request. If string, contains the literal request URL.
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("If object, contains the complete broken-down URL for this request. If string, contains the literal request URL.")
    private Url url;
    /**
     * Auth
     * <p>
     * Represents authentication helpers provided by Postman
     * 
     */
    @JsonProperty("auth")
    @JsonPropertyDescription("Represents authentication helpers provided by Postman")
    private Auth auth;
    /**
     * Proxy Config
     * <p>
     * Using the Proxy, you can configure your custom proxy into the postman for particular url match
     * 
     */
    @JsonProperty("proxy")
    @JsonPropertyDescription("Using the Proxy, you can configure your custom proxy into the postman for particular url match")
    private ProxyConfig proxy;
    /**
     * Certificate
     * <p>
     * A representation of an ssl certificate
     * 
     */
    @JsonProperty("certificate")
    @JsonPropertyDescription("A representation of an ssl certificate")
    private Certificate certificate;
    /**
     * The Standard HTTP method associated with this request.
     * 
     */
    @JsonProperty("method")
    @JsonPropertyDescription("The Standard HTTP method associated with this request.")
    private Request.Method method;
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
     * Header List
     * <p>
     * A representation for a list of headers
     * 
     */
    @JsonProperty("header")
    @JsonPropertyDescription("A representation for a list of headers")
    private List<Header> header = new ArrayList<Header>();
    /**
     * This field contains the data usually contained in the request body.
     * 
     */
    @JsonProperty("body")
    @JsonPropertyDescription("This field contains the data usually contained in the request body.")
    private Body body;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    /**
     * Url
     * <p>
     * If object, contains the complete broken-down URL for this request. If string, contains the literal request URL.
     * 
     */
    @JsonProperty("url")
    public Url getUrl() {
        return url;
    }

    /**
     * Url
     * <p>
     * If object, contains the complete broken-down URL for this request. If string, contains the literal request URL.
     * 
     */
    @JsonProperty("url")
    public void setUrl(Url url) {
        this.url = url;
    }

    /**
     * Auth
     * <p>
     * Represents authentication helpers provided by Postman
     * 
     */
    @JsonProperty("auth")
    public Auth getAuth() {
        return auth;
    }

    /**
     * Auth
     * <p>
     * Represents authentication helpers provided by Postman
     * 
     */
    @JsonProperty("auth")
    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    /**
     * Proxy Config
     * <p>
     * Using the Proxy, you can configure your custom proxy into the postman for particular url match
     * 
     */
    @JsonProperty("proxy")
    public ProxyConfig getProxy() {
        return proxy;
    }

    /**
     * Proxy Config
     * <p>
     * Using the Proxy, you can configure your custom proxy into the postman for particular url match
     * 
     */
    @JsonProperty("proxy")
    public void setProxy(ProxyConfig proxy) {
        this.proxy = proxy;
    }

    /**
     * Certificate
     * <p>
     * A representation of an ssl certificate
     * 
     */
    @JsonProperty("certificate")
    public Certificate getCertificate() {
        return certificate;
    }

    /**
     * Certificate
     * <p>
     * A representation of an ssl certificate
     * 
     */
    @JsonProperty("certificate")
    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    /**
     * The Standard HTTP method associated with this request.
     * 
     */
    @JsonProperty("method")
    public Request.Method getMethod() {
        return method;
    }

    /**
     * The Standard HTTP method associated with this request.
     * 
     */
    @JsonProperty("method")
    public void setMethod(Request.Method method) {
        this.method = method;
    }

    /**
     * Description
     * <p>
     * A Description can be a raw text, or be an object, which holds the description along with its format.
     * 
     */
    @JsonProperty("description")
    public Description getDescription() {
        return description;
    }

    /**
     * Description
     * <p>
     * A Description can be a raw text, or be an object, which holds the description along with its format.
     * 
     */
    @JsonProperty("description")
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * Header List
     * <p>
     * A representation for a list of headers
     * 
     */
    @JsonProperty("header")
    public List<Header> getHeader() {
        return header;
    }

    /**
     * Header List
     * <p>
     * A representation for a list of headers
     * 
     */
    @JsonProperty("header")
    public void setHeader(List<Header> header) {
        this.header = header;
    }

    /**
     * This field contains the data usually contained in the request body.
     * 
     */
    @JsonProperty("body")
    public Body getBody() {
        return body;
    }

    /**
     * This field contains the data usually contained in the request body.
     * 
     */
    @JsonProperty("body")
    public void setBody(Body body) {
        this.body = body;
    }

    @JsonAnyGetter
    public Map<String, AdditionalProperty> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, AdditionalProperty value) {
        this.additionalProperties.put(name, value);
    }


    /**
     * The Standard HTTP method associated with this request.
     * 
     */
    public enum Method {

        GET("GET"),
        PUT("PUT"),
        POST("POST"),
        PATCH("PATCH"),
        DELETE("DELETE"),
        COPY("COPY"),
        HEAD("HEAD"),
        OPTIONS("OPTIONS"),
        LINK("LINK"),
        UNLINK("UNLINK"),
        PURGE("PURGE"),
        LOCK("LOCK"),
        UNLOCK("UNLOCK"),
        PROPFIND("PROPFIND"),
        VIEW("VIEW");
        private final String value;
        private final static Map<String, Request.Method> CONSTANTS = new HashMap<String, Request.Method>();

        static {
            for (Request.Method c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Method(String value) {
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
        public static Request.Method fromValue(String value) {
            Request.Method constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
