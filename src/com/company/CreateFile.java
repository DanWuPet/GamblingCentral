package com.company;

import java.io.*;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;
import static com.company.Main.startChips;

public class CreateFile {
    public static String username;
    public static int createFile() {
        try {
            //if you're a new player
            System.out.println("Welcome to the Gambling Pig's Inn, insert your username to create or access your storage.");
            Scanner in = new Scanner(System.in);
            username = in.nextLine();
            File myObj = new File(username + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                //load an old players data
                FileReader fr = new FileReader(username + ".txt");
                Scanner inFile = new Scanner (fr);
                String line = inFile.nextLine();
                int i =Integer.parseInt(line);
                startChips = i;
                System.out.println("Welcome back : " + username + ".");
                System.out.println();
//int max_value 2.147.483.647 , double max_value 2^1023
                //delete loaded file
                File file = new File(username + ".txt");
                file.delete();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return startChips;
    }
}

