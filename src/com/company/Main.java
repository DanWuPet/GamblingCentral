package com.company;

import java.util.Scanner;

public class Main {

    static Scanner bet = new Scanner(System.in);
    public static int startChips;
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Printer.startScreen();
        startChips = 1000;
        CreateFile.createFile();
        System.out.println();
        System.out.println("Welcome to the Gambling Pig's Inn. Write precisely or there will be consequences >:(");
        System.out.println("Your total account: " + startChips + " coin(s).");
        FrontPage.intro();
    }
}

