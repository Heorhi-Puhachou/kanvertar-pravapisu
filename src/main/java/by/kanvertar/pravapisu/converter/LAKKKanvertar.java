package by.kanvertar.pravapisu.converter;


import by.kanvertar.pravapisu.parser.Analizatar;
import by.kanvertar.pravapisu.parser.PraanalizavanyElement;
import by.kanvertar.pravapisu.util.StringUtilCheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static by.kanvertar.pravapisu.util.StringUtilTransform.transformCase;

public class LAKKKanvertar extends BazavyKanvertar {
    public String kanvertavać(String tekst) {
        if (tekst == null || tekst.isEmpty()) {
            return tekst;
        }
        String k1Radok = (new LAKAKanvertar()).kanvertavać(tekst);   // LA -> KA
        String k2Radok = (new KAKKKanvertar()).kanvertavać(k1Radok); // KA -> KK

        return k2Radok;
    }
}
