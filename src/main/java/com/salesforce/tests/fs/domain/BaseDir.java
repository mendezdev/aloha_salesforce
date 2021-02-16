package com.salesforce.tests.fs.domain;

public abstract class BaseDir {
    protected String name;

    public BaseDir(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
