package org.apiclient.morpher.bruno.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@JsonPropertyOrder({
        "url",
        "body",
        "auth"
})
public class Request extends BrunoModelBase {

    private String method;
    private String url;
    private BodyType body;
    private AuthType auth;

    @Override
    public String getComponentRootName() {
        return StringUtils.lowerCase(getMethod());
    }
    @JsonIgnore
    public String getMethod() {
        return method;
    }

    @JsonIgnore
    public void setMethod(String method) {
        this.method = StringUtils.lowerCase(method);
    }

    public void setAuthString(String auth) {
        try {
            this.auth = AuthType.valueOf(auth);
        } catch (IllegalArgumentException e) {
            this.auth = AuthType.none;
        }
    }

    public void setAuth(AuthType auth) {
        this.auth = auth;
    }
}
