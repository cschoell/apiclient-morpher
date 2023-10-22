package org.apiclient.morpher.bruno.model;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawBody extends BrunoValueBase implements Body {

    private BodyType bodyType;

    @Override
    public String getComponentRootName() {
        final String style = bodyType == null ? BodyType.none.name() : bodyType.inBrunoStyle();
        return bodyType == BodyType.none ? "body" : "body:" + style;
    }


    @Override
    public boolean hasContent() {
        return StringUtils.isNotBlank(getValue());
    }
}
