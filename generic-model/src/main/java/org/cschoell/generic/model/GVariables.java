package org.cschoell.generic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GVariables extends GenericModelBase {
    List<GVariable> variable = new LinkedList<>();
}
