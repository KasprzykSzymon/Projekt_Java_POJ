import java.util.ArrayList;
import java.util.Scanner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Wypozyczalnia {
    private ArrayList<Samochod> samochody;
    private Scanner scanner;
    private static int nextId = 1;

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
            System.out.println("5. Ocen samochod");
            System.out.println("6. Wyswietl oceny aut");
            System.out.println("7. Wyjdz");
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
                    zobaczOcenyAut();
                    break;
                case 7:
                    System.out.println("Koniec programu!");
                    break;
                default:
                    System.out.println("Nieznana opcja!");
            }
        } while (wybor != 7);
    }


    private void dodajSamochod() {
        System.out.print("\nPodaj marke samochodu: ");
        String marka = scanner.nextLine();
        System.out.print("Podaj model samochodu: ");
        String model = scanner.nextLine();
        System.out.print("Podaj cene za dzien wynajmu: ");
        double cena = scanner.nextDouble();
        System.out.print("Podaj rok produkcji tego samochodu: ");
        short rokProdukcji = scanner.nextShort();
        scanner.nextLine();

        Samochod samochod = new Samochod(marka, model, cena, rokProdukcji);
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
            System.out.println("ID: " + samochod.id + "\t" +samochod.marka + "\t  " + samochod.model + "\t " + samochod.rokProdukcji);
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
        else{
            // Zadanie do zaimplementowania: dodaj funkcjonalność rezerwacji samochodu na określony czas
            System.out.println("Na ile dni chcesz wypozyczyc auto? ");
            int dni = scanner.nextInt();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            Date currentDate = new Date();
            System.out.println("Dzisiejsza data: " + dateFormat.format(currentDate));

            Calendar dt = Calendar.getInstance();
            dt.setTime(currentDate);

            //dt.add(Calendar.YEAR, 1);
            //dt.add(Calendar.MONTH, 1);
            dt.add(Calendar.DATE, dni);

            Date currentDatePlusOne = dt.getTime();
            System.out.println("Wynajem konczy sie: " + dateFormat.format(currentDatePlusOne));
        }

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
        System.out.println("\nKoszt wynajmu samochodu " + samochod.getMarka() + " " + samochod.getModel() + " wynosi: " + koszt + " PLN");
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
        int ocena;
        do{
            ocena = scanner.nextInt();
            scanner.nextLine();
            if(ocena<1 || 5<ocena){
                System.out.println("Podano zla wartosc. (Podaj ocene od 1 do 5)");
            }
        }while(!(ocena>=1 && 5>=ocena));

        samochod.dodajOcene(ocena);
        System.out.println("Dodano ocene dla samochodu!");
    }

    private void zobaczOcenyAut(){
        if (samochody.isEmpty()) {
            System.out.println("Brak samochodow!");
            return;
        }
        else{
            for (Samochod samochod : samochody) {
                System.out.println("\t" + samochod.marka + " \t " + samochod.model + "\tOcena: " + samochod.sredniaOcen());
                }
        }
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
        //private static int nextId = 1; // Dałem to jako zmienną globalną wypozyczalni
        private int id;
        private String marka;
        private String model;
        private double cena;
        private short rokProdukcji;
        private ArrayList<Integer> oceny;
        private boolean czyDostepny;

        public Samochod(String marka, String model, double cena, short rokProdukcji) {
            this.id = nextId++;
            this.marka = marka;
            this.model = model;
            this.cena = cena;
            this.rokProdukcji = rokProdukcji;
            this.oceny = new ArrayList<Integer>();
            this.czyDostepny = true;
        }

        public int getId() { return id; }

        public String getMarka() {
            return marka;
        }

        public String getModel() {
            return model;
        }

        public double getCena() {
            return cena;
        }
        public short getRokProdukcji() { return  rokProdukcji;}

        public boolean czyDostepny() {
            return czyDostepny;
        }

        public void zarezerwuj() {
            czyDostepny = false;
        }

        public double obliczKosztWynajmu(int dni) {
            if(dni < 7) return cena * dni;
            if(dni < 14){
                System.out.println("Dodano rabat 10%. Za wynajem " + dni + " dni ");
                return cena * dni * 0.9;
            }
            System.out.println("Dodano rabat 15%. Za wynajem " + dni + " dni");
            return cena * dni * 0.85;
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


