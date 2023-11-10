package by.kanvertar.pravapisu.converter;

/**
 * ŁT - Łacinka Tradycyjnaja
 * LA - Łacinka Aficyjnaja
 * KK - Kiryličny Klasyčny (pravapis)
 * KA - Kiryličny Aficyjny (pravapis)
 * <p>
 * Šach kanvertacyi (musić pracavać u abodva baki)
 * <p>
 * ŁT <--> KK <--> KA <--> LA
 */
public enum VidKanvertacyi {
    KALT(new KALTKanvertar()), // kiryličny aficyjny -> łacinka tradycyjnaja
    KALA(new KALAKanvertar()), // kiryličny aficyjny -> łacinka aficyjnaja
    KAKK(new KAKKKanvertar()), // kiryličny aficyjny -> kiryličny klasyčny

    KKLT(new KKLTKanvertar()), // kiryličny klasyčny -> łacinka tradycyjnaja
    KKLA(new KKLAKanvertar()), // kiryličny klasyčny -> łacinka aficyjnaja
    KKKA(new KKKAKanvertar()), // kiryličny klasyčny -> kiryličny aficyjny

    LTLA(new LTLAKanvertar()), // łacinka tradycyjnaja -> łacinka aficyjnaja
    LTKK(new LTKKKanvertar()), // łacinka tradycyjnaja -> kiryličny klasyčny
    LTKA(new LTKAKanvertar()), // łacinka tradycyjnaja -> kiryličny aficyjny

    LALT(new BazavyKanvertar()), // łacinka aficyjnaja -> łacinka tradycyjnaja
    LAKK(new BazavyKanvertar()), // łacinka aficyjnaja -> kiryličny klasyčny
    LAKA(new BazavyKanvertar()); // łacinka aficyjnaja -> kiryličny aficyjny

    public final BazavyKanvertar kanvertar;

    private VidKanvertacyi(BazavyKanvertar kanvertar) {
        this.kanvertar = kanvertar;
    }
}
