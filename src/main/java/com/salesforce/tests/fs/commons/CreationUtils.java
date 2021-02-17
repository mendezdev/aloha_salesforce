package com.salesforce.tests.fs.commons;

import com.salesforce.tests.fs.domain.BaseDir;
import com.salesforce.tests.fs.exceptions.ExistingElementException;
import com.salesforce.tests.fs.exceptions.InvalidParameterException;
import com.salesforce.tests.fs.exceptions.NameLengthException;

import java.util.List;

import static com.salesforce.tests.fs.constants.Constraints.MAX_LENGTH;

public class CreationUtils {
    public static void validate(List<BaseDir> baseElements, String elementName) throws ExistingElementException, InvalidParameterException, NameLengthException {
        validateCommonCreation(elementName);
        for (BaseDir elem : baseElements) {
            if (elem.getName().equals(elementName)) {
                throw new ExistingElementException("Element already exists");
            }
        }
    }

    private static void validateCommonCreation(String elementName) throws InvalidParameterException, NameLengthException {
        if (elementName == null) {
            throw new InvalidParameterException("Invalid Command");
        }
        if (isInvalidLength(elementName)) {
            throw new NameLengthException("Invalid length for naming");
        }
    }

    private static boolean isInvalidLength(String elementName) {
        return elementName.length() > MAX_LENGTH;
    }
}
