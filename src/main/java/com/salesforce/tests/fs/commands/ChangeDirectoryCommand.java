package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.domain.Disk;

public class ChangeDirectoryCommand extends DirectoryCommand {
    private String dirName;

    public ChangeDirectoryCommand(Disk disk, String dirName) {
        super(disk);
        this.dirName = dirName;
    }

    @Override
    public void execute() {
        if ("..".equals(dirName)) {
            if (!"/root".equals(disk.getPath())) {
                int lasIndex = disk.getPath().lastIndexOf("/");
                String fullPath = disk.getPath().substring(0, lasIndex);
                disk.setPath(fullPath);
            }
        } else {
            String fullPath = disk.getPath() + "/" + dirName;
            if (existDirectory(dirName)) {
                disk.setPath(fullPath);
            } else {
                //TODO: return an exception of directory does not exists
                System.out.println("directory"+ dirName +"does not exists");
            }
        }
    }

    private boolean existDirectory(String dirName) {
        String fullPath = disk.getPath() + "/" + dirName;
        return disk.getDirectory().containsKey(fullPath);
    }
}
