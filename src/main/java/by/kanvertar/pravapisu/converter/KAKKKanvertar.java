package by.kanvertar.pravapisu.converter;


import by.kanvertar.pravapisu.converter.constant.DvajnyMiakki;
import by.kanvertar.pravapisu.converter.constant.MiakkajaPara;
import by.kanvertar.pravapisu.converter.constant.ZmiakcajemyZycny;
import by.kanvertar.pravapisu.converter.constant.Zmiakchatel;
import by.kanvertar.pravapisu.converter.constant.replace.EndReplace;
import by.kanvertar.pravapisu.converter.constant.replace.StartReplace;
import by.kanvertar.pravapisu.converter.constant.replace.ŠablonnajaZamiena;
import by.kanvertar.pravapisu.util.ParaZamieny;
import by.kanvertar.pravapisu.util.StringUtilCheck;
import by.kanvertar.pravapisu.util.StringUtilGet;
import by.kanvertar.pravapisu.util.WordCase;
import by.kanvertar.pravapisu.parser.PraanalizavanyElement;
import by.kanvertar.pravapisu.parser.Analizatar;

import java.util.ArrayList;

import static by.kanvertar.pravapisu.util.StringUtilTransform.transformCase;


public class KAKKKanvertar extends BazavyKanvertar {

    private Analizatar parser;

    public KAKKKanvertar() {
        this.parser = new Analizatar();
    }

    public String kanvertavać(String tekst) {

        if (tekst == null || tekst.isEmpty()) {
            return tekst;
        }

        ArrayList<PraanalizavanyElement> elements = parser.parse(tekst);

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
        convertedValue = checkZ(convertedValue, next);
        convertedValue = checkApost(convertedValue);
        convertedValue = checkNe(convertedValue, next);
        convertedValue = checkBez(convertedValue, next);
        convertedValue = śablonnajaZamiena(convertedValue);
        convertedValue = replaceStart(convertedValue);
        convertedValue = replaceEnd(convertedValue);
        convertedValue = chekMZ(convertedValue);
        convertedValue = chekMZForDoubles(convertedValue);
        convertedValue = pravieryćDZ(convertedValue);
        convertedValue = transformCase(current.getWordCase(), convertedValue);
        if (!transformCase(current.getWordCase(), current.getWord()).equals(convertedValue)) {
            System.out.println(transformCase(current.getWordCase(), current.getWord()) + " -> " + convertedValue);
        }
        return convertedValue;
    }

    // і -> й
    private String checkI(PraanalizavanyElement prev, String current, String delimiter) {
        if (prev != null && current.equals("і") && delimiter.equals(" ")) {
            String lastPrevSymbol = StringUtilGet.getLastSymbol(prev.getWord());
            if (StringUtilCheck.isHalosny(lastPrevSymbol)) {
                return "й";
            }
        }
        return current;
    }

    // з'езд -> зьезд
    private String checkApost(String current) {
        if (current.contains("з'")) {
            return current.replace("з'","зь");
        }
        return current;
    }

    // з -> зь
    // праз -> празь
    private String checkZ(String current, PraanalizavanyElement next) {
        if (next != null
                && next.getDelimiter().equals(" ")
                && current.equals("з")) {
            for (int i = 0; i < MiakkajaPara.getMiakkijaPary().size(); i++) {
                if (next.getWord().startsWith(MiakkajaPara.getMiakkijaPary().get(i))) {
                    return "зь";
                }
            }
            for (int i = 0; i < Zmiakchatel.getZmiakcaceli().size(); i++) {
                if (next.getWord().startsWith(Zmiakchatel.getZmiakcaceli().get(i))) {
                    return "зь";
                }
            }
        }

        if (next != null
                && next.getDelimiter().equals(" ")
                && current.equals("праз")) {
            for (int i = 0; i < MiakkajaPara.getMiakkijaPary().size(); i++) {
                if (next.getWord().startsWith(MiakkajaPara.getMiakkijaPary().get(i))) {
                    return "празь";
                }
            }
            for (int i = 0; i < Zmiakchatel.getZmiakcaceli().size(); i++) {
                if (next.getWord().startsWith(Zmiakchatel.getZmiakcaceli().get(i))) {
                    return "празь";
                }
            }
        }

        return current;
    }

    // не -> ня
    private String checkNe(String current, PraanalizavanyElement next) {
        if (current.equals("не")
                && next != null
                && next.getDelimiter().equals(" ")
                && StringUtilCheck.pershySkladPadNaciskam(next.getWord())) {
            return "ня";
        }

        return current;
    }

    // без -> бяз
    private String checkBez(String current, PraanalizavanyElement next) {
        if (current.equals("без")
                && next != null
                && next.getDelimiter().equals(" ")
                && StringUtilCheck.pershySkladPadNaciskam(next.getWord())) {
            return "бяз";
        }
        return current;
    }


    private String chekMZ(String in) {
        for (int i = 0; i < ZmiakcajemyZycny.getZmiakcajemyjaZycnyja().size(); i++) {
            for (int j = 0; j < MiakkajaPara.getMiakkijaPary().size(); j++) {
                String officialVersionString = ZmiakcajemyZycny.getZmiakcajemyjaZycnyja().get(i) + MiakkajaPara.getMiakkijaPary().get(j);
                String tarask = ZmiakcajemyZycny.getZmiakcajemyjaZycnyja().get(i) + "ь" + MiakkajaPara.getMiakkijaPary().get(j);
                in = in.replace(officialVersionString, tarask);
            }
        }
        return in;
    }

    private String chekMZForDoubles(String in) {
        for (int i = 0; i < DvajnyMiakki.getDoubleMiakki().size(); i++) {
            for (int j = 0; j < Zmiakchatel.getZmiakcaceli().size(); j++) {
                String officialVersionString = DvajnyMiakki.getDoubleMiakki().get(i) + DvajnyMiakki.getDoubleMiakki().get(i) + Zmiakchatel.getZmiakcaceli().get(j);
                String tarask = DvajnyMiakki.getDoubleMiakki().get(i) + "ь" + DvajnyMiakki.getDoubleMiakki().get(i) + Zmiakchatel.getZmiakcaceli().get(j);
                in = in.replace(officialVersionString, tarask);
            }
        }
        return in;
    }

    private String pravieryćDZ(String in) {
        for (int j = 0; j < Zmiakchatel.getZmiakcaceli().size(); j++) {
            String radokAficyjnhahaPravapisu = "ддз" + Zmiakchatel.getZmiakcaceli().get(j);
            String tarask = "дзьдз" + Zmiakchatel.getZmiakcaceli().get(j);
            in = in.replace(radokAficyjnhahaPravapisu, tarask);
        }
        return in;
    }

    private String śablonnajaZamiena(String in) {
        for (ParaZamieny pair : ŠablonnajaZamiena.getDummyReplaces()) {
            in = in.replace(pair.getRadokAficyjnahaPravapisu(), pair.getRadokKlasyčnahaPravapisu());
        }
        return in;
    }

    private String replaceEnd(String word) {
        for (ParaZamieny pair : EndReplace.getEndReplaces()) {
            if (word.endsWith(pair.getRadokAficyjnahaPravapisu())) {
                return word.replace(pair.getRadokAficyjnahaPravapisu(), pair.getRadokKlasyčnahaPravapisu());
            }
        }
        return word;
    }

    private String replaceStart(String word) {
        for (ParaZamieny pair : StartReplace.getStartReplaces()) {
            if (word.startsWith(pair.getRadokAficyjnahaPravapisu())) {
                return word.replace(pair.getRadokAficyjnahaPravapisu(), pair.getRadokKlasyčnahaPravapisu());
            }
        }
        return word;
    }
}
