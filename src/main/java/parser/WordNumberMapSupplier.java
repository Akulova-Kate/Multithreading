package parser;

import java.util.HashMap;
import java.util.Map;

import static constants.Numbers.*;

public class WordNumberMapSupplier {

    public final static Map<String, Integer> WORD_NUMBER_MAP = initMap();

    private static Map<String, Integer> initMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put(ONE, 1);
        map.put(TWO, 2);
        map.put(THREE, 3);
        map.put(FOUR, 4);
        map.put(FIVE, 5);
        map.put(SIX, 6);
        map.put(SEVEN, 7);
        map.put(EIGHT, 8);
        map.put(NINE, 9);
        map.put(TEN, 10);
        map.put(ELEVEN, 11);
        map.put(TWELVE, 12);
        map.put(THIRTEEN, 13);
        map.put(FOURTEEN, 14);
        map.put(FIFTEEN, 15);
        map.put(SIXTEEN, 16);
        map.put(SEVENTEEN, 17);
        map.put(EIGHTEEN, 18);
        map.put(NINETEEN, 19);
        map.put(TWENTY, 20);
        map.put(THIRTY, 30);
        map.put(FORTY, 40);
        map.put(FIFTY, 50);
        map.put(SIXTY, 60);
        map.put(SEVENTY, 70);
        map.put(EIGHTY, 80);
        map.put(NINETY, 90);

        return map;
    }

}
