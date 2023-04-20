package test;

public class LauchAllTest {
    public static void main(String[] args) {
        System.out.println("\t\t\t[START TESTING]\n");

        // Call to main test class
        CardTest.allTest();
        DeckTest.allTest();
        DeckFactoryTest.allTest();
        System.out.println("\n\t\t\t[END TESTING]");
    }
}
