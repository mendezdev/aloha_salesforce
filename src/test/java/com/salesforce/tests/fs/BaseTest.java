package com.salesforce.tests.fs;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.ArrayList;
import java.util.List;

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

    // helpers
    protected List<String> getExpectedResults(String... values) {
        List<String> list = new ArrayList<String>();
        for (String s : values) {
            list.add(s + "\n");
        }
        return list;
    }

    protected String[] toArray(List<String> list) {
        return list.toArray(new String[0]);
    }

    protected String getInvalidLengthName() {
        int capacity = 101;
        StringBuilder builder = new StringBuilder(capacity);
        for (int i = 0; i <= capacity; i++) {
            builder.append("x");
        }
        return builder.toString();
    }
}