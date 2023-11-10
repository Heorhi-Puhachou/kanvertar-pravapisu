package by.kanvertar.pravapisu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.kanvertar.pravapisu.util.StringUtilGet.findFirstVowel;
import static by.kanvertar.pravapisu.util.StringUtilGet.getVowelQuantity;

public class StringUtilCheck {

    public static boolean isWordSymbol(char symbol) {
        String nonDelimiterPattern = "[\\p{L}\\d']";
        Pattern pattern = Pattern.compile(nonDelimiterPattern);
        Matcher matcher = pattern.matcher("" + symbol);
        return matcher.matches();
    }

    public static boolean isHalosny(String symbol) {
        String nonDelimiterPattern = "[аяоёэеуюыі]";
        Pattern pattern = Pattern.compile(nonDelimiterPattern);
        Matcher matcher = pattern.matcher(symbol);
        return matcher.matches();
    }

    public static boolean isHalosny(char symbol) {
        return isHalosny("" + symbol);
    }

    public static boolean isEngWord(String word) {
        String nonDelimiterPattern = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(nonDelimiterPattern);
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

    public static boolean hetaKiryličnajeSłoava(String word) {
        String nonDelimiterPattern = "[а-яА-Я]+";
        Pattern pattern = Pattern.compile(nonDelimiterPattern);
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

    public static boolean isEngSymbol(char symbol) {
        return isEngWord("" + symbol);
    }

    public static boolean hetaKiryličnySymbal(char symbol) {
        return Character.UnicodeBlock.of(symbol).equals(Character.UnicodeBlock.CYRILLIC);
    }

    public static boolean isNumber(String symbol) {
        String nonDelimiterPattern = "[\\d]+";
        Pattern pattern = Pattern.compile(nonDelimiterPattern);
        Matcher matcher = pattern.matcher(symbol);
        return matcher.matches();
    }

    public static boolean isNumber(char symbol) {
        return isNumber("" + symbol);
    }

    public static boolean isApostraf(String symbol) {
        return "'".equals(symbol);
    }

    public static boolean isApostraf(char symbol) {
        return isApostraf("" + symbol);
    }

    public static boolean hetaMiakkiHalosny(String symbol) {
        String miakkiHalosnyPattern = "[яёеюі]";
        Pattern pattern = Pattern.compile(miakkiHalosnyPattern);
        Matcher matcher = pattern.matcher(symbol);
        return matcher.matches();
    }

    public static boolean hetaMiakkiHalosny(char symbol) {
        return hetaMiakkiHalosny("" + symbol);
    }

    public static boolean isOneVowelInWord(String word) {
        return getVowelQuantity(word) == 1;
    }

    public static boolean pershySkladPadNaciskam(String word) {
        return word.equals("бачу")
                || word.equals("назвы")
                || word.equals("будзе")
                || word.equals("буду")
                || word.equals("трэба")
                || word.equals("ведаю")
                || (isNumber(word) && (word.startsWith("2") || word.startsWith("3")))
                || "о".equals(findFirstVowel(word))
                || isOneVowelInWord(word);
    }
}
