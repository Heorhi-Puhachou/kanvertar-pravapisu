package by.kanvertar.pravapisu.converter;


public class KKLAKanvertar extends BazavyKanvertar {
    public String kanvertavać(String tekst) {
        if (tekst == null || tekst.isEmpty()) {
            return tekst;
        }
        String kRadok = (new KKKAKanvertar()).kanvertavać(tekst);
        String lRadok = (new KALAKanvertar()).kanvertavać(kRadok);

        return lRadok;
    }
}
