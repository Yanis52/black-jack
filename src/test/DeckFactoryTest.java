package test;

import cartes.*;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class DeckFactoryTest extends TestClass {
    public DeckFactoryTest() {
    }

    public void completeDeck52Test() {
        messageStart("testCompleteDeck52");
        Deck cinqdeux = DeckFactory.get52DeckCard("classique");
        ArrayList<Card> recupDeck = cinqdeux.getDeck();
        ArrayList<Card> deckComplet = new ArrayList<>();

        ArrayList<String> color = new ArrayList<>(Arrays.asList("pique", "trefle", "carreau", "coeur"));

        for (int i = 2; i < 11; i++) {
            for (String c : color) {
                deckComplet.add(new Card(Integer.toString(i), c, "classique"));
            }
        }

        ArrayList<String> figure_as = new ArrayList<>(Arrays.asList("as", "valet", "reine", "roi"));
        for (String c : color) {
            for (String f : figure_as) {
                deckComplet.add(new Card(f, c, "classique"));
            }
        }

        for (Card c : deckComplet) {
            assertEquals(true, recupDeck.contains(c));
        }

        testEquals(true, true);
        messageEnd(1);
    }

    public void completeDeck40Test() {
        messageStart("testCompleteDeck40");
        Deck cinqdeux = DeckFactory.get52DeckCard("classique");
        ArrayList<Card> recupDeck = cinqdeux.getDeck();
        ArrayList<Card> deckComplet = new ArrayList<>();

        ArrayList<String> color = new ArrayList<>(Arrays.asList("pique", "trefle", "carreau", "coeur"));

        for (int i = 2; i < 11; i++) {
            for (String c : color) {
                deckComplet.add(new Card(Integer.toString(i), c, "classique"));
            }
        }

        for (String c : color) {
            deckComplet.add(new Card("as", c, "deckStyle"));
        }

        for (Card c : deckComplet) {
            assertEquals(true, recupDeck.contains(c));
        }

        testEquals(true, true);
        messageEnd(1);
    }

    public static void allTest() {

        DeckFactoryTest test = new DeckFactoryTest();

        test.messageStartClassTest("DeckTestFactory");
        // Tests
        test.completeDeck52Test();
        test.completeDeck40Test();
        test.messageEndClassTest();

    }

    public static void main(String[] args) {
        DeckFactoryTest.allTest();
    }

}
