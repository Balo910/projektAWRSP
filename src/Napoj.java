import java.util.Calendar;

class Napoj extends Produkt {
    private boolean czyAlkohol;
    public Napoj(String nazwa, double cena, String opis, boolean czyAlkohol) {
        super(nazwa, cena, opis);
        this.czyAlkohol = czyAlkohol;
    }

    public boolean sprawdzWiek(int rokUrodzenia) {
        int aktualnyRok = Calendar.getInstance().get(Calendar.YEAR);
        return (aktualnyRok - rokUrodzenia) >= 18;
    }

    public boolean isCzyAlkohol() {
        return czyAlkohol;
    }
}
