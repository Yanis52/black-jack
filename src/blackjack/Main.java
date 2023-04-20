package blackjack;

import cartes.Hand;

public class Main {
    public static void main(String[] args) {
        /*
         * Demo de Party, avec une partie dans le terminal
         */
        Party a = new Party(11, "vintage");
        a.addHand(new Hand());
        a.addHand(new Hand());
        a.launchGame();
    }
}
