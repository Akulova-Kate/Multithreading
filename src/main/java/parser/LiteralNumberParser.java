package parser;

import constants.Rank;

import java.util.Arrays;
import java.util.List;

public class LiteralNumberParser {

    public static int convertStringToNumber(String line) {
        List<String> words = getListOfInputWords(line);
        checkInputLine(words);
        int result = 0;
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            int intValue = WordNumberMapSupplier.WORD_NUMBER_MAP.get(word.toLowerCase());
            String nextWord = getNextWordIfExists(words, i + 1);
            if (nextWord != null) {
                if (Rank.THOUSAND.equals(nextWord.toLowerCase())) {
                    intValue = intValue * 1000;
                    i++;
                } else if (Rank.HUNDRED.equals(nextWord.toLowerCase())) {
                    intValue = intValue * 100;
                    i++;
                }
            }
            result += intValue;
        }
        return result;
    }

    private static String getNextWordIfExists(List<String> list, int i) {
        if (list.size() > i) {
            return list.get(i);
        }
        return null;
    }

    private static List<String> getListOfInputWords(String line) {
        return Arrays.asList(line.split(" "));
    }

    private static void checkInputLine(List<String> words ){
        InputChecker inputChecker = new InputChecker(words);
        if (!inputChecker.isCorrect()) {
            throw new IllegalArgumentException("Input value is empty or incorrect!");
        }
    }
}
