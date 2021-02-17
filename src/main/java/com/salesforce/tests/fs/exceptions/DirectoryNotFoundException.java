package com.salesforce.tests.fs.exceptions;

public class DirectoryNotFoundException extends Exception {
    public DirectoryNotFoundException(String message) {
        super(message);
    }
}
