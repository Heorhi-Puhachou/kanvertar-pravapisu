package by.kanvertar.pravapisu.converter;


public class LTKAKanvertar extends BazavyKanvertar {
    public String kanvertavać(String tekst) {
        if (tekst == null || tekst.isEmpty()) {
            return tekst;
        }
        String kRadok = (new LTKKKanvertar()).kanvertavać(tekst);   // ŁT -> KK
        String k2Radok = (new KKKAKanvertar()).kanvertavać(kRadok); // KK -> KA

        return k2Radok;
    }
}
