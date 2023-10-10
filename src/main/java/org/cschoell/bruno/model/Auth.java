package org.cschoell.bruno.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;

@Data
public class Auth extends LinkedHashMap<String, String> implements BrunoModelComponentRoot {

    @Override
    public String getComponentRootName() {
        return "auth:" + type;
    }

    private AuthType type;

    @Override
    public boolean hidden() {
        return type == AuthType.none;
    }

    public void setType(String type) {
        try {
            this.type = AuthType.valueOf(StringUtils.lowerCase(type));
        } catch (IllegalArgumentException e) {
            this.type = AuthType.none;
        }
    }
}
