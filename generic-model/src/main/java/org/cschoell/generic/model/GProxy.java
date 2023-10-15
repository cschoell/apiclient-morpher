package org.cschoell.generic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GProxy extends GenericModelBase {

    /**
     * The Url match for which the proxy config is defined
     *
     */
    @JsonProperty("match")
    @JsonPropertyDescription("The Url match for which the proxy config is defined")
    private String match = "http+https://*/*";
    /**
     * The proxy server host
     *
     */
    @JsonProperty("host")
    @JsonPropertyDescription("The proxy server host")
    private String host;
    /**
     * The proxy server port
     *
     */
    @JsonProperty("port")
    @JsonPropertyDescription("The proxy server port")
    private Integer port = 8080;
    /**
     * The tunneling details for the proxy config
     *
     */
    @JsonProperty("tunnel")
    @JsonPropertyDescription("The tunneling details for the proxy config")
    private Boolean tunnel = false;
    /**
     * When set to true, ignores this proxy configuration entity
     *
     */
    @JsonProperty("disabled")
    @JsonPropertyDescription("When set to true, ignores this proxy configuration entity")
    private Boolean disabled = false;

}
