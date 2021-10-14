package com.company;

import static com.company.Main.startChips;


public class pointSystem {
    public static int highscore;
    public static int globalChips = startChips;

    public static int updateHighscore() {
        if (globalChips > highscore) {
            highscore = globalChips;
        }

        return highscore;
    }
}

