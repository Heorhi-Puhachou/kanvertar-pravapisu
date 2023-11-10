import by.kanvertar.pravapisu.converter.KKLTKanvertar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KTLTKanvertarTest {

    private static final KKLTKanvertar kanvertar = new KKLTKanvertar();

    @Test
    public void test() {
        assertEquals("Lahienda Zeldy", kanvertar.kanvertavać("Лягенда Зэльды"));
    }

    @Test
    public void testN() {
        assertEquals("Lahienda Zeldy", kanvertar.kanvertavać("Лягенда Зэльды"));
    }

    @Test
    public void testL() {
        assertEquals("Luk", kanvertar.kanvertavać("Люк"));
        assertEquals("Ła ła ła", kanvertar.kanvertavać("Ла ла ла"));
        assertEquals("Lalka", kanvertar.kanvertavać("Лялька"));
        assertEquals("Łyč Linka", kanvertar.kanvertavać("Лыч Лінка"));
    }

    @Test
    public void testZ() {
        assertEquals("Žyćcio", kanvertar.kanvertavać("Жыцьцё"));
    }
}
