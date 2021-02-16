package com.salesforce.tests.fs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest extends BaseTest {

    @Test
    public void testCreateValidDirectory() {
        List<String> expectedResults = getExpectedValidDirectories("/root", "/root/new_directory");
        runTest(toArray(expectedResults), "mkdir new_directory", "ls", "quit");
    }

    @Test
    public void testCreateValidDirectoryAndSubDirectories() {
        List<String> expectedResults = getExpectedValidDirectories(
                "/root/new_directory/new_directory_lvl2", "/root/new_directory");

        runTest(toArray(expectedResults),
                "mkdir new_directory",
                "cd new_directory",
                "mkdir new_directory_lvl2",
                "ls",
                "quit");
    }

    private List<String> getExpectedValidDirectories(String... values) {
        List<String> list = new ArrayList<String>();
        for (String s : values) {
            list.add(s + "\n");
        }
        return list;
    }

    private String[] toArray(List<String> list) {
        return list.toArray(new String[0]);
    }
}
