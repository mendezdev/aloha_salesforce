package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.domain.Disk;

public class CurrentDirectoryCommand  extends DirectoryCommand {
    public CurrentDirectoryCommand(Disk disk) {
        super(disk);
    }

    @Override
    public void execute() {
        System.out.println(disk.getPath());
    }
}
