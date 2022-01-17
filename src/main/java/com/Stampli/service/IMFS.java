package com.Stampli.service;

import com.Stampli.model.PrintType;

public interface IMFS {
    void addFile(long id, String name, byte[] data, long pid);

    void addDir(long id, String name, long pid);

    void delete(long id);

    String print(PrintType type);


}

