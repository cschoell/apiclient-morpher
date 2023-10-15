package org.cschoell.generic.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.lowerCase;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class GenericKeyValueBase extends GenericModelBase {
    private String key;
    private String value;
}
