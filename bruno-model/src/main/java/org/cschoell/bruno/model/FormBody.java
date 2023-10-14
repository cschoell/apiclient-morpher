package org.cschoell.bruno.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.LinkedHashMap;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class FormBody extends LinkedHashMap<String, String> implements Body {

    private BodyType type;
    @Override
    public String getComponentRootName() {
        return type == BodyType.none ? "body" : "body:" + type.inBrunoStyle();
    }

    @JsonIgnore
    public BodyType getType() {
        return type;
    }

    @Override
    public boolean hasContent() {
        return !this.isEmpty();
    }


}
