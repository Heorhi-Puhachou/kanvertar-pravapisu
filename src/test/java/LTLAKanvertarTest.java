import by.kanvertar.pravapisu.converter.LTKKKanvertar;
import by.kanvertar.pravapisu.converter.LTLAKanvertar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LTLAKanvertarTest {

    private static final LTLAKanvertar converter = new LTLAKanvertar();

    @Test
    public void test() {
        assertEquals("kavaĺ daskanaĺnym snieh viasiellie", converter.kanvertavać("kaval daskanalnym śnieh viasielle"));
    }
}
