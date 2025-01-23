public class Produkty {
    private String nazwa;
    private double cena;
    private String opis;

    public Produkty(String nazwa, double cena, String opis) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.opis = opis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public String getOpis() {
        return opis;
    }

    public double obliczCene(int liczbaSztuk) {
        return cena * liczbaSztuk;
    }
}