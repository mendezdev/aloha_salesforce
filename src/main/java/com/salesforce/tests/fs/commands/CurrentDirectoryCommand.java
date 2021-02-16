package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.exceptions.ExistingElementException;
import com.salesforce.tests.fs.exceptions.NameLengthException;

public class CurrentDirectoryCommand  extends DirectoryCommand {
    public CurrentDirectoryCommand(Disk disk) {
        super(disk);
    }

    @Override
    public void execute() throws ExistingElementException, NameLengthException {
        System.out.println(disk.getPath());
    }
}
