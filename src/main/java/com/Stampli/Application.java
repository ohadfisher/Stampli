package com.Stampli;

import com.Stampli.model.PrintType;
import com.Stampli.service.FileSystem;
import com.Stampli.service.IMFS;

public class Application {

    public static void main(String[] args) {

        IMFS imfs = new FileSystem();

        imfs.addDir(1, "DirA", 0);
        imfs.addFile(11, "File1", "data11".getBytes(), 1);
        imfs.addFile(12, "File2", "data12".getBytes(), 1);

        imfs.addDir(13, "DirC", 1);
        imfs.addFile(2, "File3", "data2".getBytes(), 0);
        imfs.addFile(3, "File4", "data3".getBytes(), 0);
        imfs.addDir(4, "DirD", 0);
        imfs.addFile(41, "File5", "data41".getBytes(), 4);
        //imfs.delete(4);
        System.out.println(imfs.print(PrintType.DOS));
    }
}
