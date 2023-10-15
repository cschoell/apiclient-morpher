package org.cschoell.generic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GCertificate extends GenericModelBase {

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
    private GFile key;
    /**
     * An object containing path to file certificate, on the file system
     *
     */
    @JsonProperty("cert")
    @JsonPropertyDescription("An object containing path to file certificate, on the file system")
    private GFile cert;
    /**
     * The passphrase for the certificate
     *
     */
    @JsonProperty("passphrase")
    @JsonPropertyDescription("The passphrase for the certificate")
    private String passphrase;

}
