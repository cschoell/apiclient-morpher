package org.cschoell.generic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class GFolder extends GenericModelBase {

    String name;

    List<GFolder> subFolders;
    List<GRequest> requests;

    GAuth auth;

    public GFolder(String name) {
        this.name = name;
    }
}
