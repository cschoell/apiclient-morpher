package org.cschoell.bruno.model;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawBody extends BrunoValueBase implements Body {

    private BodyType type;

    @Override
    public String getComponentRootName() {
        final String style = type == null ? BodyType.none.name() : type.inBrunoStyle();
        return type == BodyType.none ? "body" : "body:" + style;
    }


    @Override
    public boolean hasContent() {
        return StringUtils.isNotBlank(getValue());
    }
}
