import java.util.ArrayList;
import java.util.List;

public class Koszyk {
    private List<Produkty> produkty;
    private List<Integer> ilosc;

    public Koszyk() {
        this.produkty = new ArrayList<>();
        this.ilosc = new ArrayList<>();
    }

    public List<Produkty> getProdukty() {
        return produkty;
    }

    public List<Integer> getIlosc() {
        return ilosc;
    }

    public void pokazKoszyk() {
        if (produkty.isEmpty()) {
            System.out.println("Koszyk jest pusty.");
            return;
        }

        System.out.println("Twój koszyk:");
        for (int i = 0; i < produkty.size(); i++) {
            Produkty produkt = produkty.get(i);
            int ilosc = this.ilosc.get(i);
            System.out.printf("%d. %s - (%dx): %.2f zł%n", i + 1, produkt.getNazwa(), ilosc, produkt.obliczCene(ilosc));
        }
    }

    public void usunProdukt(int index) {
        if (index >= 0 && index < produkty.size()) {
            produkty.remove(index);
            ilosc.remove(index);
        }
    }
}
