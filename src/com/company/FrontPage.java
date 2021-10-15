package com.company;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import static com.company.CreateFile.username;
import static com.company.pointSystem.globalChips;
import static com.company.pointSystem.highscore;
import static com.company.pointSystem.updateHighscore;

public class FrontPage {
    static int i=0;

    public static void intro() {



        //intro

        while (i == 0) {
            updateHighscore();
            if (globalChips == 0) {
                System.out.println("\n" + "\n" +"You lost all your money, get out of here!!!");
                break;
            }

            System.out.println("\n" + "Would you like to play " + "\n" + "(1). Coin Flip "+ "\n" + "(2). Blackjack" +
                    "\n" + "(3). Roulette" + "\n" + "Type 'End' to end the game.");

            //takes in input
            Scanner in = new Scanner(System.in);
            String select = in.next().toLowerCase(Locale.ROOT);

            if (select.equals("coin flip") || select.equals("1")) {
                CoinFlip.coinFlip();
            }
            if (select.equals("blackjack") || select.equals("2")) {
                BlackJack.blackjack();
            }
            if (select.equals("roulette") || select.equals("3")) {
                Roulette.roulette();
            }
            if (select.equals("end")) {
                i++;
            }
        }
        WriteFile.writeFile();
        System.out.println("Your highscore of today: " + highscore + "\n" + "Your balance: " + globalChips);
    }
}