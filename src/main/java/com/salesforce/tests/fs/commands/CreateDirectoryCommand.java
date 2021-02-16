package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.domain.Directory;
import com.salesforce.tests.fs.domain.Disk;

public class CreateDirectoryCommand extends DirectoryCommand {
    private String name;

    public CreateDirectoryCommand(Disk disk, String dirName) {
        super(disk);
        this.name = name;
    }

    @Override
    public void execute() {
        if (existDirectory(this.name)) {
            //TODO: return an exception of directory already exists
            System.out.println("the directory already exists");
        } else {
            String fullPath = disk.getPath() + "/" + this.name;
            disk.getDirectory().put(fullPath, new Directory(this.name));
        }
    }

    private boolean existDirectory(String dirName) {
        String fullPath = disk.getPath() + "/" + dirName;
        return disk.getDirectory().containsKey(fullPath);
    }
}
