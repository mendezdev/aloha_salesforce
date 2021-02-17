package com.salesforce.tests.fs;

import org.junit.Test;

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
        List<String> expectedResult = getExpectedResults("Element already exists");

        runTest(toArray(expectedResult),
                "mkdir new_directory", "mkdir new_directory", "quit");
    }

    @Test
    public void testCreateDirectoryButInvalidParameter() {
        List<String> expectedResult = getExpectedResults("Invalid Command");

        runTest(toArray(expectedResult),
                "mkdir", "quit");
    }

    // CD COMMAND
    @Test
    public void testChangeValidDirectory() {
        List<String> expectedResults = getExpectedResults("/first_directory", "/first_directory/second_directory");
        runTest(toArray(expectedResults),
                "mkdir first_directory",
                "cd first_directory",
                "mkdir second_directory",
                "ls",
                "quit");
    }

    @Test
    public void testChangeBackwardDirectory() {
        List<String> expectedResults = getExpectedResults(
                "/first_directory",
                "/first_directory/second_directory",
                "/root",
                "/root/first_directory",
                "/root/first_directory/second_directory");
        runTest(toArray(expectedResults),
                "mkdir first_directory",
                "cd first_directory",
                "mkdir second_directory",
                "ls",
                "cd ..",
                "ls",
                "quit");
    }

    @Test
    public void testChangeDirectoryNotFound() {
        List<String> expectedResults = getExpectedResults("Directory not found");
        runTest(toArray(expectedResults),
                "cd new_dir",
                "quit");
    }

    // TOUCH COMMAND
    @Test
    public void testCreateValidFile() {
        List<String> expectedResults = getExpectedResults("/root", "/root/example.txt");
        runTest(toArray(expectedResults),
                "touch example.txt",
                "ls",
                "quit");
    }

    @Test
    public void testCreateFileInvalidLengthName() {
        List<String> expectedResults = getExpectedResults("Invalid length for naming");
        runTest(toArray(expectedResults),
                "touch " + getInvalidLengthName(),
                "quit");
    }

    // LS COMMAND
    @Test
    public void testListContentCommand() {
        List<String> expectedResults = getExpectedResults(
                "/root",
                "/root/example1.txt",
                "/root/example2.txt",
                "/root/first_dir",
                "/root/first_dir/example1.txt",
                "/root/first_dir/example2.txt",
                "/root/first_dir/second_dir",
                "/root/first_dir/second_dir/example1.txt",
                "/root/first_dir/second_dir/example2.txt",
                "/second_dir",
                "/second_dir/example1.txt",
                "/second_dir/example2.txt"
        );
        runTest(toArray(expectedResults),
                "mkdir first_dir",
                "touch example1.txt",
                "touch example2.txt",
                "cd first_dir",
                "touch example1.txt",
                "touch example2.txt",
                "mkdir second_dir",
                "cd second_dir",
                "touch example1.txt",
                "touch example2.txt",
                "cd ..",
                "cd ..",
                "ls",
                "cd first_dir",
                "cd second_dir",
                "ls",
                "quit");
    }
}
