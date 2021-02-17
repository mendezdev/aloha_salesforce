package com.salesforce.tests.fs;

import com.salesforce.tests.fs.commands.*;
import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.engine.DirectoryInvoker;

import java.util.Scanner;

import static com.salesforce.tests.fs.constants.Commands.*;

/**
 * The entry point for the Test program
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // initial structure for the Disk, commands and invoker
        // initial path is "/root"
        Disk disk = new Disk();
        DirectoryCommand listCommand = new ListContentDirectoryCommand(disk);
        DirectoryInvoker invoker = new DirectoryInvoker();

        while (scanner.hasNext()) {
            String[] input = getInput(scanner.nextLine());
            String command = input[0];
            String parameter = null;
            if (input.length > 1) {
                parameter = input[1];
            }

            if (PWD.equals(command)) {
                invoker.setCommand(new CurrentDirectoryCommand(disk));
            } else if (LS.equals(command)) {
                invoker.setCommand(listCommand);
            } else if (MKDIR.equals(command)) {
                invoker.setCommand(new CreateDirectoryCommand(disk, parameter));
            } else if (TOUCH.equals(command)) {
                invoker.setCommand(new CreateFileCommand(disk, parameter));
            } else if (CD.equals(command)) {
                invoker.setCommand(new ChangeDirectoryCommand(disk, parameter));
            } else if (QUIT.equals(command)){
                break;
            } else {
                invoker.setCommand(new UnknownCommand(disk));
            }

            try {
                invoker.executeCommand();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private static String[] getInput(String input) {
        return input.split(" ");
    }
}
