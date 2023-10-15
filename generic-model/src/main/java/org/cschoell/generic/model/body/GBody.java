package org.cschoell.generic.model.body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.cschoell.generic.model.GFile;
import org.cschoell.generic.model.GGraphql;
import org.cschoell.generic.model.GValue;
import org.cschoell.generic.model.GenericModelBase;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GBody extends GenericModelBase {

    GBodyContentType contentType;

    GValue text;
    GKeyValueBody urlencoded;
    GKeyValueBody formdata;
    GGraphql graphql;
    GFile file;



}
