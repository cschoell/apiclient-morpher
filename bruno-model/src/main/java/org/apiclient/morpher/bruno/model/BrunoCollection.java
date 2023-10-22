package org.apiclient.morpher.bruno.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Data
public class BrunoCollection {

    private Meta meta;

    private List<BrunoRequestFile> requests = new ArrayList<>();

    private List<Folder> folders = new ArrayList<>();

}
