package com.salesforce.tests.fs.domain;

import java.util.HashMap;
import java.util.Map;

public class Disk {
    private String path;
    private Map<String, Directory> directory;

    public Disk() {
        this.path = "/root";
        this.directory = new HashMap<String, Directory>();
        this.directory.put("/root", new Directory("root"));
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, Directory> getDirectory() {
        return directory;
    }
}
