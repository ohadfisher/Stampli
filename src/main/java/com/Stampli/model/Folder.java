package com.Stampli.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Folder extends FileSystemBaseEntity {

    private Set<FileSystemBaseEntity> allFileOrFolder;


    public Folder(long id, String name, Optional<Long> pid) {
        super(id, name, pid);
        allFileOrFolder = new HashSet<>();
    }


    public Set<FileSystemBaseEntity> getAllFileOrFolder() {
        return allFileOrFolder;
    }

    public void addToAllFileOrFolder(FileSystemBaseEntity insertFileOrFolder) {
        allFileOrFolder.add(insertFileOrFolder);
    }


    public void removeFromAllFileOrFolder(FileSystemBaseEntity removeFileOrFolder) {
        allFileOrFolder.remove(removeFileOrFolder);
    }


}
