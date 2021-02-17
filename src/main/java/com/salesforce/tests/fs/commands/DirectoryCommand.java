package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.exceptions.CommandProcessorException;

public abstract class DirectoryCommand {
    protected Disk disk;

    public DirectoryCommand(Disk disk) { this.disk = disk; }

    public abstract void execute() throws CommandProcessorException;
}
