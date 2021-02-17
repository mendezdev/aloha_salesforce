package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.domain.Directory;
import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.exceptions.ExistingElementException;
import com.salesforce.tests.fs.exceptions.InvalidParameterException;
import com.salesforce.tests.fs.exceptions.NameLengthException;

import static com.salesforce.tests.fs.constants.Constraints.MAX_LENGTH;

public class CreateDirectoryCommand extends DirectoryCommand {
    private String name;

    public CreateDirectoryCommand(Disk disk, String dirName) {
        super(disk);
        this.name = dirName;
    }

    @Override
    public void execute() throws ExistingElementException, InvalidParameterException, NameLengthException {
        validate(this.name);
        String fullPath = disk.getPath() + "/" + this.name;
        disk.getCurrentDirectory().getDirectories()
                .add(new Directory(fullPath, this.name));
    }

    private void validate(String dirName) throws InvalidParameterException, ExistingElementException, NameLengthException {
        if (dirName == null) {
            throw new InvalidParameterException("Invalid Command");
        }
        if (existDirectory(dirName)) {
            throw new ExistingElementException("Directory already exists");
        }
        if (!isValidLength(dirName)) {
            throw new NameLengthException("Invalid length for naming");
        }
    }

    private boolean existDirectory(String dirName) {
        for (Directory d : disk.getCurrentDirectory().getDirectories()) {
            if (d.getName().equals(dirName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidLength(String dirName) {
        return dirName.length() <= MAX_LENGTH;
    }
}
