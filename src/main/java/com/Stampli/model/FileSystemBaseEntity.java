package com.Stampli.model;

import java.util.Optional;


public abstract class FileSystemBaseEntity {
    private long id;
    private String name;
    private Optional<Long> pid;//It Optional just because the root don't have upper folder(for the root Optional.empty())

    protected FileSystemBaseEntity(long id, String name, Optional<Long> pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<Long> getPid() {
        return pid;
    }


}
