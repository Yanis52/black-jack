package test;

import org.junit.Test;
import cartes.Card;

public class CardTest extends TestClass {

    public CardTest() {
    }

    @Test
    public void testCardCreation() {
        messageStart("testCardCreation");

        Card card = new Card("as", "coeur", "vintage");
        testEquals("as", card.getValue());
        testEquals("coeur", card.getColor());

        messageEnd(2);
    }

    @Test
    public void testCardToString() {
        messageStart("testCardToString");

        Card card = new Card("as", "coeur", "vintage");
        testEquals("(as, coeur)", card.toString());

        messageEnd(1);
    }

    @Test
    public void testCardGetPath() {
        messageStart("testCardGetPath");

        Card card = new Card("as", "coeur", "vintage");
        testEquals("assets/card_img/coeur_as.png", card.getImgPath());

        messageEnd(1);
    }

    @Test
    public void testCardCompareTo() {
        messageStart("testCardCompareTo");

        Card card1 = new Card("2", "coeur", "vintage");
        Card card2 = new Card("roi", "coeur", "vintage");
        Card card3 = new Card("roi", "pique", "vintage");

        testEquals(-1, card1.compareTo(card2));
        testEquals(1, card2.compareTo(card1));
        testEquals(0, card2.compareTo(card3));

        messageEnd(3);
    }

    public static void allTest() {

        CardTest test = new CardTest();

        test.messageStartClassTest("CardTest");

        // Tests
        test.testCardCreation();
        test.testCardToString();
        test.testCardGetPath();
        test.testCardCompareTo();

        test.messageEndClassTest();

    }

    public static void main(String[] args) {
        CardTest.allTest();
    }

}