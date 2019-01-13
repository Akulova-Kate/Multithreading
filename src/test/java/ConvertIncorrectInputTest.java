import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ConvertIncorrectInputTest {
    private InputProcessorThread inputProcessorThread;
    private String inputLine;

    public ConvertIncorrectInputTest(String inputLine) {
        this.inputLine = inputLine;
    }

    @Parameterized.Parameters
    public static Collection incorrectInputWords() {
        return Arrays.asList(
                "",
                " ",
                "eno",
                "thousand one",
                "hundred six",
                "one hundred ninety ninety",
                "two thousand fifty eleven",
                "one hundred two thousand",
                "eleven five",
                "thirty two nine",
                "one thousand thirty hundred",
                "twelve thousand",
                "seven hundred eleven one",
                "one hundred two thousand sixty six one"
        );
    }

    @Before
    public void setUp() {
        inputProcessorThread = new InputProcessorThread(new InputStorage());
    }

    @Test(expected = IllegalArgumentException.class)
    public void readLiteralNumberTest() {
        inputProcessorThread.getNumberFromLine(inputLine);
    }
}
