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

    private String type;

    public void setType(String type) {
        this.type = StringUtils.lowerCase(type);
    }
}
