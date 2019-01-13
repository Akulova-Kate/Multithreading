package parser;

import java.util.Arrays;
import java.util.List;

import static constants.Numbers.*;
import static constants.Rank.*;

public class InputChecker {

    private List<String> words;

    private static final List<String> UNITS = Arrays.asList(ONE, TWO, THREE, FOUR, FIVE,
            SIX, SEVEN, EIGHT, NINE);
    private static final List<String> TENS = Arrays.asList(TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN,
            FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTEEN, NINETEEN);
    private static final List<String> DECADES = Arrays.asList(TWENTY, THIRTY, FORTY,
            FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY);

    public InputChecker(List<String> words) {
        this.words = words;
    }

    public boolean isCorrect() {
        return checkSizeOfWordsInLine() &&
                checkThatWordsAreCorrect() &&
                isCheckWordsOrder();
    }

    private boolean isCheckWordsOrder() {
        int size = words.size();
        switch (size) {
            case 1:
                return checkIfSizeIsOne();
            case 2:
                return checkIfSizeIsTwo();
            case 3:
                return checkIfSizeIsThree();
            case 4:
                return checkIfSizeIfFour();
            case 5:
                return checkIfSizeIsFive();
            case 6:
                return checkIfSizeIsSix();
        }
        return false;
    }

    private boolean checkSizeOfWordsInLine() {
        return !words.isEmpty() && words.size() <= 6;
    }

    private boolean checkThatWordsAreCorrect() {
        return words.stream().allMatch(this::isListContainsWord);

    }

    private boolean checkIfSizeIsOne() {
        return isUnitOrTenOrDecade(words.get(0).toLowerCase());
    }

    private boolean checkIfSizeIsTwo() {
        String firstWord = words.get(0).toLowerCase();
        String secondWord = words.get(1).toLowerCase();

        return DECADES.contains(firstWord) && UNITS.contains(secondWord) ||
                UNITS.contains(firstWord) && isHundredOrThousand(secondWord);
    }

    private boolean checkIfSizeIsThree() {
        String firstWord = words.get(0).toLowerCase();
        String secondWord = words.get(1).toLowerCase();
        String thirdWord = words.get(2).toLowerCase();

        return UNITS.contains(firstWord) && isHundredOrThousand(secondWord) &&
                isUnitOrTenOrDecade(thirdWord);
    }

    private boolean checkIfSizeIfFour() {
        String firstWord = words.get(0).toLowerCase();
        String secondWord = words.get(1).toLowerCase();
        String thirdWord = words.get(2).toLowerCase();
        String fourthWord = words.get(3).toLowerCase();

        boolean isCorrectWhenThousand = UNITS.contains(firstWord) && THOUSAND.equals(secondWord) &&
                (UNITS.contains(thirdWord) && HUNDRED.equals(fourthWord) ||
                        DECADES.contains(thirdWord) && UNITS.contains(fourthWord));

        boolean isCorrectWhenHundred = UNITS.contains(firstWord) && HUNDRED.equals(secondWord) &&
                DECADES.contains(thirdWord) && UNITS.contains(fourthWord);


        return isCorrectWhenHundred || isCorrectWhenThousand;

    }

    private boolean checkIfSizeIsFive() {
        String firstWord = words.get(0).toLowerCase();
        String secondWord = words.get(1).toLowerCase();
        String thirdWord = words.get(2).toLowerCase();
        String fourthWord = words.get(3).toLowerCase();
        String fifthWord = words.get(4).toLowerCase();

        return UNITS.contains(firstWord) && THOUSAND.equals(secondWord) &&
                UNITS.contains(thirdWord) && HUNDRED.equals(fourthWord) &&
                isUnitOrTenOrDecade(fifthWord);
    }

    private boolean checkIfSizeIsSix() {
        String firstWord = words.get(0).toLowerCase();
        String secondWord = words.get(1).toLowerCase();
        String thirdWord = words.get(2).toLowerCase();
        String fourthWord = words.get(3).toLowerCase();
        String fifthWord = words.get(4).toLowerCase();
        String sixthWord = words.get(5).toLowerCase();

        return UNITS.contains(firstWord) && THOUSAND.equals(secondWord) &&
                UNITS.contains(thirdWord) && HUNDRED.equals(fourthWord) &&
                DECADES.contains(fifthWord) && UNITS.contains(sixthWord);
    }

    private boolean isListContainsWord(String word) {
        word = word.toLowerCase();
        return isUnitOrTenOrDecade(word) ||
                isHundredOrThousand(word);
    }

    private boolean isUnitOrTenOrDecade(String word) {
        return UNITS.contains(word) || TENS.contains(word) || DECADES.contains(word);
    }

    private boolean isHundredOrThousand(String word) {
        return HUNDRED.equals(word) || THOUSAND.equals(word);
    }
}

