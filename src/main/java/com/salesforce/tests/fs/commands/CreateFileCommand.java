package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.commons.CreationUtils;
import com.salesforce.tests.fs.domain.BaseDir;
import com.salesforce.tests.fs.domain.Directory;
import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.domain.File;
import com.salesforce.tests.fs.exceptions.CommandProcessorException;

import java.util.ArrayList;

public class CreateFileCommand extends DirectoryCommand {
    private String fileName;

    public CreateFileCommand(Disk disk, String fileName) {
        super(disk);
        this.fileName = fileName;
    }

    @Override
    public void execute() throws CommandProcessorException {
        Directory directory = disk.getCurrentDirectory();
        CreationUtils.validate(
            new ArrayList<BaseDir>(directory.getFiles()),
            this.fileName);
        directory.getFiles().add(new File(disk.getPath() + "/" + fileName, fileName));
    }
}
