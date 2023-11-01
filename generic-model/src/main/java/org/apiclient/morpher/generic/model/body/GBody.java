package org.apiclient.morpher.generic.model.body;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apiclient.morpher.generic.model.GFile;
import org.apiclient.morpher.generic.model.GGraphql;
import org.apiclient.morpher.generic.model.GValue;
import org.apiclient.morpher.generic.model.GenericModelBase;

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

    String src;



}
