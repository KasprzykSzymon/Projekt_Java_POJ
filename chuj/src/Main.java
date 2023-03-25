import java.util.ArrayList;
import java.util.Scanner;

public class Wypozyczalnia {
    private ArrayList<Samochod> samochody;
    private Scanner scanner;

    public Wypozyczalnia() {
        samochody = new ArrayList(Samochod);
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


    //funkcja, która umożliwia dodawanie samochodu przez uzytkownika
private void dodajSamochod() {
    System.out.print("\nPodaj marke samochodu: ");
    String marka = scanner.nextLine();
    System.out.print("Podaj model samochodu: ");
    String model = scanner.nextLine();
    System.out.println("Podaj cene za dzien wynajmu: ");
    double cena = scanner.nextDouble();
    scanner.nextLine();

    Samochod samochod = new Samochod(marka, model, cena);
    samochody.add(samochod);
    System.out.println("Dodano samochod!");
}

    //funkcja, która umożliwia sprawdzenie listy dostępnych samochodów (o ile użytkownik takowe dodał)
private void wyswietlSamochody() {
    if (samochody.isEmpty()) {
        System.out.println("Brak samochodow!");
    }

    System.out.println("\nLista samochodow: ");
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
}
    public void ocenSamochod() {
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

    private void obliczKosztWynajmu() {
        int cena = scanner.nextInt();
        scanner.nextLine();
        int dni = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Koszt najmu auta wynosi: " + cena * dni );
    }
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
    this.oceny = ArrayList<Integer>();
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
//uzywalem idea 2 lata temu i nie wiedzialem co to git xsd
public double getCena() {
    return cena;
}

public boolean czyDostepny() {
    return czyDostepny;
}

public void zarezerwuj() {
    czyDostepny = false;
}

public double obliczKosztWynajmu (int dni) {
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

