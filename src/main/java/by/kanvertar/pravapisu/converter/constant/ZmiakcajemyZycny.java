package by.kanvertar.pravapisu.converter.constant;

import java.util.ArrayList;

public class ZmiakcajemyZycny {
    private static ZmiakcajemyZycny single_instance = null;


    private ArrayList<String> zmiakcajemyjaZycnyja;


    private ZmiakcajemyZycny() {
        zmiakcajemyjaZycnyja = new ArrayList<>();
        zmiakcajemyjaZycnyja.add("с");
        zmiakcajemyjaZycnyja.add("ц");
        zmiakcajemyjaZycnyja.add("н");
        zmiakcajemyjaZycnyja.add("з");
        zmiakcajemyjaZycnyja.add("дз");
    }

    public static ZmiakcajemyZycny getInstance() {
        if (single_instance == null)
            single_instance = new ZmiakcajemyZycny();

        return single_instance;
    }

    public static ArrayList<String> getZmiakcajemyjaZycnyja() {
        return getInstance().zmiakcajemyjaZycnyja;
    }
}
