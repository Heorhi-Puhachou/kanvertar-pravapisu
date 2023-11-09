import by.kanvertar.pravapisu.converter.k.KAKanvertar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KAKanvertarTest {

    private static final KAKanvertar converter = new KAKanvertar();

    @Test
    public void test() {
        assertEquals("Не там Еўропа...", converter.kanvertavać("Ня там Эўропа..."));
    }

    @Test
    public void testMZ() {
        assertEquals("пасля", converter.kanvertavać("пасьля"));
    }

    @Test
    public void testEnding() {
        assertEquals("кампендыум", converter.kanvertavać("кампендыюм"));
        assertEquals("калегіум", converter.kanvertavać("калегіюм"));
    }

    @Test
    public void testDoublesMZ() {
        assertEquals("вяселле", converter.kanvertavać("вясельле"));
    }

    @Test
    public void testNoChange() {
        assertEquals("карыстальнік", converter.kanvertavać("карыстальнік"));
    }

    @Test
    public void testDZ() {
        assertEquals("суддзя", converter.kanvertavać("судзьдзя"));
    }

    @Test
    public void testJa() {
        assertEquals("класічны", converter.kanvertavać("клясычны"));
    }

    @Test
    public void testMkkZnk() {
        assertEquals("праз яе", converter.kanvertavać("празь яе"));
        assertEquals("з яе", converter.kanvertavać("зь яе"));
        assertEquals("з'еў", converter.kanvertavać("зьеў"));
        assertEquals("з'езд", converter.kanvertavać("зьезд"));
    }

}
