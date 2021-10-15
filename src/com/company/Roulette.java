package com.company;

import java.util.*;

import static com.company.pointSystem.globalChips;

public class Roulette {
    static int chips = globalChips;
    //chips are the currency you play with in your chosen game
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    //typeNum: The type of number, like an Odd or Even number.
    static String typeNum;
    static boolean win;
    //winMul: The multiplier of betting if you win
    static int winMul;
    static Integer[] red = new Integer[] {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
    static Integer[] black = new Integer[] {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};

    static List<Integer> redList = new ArrayList<>(Arrays.asList(red));
    static List<Integer> blackList = new ArrayList<>(Arrays.asList(black));
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_WHITE = "\u001B[37m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String BLACK_BACKGROUND = "\u001B[40m";

    public static int roulette() {
        System.out.println("You chose to play Roulette, guess the outcome of the game.");
        int roulNum = rnd.nextInt(37);
        if (roulNum != 0) {
            if (roulNum % 2 == 0) {
                typeNum = "Even";
            } else {
                typeNum = "Odd";
            }
        }

        //betting
        System.out.println("Where would you like to bet? You can choose between: \n"
                + "\n" + "Odd/Even" + "\n" + "Red/Black" + "\n" + "Straight"
                + "\n" + "1. or 2.Half " + "\n" + "1. 2. or 3.Dozen"
                + "\n" + "1. 2. or 3.Column");
        String betType = in.next();

        System.out.println("How much do you bet?");
        int betting = in.nextInt();

        while (betting > chips || betting <= 0) {
            System.out.println("You can't use chips, you don't have!!!");
            System.out.println("Give new bet.");
            betting = in.nextInt();

        }

        chips = chips - betting;

        if (betType.equals("Odd")) {
            winMul = 2 * betting;
            if (typeNum.equals("Odd")) {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed right and won: " + winMul + " coin(s).");
                win = true;
            } else {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");
                win = false;
            }
        }

        if (betType.equals("Even")) {
            winMul = 2 * betting;
            if (typeNum.equals("Even")) {
                System.out.println("It landed on: " + roulNum + "\n" +"You guessed right and won: " + winMul + " coin(s).");
                win = true;
            } else {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");
                win = false;
            }
        }

        if (betType.equals("Straight")) {
            System.out.println("What number do you pick?");
            int straightGuess = in.nextInt();
            winMul = 35 * betting;
            if (roulNum == (straightGuess)) {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed right and won: " + winMul + " coin(s).");
                win = true;
            } else {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");
                win = false;
            }
        }

        if (betType.equals("1.Half")) {
            winMul = 2 * betting;
            if (roulNum <= 18 && roulNum > 0) {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed right and won: " + winMul + " coin(s).");
                win = true;
            } else {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");
                win = false;
            }
        }

        if (betType.equals("2.Half")) {
            winMul = 2 * betting;
            if (roulNum > 18) {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed right and won: " + winMul + " coin(s).");
                win = true;
            } else {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");
                win = false;
            }
        }

        if (betType.equals("1.Dozen")) {
            winMul = 3 * betting;
            if (roulNum > 0 && roulNum <= 12) {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed right and won: " + winMul + " coin(s).");
                win = true;
            } else {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");
                win = false;
            }
        }
        if (betType.equals("2.Dozen")) {
            winMul = 3 * betting;
            if (roulNum > 12 && roulNum <= 24) {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed right and won: " + winMul + " coin(s).");
                win = true;
            } else {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");
                win = false;
            }
        }
        if (betType.equals("3.Dozen")) {
            winMul = 3 * betting;
            if (roulNum > 24 && roulNum <= 36) {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed right and won: " + winMul + " coin(s).");
                win = true;
            } else {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");
                win = false;
            }
        }
        if (betType.equals("1.Column")) {
            winMul = 3 * betting;
            if (roulNum % 3 == 1) {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed right and won: " + winMul + " coin(s).");
                win = true;
            } else {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");
                win = false;
            }
        }
        if (betType.equals("2.Column")) {
            winMul = 3 * betting;
            if (roulNum % 3 == 2) {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed right and won: " + winMul + " coin(s).");
                win = true;
            } else {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");
                win = false;
            }
        }
        if (betType.equals("3.Column")) {
            winMul = 3 * betting;
            if (roulNum % 3 == 0) {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed right and won: " + winMul + " coin(s).");
                win = true;
            } else {
                System.out.println("It landed on: " + roulNum + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");
                win = false;
            }
        }

        if (betType.equals("Red")) {
            winMul = 2 * betting;
            if (redList.contains(roulNum)) {
                win = true;
            } else {
                win = false;
            }
            if (win) {
                System.out.println("It landed on: " + TEXT_WHITE + RED_BACKGROUND + roulNum + TEXT_RESET + "\n" + "You guessed right and won: " + winMul + " coin(s).");
            } else {
                System.out.println("It landed on: " + TEXT_WHITE + BLACK_BACKGROUND + roulNum + TEXT_RESET + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");

            }
        }
        if (betType.equals("Black")) {
            winMul = 2 * betting;
            if (blackList.contains(roulNum)) {
                win = true;
            } else {
                win = false;
            }
            if (win) {
                System.out.println("It landed on: " + TEXT_WHITE + BLACK_BACKGROUND + roulNum + TEXT_RESET + "\n" + "You guessed right and won: " + winMul + " coin(s).");
            } else {
                System.out.println("It landed on: " + TEXT_WHITE + RED_BACKGROUND + roulNum + TEXT_RESET + "\n" + "You guessed wrong and lost: " + betting + " coin(s).");

            }
        }

        if (win) {
            globalChips = chips + winMul;
        } else {
            globalChips = chips;
        }
        System.out.println("Your new balance: " + globalChips);
        return globalChips;
    }
}

/*
players may choose to place bets on either a single number,
various groupings of numbers, the colors red or black,
whether the number is odd or even, or if the numbers are high (19–36) or low (1–18).

Payouts:
Straight up: any single number including 0:                     35 to 1
Split: any two adjoining numbers vertical or horizontal:        17 to 1
Basket: 0,1,2 or 0,2,3:                                         11 to 1
Street: any three numbers horizontal(1,2,3 or 16,17,18):        11 to 1
Corner: any four adjoining numbers in a block(17, 18, 20, 21):  8 to 1
Six Line: any six numbers from two rows (28,29,30,31,32,33) :   5 to 1
1st Column: 1,4,7,10,13,16,19,22,25,28,31,34                :   2 to 1
2nd Column: 2,5,8,11,14,17,20,23,26,29,32,35                :   2 to 1
3rd Column: 3,6,9,12,15,18,21,24,27,30,33,36                :   2 to 1
1st Dozen : 1 through 12                                    :   2 to 1
2nd Dozen : 13 through 24                                   :   2 to 1
3rd Dozen : 25 through 36                                   :   2 to 1
Odd     : 1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35  :   1 to 1
Even    : 2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36 :   1 to 1
Red     : red                                                   1 to 1
Black   : black                                                 1 to 1
1 to 18 : 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18 :        1 to 1
19 to 36: 19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36 1 to 1
 */



