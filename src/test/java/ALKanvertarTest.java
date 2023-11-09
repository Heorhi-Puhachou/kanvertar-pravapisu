import by.kanvertar.pravapisu.converter.l.ALKanvertar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ALKanvertarTest {

    private static final ALKanvertar converter = new ALKanvertar();

    @Test
    public void test() {
        assertEquals("nia toj źjezd da Iŭja", converter.kanvertavać("не той з'езд да Іўя"));
        assertEquals("Jana j jon ubačyli śviet.", converter.kanvertavać("Яна і ён убачылі свет."));
    }
}
