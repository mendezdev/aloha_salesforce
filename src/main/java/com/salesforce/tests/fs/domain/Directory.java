package com.salesforce.tests.fs.domain;

import java.util.ArrayList;
import java.util.List;

public class Directory extends BaseDir {
    private List<File> files;
    private List<Directory> directories;

    public Directory(String path, String name) {
        super(path, name);
        this.files = new ArrayList<File>();
        this.directories = new ArrayList<Directory>();
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public List<File> getFiles() {
        return files;
    }
}
