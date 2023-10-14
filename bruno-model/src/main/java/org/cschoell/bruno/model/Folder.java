package org.cschoell.bruno.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.io.FileSystem;

import java.util.LinkedList;
import java.util.List;

@ToString(callSuper = true)
@Data
@NoArgsConstructor
public class Folder {

    String name;

    public Folder(String name) {
        this.name = name;
    }

    public String getFolderName() {
        return org.apache.commons.io.FileSystem.getCurrent().toLegalFileName(name, '_');
    }

    List<BrunoRequestFile> requests = new LinkedList<>();
    List<Folder> subFolder = new LinkedList<>();
}
