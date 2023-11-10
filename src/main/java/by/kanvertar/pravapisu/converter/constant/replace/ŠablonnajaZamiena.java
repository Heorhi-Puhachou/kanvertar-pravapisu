package by.kanvertar.pravapisu.converter.constant.replace;

import by.kanvertar.pravapisu.util.ParaZamieny;

import java.util.ArrayList;

public class ŠablonnajaZamiena {
    private static ŠablonnajaZamiena single_instance = null;


    private ArrayList<ParaZamieny> dummyReplace;


    private ŠablonnajaZamiena() {
        this.dummyReplace = new ArrayList<>();
        dummyReplace.add(new ParaZamieny("амерык", "амэрык"));
        dummyReplace.add(new ParaZamieny("анверт", "анвэрт"));
        dummyReplace.add(new ParaZamieny("аргумент", "аргумэнт"));
        dummyReplace.add(new ParaZamieny("артапед", "артапэд"));
        dummyReplace.add(new ParaZamieny("аспект", "аспэкт"));
        dummyReplace.add(new ParaZamieny("арфаграф", "артаграф"));
        dummyReplace.add(new ParaZamieny("арыстоцель", "арыстотэль"));
        dummyReplace.add(new ParaZamieny("валанцёр", "валянтэр"));
        dummyReplace.add(new ParaZamieny("версі", "вэрсі"));
        dummyReplace.add(new ParaZamieny("вулкан", "вулькан"));
        dummyReplace.add(new ParaZamieny("в’етнам", "віетнам"));
        dummyReplace.add(new ParaZamieny("гаус", "гаўс"));
        dummyReplace.add(new ParaZamieny("Генры", "Гэнры"));
        dummyReplace.add(new ParaZamieny("глам", "глям"));
        dummyReplace.add(new ParaZamieny("гласар", "глясар"));
        dummyReplace.add(new ParaZamieny("візіт", "візыт"));
        dummyReplace.add(new ParaZamieny("дакумент", "дакумэнт"));
        dummyReplace.add(new ParaZamieny("донья", "доньня"));
        dummyReplace.add(new ParaZamieny("еўр", "эўр"));
        dummyReplace.add(new ParaZamieny("іерогліф", "герогліф"));
        dummyReplace.add(new ParaZamieny("каментарый", "камэнтар"));
        dummyReplace.add(new ParaZamieny("каталог", "каталёг"));
        dummyReplace.add(new ParaZamieny("класіч", "клясыч"));
        dummyReplace.add(new ParaZamieny("клуб", "клюб"));
        dummyReplace.add(new ParaZamieny("лагіч", "лягіч"));
        dummyReplace.add(new ParaZamieny("лампада", "лямпада"));
        dummyReplace.add(new ParaZamieny("лейкацыт", "леўкацыт"));
        dummyReplace.add(new ParaZamieny("логік", "лёгік"));
        dummyReplace.add(new ParaZamieny("логія", "лёгія"));
        dummyReplace.add(new ParaZamieny("мекка", "мэка"));
        dummyReplace.add(new ParaZamieny("метад", "мэтад"));
        dummyReplace.add(new ParaZamieny("механ", "мэхан"));
        dummyReplace.add(new ParaZamieny("мільянер", "мільянэр"));
        dummyReplace.add(new ParaZamieny("менеджэр", "мэнэджар"));
        dummyReplace.add(new ParaZamieny("музей", "музэй"));
        dummyReplace.add(new ParaZamieny("мушкіцёр", "мушкітэр"));
        dummyReplace.add(new ParaZamieny("пазіцы", "пазыцы"));
        dummyReplace.add(new ParaZamieny("партнёр", "партнэр"));
        dummyReplace.add(new ParaZamieny("плутон", "плютон"));
        dummyReplace.add(new ParaZamieny("прэзент", "прэзэнт"));
        dummyReplace.add(new ParaZamieny("рыдыус", "радыюс"));
        dummyReplace.add(new ParaZamieny("рэклам", "рэклям"));
        dummyReplace.add(new ParaZamieny("саліцёр", "слітэр"));
        dummyReplace.add(new ParaZamieny("сегм", "сэгм"));
        dummyReplace.add(new ParaZamieny("сесія", "сэсія"));
        dummyReplace.add(new ParaZamieny("сесію", "сэсію"));
        dummyReplace.add(new ParaZamieny("сігнал", "сыгнал"));
        dummyReplace.add(new ParaZamieny("сістэм", "сыстэм"));
        dummyReplace.add(new ParaZamieny("фунікулёр", "фунікулер"));
        dummyReplace.add(new ParaZamieny("фальклор", "фальклёр"));
        dummyReplace.add(new ParaZamieny("шоу", "шоў"));
        dummyReplace.add(new ParaZamieny("элемент", "элемэнт"));
        dummyReplace.add(new ParaZamieny("эфект", "эфэкт"));
    }

    public static ŠablonnajaZamiena getInstance() {
        if (single_instance == null)
            single_instance = new ŠablonnajaZamiena();

        return single_instance;
    }

    public static ArrayList<ParaZamieny> getDummyReplaces() {
        return getInstance().dummyReplace;
    }
}
