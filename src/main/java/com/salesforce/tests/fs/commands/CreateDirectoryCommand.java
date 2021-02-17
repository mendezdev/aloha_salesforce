package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.commons.CreationUtils;
import com.salesforce.tests.fs.domain.BaseDir;
import com.salesforce.tests.fs.domain.Directory;
import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.exceptions.ExistingElementException;
import com.salesforce.tests.fs.exceptions.InvalidParameterException;
import com.salesforce.tests.fs.exceptions.NameLengthException;

import java.util.ArrayList;

public class CreateDirectoryCommand extends DirectoryCommand {
    private String name;

    public CreateDirectoryCommand(Disk disk, String dirName) {
        super(disk);
        this.name = dirName;
    }

    @Override
    public void execute() throws ExistingElementException, InvalidParameterException, NameLengthException {
        Directory currentDir = disk.getCurrentDirectory();
        CreationUtils.validate(
                new ArrayList<BaseDir>(currentDir.getDirectories()),
                this.name);

        String fullPath = disk.getPath() + "/" + this.name;
        currentDir.getDirectories().add(new Directory(fullPath, this.name));
    }
}
