import by.kanvertar.pravapisu.converter.KALAKanvertar;
import by.kanvertar.pravapisu.converter.LTKKKanvertar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LTKKKanvertarTest {

    private static final LTKKKanvertar converter = new LTKKKanvertar();

    @Test
    public void test() {
        assertEquals("каб чалавек Божы быў дасканальным, да ўсякага добрага дзела гатовым", converter.kanvertavać("kab čałaviek Božy byŭ daskanalnym, da ŭsiakaha dobraha dzieła hatovym"));
        assertEquals("каваль дасканальным сьнег", converter.kanvertavać("kaval daskanalnym śnieh"));
    }
}
