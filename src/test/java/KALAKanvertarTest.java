import by.kanvertar.pravapisu.converter.KALAKanvertar;
import by.kanvertar.pravapisu.converter.KALTKanvertar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KALAKanvertarTest {

    private static final KALAKanvertar converter = new KALAKanvertar();

    @Test
    public void test() {
        assertEquals("kab čalaviek Božy byŭ daskanaĺnym, da ŭsiakaha dobraha dziela hatovym", converter.kanvertavać("каб чалавек Божы быў дасканальным, да ўсякага добрага дзела гатовым"));
    }
}
