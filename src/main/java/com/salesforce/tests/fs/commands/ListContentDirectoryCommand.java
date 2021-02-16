package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.domain.Directory;
import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.domain.File;

import java.util.Map;

public class ListContentDirectoryCommand extends DirectoryCommand {
    public ListContentDirectoryCommand(Disk disk) {
        super(disk);
    }

    @Override
    public void execute() {
        for (Map.Entry<String, Directory> entry : disk.getDirectory().entrySet()) {
            if (entry.getKey().contains(disk.getPath())) {
                System.out.println("dir: " + entry.getKey());
                for (File f : entry.getValue().getFiles()) {
                    System.out.println("file: " + entry.getKey() + "/" + f.getName());
                }
            }
        }
    }
}
