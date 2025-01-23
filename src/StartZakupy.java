import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StartZakupy {
    private static double sumaKoszyka = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> paragon = new ArrayList<>();
        Koszyk koszyk = new Koszyk();

        List<Mieso> mieso = Arrays.asList(
                new Mieso("Pasztet", 2.58, "Pasztet drobiowo-wieprzowy 131 g."),
                new Mieso("Szynka", 11.49, "Szynka wędzona 200 g."),
                new Mieso("Parówki", 4.94, "Parówki wieprzowe 250 g.")
        );

        List<Owoce> owoce = Arrays.asList(
                new Owoce("Kiwi", 1.74, "Kiwi świeże 150 g."),
                new Owoce("Arbuz", 13.79, "Arbuz mini 2 kg."),
                new Owoce("Ananas", 9.19, "Ananas średni 1.40 kg.")
        );

        List<Warzywa> warzywa = Arrays.asList(
                new Warzywa("Ogórek", 3.68, "Ogórek długi 200 g."),
                new Warzywa("Rzodkiewka", 2.79, "Rzodkiewka pęczek 180 g."),
                new Warzywa("Sałata", 5.98, "Sałata lodowa 400 g. ")
        );

        List<Napoje> napoje = Arrays.asList(
                new Napoje("Piwo", 3.32, "Piwo w puszce 0,5 L.", true),
                new Napoje("Woda", 0.98, "Woda źródlana niegazowana 1,5 L.", false),
                new Napoje("Sok pomidorowy", 4.78, "Sok pomidorowy pikantny 1 L.", false)
        );

        List<Pieczywo> pieczywo = Arrays.asList(
                new Pieczywo("Bułka", 0.34, "Bułka kajzerka 50 g."),
                new Pieczywo("Chleb", 2.36, "Chleb pszenno-żytni 500 g."),
                new Pieczywo("Bagietka", 4.19, "Bagietka z masłem czosnkowym 165 g.")
        );

        List<Nabial> nabial = Arrays.asList(
                new Nabial("Mleko", 3.28, "Mleko 1.5% 1 L."),
                new Nabial("Ser pleśniowy", 5.64, "Ser pleśniowy blue 100 g."),
                new Nabial("Serek wiejski", 2.58, "Serek wiejski naturalny 200 g.")
        );

        boolean shopping = true;

        while (shopping) {
            System.out.println("\nWybierz kategorię produktów:");
            System.out.println("1. Mięso");
            System.out.println("2. Owoce");
            System.out.println("3. Warzywa");
            System.out.println("4. Napoje");
            System.out.println("5. Pieczywo");
            System.out.println("6. Nabiał");
            System.out.println("7. Zakończ zakupy");
            System.out.println("8. Pokaż koszyk");
            System.out.println("9. Usuń produkt z koszyka");
            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    System.out.println("\nDostępne mięso:");
                    for (int i = 0; i < mieso.size(); i++) {
                        System.out.printf("%d. %s - %.2f zł/szt. (%s)%n", i + 1, mieso.get(i).getNazwa(), mieso.get(i).getCena(), mieso.get(i).getOpis());
                    }
                    System.out.println("Wybierz produkt (numer):");
                    int miesoIndex = scanner.nextInt() - 1;
                    System.out.println("Podaj liczbę sztuk:");
                    int liczbaMieso = scanner.nextInt();
                    double cenaMieso = mieso.get(miesoIndex).obliczCene(liczbaMieso);
                    koszyk.getProdukty().add(mieso.get(miesoIndex));
                    koszyk.getIlosc().add(liczbaMieso);
                    sumaKoszyka += cenaMieso;
                    paragon.add(String.format("%s - (%dx): %.2f zł", mieso.get(miesoIndex).getNazwa(), liczbaMieso, cenaMieso).replace('.', ','));
                    System.out.printf("Cena za (%dx): %.2f zł%n", liczbaMieso, cenaMieso);
                    break;

                case 2:
                    System.out.println("\nDostępne owoce:");
                    for (int i = 0; i < owoce.size(); i++) {
                        System.out.printf("%d. %s - %.2f zł/szt. (%s)%n", i + 1, owoce.get(i).getNazwa(), owoce.get(i).getCena(), owoce.get(i).getOpis());
                    }
                    System.out.println("Wybierz produkt (numer):");
                    int owoceIndex = scanner.nextInt() - 1;
                    System.out.println("Podaj liczbę sztuk:");
                    int liczbaSztuk = scanner.nextInt();
                    double cenaOwoceZaSztuke = owoce.get(owoceIndex).obliczCene(liczbaSztuk);
                    koszyk.getProdukty().add(owoce.get(owoceIndex));
                    koszyk.getIlosc().add(liczbaSztuk);
                    sumaKoszyka += cenaOwoceZaSztuke;
                    paragon.add(String.format("%s - (%dx): %.2f zł", owoce.get(owoceIndex).getNazwa(), liczbaSztuk, cenaOwoceZaSztuke).replace('.', ','));
                    System.out.printf("Cena za (%dx): %.2f zł%n", liczbaSztuk, cenaOwoceZaSztuke);
                    break;

                case 3:
                    System.out.println("\nDostępne warzywa:");
                    for (int i = 0; i < warzywa.size(); i++) {
                        System.out.printf("%d. %s - %.2f zł/szt. (%s)%n", i + 1, warzywa.get(i).getNazwa(), warzywa.get(i).getCena(), warzywa.get(i).getOpis());
                    }
                    System.out.println("Wybierz produkt (numer):");
                    int warzywaIndex = scanner.nextInt() - 1;
                    System.out.println("Podaj liczbę sztuk:");
                    int liczbaWarzywa = scanner.nextInt();  // Liczba sztuk
                    double cenaWarzywa = warzywa.get(warzywaIndex).obliczCene(liczbaWarzywa);
                    koszyk.getProdukty().add(warzywa.get(warzywaIndex));
                    koszyk.getIlosc().add(liczbaWarzywa);
                    sumaKoszyka += cenaWarzywa;
                    paragon.add(String.format("%s - (%dx): %.2f zł", warzywa.get(warzywaIndex).getNazwa(), liczbaWarzywa, cenaWarzywa).replace('.', ','));
                    System.out.printf("Cena za (%dx): %.2f zł%n", liczbaWarzywa, cenaWarzywa);
                    break;

                case 4:
                    System.out.println("\nDostępne napoje:");
                    for (int i = 0; i < napoje.size(); i++) {
                        System.out.printf("%d. %s - %.2f zł (%s)%n", i + 1, napoje.get(i).getNazwa(), napoje.get(i).getCena(), napoje.get(i).getOpis());
                    }
                    System.out.println("Wybierz produkt (numer):");
                    int napojeIndex = scanner.nextInt() - 1;
                    if (napoje.get(napojeIndex).isCzyAlkohol()) {
                        System.out.println("Podaj swój rok urodzenia:");
                        int rokUrodzenia = scanner.nextInt();
                        if (!napoje.get(napojeIndex).sprawdzWiek(rokUrodzenia)) {
                            System.out.println("Nie możesz kupić tego produktu, ponieważ jesteś niepełnoletni.");
                            break;
                        }
                    }
                    System.out.println("Podaj liczbę sztuk:");
                    int liczbaNapoje = scanner.nextInt();
                    double cenaNapoje = napoje.get(napojeIndex).getCena() * liczbaNapoje;
                    koszyk.getProdukty().add(napoje.get(napojeIndex));
                    koszyk.getIlosc().add(liczbaNapoje);
                    sumaKoszyka += cenaNapoje;
                    paragon.add(String.format("%s - (%dx): %.2f zł", napoje.get(napojeIndex).getNazwa(), liczbaNapoje, cenaNapoje).replace('.', ','));
                    System.out.printf("Cena za (%dx): %.2f zł%n", liczbaNapoje, cenaNapoje);
                    break;

                case 5:
                    System.out.println("\nDostępne pieczywo:");
                    for (int i = 0; i < pieczywo.size(); i++) {
                        System.out.printf("%d. %s - %.2f zł (%s)%n", i + 1, pieczywo.get(i).getNazwa(), pieczywo.get(i).getCena(), pieczywo.get(i).getOpis());
                    }
                    System.out.println("Wybierz produkt (numer):");
                    int pieczywoIndex = scanner.nextInt() - 1;
                    System.out.println("Podaj liczbę sztuk:");
                    int liczbaPieczywo = scanner.nextInt();
                    double cenaPieczywo = pieczywo.get(pieczywoIndex).obliczCene(liczbaPieczywo);
                    koszyk.getProdukty().add(pieczywo.get(pieczywoIndex));
                    koszyk.getIlosc().add(liczbaPieczywo);
                    sumaKoszyka += cenaPieczywo;
                    paragon.add(String.format("%s - (%dx): %.2f zł", pieczywo.get(pieczywoIndex).getNazwa(), liczbaPieczywo, cenaPieczywo).replace('.', ','));
                    System.out.printf("Cena za (%dx): %.2f zł%n", liczbaPieczywo, cenaPieczywo);
                    break;


                case 6:
                    System.out.println("\nDostępny nabiał:");
                    for (int i = 0; i < nabial.size(); i++) {
                        System.out.printf("%d. %s - %.2f zł (%s)%n", i + 1, nabial.get(i).getNazwa(), nabial.get(i).getCena(), nabial.get(i).getOpis());
                    }
                    System.out.println("Wybierz produkt (numer):");
                    int nabialIndex = scanner.nextInt() - 1;
                    System.out.println("Podaj liczbę sztuk:");
                    int liczbaNabial = scanner.nextInt();
                    double cenaNabial = nabial.get(nabialIndex).obliczCene(liczbaNabial);
                    koszyk.getProdukty().add(nabial.get(nabialIndex));
                    koszyk.getIlosc().add(liczbaNabial);
                    sumaKoszyka += cenaNabial;
                    paragon.add(String.format("%s - (%dx): %.2f zł", nabial.get(nabialIndex).getNazwa(), liczbaNabial, cenaNabial).replace('.', ','));
                    System.out.printf("Cena za (%dx): %.2f zł%n", liczbaNabial, cenaNabial);
                    break;


                case 7:
                    shopping = false;
                    try (FileWriter writer = new FileWriter("paragon.txt")) {
                        writer.write("Paragon:\n");
                        for (String liniaParagonu : paragon) {
                            writer.write(liniaParagonu + "\n");
                        }
                        writer.write(String.format("\nŁączna kwota: %.2f zł%n", sumaKoszyka).replace('.', ','));
                        System.out.println("Paragon został zapisany do pliku 'paragon.txt'.");
                    } catch (IOException e) {
                        System.out.println("Błąd podczas zapisywania paragonu.");
                    }
                    break;


                case 8:
                    koszyk.pokazKoszyk();
                    break;

                case 9:
                    koszyk.pokazKoszyk();
                    System.out.println("Wybierz numer produktu do usunięcia:");
                    int indexDoUsuniecia = scanner.nextInt() - 1;
                    List<Produkt> produktyKoszyka = koszyk.getProdukty();
                    if (indexDoUsuniecia >= 0 && indexDoUsuniecia < produktyKoszyka.size()) {
                        Produkt usunietyProdukt = produktyKoszyka.get(indexDoUsuniecia);
                        int iloscUsunieta = koszyk.getIlosc().get(indexDoUsuniecia);
                        koszyk.usunProdukt(indexDoUsuniecia);
                        String produktDoUsuniecia = String.format("%s - (%dx):", usunietyProdukt.getNazwa(), iloscUsunieta).replace('.', ',');
                        paragon.removeIf(liniaParagonu -> liniaParagonu.startsWith(produktDoUsuniecia));
                        sumaKoszyka = 0;
                        for (int i = 0; i < koszyk.getProdukty().size(); i++) {
                            sumaKoszyka += koszyk.getProdukty().get(i).getCena() * koszyk.getIlosc().get(i);
                        }
                        System.out.println("Produkt został usunięty z koszyka.");
                    } else {
                        System.out.println("Nieprawidłowy numer produktu.");
                    }
                    break;
            }
        }
    }
}