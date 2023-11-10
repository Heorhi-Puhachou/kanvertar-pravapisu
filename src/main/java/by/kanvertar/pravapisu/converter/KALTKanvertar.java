package by.kanvertar.pravapisu.converter;


public class KALTKanvertar extends BazavyKanvertar {
    public String kanvertavać(String tekst) {
        if (tekst == null || tekst.isEmpty()) {
            return tekst;
        }
        String kRadok = (new KAKKKanvertar()).kanvertavać(tekst);
        String lRadok = (new KKLTKanvertar()).kanvertavać(kRadok);

        return lRadok;
    }
}
