import by.kanvertar.pravapisu.converter.KAKKKanvertar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KAKTKanvertarTest {

    private static final KAKKKanvertar converter = new KAKKKanvertar();

    @Test
    public void testTransformEIntoJa() {
        assertEquals("Ня там.", converter.kanvertavać("Не там."));
        assertEquals("Бяз назвы", converter.kanvertavać("Без назвы"));
        assertEquals("Ня бойка", converter.kanvertavać("Не бойка"));
    }

    @Test
    public void testNoChange() {
        assertEquals("аплікацыя", converter.kanvertavać("аплікацыя"));
        assertEquals("Пугачова", converter.kanvertavać("Пугачова"));
    }

    @Test
    public void testEnding() {
        assertEquals("кампендыюм", converter.kanvertavać("кампендыум"));
        assertEquals("калегіюм", converter.kanvertavać("калегіум"));
    }


    @Test
    public void testDoublesMZ() {
        assertEquals("вясельле", converter.kanvertavać("вяселле"));
    }

    @Test
    public void testDZ() {
        assertEquals("судзьдзя", converter.kanvertavać("суддзя"));
    }

    @Test
    public void testBP() {
        assertEquals("зьбег", converter.kanvertavać("збег"));
        assertEquals("сьпеўнік", converter.kanvertavać("спеўнік"));
    }

    @Test
    public void testBP2() {
        assertEquals("б'е", converter.kanvertavać("б'е"));
        assertEquals("п'е", converter.kanvertavać("п'е"));
    }

    @Test
    public void testE() {
        assertEquals("Эўропа", converter.kanvertavać("Еўропа"));
    }

    @Test
    public void testZ() {
        assertEquals("празь яе", converter.kanvertavać("праз яе"));
        assertEquals("зь сямі", converter.kanvertavać("з сямі"));
    }

    @Test
    public void testMkkZnk() {
        assertEquals("зьеў", converter.kanvertavać("з'еў"));
        assertEquals("зьезд", converter.kanvertavać("з'езд"));
    }

    @Test
    public void testSS() {
        assertEquals("сьмяесься", converter.kanvertavać("смяешся"));
    }

}
