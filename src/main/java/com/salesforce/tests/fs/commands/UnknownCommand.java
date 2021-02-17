package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.exceptions.CommandProcessorException;

public class UnknownCommand extends DirectoryCommand {
    private final String message = "Unrecognized command";

    public UnknownCommand(Disk disk) {
        super(disk);
    }

    public void execute() throws CommandProcessorException {
        System.out.println(this.message);
    }
}
