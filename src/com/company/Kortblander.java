package com.company;

import java.util.ArrayList;

public class Kortblander {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] kulører = {"Hearts", "Diamonds", "Spades", "Clubs"};
        String[] billedkort = {"Jack", "Queen", "King"};
        int blandet = 0;
        ArrayList<String> bunke = new ArrayList<>();
        for (String farve : kulører) {
            for (int i = 1; i <= 10; i++) {
                String s = i + " Of " + farve;
                bunke.add(s);
            }
            for (String billede : billedkort) {
                String s = billede + " Of " + farve;
                bunke.add(s);
            }
        }
        while (blandet < 1000) {
            int rnd = (int) (Math.random() * 52);
            String valgtkort = bunke.get(rnd);
            bunke.remove(rnd);
            bunke.add(valgtkort);
            blandet++;
        }
        System.out.println(bunke);
    }
}