package by.kanvertar.pravapisu.util;

public class ParaZamieny {
    private String radokAficyjnahaPravapisu;
    private String radokKlasyčnahaPravapisu;

    public ParaZamieny(String radokAficyjnahaPravapisu, String radokKlasyčnahaPravapisu) {
        this.radokAficyjnahaPravapisu = radokAficyjnahaPravapisu;
        this.radokKlasyčnahaPravapisu = radokKlasyčnahaPravapisu;
    }

    public String getRadokAficyjnahaPravapisu() {
        return radokAficyjnahaPravapisu;
    }

    public String getRadokKlasyčnahaPravapisu() {
        return radokKlasyčnahaPravapisu;
    }
}
