package by.kanvertar.pravapisu.converter;


import by.kanvertar.pravapisu.converter.constant.DvajnyMiakki;
import by.kanvertar.pravapisu.converter.constant.ZmiakcajemyZycny;
import by.kanvertar.pravapisu.converter.constant.Zmiakchatel;
import by.kanvertar.pravapisu.converter.constant.replace.EndReplace;
import by.kanvertar.pravapisu.converter.constant.replace.StartReplace;
import by.kanvertar.pravapisu.converter.constant.replace.ŠablonnajaZamiena;
import by.kanvertar.pravapisu.util.ParaZamieny;
import by.kanvertar.pravapisu.util.StringUtilCheck;
import by.kanvertar.pravapisu.util.StringUtilGet;
import by.kanvertar.pravapisu.util.WordCase;
import by.kanvertar.pravapisu.converter.constant.MiakkajaPara;
import by.kanvertar.pravapisu.parser.PraanalizavanyElement;
import by.kanvertar.pravapisu.parser.Analizatar;

import java.util.ArrayList;

import static by.kanvertar.pravapisu.util.StringUtilCheck.isHalosny;
import static by.kanvertar.pravapisu.util.StringUtilTransform.transformCase;


public class KKKAKanvertar extends BazavyKanvertar {

    private Analizatar analizatar;

    public KKKAKanvertar() {
        this.analizatar = new Analizatar();
    }

    public String kanvertavać(String tekst) {

        if (tekst == null || tekst.isEmpty()) {
            return tekst;
        }

        ArrayList<PraanalizavanyElement> elements = analizatar.parse(tekst);

        StringBuilder result = new StringBuilder();

        for (int index = 0; index < elements.size(); index++) {
            PraanalizavanyElement current = elements.get(index);
            if (StringUtilCheck.isEngWord(current.getOriginalWord()) || current.getWordCase() == WordCase.OTHER) {
                result.append(current.getDelimiter()).append(current.getOriginalWord());
            } else {
                PraanalizavanyElement prev = getPrevElement(elements, index);
                PraanalizavanyElement next = getNextElement(elements, index);
                result.append(elements.get(index).getDelimiter()).append(convertElement(prev, current, next));
            }
        }
        return result.toString();
    }

    private PraanalizavanyElement getPrevElement(ArrayList<PraanalizavanyElement> elements, int index) {
        if (index > 0) {
            return elements.get(index - 1);
        } else {
            return null;
        }
    }

    private PraanalizavanyElement getNextElement(ArrayList<PraanalizavanyElement> elements, int index) {
        if (index < elements.size() - 1) {
            return elements.get(index + 1);
        } else {
            return null;
        }
    }

    private String convertElement(PraanalizavanyElement prev, PraanalizavanyElement current, PraanalizavanyElement next) {
        String convertedValue = checkI(prev, current.getWord(), current.getDelimiter());
        convertedValue = chekDZ(convertedValue);
        convertedValue = checkApost(convertedValue);
        convertedValue = checkZ(convertedValue, next);
        convertedValue = checkNe(convertedValue, next);
        convertedValue = checkBez(convertedValue, next);
        convertedValue = dummyReplace(convertedValue);
        convertedValue = replaceStart(convertedValue);
        convertedValue = replaceEnd(convertedValue);
        convertedValue = chekMZ(convertedValue);
        convertedValue = chekMZForDoubles(convertedValue);
        convertedValue = transformCase(current.getWordCase(), convertedValue);
        if (!transformCase(current.getWordCase(), current.getWord()).equals(convertedValue)) {
            System.out.println(transformCase(current.getWordCase(), current.getWord()) + " -> " + convertedValue);
        }
        return convertedValue;
    }

    // й -> і
    private String checkI(PraanalizavanyElement prev, String current, String delimiter) {
        if (prev != null && current.equals("й") && delimiter.equals(" ")) {
            String lastPrevSymbol = StringUtilGet.getLastSymbol(prev.getWord());
            if (StringUtilCheck.isHalosny(lastPrevSymbol)) {
                return "і";
            }
        }
        return current;
    }

    //  зьезд -> з'езд
    private String checkApost(String current) {
        if (current.length() > current.indexOf("зь") + 2
                && current.contains("зь")
                && Zmiakchatel.getZmiakcaceli().contains(current.substring(current.indexOf("зь") + 2, current.indexOf("зь") + 3))) {
            return current.replace("зь", "з'");
        }
        return current;
    }

    // зь -> з
    // празь -> праз
    private String checkZ(String current, PraanalizavanyElement next) {
        if (current.equals("зь")) {
            return "з";
        }
        if (current.equals("празь")) {
            return "праз";
        }
        return current;
    }

    // ня -> не
    private String checkNe(String current, PraanalizavanyElement next) {
        if (current.equals("ня")) {
            return "не";
        }

        return current;
    }

    // без -> бяз
    private String checkBez(String current, PraanalizavanyElement next) {
        if (current.equals("бяз")) {
            return "без";
        }
        return current;
    }


    private String chekMZ(String in) {
        for (int i = 0; i < ZmiakcajemyZycny.getZmiakcajemyjaZycnyja().size(); i++) {
            for (int j = 0; j < MiakkajaPara.getMiakkijaPary().size(); j++) {
                String aRadok = ZmiakcajemyZycny.getZmiakcajemyjaZycnyja().get(i) + MiakkajaPara.getMiakkijaPary().get(j);
                String kRadok = ZmiakcajemyZycny.getZmiakcajemyjaZycnyja().get(i) + "ь" + MiakkajaPara.getMiakkijaPary().get(j);
                in = in.replace(kRadok, aRadok);
            }
        }
        return in;
    }

    private String chekMZForDoubles(String in) {
        for (int i = 0; i < DvajnyMiakki.getDoubleMiakki().size(); i++) {
            for (int j = 0; j < Zmiakchatel.getZmiakcaceli().size(); j++) {
                String aRadok = DvajnyMiakki.getDoubleMiakki().get(i) + DvajnyMiakki.getDoubleMiakki().get(i) + Zmiakchatel.getZmiakcaceli().get(j);
                String kRadok = DvajnyMiakki.getDoubleMiakki().get(i) + "ь" + DvajnyMiakki.getDoubleMiakki().get(i) + Zmiakchatel.getZmiakcaceli().get(j);
                in = in.replace(kRadok, aRadok);
            }
        }
        return in;
    }

    //дзьдз -> ддз
    private String chekDZ(String in) {
        return in.replace("дзьдз", "ддз");
    }

    private String dummyReplace(String in) {
        for (ParaZamieny pair : ŠablonnajaZamiena.getDummyReplaces()) {
            in = in.replace(pair.getRadokKlasyčnahaPravapisu(), pair.getRadokAficyjnahaPravapisu());
        }
        return in;
    }

    private String replaceEnd(String word) {
        for (ParaZamieny pair : EndReplace.getEndReplaces()) {
            if (word.endsWith(pair.getRadokKlasyčnahaPravapisu())) {
                return word.replace(pair.getRadokKlasyčnahaPravapisu(), pair.getRadokAficyjnahaPravapisu());
            }
        }
        return word;
    }

    private String replaceStart(String word) {
        for (ParaZamieny pair : StartReplace.getStartReplaces()) {
            if (word.startsWith(pair.getRadokKlasyčnahaPravapisu())) {
                return word.replace(pair.getRadokKlasyčnahaPravapisu(), pair.getRadokAficyjnahaPravapisu());
            }
        }
        return word;
    }
}
