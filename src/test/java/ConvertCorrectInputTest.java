import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class InputProcessorThreadCorrectInputTest {
    private InputProcessorThread inputProcessorThread;
    private String inputLine;
    private int expectedNumber;


    public InputProcessorThreadCorrectInputTest(String inputLine, int expectedNumber) {
        this.inputLine = inputLine;
        this.expectedNumber = expectedNumber;
    }

    @Before
    public void setUp() {
        inputProcessorThread = new InputProcessorThread(new InputStorage());
    }


    @Parameterized.Parameters
    public static Collection correctInputWords() {
        return Arrays.asList(new Object[][]{
                {"one", 1},
                {"teN", 10},
                {"fiFty", 50},
                {"ninety five", 95},
                {"two HUNDRED", 200},
                {"three HUNDRED seventeen", 317},
                {"four HUNDRED forty", 440},
                {"five hundred sixty five", 565},
                {"six thousAnd", 6000},
                {"seven thousand seven", 7007},
                {"eight thousand eleven", 8011},
                {"nine thousand thirty", 9030},
                {"one thousand eighty one", 1081},
                {"one thousand five hunDred", 1500},
                {"one thousand six hundred five", 1605},
                {"one thousand six hundred twelve", 1612},
                {"one thousand six hundred twenty two", 1622}
        });
    }

    @Test
    public void readLiteralNumberTest() {
        assertEquals(expectedNumber, inputProcessorThread.getNumberFromLine(inputLine));


    }
}