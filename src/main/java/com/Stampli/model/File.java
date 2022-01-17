package com.Stampli.model;

import java.util.Optional;

public class File extends FileSystemBaseEntity {
    private byte[] data;

    public File(long id, String name, byte[] data, Optional<Long> pid) {
        super(id, name, pid);
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }
}
