package org.apiclient.morpher.bruno.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.LinkedHashMap;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class FormBody extends LinkedHashMap<String, String> implements Body {

    private BodyType bodyType;
    @Override
    public String getComponentRootName() {
        return bodyType == BodyType.none ? "body" : "body:" + bodyType.inBrunoStyle();
    }

    @JsonIgnore
    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public boolean hasContent() {
        return !this.isEmpty();
    }


}
