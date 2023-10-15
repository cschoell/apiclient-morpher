
package org.cschoell.postman.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Response
 * <p>
 * A response represents an HTTP response.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "originalRequest",
    "responseTime",
    "timings",
    "header",
    "cookie",
    "body",
    "status",
    "code"
})
@Data
public class Response {

    /**
     * A unique, user defined identifier that can  be used to refer to this response from requests.
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("A unique, user defined identifier that can  be used to refer to this response from requests.")
    private String id;
    /**
     * Request
     * <p>
     * A request represents an HTTP request. If a string, the string is assumed to be the request URL and the method is assumed to be 'GET'.
     * 
     */
    @JsonProperty("originalRequest")
    @JsonPropertyDescription("A request represents an HTTP request. If a string, the string is assumed to be the request URL and the method is assumed to be 'GET'.")
    private Request originalRequest;
    /**
     * ResponseTime
     * <p>
     * The time taken by the request to complete. If a number, the unit is milliseconds. If the response is manually created, this can be set to `null`.
     * 
     */
    @JsonProperty("responseTime")
    @JsonPropertyDescription("The time taken by the request to complete. If a number, the unit is milliseconds. If the response is manually created, this can be set to `null`.")
    private String responseTime;
    /**
     * Response Timings
     * <p>
     * Set of timing information related to request and response in milliseconds
     * 
     */
    @JsonProperty("timings")
    @JsonPropertyDescription("Set of timing information related to request and response in milliseconds")
    private Timings timings;
    /**
     * Headers
     * <p>
     * No HTTP request is complete without its headers, and the same is true for a Postman request. This field is an array containing all the headers.
     * 
     */
    @JsonProperty("header")
    @JsonPropertyDescription("No HTTP request is complete without its headers, and the same is true for a Postman request. This field is an array containing all the headers.")
    private List<Header> header = new ArrayList<>();
    @JsonProperty("cookie")
    private List<Cookie> cookie = new ArrayList<>();
    /**
     * The raw text of the response.
     * 
     */
    @JsonProperty("body")
    @JsonPropertyDescription("The raw text of the response.")
    private String body;
    /**
     * The response status, e.g: '200 OK'
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("The response status, e.g: '200 OK'")
    private String status;
    /**
     * The numerical response code, example: 200, 201, 404, etc.
     * 
     */
    @JsonProperty("code")
    @JsonPropertyDescription("The numerical response code, example: 200, 201, 404, etc.")
    private Integer code;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    /**
     * A unique, user defined identifier that can  be used to refer to this response from requests.
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * A unique, user defined identifier that can  be used to refer to this response from requests.
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Request
     * <p>
     * A request represents an HTTP request. If a string, the string is assumed to be the request URL and the method is assumed to be 'GET'.
     * 
     */
    @JsonProperty("originalRequest")
    public Request getOriginalRequest() {
        return originalRequest;
    }

    /**
     * Request
     * <p>
     * A request represents an HTTP request. If a string, the string is assumed to be the request URL and the method is assumed to be 'GET'.
     * 
     */
    @JsonProperty("originalRequest")
    public void setOriginalRequest(Request originalRequest) {
        this.originalRequest = originalRequest;
    }

    /**
     * ResponseTime
     * <p>
     * The time taken by the request to complete. If a number, the unit is milliseconds. If the response is manually created, this can be set to `null`.
     * 
     */
    @JsonProperty("responseTime")
    public String getResponseTime() {
        return responseTime;
    }

    /**
     * ResponseTime
     * <p>
     * The time taken by the request to complete. If a number, the unit is milliseconds. If the response is manually created, this can be set to `null`.
     * 
     */
    @JsonProperty("responseTime")
    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * Response Timings
     * <p>
     * Set of timing information related to request and response in milliseconds
     * 
     */
    @JsonProperty("timings")
    public Timings getTimings() {
        return timings;
    }

    /**
     * Response Timings
     * <p>
     * Set of timing information related to request and response in milliseconds
     * 
     */
    @JsonProperty("timings")
    public void setTimings(Timings timings) {
        this.timings = timings;
    }

    /**
     * Headers
     * <p>
     * No HTTP request is complete without its headers, and the same is true for a Postman request. This field is an array containing all the headers.
     * 
     */
    @JsonProperty("header")
    public List<Header> getHeader() {
        return header;
    }

    /**
     * Headers
     * <p>
     * No HTTP request is complete without its headers, and the same is true for a Postman request. This field is an array containing all the headers.
     * 
     */
    @JsonProperty("header")
    public void setHeader(List<Header> header) {
        this.header = header;
    }

    @JsonProperty("cookie")
    public List<Cookie> getCookie() {
        return cookie;
    }

    @JsonProperty("cookie")
    public void setCookie(List<Cookie> cookie) {
        this.cookie = cookie;
    }

    /**
     * The raw text of the response.
     * 
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     * The raw text of the response.
     * 
     */
    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * The response status, e.g: '200 OK'
     * 
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * The response status, e.g: '200 OK'
     * 
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * The numerical response code, example: 200, 201, 404, etc.
     * 
     */
    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    /**
     * The numerical response code, example: 200, 201, 404, etc.
     * 
     */
    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
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
