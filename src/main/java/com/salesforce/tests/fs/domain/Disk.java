package com.salesforce.tests.fs.domain;

import java.util.List;

public class Disk {
    private String path;
    private Directory directory;

    public Disk() {
        this.path = "/root";
        this.directory = new Directory("/root", "root");
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Directory getDirectory() {
        return directory;
    }

    public Directory getCurrentDirectory() {
        return getRecursiveDirectory(this.directory, this.path, this.directory.getName());
    }

    private Directory getRecursiveDirectory(Directory directory, String path, String dirName) {
        String[] paths = path.split("/");
        List<Directory> directories = directory.getDirectories();
        Directory directoryFound = null;
        if (paths.length == 2) {
            return directory;
        } else {
            for (Directory d : directories) {
                if (d.getName().equals(paths[2])) {
                    directoryFound = d;
                    break;
                }
            }

            if (directoryFound != null) {
                String refinedPath = "";
                for (int i = 2; i < paths.length; i++) {
                    refinedPath = refinedPath + "/" + paths[i];
                }
                return getRecursiveDirectory(directoryFound, refinedPath, dirName);
            } else {
                return directoryFound;
            }
        }
    }
}
