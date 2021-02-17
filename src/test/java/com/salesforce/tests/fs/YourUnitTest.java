package com.salesforce.tests.fs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest extends BaseTest {
    // INVALID COMMANDS
    @Test
    public void testUnrecognizeCommand() {
        List<String> expectedResults = getExpectedResults("Unrecognized command");
        runTest(toArray(expectedResults), "somecommand", "quit");
    }

    // MKDIR COMMAND TEST
    @Test
    public void testCreateValidDirectory() {
        List<String> expectedResults = getExpectedResults("/root", "/root/new_directory");
        runTest(toArray(expectedResults), "mkdir new_directory", "ls", "quit");
    }

    @Test
    public void testCreateValidDirectoryAndSubDirectories() {
        List<String> expectedResults = getExpectedResults(
                "/new_directory", "/new_directory/new_directory_lvl2");

        runTest(toArray(expectedResults),
                "mkdir new_directory",
                "cd new_directory",
                "mkdir new_directory_lvl2",
                "ls",
                "quit");
    }

    @Test
    public void testCreateInvalidLengthDirectory() {
        List<String> expectedResult = getExpectedResults("Invalid length for naming");

        runTest(toArray(expectedResult),
                "mkdir " + getInvalidLengthName(), "quit");
    }

    @Test
    public void testCreateDirectoryButAlreadyExists() {
        List<String> expectedResult = getExpectedResults("Directory already exists");

        runTest(toArray(expectedResult),
                "mkdir new_directory", "mkdir new_directory", "quit");
    }

    @Test
    public void testCreateDirectoryButInvalidParameterName() {
        List<String> expectedResult = getExpectedResults("Invalid Command");

        runTest(toArray(expectedResult),
                "mkdir", "quit");
    }

    // helpers
    private List<String> getExpectedResults(String... values) {
        List<String> list = new ArrayList<String>();
        for (String s : values) {
            list.add(s + "\n");
        }
        return list;
    }

    private String[] toArray(List<String> list) {
        return list.toArray(new String[0]);
    }

    private String getInvalidLengthName() {
        int capacity = 100;
        StringBuilder builder = new StringBuilder(capacity);
        for (int i = 0; i <= capacity; i++) {
            builder.append("x");
        }
        return builder.toString();
    }
}
