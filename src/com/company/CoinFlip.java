package com.company;

import java.util.Random;
import java.util.Scanner;;
import static com.company.Main.boughtChips;

public class CoinFlip {
    static int chips = boughtChips;
    int coinValue = 0;
    static String coinSide;
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

//gamesetup

    public static int coinFlip() {
        int coinValue = rnd.nextInt(1001) + 1;

        if (coinValue > 501) {
            coinSide = "Heads";
        }
        else if(coinValue > 1 && coinValue <= 501){
            coinSide = "Tails";
        }
        else{
            coinSide = "Draw";
        }

            System.out.println("How much do you bet?");
            int betting = in.nextInt();

            System.out.println("What do you choose? Heads or Tails?");
            String guess = in.next();


            //payout

            if (guess.equals(coinSide)) {
                System.out.println("You guessed right and won: " + betting + " coin(s).");
                chips = chips + betting;

            } else {
                System.out.println("You guessed wrong and lost: " + betting + " coin(s).");
                chips = chips - betting;
            }
            System.out.println("Your balance: " + chips);

        return chips;
    }
}
