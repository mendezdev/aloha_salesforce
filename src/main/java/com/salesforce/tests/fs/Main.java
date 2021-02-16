package com.salesforce.tests.fs;

import com.salesforce.tests.fs.commands.*;
import com.salesforce.tests.fs.domain.Disk;
import com.salesforce.tests.fs.engine.DirectoryInvoker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static com.salesforce.tests.fs.constants.Commands.*;

/**
 * The entry point for the Test program
 */
public class Main {

    // I'm having problems to identify how hackerrank or this test is going to get the parameters
    // the idea is to get the parameters, identify if second parameter is needed, like in mkdir or ls command
    // and set the command and execute it

    // the exceptions were created to show the message to the user but
    // the messages can be in constants like the commands
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        String inputArg = "";

        Disk disk = new Disk();
        DirectoryCommand listCommand = new ListContentDirectoryCommand(disk);
        DirectoryInvoker invoker = new DirectoryInvoker();

        while (scanner.hasNext()) {
            boolean isExecutable = true;
            input = scanner.nextLine();

            if (PWD.equals(input)) {
                invoker.setCommand(new CurrentDirectoryCommand(disk));
            } else if (LS.equals(input)) {
                invoker.setCommand(listCommand);
            } else if (MKDIR.equals(input)) {
                String dirName = ""; // get from scanner
                invoker.setCommand(new CreateDirectoryCommand(disk, dirName));
            } else if (TOUCH.equals(input)) {
                String fileName = ""; // get from scanner
                invoker.setCommand(new CreateFileCommand(disk, fileName));
            } else if (CD.equals(input)) {
                String to = ""; // get from scanner
                invoker.setCommand(new ChangeDirectoryCommand(disk, to));
            } else if (QUIT.equals(input)){
                break;
            }
            else {
                isExecutable = false;
                System.out.println("Unrecognized command");
            }

            if (isExecutable) {
                try {
                    invoker.executeCommand();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        scanner.close();
    }
}
