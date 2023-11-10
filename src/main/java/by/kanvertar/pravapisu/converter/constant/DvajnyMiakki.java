package by.kanvertar.pravapisu.converter.constant;

import java.util.ArrayList;

public class DvajnyMiakki {
    private static DvajnyMiakki single_instance = null;

    private final ArrayList<String> dvajnyMiakki;

    private DvajnyMiakki() {
        dvajnyMiakki = new ArrayList<>();
        dvajnyMiakki.add("с");
        dvajnyMiakki.add("ц");
        dvajnyMiakki.add("н");
        dvajnyMiakki.add("з");
        dvajnyMiakki.add("л");
    }

    public static DvajnyMiakki getInstance() {
        if (single_instance == null)
            single_instance = new DvajnyMiakki();
        return single_instance;
    }

    public static ArrayList<String> getDoubleMiakki() {
        return getInstance().dvajnyMiakki;
    }
}
