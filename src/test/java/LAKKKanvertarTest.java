import by.kanvertar.pravapisu.converter.LAKKKanvertar;
import by.kanvertar.pravapisu.converter.LALTKanvertar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LAKKKanvertarTest {

    private static final LAKKKanvertar converter = new LAKKKanvertar();

    @Test
    public void test() {
        assertEquals("ня той мэнталітэт", converter.kanvertavać("nie toj mientalitet"));
    }
}
