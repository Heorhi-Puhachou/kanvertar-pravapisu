package by.kanvertar.pravapisu;

import by.kanvertar.pravapisu.converter.BazavyKanvertar;
import by.kanvertar.pravapisu.converter.k.KAKTKanvertar;
import by.kanvertar.pravapisu.converter.l.ALKanvertar;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Zapusk {

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            System.out.println("Niapravilnaja kolkaść arhumentaŭ. Ich pavinna być 4:");
            System.out.println("- pravapis u fajle, jaki budzie kanvertavacca (ŁT, ŁA, KT, KA)");
            System.out.println("  ŁT - Łacinka Tradycyjnaja");
            System.out.println("  LA - Łacinka Aficyjnaja");
            System.out.println("  KK - Kirylica Klasyčnaja");
            System.out.println("  KA - Kirylica Aficyjnaja");
            System.out.println("- šlach da txt-fajła, jaki budzie kanvertavacca");
            System.out.println("- pravapis novaha fajła (ŁT, ŁA, KT, KA)");
            System.out.println("- šlach da  novaha fajła");
            System.out.println("\nprykład:");
            System.out.println("java -jar converter.jar KA 1 ŁT 2\n");
        } else {
            String inputStyle = args[0];
            String inputPath = args[1];
            String outputStyle = args[2];
            String outputPath = args[3];
            checkAndConvert(inputStyle, inputPath, outputStyle, outputPath);
        }
    }

    static void checkAndConvert(
            String inputStyle,
            String inputPath,
            String outputStyle,
            String outputPath) throws IOException {
        if (!validStyle(inputStyle)) {
            System.out.println("Niapravilny styl uvachodnaha fajła.");
        } else if (!validStyle(outputStyle)) {
            System.out.println("Niapravilny styl vychodnaha fajła.");
        } else {
            BazavyKanvertar converter = getConverterByStyles(inputStyle, outputStyle);
            convertToFile(inputPath, outputPath, converter);
        }
    }

    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    static void writeToFile(String output, String path) throws IOException {
        FileWriter myWriter = new FileWriter(path);
        myWriter.write(output);
        myWriter.close();
    }

    static void convertToFile(String inputPath, String outputPath, BazavyKanvertar converter) throws IOException {
        String input = readFile(inputPath, StandardCharsets.UTF_8);
        System.out.println(input);
        String output = converter.kanvertavać(input);
        System.out.println(output);
        writeToFile(output, outputPath);
    }

    static boolean validStyle(String style) {
        return style.equalsIgnoreCase("ŁT")
                || style.equalsIgnoreCase("ŁA")
                || style.equalsIgnoreCase("KT")
                || style.equalsIgnoreCase("KA");
    }

    static BazavyKanvertar getConverterByStyles(String inputStyle, String outputStyle) {
        if (inputStyle.equalsIgnoreCase("KA") && outputStyle.equalsIgnoreCase("KT")) {
            return new KAKTKanvertar();
        } else if (inputStyle.equalsIgnoreCase("KA") && outputStyle.equalsIgnoreCase("ŁT")) {
            return new ALKanvertar();
        } else {
            return new BazavyKanvertar();
        }
    }
}
