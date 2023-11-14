import by.kanvertar.pravapisu.converter.LAKAKanvertar;
import by.kanvertar.pravapisu.converter.LTKKKanvertar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LAKAKanvertarTest {

    private static final LAKAKanvertar converter = new LAKAKanvertar();

    @Test
    public void test() {
        assertEquals("каваль боль соль чалавек", converter.kanvertavać("kavaĺ boĺ soĺ čalaviek"));
    }
}
