package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.domain.Directory;
import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.domain.File;

import java.util.List;

public class ListContentDirectoryCommand extends DirectoryCommand {
    public ListContentDirectoryCommand(Disk disk) {
        super(disk);
    }

    @Override
    public void execute() {
        Directory directory = disk.getCurrentDirectory();
        String initialPath = "/" + directory.getName();
        printContentDirectory(directory, initialPath);
    }

    private void printContentDirectory(Directory directory, String path) {
        List<Directory> directories = directory.getDirectories();
        System.out.println(path);
        for (File f : directory.getFiles()) {
            System.out.println(path + "/" + f.getName());
        }
        if (directories.size() > 0) {
            for (int i = 0; i < directories.size(); i++) {
                printContentDirectory(directories.get(i), path + "/" + directories.get(i).getName());
            }
        }
    }
}
