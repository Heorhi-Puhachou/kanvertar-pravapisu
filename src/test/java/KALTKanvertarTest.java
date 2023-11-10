import by.kanvertar.pravapisu.converter.KALTKanvertar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KALTKanvertarTest {

    private static final KALTKanvertar converter = new KALTKanvertar();

    @Test
    public void test() {
        assertEquals("nia toj źjezd da Iŭja", converter.kanvertavać("не той з'езд да Іўя"));
        assertEquals("Jana j jon ubačyli śviet.", converter.kanvertavać("Яна і ён убачылі свет."));
        assertEquals("kab čałaviek Božy byŭ daskanalnym, da ŭsiakaha dobraha dzieła hatovym", converter.kanvertavać("каб чалавек Божы быў дасканальным, да ўсякага добрага дзела гатовым"));
    }
}
