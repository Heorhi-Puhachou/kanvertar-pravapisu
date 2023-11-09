package by.kanvertar.pravapisu.converter.k.constant.replace;

import by.kanvertar.pravapisu.util.ParaZamieny;

import java.util.ArrayList;

public class StartReplace {
    private static StartReplace single_instance = null;


    private ArrayList<ParaZamieny> startReplace;


    private StartReplace() {
        this.startReplace = new ArrayList<>();
        startReplace.add(new ParaZamieny("бельгі", "бэльгі"));
        startReplace.add(new ParaZamieny("ірланд", "ірлянд"));
        startReplace.add(new ParaZamieny("люксембург", "люксэмбург"));
        startReplace.add(new ParaZamieny("нідэрланд", "нідэрлянд"));
        startReplace.add(new ParaZamieny("швейцар", "швайцар"));
        startReplace.add(new ParaZamieny("швецы", "швэцы"));
        startReplace.add(new ParaZamieny("амерык", "амэрык"));

        startReplace.add(new ParaZamieny("аперац", "апэрац"));
        startReplace.add(new ParaZamieny("інструмент", "інструмэнт"));
        startReplace.add(new ParaZamieny("сервер", "сэрвэр"));
        startReplace.add(new ParaZamieny("сітуац", "сытуац"));
        startReplace.add(new ParaZamieny("спец", "спэц"));
        startReplace.add(new ParaZamieny("псіх", "псых"));
        startReplace.add(new ParaZamieny("імпер", "імпэр"));
        startReplace.add(new ParaZamieny("шаблон", "шаблён"));
        startReplace.add(new ParaZamieny("лакал", "лякал"));
        startReplace.add(new ParaZamieny("лабарат", "лябарат"));
        startReplace.add(new ParaZamieny("канвенц", "канвэнц"));
        startReplace.add(new ParaZamieny("эфект", "эфэкт"));
        startReplace.add(new ParaZamieny("механі", "мэхані"));
    }

    public static StartReplace getInstance() {
        if (single_instance == null)
            single_instance = new StartReplace();

        return single_instance;
    }

    public static ArrayList<ParaZamieny> getStartReplaces() {
        return getInstance().startReplace;
    }
}
