package com.company;

import java.util.Scanner;

public class Main {
    static Scanner bet = new Scanner(System.in);
    public static int startChips;
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Gambling pig's inn.");
        /*System.out.println("How many coins would you like to buy?");
        boughtChips = bet.nextInt();*/
        startChips = 1000;
        System.out.println("Your total account: " + startChips + " coin(s).");
        FrontPage.intro();
    }
}

