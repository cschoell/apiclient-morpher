package org.cschoell.generic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GScript extends GenericModelBase {

    /**
     * The script to execute
     */
    String exec;

    String  srcUrl;

    String contentType;

    String name;

    String id;

    boolean disabled;

    /**
     * The client this script has been copied from originally
     */
    ApiConfigurationType scriptOriginClient;
}
