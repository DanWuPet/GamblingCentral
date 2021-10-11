package com.company;

public class Card {
    private int rank;
    private int suit;

    public Card() {
        this.rank = rank;
        this.suit = suit;
    }
    //Henter et kort eks. "3 of Clubs".
    public String toString() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String card = ranks[this.rank] + " of " + suits[this.suit];
        return card;
    }
        public boolean equals(Card that) {
            return this.rank == that.rank
                    && this.suit == that.suit;
        }
        public int compareTo(Card that) {
            if (this.suit < that.suit) {
                return -1;
            }
            if (this.suit > that.suit) {
                return 1;
            }
            if (this.rank < that.rank) {
                return -1;
            }
            if (this.rank > that.rank) {
                return 1;
            }
            return 0;
        }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }
}

