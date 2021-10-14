package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

import static com.company.pointSystem.globalChips;

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

            System.out.println("Would you like to play '(1). Coin Flip' or '(2). Blackjack' or '(3). Roulette' or type 'End' to end the game.");

            //takes in input
            Scanner in = new Scanner(System.in);
            String select = in.next();

            if (select.equals("Heads and tails") || select.equals("1")) {
                CoinFlip.coinFlip();
            }
            if (select.equals("Blackjack") || select.equals("2")) {
                BlackJack.blackjack();
            }
            if (select.equals("Roulette") || select.equals("3")) {
                Roulette.roulette();
            }
            if (select.equals("End")) {
                i++;
            }
        }
        WriteFile.writeFile();
        System.out.println("Your highscore of today: " + highscore + "\n" + "Your balance: " + globalChips);
    }
}





