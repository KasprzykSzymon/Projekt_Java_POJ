import java.util.ArrayList;
import java.util.Scanner;

public class Wypozyczalnia {
    private ArrayList<Samochod> samochody;
    private Scanner scanner;

    public Wypozyczalnia() {
        samochody = new ArrayList<Samochod>();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        int wybor;
        do {
            System.out.println("\n===============================");
            System.out.println("1. Dodaj samochod");
            System.out.println("2. Wyswietl samochody");
            System.out.println("3. Rezerwuj samochod");
            System.out.println("4. Oblicz koszt wynajmu samochodu");
            System.out.println("5. Oceń samochod");
            System.out.println("6. Wyjdz");
            System.out.print("\nWybierz opcje: ");
            wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    dodajSamochod();
                    break;
                case 2:
                    wyswietlSamochody();
                    break;
                case 3:
                    rezerwujSamochod();
                    break;
                case 4:
                    obliczKosztWynajmu();
                    break;
                case 5:
                    ocenSamochod();
                    break;
                case 6:
                    System.out.println("Koniec programu!");
                    break;
                default:
                    System.out.println("Nieznana opcja!");
            }
        } while (wybor != 6);
    }


    private void dodajSamochod() {
        System.out.print("\nPodaj marke samochodu: ");
        String marka = scanner.nextLine();
        System.out.print("Podaj model samochodu: ");
        String model = scanner.nextLine();
        System.out.print("Podaj cene za dzien wynajmu: ");
        double cena = scanner.nextDouble();
        scanner.nextLine();

        Samochod samochod = new Samochod(marka, model, cena);
        samochody.add(samochod);
        System.out.println("Dodano samochod!");
    }

    private void wyswietlSamochody() {
        if (samochody.isEmpty()) {
            System.out.println("Brak samochodow!");
            return;
        }

        System.out.println("\nLista samochodow:");
        for (Samochod samochod : samochody) {
            System.out.println(samochod);
        }
    }

    private void rezerwujSamochod() {
        System.out.print("\nPodaj ID samochodu do rezerwacji: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Samochod samochod = znajdzSamochod(id);
        if (samochod == null) {
            System.out.println("Nie znaleziono samochodu o podanym ID!");
            return;
        }

        // Zadanie do zaimplementowania: dodaj funkcjonalność rezerwacji samochodu na określony czas
    }

    private void obliczKosztWynajmu() {
        System.out.print("\nPodaj ID samochodu: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Samochod samochod = znajdzSamochod(id);
        if (samochod == null) {
            System.out.println("Nie znaleziono samochodu o podanym ID!");
            return;
        }
        System.out.print("Podaj liczbe dni wynajmu: ");
        int dni = scanner.nextInt();

        double koszt = samochod.obliczKosztWynajmu(dni);
        System.out.println("\nKoszt wynajmu samochodu " + samochod.getMarka() + " " + samochod.getModel() + " wynosi: " + koszt + " zł");
    }

    private void ocenSamochod() {
        System.out.print("\nPodaj ID samochodu: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Samochod samochod = znajdzSamochod(id);
        if (samochod == null) {
            System.out.println("Nie znaleziono samochodu o podanym ID!");
            return;
        }

        System.out.print("Podaj ocene samochodu (od 1 do 5): ");
        int ocena = scanner.nextInt();
        scanner.nextLine();

        samochod.dodajOcene(ocena);
        System.out.println("Dodano ocene dla samochodu!");
    }

    private Samochod znajdzSamochod(int id) {
        for (Samochod samochod : samochody) {
            if (samochod.getId() == id) {
                return samochod;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();
        wypozyczalnia.menu();
    }

    class Samochod {
        private static int nextId = 1;
        private int id;
        private String marka;
        private String model;
        private double cena;
        private ArrayList<Integer> oceny;
        private boolean czyDostepny;

        public Samochod(String marka, String model, double cena) {
            this.id = nextId++;
            this.marka = marka;
            this.model = model;
            this.cena = cena;
            this.oceny = new ArrayList<Integer>();
            this.czyDostepny = true;
        }

        public int getId() {
            return id;
        }

        public String getMarka() {
            return marka;
        }

        public String getModel() {
            return model;
        }

        public double getCena() {
            return cena;
        }

        public boolean czyDostepny() {
            return czyDostepny;
        }

        public void zarezerwuj() {
            czyDostepny = false;
        }

        public double obliczKosztWynajmu(int dni) {
            return cena * dni;
        }

        public void dodajOcene(int ocena) {
            oceny.add(ocena);
        }

        public double sredniaOcen() {
            if (oceny.isEmpty()) {
                return 0;
            }

            double suma = 0;
            for (int ocena : oceny) {
                suma += ocena;
            }

            return suma / oceny.size();
        }
    }
}


