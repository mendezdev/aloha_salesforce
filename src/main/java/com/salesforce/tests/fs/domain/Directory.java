package com.salesforce.tests.fs.domain;

import java.util.ArrayList;
import java.util.List;

public class Directory extends BaseDir {
    private List<File> files;

    public Directory(String name) {
        super(name);
        this.files = new ArrayList<File>();
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
