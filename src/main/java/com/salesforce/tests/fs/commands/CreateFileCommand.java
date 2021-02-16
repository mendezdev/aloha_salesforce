package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.domain.Directory;
import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.domain.File;
import com.salesforce.tests.fs.exceptions.ExistingElementException;
import com.salesforce.tests.fs.exceptions.NameLengthException;

public class CreateFileCommand extends DirectoryCommand {
    private String fileName;

    public CreateFileCommand(Disk disk, String fileName) {
        super(disk);
        this.fileName = fileName;
    }

    @Override
    public void execute() throws ExistingElementException, NameLengthException {
        if (fileName.length() > 100) {
            throw new NameLengthException("invalid length");
        }

        Directory dir = disk.getDirectory().get(disk.getPath());
        for (File f : dir.getFiles()) {
            if (fileName.equals(f.getName())) {
                throw new ExistingElementException("the file name already exists.");
            }
        }

        dir.getFiles().add(new File(fileName));
    }
}
