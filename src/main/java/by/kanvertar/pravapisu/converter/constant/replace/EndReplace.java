package by.kanvertar.pravapisu.converter.constant.replace;

import by.kanvertar.pravapisu.util.ParaZamieny;

import java.util.ArrayList;

public class EndReplace {
    private static EndReplace single_instance = null;


    private ArrayList<ParaZamieny> endReplace;


    private EndReplace() {
        this.endReplace = new ArrayList<>();
        endReplace.add(new ParaZamieny("метр", "метар"));
        endReplace.add(new ParaZamieny("літр", "літар"));

        //элемент -> элемэнт
        //дакумент -> дакумэнт
        endReplace.add(new ParaZamieny("мент", "мэнт"));

        //калегіум - калегіюм
        endReplace.add(new ParaZamieny("іум", "іюм"));

        //кампендыум - кампендыюм
        endReplace.add(new ParaZamieny("ыум", "ыюм"));

        //эскадрылья - эскадрыльля
        endReplace.add(new ParaZamieny("лья", "льля"));

        //смяешся - сьмяесься
        endReplace.add(new ParaZamieny("шся", "сься"));
    }

    public static EndReplace getInstance() {
        if (single_instance == null)
            single_instance = new EndReplace();

        return single_instance;
    }

    public static ArrayList<ParaZamieny> getEndReplaces() {
        return getInstance().endReplace;
    }
}
