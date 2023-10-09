package org.cschoell.bruno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawBody extends BrunoValueBase implements Body {

    private BodyType type;

    @Override
    public String getComponentRootName() {
        return type == BodyType.none ? "body" : "body:" + type.inBrunoStyle();
    }


    @Override
    public boolean hasContent() {
        return StringUtils.isNotBlank(getValue());
    }
}
