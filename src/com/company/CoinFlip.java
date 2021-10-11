package com.company;

import java.util.Random;
import java.util.Scanner;;
import static com.company.Main.bet;
import static com.company.Main.boughtChips;
import static com.company.pointSystem.globalChips;

public class CoinFlip {
    static int chips = globalChips;
    int coinValue = 0;
    static String coinSide;
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

//gamesetup

    public static int coinFlip() {
        int coinValue = rnd.nextInt(3001) + 1;

        if (coinValue > 2) {
            coinSide = "Heads";
        } else if (coinValue > 1 && coinValue <= 3001) {
            coinSide = "Tails";
        } else {
            coinSide = "Draw";
        }

            System.out.println("How much do you bet?");
            int betting = in.nextInt();

            while (betting > chips || betting <= 0) {
                System.out.println("You can't use chips, you don't have!!!");
                System.out.println("Give new bet.");
                betting = in.nextInt();

            }
                chips = chips - betting;

        System.out.println("What do you choose? Heads or Tails? Or maybe the rare Draw?");
        String guess = in.next();
        System.out.println("It landed on " + coinSide + "!");

        //payout

        //correct guess
        if (guess.equals(coinSide)) {
            if (guess.equals("Draw")) {
                chips = chips + (12000 * betting);
                System.out.println("You guessed right and won: " + (betting * 10) + " coin(s).");
            } else {
                chips = chips + (2 * betting);
                System.out.println("You guessed right and won: " + betting + " coin(s).");
            }

        //wrong guess
        } else {
            System.out.println("You guessed wrong and lost: " + betting + " coin(s).");
        }
        System.out.println("Your balance: " + chips);

        globalChips = chips;
        return globalChips;
    }
}
