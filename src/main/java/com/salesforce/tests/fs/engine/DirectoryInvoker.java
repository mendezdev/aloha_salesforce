package com.salesforce.tests.fs.engine;

import com.salesforce.tests.fs.commands.DirectoryCommand;
import com.salesforce.tests.fs.exceptions.CommandProcessorException;

public class DirectoryInvoker {
    private DirectoryCommand command;

    public void setCommand(DirectoryCommand command) {
        this.command = command;
    }

    public void executeCommand() throws CommandProcessorException {
        this.command.execute();
    }
}
