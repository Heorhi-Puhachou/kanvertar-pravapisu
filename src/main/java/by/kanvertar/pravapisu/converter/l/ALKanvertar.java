package by.kanvertar.pravapisu.converter.l;


import by.kanvertar.pravapisu.converter.BazavyKanvertar;
import by.kanvertar.pravapisu.converter.k.KAKTKanvertar;

public class ALKanvertar extends BazavyKanvertar {
    public String kanvertavać(String tekst) {
        if (tekst == null || tekst.isEmpty()) {
            return tekst;
        }
        String kRadok = (new KAKTKanvertar()).kanvertavać(tekst);
        String lRadok = (new KLKanvertar()).kanvertavać(kRadok);

        return lRadok;
    }
}
