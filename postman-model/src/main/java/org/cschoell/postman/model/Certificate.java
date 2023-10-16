
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
 * Certificate
 * <p>
 * A representation of an ssl certificate
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "matches",
    "key",
    "cert",
    "passphrase"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certificate {

    /**
     * A name for the certificate for user reference
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("A name for the certificate for user reference")
    private String name;
    /**
     * A list of Url match pattern strings, to identify Urls this certificate can be used for.
     * 
     */
    @JsonProperty("matches")
    @JsonPropertyDescription("A list of Url match pattern strings, to identify Urls this certificate can be used for.")
    private List<String> matches = new ArrayList<>();
    /**
     * An object containing path to file containing private key, on the file system
     * 
     */
    @JsonProperty("key")
    @JsonPropertyDescription("An object containing path to file containing private key, on the file system")
    private Key key;
    /**
     * An object containing path to file certificate, on the file system
     * 
     */
    @JsonProperty("cert")
    @JsonPropertyDescription("An object containing path to file certificate, on the file system")
    private Cert cert;
    /**
     * The passphrase for the certificate
     * 
     */
    @JsonProperty("passphrase")
    @JsonPropertyDescription("The passphrase for the certificate")
    private String passphrase;
    @JsonIgnore
    private Map<String, AdditionalProperty> additionalProperties = new LinkedHashMap<>();

    /**
     * A name for the certificate for user reference
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * A name for the certificate for user reference
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A list of Url match pattern strings, to identify Urls this certificate can be used for.
     * 
     */
    @JsonProperty("matches")
    public List<String> getMatches() {
        return matches;
    }

    /**
     * A list of Url match pattern strings, to identify Urls this certificate can be used for.
     * 
     */
    @JsonProperty("matches")
    public void setMatches(List<String> matches) {
        this.matches = matches;
    }

    /**
     * An object containing path to file containing private key, on the file system
     * 
     */
    @JsonProperty("key")
    public Key getKey() {
        return key;
    }

    /**
     * An object containing path to file containing private key, on the file system
     * 
     */
    @JsonProperty("key")
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * An object containing path to file certificate, on the file system
     * 
     */
    @JsonProperty("cert")
    public Cert getCert() {
        return cert;
    }

    /**
     * An object containing path to file certificate, on the file system
     * 
     */
    @JsonProperty("cert")
    public void setCert(Cert cert) {
        this.cert = cert;
    }

    /**
     * The passphrase for the certificate
     * 
     */
    @JsonProperty("passphrase")
    public String getPassphrase() {
        return passphrase;
    }

    /**
     * The passphrase for the certificate
     * 
     */
    @JsonProperty("passphrase")
    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
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
