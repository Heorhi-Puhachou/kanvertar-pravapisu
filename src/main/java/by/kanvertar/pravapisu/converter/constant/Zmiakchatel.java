package by.kanvertar.pravapisu.converter.constant;

import java.util.ArrayList;

public class Zmiakchatel {
    private static Zmiakchatel single_instance = null;


    private ArrayList<String> zmiakcacieli;


    private Zmiakchatel() {
        zmiakcacieli = new ArrayList<>();
        zmiakcacieli.add("ь");
        zmiakcacieli.add("я");
        zmiakcacieli.add("е");
        zmiakcacieli.add("ю");
        zmiakcacieli.add("ё");
        zmiakcacieli.add("і");
    }

    public static Zmiakchatel getInstance() {
        if (single_instance == null)
            single_instance = new Zmiakchatel();

        return single_instance;
    }

    public static ArrayList<String> getZmiakcaceli() {
        return getInstance().zmiakcacieli;
    }
}
