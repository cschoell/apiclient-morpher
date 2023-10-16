
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Url
 * <p>
 * If object, contains the complete broken-down URL for this request. If string, contains the literal request URL.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "raw",
    "protocol",
    "host",
    "path",
    "port",
    "query",
    "hash",
    "variable"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    /**
     * The string representation of the request URL, including the protocol, host, path, hash, query parameter(s) and path variable(s).
     * 
     */
    @JsonProperty("raw")
    @JsonPropertyDescription("The string representation of the request URL, including the protocol, host, path, hash, query parameter(s) and path variable(s).")
    private String raw;
    /**
     * The protocol associated with the request, E.g: 'http'
     * 
     */
    @JsonProperty("protocol")
    @JsonPropertyDescription("The protocol associated with the request, E.g: 'http'")
    private String protocol;
    /**
     * Host
     * <p>
     * The host for the URL, E.g: api.yourdomain.com. Can be stored as a string or as an array of strings.
     * 
     */
    @JsonProperty("host")
    @JsonPropertyDescription("The host for the URL, E.g: api.yourdomain.com. Can be stored as a string or as an array of strings.")
    private List<String> host = new ArrayList<>();
    /**
     * The complete path of the current url, broken down into segments. A segment could be a string, or a path variable.
     * 
     */
    @JsonProperty("path")
    @JsonPropertyDescription("The complete path of the current url, broken down into segments. A segment could be a string, or a path variable.")
    private List<String> path = new ArrayList<>();
    /**
     * The port number present in this URL. An empty value implies 80/443 depending on whether the protocol field contains http/https.
     * 
     */
    @JsonProperty("port")
    @JsonPropertyDescription("The port number present in this URL. An empty value implies 80/443 depending on whether the protocol field contains http/https.")
    private String port;
    /**
     * An array of QueryParams, which is basically the query string part of the URL, parsed into separate variables
     * 
     */
    @JsonProperty("query")
    @JsonPropertyDescription("An array of QueryParams, which is basically the query string part of the URL, parsed into separate variables")
    private List<Query> query = new ArrayList<>();
    /**
     * Contains the URL fragment (if any). Usually this is not transmitted over the network, but it could be useful to store this in some cases.
     * 
     */
    @JsonProperty("hash")
    @JsonPropertyDescription("Contains the URL fragment (if any). Usually this is not transmitted over the network, but it could be useful to store this in some cases.")
    private String hash;
    /**
     * Postman supports path variables with the syntax `/path/:variableName/to/somewhere`. These variables are stored in this field.
     * 
     */
    @JsonProperty("variable")
    @JsonPropertyDescription("Postman supports path variables with the syntax `/path/:variableName/to/somewhere`. These variables are stored in this field.")
    private List<Variable> variable = new ArrayList<>();
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    /**
     * The string representation of the request URL, including the protocol, host, path, hash, query parameter(s) and path variable(s).
     * 
     */
    @JsonProperty("raw")
    public String getRaw() {
        return raw;
    }

    /**
     * The string representation of the request URL, including the protocol, host, path, hash, query parameter(s) and path variable(s).
     * 
     */
    @JsonProperty("raw")
    public void setRaw(String raw) {
        this.raw = raw;
    }

    /**
     * The protocol associated with the request, E.g: 'http'
     * 
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * The protocol associated with the request, E.g: 'http'
     * 
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Host
     * <p>
     * The host for the URL, E.g: api.yourdomain.com. Can be stored as a string or as an array of strings.
     * 
     */
    @JsonProperty("host")
    public List<String> getHost() {
        return host;
    }

    /**
     * Host
     * <p>
     * The host for the URL, E.g: api.yourdomain.com. Can be stored as a string or as an array of strings.
     * 
     */
    @JsonProperty("host")
    public void setHost(List<String> host) {
        this.host = host;
    }

    /**
     * The complete path of the current url, broken down into segments. A segment could be a string, or a path variable.
     * 
     */
    @JsonProperty("path")
    public List<String> getPath() {
        return path;
    }

    /**
     * The complete path of the current url, broken down into segments. A segment could be a string, or a path variable.
     * 
     */
    @JsonProperty("path")
    public void setPath(List<String> path) {
        this.path = path;
    }

    /**
     * The port number present in this URL. An empty value implies 80/443 depending on whether the protocol field contains http/https.
     * 
     */
    @JsonProperty("port")
    public String getPort() {
        return port;
    }

    /**
     * The port number present in this URL. An empty value implies 80/443 depending on whether the protocol field contains http/https.
     * 
     */
    @JsonProperty("port")
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * An array of QueryParams, which is basically the query string part of the URL, parsed into separate variables
     * 
     */
    @JsonProperty("query")
    public List<Query> getQuery() {
        return query;
    }

    /**
     * An array of QueryParams, which is basically the query string part of the URL, parsed into separate variables
     * 
     */
    @JsonProperty("query")
    public void setQuery(List<Query> query) {
        this.query = query;
    }

    /**
     * Contains the URL fragment (if any). Usually this is not transmitted over the network, but it could be useful to store this in some cases.
     * 
     */
    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    /**
     * Contains the URL fragment (if any). Usually this is not transmitted over the network, but it could be useful to store this in some cases.
     * 
     */
    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * Postman supports path variables with the syntax `/path/:variableName/to/somewhere`. These variables are stored in this field.
     * 
     */
    @JsonProperty("variable")
    public List<Variable> getVariable() {
        return variable;
    }

    /**
     * Postman supports path variables with the syntax `/path/:variableName/to/somewhere`. These variables are stored in this field.
     * 
     */
    @JsonProperty("variable")
    public void setVariable(List<Variable> variable) {
        this.variable = variable;
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
