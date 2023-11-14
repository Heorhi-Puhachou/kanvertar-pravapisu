import by.kanvertar.pravapisu.converter.LAKAKanvertar;
import by.kanvertar.pravapisu.converter.LALTKanvertar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LALTKanvertarTest {

    private static final LALTKanvertar converter = new LALTKanvertar();

    @Test
    public void test() {
        assertEquals("kaval bol sol čałaviek", converter.kanvertavać("kavaĺ boĺ soĺ čalaviek"));
        assertEquals("nia toj mentalitet", converter.kanvertavać("nie toj mientalitet"));
    }
}
