package org.apiclient.morpher.generic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apiclient.morpher.generic.model.body.GBody;

import java.util.LinkedList;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GRequest extends GenericModelBase {

    GValue asserts;
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
