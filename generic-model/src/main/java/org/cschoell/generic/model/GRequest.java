package org.cschoell.generic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.cschoell.generic.model.body.GBody;
import org.cschoell.generic.model.body.GBodyContentType;
import org.cschoell.generic.model.body.GKeyValueBody;
import org.cschoell.generic.model.body.GValueBody;

import java.util.LinkedList;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GRequest extends GenericModelBase {

    GRequestMeta meta;

    GAuth auth;

    GBody body;

    List<GQuery> query = new LinkedList<>();

    GUrl url;
    GProxy proxy;
    GCertificate certificate;
    HttpMethodType method;

    List<GHeader> header = new LinkedList<>();

    GScript tests;
    GVariables postResponseVars;
    GVariables preRequestVars;
    GScript postResponseScript;
    GScript preRequestScript;
}
