package com.salesforce.tests.fs;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Unit Test runner: capture stdin/stdout for testing
 */
public class BaseTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().muteForSuccessfulTests().enableLog();

    protected void runTest(String[] expectedOutput, String... input) {
        systemInMock.provideLines(input);
        Main.main(new String[0]);
        Assert.assertEquals(String.join("", expectedOutput),
                systemOutRule.getLogWithNormalizedLineSeparator());
    }
}