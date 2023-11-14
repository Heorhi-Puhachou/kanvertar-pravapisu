package by.kanvertar.pravapisu.converter;


public class LALTKanvertar extends BazavyKanvertar {
    public String kanvertavać(String tekst) {
        if (tekst == null || tekst.isEmpty()) {
            return tekst;
        }
        String k1Radok = (new LAKAKanvertar()).kanvertavać(tekst);   // LA -> KA
        String k2Radok = (new KAKKKanvertar()).kanvertavać(k1Radok); // KA -> KK
        String lRadok = (new KKLTKanvertar()).kanvertavać(k2Radok); // KK -> LT

        return lRadok;
    }
}
