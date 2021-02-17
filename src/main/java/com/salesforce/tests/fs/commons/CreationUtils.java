package com.salesforce.tests.fs.commons;

import com.salesforce.tests.fs.domain.BaseDir;
import com.salesforce.tests.fs.exceptions.CommandProcessorException;

import java.util.List;

import static com.salesforce.tests.fs.constants.Constraints.MAX_LENGTH;

public class CreationUtils {
    public static void validate(List<BaseDir> baseElements, String elementName) throws CommandProcessorException {
        validateCommonCreation(elementName);
        for (BaseDir elem : baseElements) {
            if (elem.getName().equals(elementName)) {
                throw new CommandProcessorException("Element already exists");
            }
        }
    }

    private static void validateCommonCreation(String elementName) throws CommandProcessorException {
        if (elementName == null) {
            throw new CommandProcessorException("Invalid Command");
        }
        if (isInvalidLength(elementName)) {
            throw new CommandProcessorException("Invalid length for naming");
        }
    }

    private static boolean isInvalidLength(String elementName) {
        return elementName.length() > MAX_LENGTH;
    }
}
