package com.company;

import java.util.Scanner;

import static com.company.pointSystem.globalChips;

public class BlackJack {
    public static int playerMoney = globalChips;

    public static int blackjack() {

        System.out.println("Welcome to Blackjack!");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        Deck playerDeck = new Deck();

        Deck dealerDeck = new Deck();
        //playermoney = 100;

        Scanner userInput = new Scanner(System.in);

        boolean playing = true;

        while (playing && playerMoney > 0) {

            //play on!
            System.out.println("How much would you like to bet?");
            int playerBet = userInput.nextInt();
            if (playerBet > playerMoney) {
                System.out.println("You can't use coins you don't have!!!");
                break;
            }

            boolean endRound = false;

            //start dealing
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while (true) {
                System.out.println("Your hand: ");
                System.out.println(playerDeck.toString());
                System.out.println("Your hand is valued at: " + playerDeck.cardsValue());

                //Display Dealer Hand
                System.out.println("Dealer Hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");

                //What does the player want to do?
                System.out.println("Would you like to (1) Hit or (2) Stand?");
                int response = userInput.nextInt();

                //They Hit
                if (response == 1) {
                    playerDeck.draw(playingDeck);
                    System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                    //Bust if > 21
                    if (playerDeck.cardsValue() > 21) {
                        System.out.println("Bust. Currently valued at: " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }

                if (response == 2) {
                    break;
                }
            }

            //Reveal Dealer Cards
            System.out.println("Dealer Cards: " + dealerDeck.toString());
            //See if dealer has more points than player
            if ((dealerDeck.cardsValue() >= 17) && ((dealerDeck.cardsValue() > playerDeck.cardsValue()) || (playerDeck.cardsValue() > 21)) && endRound == false) {
                System.out.println("Dealer beats you!");
                playerMoney -= playerBet;
                System.out.println("You lost: " + playerBet);
                endRound = true;
            }
            //Dealer Draws at 16, stand at 17
            while ((dealerDeck.cardsValue() < 17) && endRound == false) {
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
            }
            //Display Total Value for Dealer
            System.out.println("Dealer's Hand is valued at: " + dealerDeck.cardsValue());
            //Determine if dealer busted
            if ((dealerDeck.cardsValue() > 21) && endRound == false) {
                System.out.println("Dealer busts! You win!");
                playerMoney += playerBet;
                System.out.println("You won: " + playerBet + " coin(s).");
                endRound = true;
            }

            //determine if push
            if (playerDeck.cardsValue() == dealerDeck.cardsValue() && endRound == false) {
                System.out.println("Push");
                endRound = true;
            }

            if ((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
                System.out.println("You win the hand");
                playerMoney += playerBet;
                System.out.println("You won: " + playerBet + " coin(s).");
                endRound = true;
            } else if (endRound == false) {
                System.out.println("You lose the hand");
                playerMoney -= playerBet;
                endRound = true;
            }

            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("End of hand.");
            System.out.println("");
            System.out.println("Your new balance: " + playerMoney + " coin(s). " + "\n");
            System.out.println("Do you wanna continue playing? (y/n)");
            String keepPlay = userInput.next();
            if (keepPlay.equals("n")) {
                playing = false;
            }

        }
        //end of game
        if (playerMoney == 0) {
            System.out.println("You're out of money, here is a boot!" + "\n" + "\n");
        }

        globalChips = playerMoney;
        return globalChips;
    }
}