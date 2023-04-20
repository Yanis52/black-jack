package test;

import cartes.*;
import java.util.ArrayList;

import org.junit.Test;

public class DeckTest extends TestClass {
    public DeckTest() {
    }

    @Test
    public void testAddCard() {
        messageStart("testAddCard");
        Deck deck = DeckFactory.get52DeckCard("classique");

        Card card = new Card("as", "coeur", "classique");
        deck.addCardToEnd(card);
        ArrayList<Card> recupDeck = deck.getDeck();

        testEquals(53, recupDeck.size());
        testEquals(card, recupDeck.get(recupDeck.size() - 1));

        Card cardDebut = new Card("as", "coeur", "classique");
        deck.addCardToHead(cardDebut);

        testEquals(54, recupDeck.size());
        testEquals(cardDebut, recupDeck.get(0));

        messageEnd(4);
    }

    @Test
    public void testDrawCard() {
        messageStart("testDrawCard");
        Deck deck = DeckFactory.get52DeckCard("classique");

        ArrayList<Card> recupDeck = deck.getDeck();
        Card card = deck.drawCard();

        testEquals(51, recupDeck.size());
        deck.addCardToHead(card);
        testEquals(card, recupDeck.get(0));

        messageEnd(2);
    }

    public static void allTest() {

        DeckTest test = new DeckTest();

        test.messageStartClassTest("DeckTest");

        // Tests
        test.testAddCard();
        test.testDrawCard();

        test.messageEndClassTest();

    }

    public static void main(String[] args) {
        DeckTest.allTest();
    }

}
