package org.apiclient.morpher.generic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GCollection extends GenericModelBase{

    GInfo info;
    List<GFolder> folders = new LinkedList<>();
    List<GRequest> requests = new LinkedList<>();
    List<GVariable> variables;
    GAuth auth;
    GProtocolProfileBehavior protocolProfileBehavior;

}
