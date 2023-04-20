package test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class TestClass {

    public int count = 0;
    public ArrayList<Integer> countTest = new ArrayList<>();
    public String methodName = "";
    public String nameClass = "";

    public void messageStartClassTest(String className) {
        System.out.println("\t[START CLASS TESTS] " + className + "\n");
        nameClass = className;
    }

    public void messageEndClassTest() {
        System.out.println("\t[END CLASS TESTS] " + nameClass + "\n");
        nameClass = "";
    }

    public void messageStart(String nameMethod) {
        System.out.println("[START TESTS] " + nameMethod);
        methodName = nameMethod;
    }

    public void messageEnd(int nbTest) {
        if (countTest.size() == nbTest) {
            System.out.println("[END TESTS] " + methodName + " PASSED" + "\n");
        } else {
            System.out.println("[END TESTS] " + methodName + " FAILED" + "\n");
        }

        reset();
    }

    public void reset() {
        countTest = new ArrayList<>();
        count = 0;
        methodName = "";
    }

    public void testEquals(Object expected, Object actual) {
        try {
            assertEquals(expected, actual);
            System.out.println("[TEST] " + count + " SUCCES");
            countTest.add(count);
            count++;
        } catch (AssertionError e) {
            System.out.println("[TEST] " + count + " FAILED");
            System.out.println(("##### error descritpion #####"));
            e.printStackTrace();
            System.out.println(("###########"));

        }
    }
}
