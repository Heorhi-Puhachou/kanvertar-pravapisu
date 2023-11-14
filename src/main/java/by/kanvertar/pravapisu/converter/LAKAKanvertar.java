package by.kanvertar.pravapisu.converter;


import by.kanvertar.pravapisu.parser.Analizatar;
import by.kanvertar.pravapisu.parser.PraanalizavanyElement;
import by.kanvertar.pravapisu.util.StringUtilCheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static by.kanvertar.pravapisu.util.StringUtilTransform.transformCase;

public class LAKAKanvertar extends BazavyKanvertar {
    private final Analizatar parser;
    private final HashMap<String, String> pairs;
    private final HashMap<String, String> pairsL;

    public LAKAKanvertar() {

        this.parser = new Analizatar();
        pairs = new HashMap<>();
        pairs.put("a", "а");
        pairs.put("b", "б");
        pairs.put("v", "в");
        pairs.put("h", "г");
        pairs.put("d", "д");
        pairs.put("je", "е");
        pairs.put("jo", "ё");
        pairs.put("ž", "ж");
        pairs.put("z", "з");
        pairs.put("i", "і");
        pairs.put("j", "й");
        pairs.put("k", "к");
        pairs.put("l", "л");
        pairs.put("m", "м");
        pairs.put("n", "н");
        pairs.put("o", "о");
        pairs.put("p", "п");
        pairs.put("r", "р");
        pairs.put("s", "с");
        pairs.put("t", "т");
        pairs.put("u", "у");
        pairs.put("ŭ", "ў");
        pairs.put("f", "ф");
        pairs.put("ch", "х");
        pairs.put("c", "ц");
        pairs.put("č", "ч");
        pairs.put("š", "ш");
        pairs.put("y", "ы");
        //pairs.put("ь", "");
        pairs.put("e", "э");
        pairs.put("ju", "ю");
        pairs.put("ja", "я");
        pairs.put("ie", "е");
        pairs.put("ĺ", "ль");
        pairs.put("ń", "нь");
        pairs.put("ć", "ць");
        pairs.put("ś", "сь");
        pairs.put("ź", "зь");

        pairsL = new HashMap<>();
        pairsL.put("ĺ", "ль");
        pairsL.put("ie", "е");
        pairsL.put("iu", "ю");
        pairsL.put("io", "ё");
        pairsL.put("ia", "я");
    }

    public String kanvertavać(String tekst) {
        if (tekst == null || tekst.isEmpty()) {
            return tekst;
        }
        ArrayList<PraanalizavanyElement> elements = parser.parse(tekst);
        StringBuilder result = new StringBuilder();

        for (PraanalizavanyElement current : elements) {
            result.append(current.getDelimiter()).append(convertElement(current));
        }

        return result.toString();
    }

    private String convertElement(PraanalizavanyElement current) {
        String convertedValue = advancedReplace(current.getWord());
        convertedValue = transformCase(current.getWordCase(), convertedValue);
        return convertedValue;
    }

    private String advancedReplace(String word) {
        String padrychtavanajeSłova = replaceHałosnyjaDyL(word);

        String result = "";

        char[] chars = padrychtavanajeSłova.toCharArray();

        for (int i = 0; i < padrychtavanajeSłova.length(); i++) {
            if (StringUtilCheck.isNumber(chars[i]) || StringUtilCheck.hetaKiryličnySymbal(chars[i])) {
                result = result + chars[i];
            } else {
                String symbol = pairs.get("" + chars[i]);
                result = result + symbol;
            }
        }

        return result;
    }

    private String replaceHałosnyjaDyL(String word) {
        for (Map.Entry<String, String> entry : pairsL.entrySet()) {
            word = word.replace(entry.getKey(), entry.getValue());
        }
        return word;
    }
}
