package org.apiclient.morpher.generic.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.lowerCase;

@Data
@JsonPropertyOrder(alphabetic = true)
public class GenericModelBase {

    private GDescription description;

    private String type;

    private Map<String, GAdditionalProperty> additionalProperties = new LinkedHashMap<>();

    public String getType() {
        if (StringUtils.isBlank(type)) return lowerCase(getClass().getSimpleName());
        return type;
    }
}
