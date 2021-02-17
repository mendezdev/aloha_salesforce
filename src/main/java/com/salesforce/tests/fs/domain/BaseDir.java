package com.salesforce.tests.fs.domain;

public abstract class BaseDir {
    protected String path;
    protected String name;

    public BaseDir(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
