package com.Stampli.service;

import com.Stampli.model.File;
import com.Stampli.model.FileSystemBaseEntity;
import com.Stampli.model.Folder;
import com.Stampli.model.PrintType;

import java.util.*;
import java.util.stream.Collectors;

public class FileSystem implements IMFS {

    public static Map<Long, FileSystemBaseEntity> allFilesAndFolderByPid;

    //initialise
    public FileSystem() {
        allFilesAndFolderByPid = new HashMap();
        Folder rootFolder = new Folder(0, "", Optional.empty());
        allFilesAndFolderByPid.put(0L, rootFolder);
    }

    private static void updateFileSystem(FileSystemBaseEntity fileSystemBaseEntity) {
        allFilesAndFolderByPid.put(fileSystemBaseEntity.getId(), fileSystemBaseEntity);
        ((Folder) allFilesAndFolderByPid.get(fileSystemBaseEntity.getPid().get())).addToAllFileOrFolder(fileSystemBaseEntity);
    }

    @Override
    public void addFile(long id, String name, byte[] data, long pid) {
        File insertFile = new File(id, name, data, Optional.of(pid));
        updateFileSystem(insertFile);
    }

    @Override
    public void addDir(long id, String name, long pid) {
        Folder insertFolder = new Folder(id, name, Optional.of(pid));
        updateFileSystem(insertFolder);
    }

    @Override
    public void delete(long id) {
        FileSystemBaseEntity fileSystemBaseEntity = allFilesAndFolderByPid.get(id);
        if (fileSystemBaseEntity instanceof Folder) {
            for (FileSystemBaseEntity fileSystemBaseEntityOfLoop : ((Folder) fileSystemBaseEntity).getAllFileOrFolder()) {
                delete(fileSystemBaseEntityOfLoop.getId());
            }
        }
        allFilesAndFolderByPid.remove(id);
    }

    @Override
    public String print(PrintType type) {
        return printElement(0L, 0);
    }

    private String printElement(Long id, int depth) {
        String result = "";
        for (int tabIndex = 0; tabIndex < depth; tabIndex++) {
            result = result + "\t ";
        }

        FileSystemBaseEntity fileSystemBaseEntity = allFilesAndFolderByPid.get(id);

        List<String> listOfInnerPrintResult = new ArrayList<>();

        if (fileSystemBaseEntity instanceof Folder) {
            result = result + fileSystemBaseEntity.getName() + "\\" + "\n";
            listOfInnerPrintResult = ((Folder) fileSystemBaseEntity).getAllFileOrFolder().stream()
                    .map(fileOrFolder -> printElement(fileOrFolder.getId(), depth + 1)).collect(Collectors.toList());
        } else {
            result = result + fileSystemBaseEntity.getName() + "\n";
        }

        for (String innerResult : listOfInnerPrintResult) {
            result = result + innerResult;
        }

        return result;
    }

}
