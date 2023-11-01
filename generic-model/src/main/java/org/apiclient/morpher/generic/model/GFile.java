package org.apiclient.morpher.generic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GFile extends GenericModelBase{

    private String filePath;
    private String content;
}
