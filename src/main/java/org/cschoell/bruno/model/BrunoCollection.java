package org.cschoell.bruno.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BrunoCollection {
    private List<BrunoRequestFile> requests = new ArrayList<>();

    private List<Folder> folders = new ArrayList<>();

}
