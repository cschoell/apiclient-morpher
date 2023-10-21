package org.cschoell.generic.model;

import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class GHeader extends GenericKeyValueBase {

    public GHeader(String key, String value) {
        super(key, value);
    }
}
