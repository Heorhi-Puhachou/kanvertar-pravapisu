package by.kanvertar.pravapisu.converter.constant;

import java.util.ArrayList;

public class ZmiakcajucyZycny {
    private static ZmiakcajucyZycny single_instance = null;


    private ArrayList<String> zmiakcajemyjaZycnyja;


    private ZmiakcajucyZycny() {
        zmiakcajemyjaZycnyja = new ArrayList<>();
        zmiakcajemyjaZycnyja.add("с");
        zmiakcajemyjaZycnyja.add("п");
        zmiakcajemyjaZycnyja.add("б");
        zmiakcajemyjaZycnyja.add("в");
        zmiakcajemyjaZycnyja.add("ц");
        zmiakcajemyjaZycnyja.add("н");
        zmiakcajemyjaZycnyja.add("м");
        zmiakcajemyjaZycnyja.add("л");
        zmiakcajemyjaZycnyja.add("з");
        zmiakcajemyjaZycnyja.add("дз");
    }

    public static ZmiakcajucyZycny getInstance() {
        if (single_instance == null)
            single_instance = new ZmiakcajucyZycny();

        return single_instance;
    }

    public static ArrayList<String> getZmiakcajucyZycny() {
        return getInstance().zmiakcajemyjaZycnyja;
    }
}
