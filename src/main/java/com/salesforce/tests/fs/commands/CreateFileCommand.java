package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.domain.Directory;
import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.domain.File;
import com.salesforce.tests.fs.exceptions.ExistingElementException;
import com.salesforce.tests.fs.exceptions.InvalidParameterException;
import com.salesforce.tests.fs.exceptions.NameLengthException;

import java.util.List;

import static com.salesforce.tests.fs.constants.Constraints.MAX_LENGTH;

public class CreateFileCommand extends DirectoryCommand {
    private String fileName;

    public CreateFileCommand(Disk disk, String fileName) {
        super(disk);
        this.fileName = fileName;
    }

    @Override
    public void execute() throws ExistingElementException, NameLengthException, InvalidParameterException {
        Directory directory = disk.getCurrentDirectory();
        validate(directory, this.fileName);

        directory.getFiles().add(new File(disk.getPath() + "/" + fileName, fileName));
    }

    private void validate(Directory directory, String fileName) throws InvalidParameterException, ExistingElementException, NameLengthException {
        if (fileName == null) {
            throw new InvalidParameterException("Invalid Command");
        }
        if (existingFile(directory, fileName)) {
            throw new ExistingElementException("Directory already exists");
        }
        if (!isValidLength(fileName)) {
            throw new NameLengthException("Invalid length for naming");
        }
    }

    private boolean existingFile(Directory directory, String fileName) {
        for (File f : directory.getFiles()) {
            if (f.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidLength(String fileName) {
        return fileName.length() <= MAX_LENGTH;
    }
}
