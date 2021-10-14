package com.company;

import java.io.*;
import java.util.Scanner;

import static com.company.CreateFile.username;
import static com.company.Main.startChips;
import static com.company.pointSystem.globalChips;
import static com.company.pointSystem.highscore;

public class WriteFile {

    public static int writeFile() {
        try {
            File myObj = new File(username + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(username + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        outFile.println(globalChips);
        outFile.close();

        return globalChips;
    }
}
