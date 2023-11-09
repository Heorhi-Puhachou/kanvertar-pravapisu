package by.kanvertar.pravapisu.util;

import static by.kanvertar.pravapisu.util.StringUtilCheck.isHalosny;

public class StringUtilGet {

    public static String findFirstVowel(String word) {
        char[] chars = word.toCharArray();
        String result = null;

        for (int i = 0; i < word.length(); i++) {
            if (StringUtilCheck.isHalosny("" + chars[i])) {
                return "" + chars[i];
            }
        }
        return result;
    }

    public static int getVowelQuantity(String word) {
        char[] chars = word.toCharArray();
        int quantity = 0;

        for (int i = 0; i < word.length(); i++) {
            if (StringUtilCheck.isHalosny("" + chars[i])) {
                quantity++;
            }
        }
        return quantity;
    }

    public static String getLastSymbol(String input) {
        return input.substring(input.length() - 1);
    }
}
