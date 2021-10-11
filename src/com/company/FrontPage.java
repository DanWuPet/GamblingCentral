package com.company;

import java.util.Scanner;

public class FrontPage {

    public static void intro() {

        //intro
        int i = 0;
        while (i == 0) {
            System.out.println("Would you like to play '(1). Heads or tails' or '(2). Blackjack'");

            //takes in input
            Scanner in = new Scanner(System.in);
            String select = in.next();

            if (select.equals("Heads and tails") || select.equals("1")) {
                CoinFlip.coinFlip();
            }
            if (select.equals("Blackjack") || select.equals("2")) {

                int betting = in.nextInt();

            }
            if (select.equals("End")) {
                i++;
            }
        }
    }
}




