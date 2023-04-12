//import java.util.ArrayList;
//import java.util.Scanner;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.text.ParseException;
//
//
//public class Wypozyczalnia  {
//    private Scanner scanner;
//    private ArrayList<Samochod> samochody;
//    private static int nextId = 1;
//
//    public Wypozyczalnia() {
//        samochody = new ArrayList<Samochod>();
//        scanner = new Scanner(System.in);
//    }
//
//    public void menu() {
//        int wybor;
//        do {
//            System.out.println("\n===============================");
//            System.out.println("1. Dodaj samochod");
//            System.out.println("2. Wyswietl samochody");
//            System.out.println("3. Rezerwuj samochod");
//            System.out.println("4. Oblicz koszt wynajmu samochodu");
//            System.out.println("5. Ocen samochod");
//            System.out.println("6. Wyswietl oceny aut");
//            System.out.println("7. Wyjdz");
//            System.out.print("\nWybierz opcje: ");
//            wybor = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (wybor) {
//                case 1:
//                    dodajSamochod();
//                    break;
//                case 2:
//                    wyswietlSamochody();
//                    break;
//                case 3:
//                    rezerwujSamochod();
//                    break;
//                case 4:
//                    obliczKosztWynajmu();
//                    break;
//                case 5:
//                    ocenSamochod();
//                    break;
//                case 6:
//                    zobaczOcenyAut();
//                    break;
//                case 7:
//                    System.out.println("Koniec programu!");
//                    break;
//                default:
//                    System.out.println("Nieznana opcja!");
//            }
//        } while (wybor != 7);
//    }
//
//
//    protected void dodajSamochod() {
//        System.out.print("\nPodaj marke samochodu: ");
//        String marka = scanner.nextLine();
//        System.out.print("Podaj model samochodu: ");
//        String model = scanner.nextLine();
//        System.out.print("Podaj cene za dzien wynajmu: ");
//        double cena = scanner.nextDouble();
//        System.out.print("Podaj rok produkcji tego samochodu: ");
//        short rokProdukcji = scanner.nextShort();
//        scanner.nextLine();
//
//        Samochod samochod = new Samochod(marka, model, cena, rokProdukcji);
//        samochody.add(samochod);
//        System.out.println("Dodano samochod!");
//    }
//
//    protected String wyswietlSamochody() {
//        ArrayList<String> listCars = new ArrayList<String>();
//        String listaAut = "";
//        if (samochody.isEmpty()) {
//            System.out.println("Brak samochodow!");
//            listCars.add("Brak samochodow!");
//        }
//        else {
//            System.out.println("\nLista samochodow:");
//            for (Samochod samochod : samochody) {
//                System.out.println("ID: " + samochod.id + "\t" + samochod.marka + "\t  " + samochod.model + "\t " + samochod.rokProdukcji);
//                listCars.add("ID: " + samochod.id + "\t" + samochod.marka + "\t  " + samochod.model + "\t " + samochod.rokProdukcji);
//            }
//        }
//        for (String s : listCars){
//            listaAut += s + "\n";
//        }
//        return listaAut;
//    }
//
//    private void rezerwujSamochod() {
//        System.out.print("\nPodaj ID samochodu do rezerwacji: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Samochod samochod = znajdzSamochod(id);
//        if (samochod == null) {
//            System.out.println("Nie znaleziono samochodu o podanym ID!");
//            return;
//        } else {
//            System.out.println("Na ile dni chcesz wypozyczyc samochod?");
//            int days = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.println("Czy chcesz zaczac wypozyczanie od dzisiaj? (TAK/NIE)");
//            String wybor = scanner.nextLine().toUpperCase();
//
//            Calendar startDate = Calendar.getInstance();
//            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//            if (wybor.equals("TAK")) {
//                System.out.println("Wypozyczanie zaczyna się od dzisiaj: " + dateFormat.format(startDate.getTime()));
//            } else if (wybor.equals("NIE")) {
//                System.out.println("Podaj date rozpoczecia wypozyczenia (w formacie dd/MM/yyyy): ");
//                String dateStr = scanner.nextLine();
//
//
//                try {
//
//                    Date date = dateFormat.parse(dateStr);
//                    startDate.setTime(date);
//                    System.out.println("Wypozyczanie zaczyna sie od: " + dateFormat.format(startDate.getTime()));
//                } catch (ParseException e) {
//                    System.out.println("Nieprawidlowy format daty!");
//                    return;
//                }
//            } else {
//                System.out.println("Nieznana opcja!");
//                return;
//            }
//
//            Calendar endDate = (Calendar) startDate.clone();
//            //endDate.add(Calendar.YEAR, 1);
//            //endDate.add(Calendar.MONTH, 1);
//            endDate.add(Calendar.DATE, days);
//            System.out.println("Wypozyczanie konczy sie dnia: " + dateFormat.format(endDate.getTime()));
//        }
//    }
//
//    protected void obliczKosztWynajmu() {
//        System.out.print("\nPodaj ID samochodu: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Samochod samochod = znajdzSamochod(id);
//        if (samochod == null) {
//            System.out.println("Nie znaleziono samochodu o podanym ID!");
//            return;
//        }
//        System.out.print("Podaj liczbe dni wynajmu: ");
//        int dni = scanner.nextInt();
//
//        double koszt = samochod.obliczKosztWynajmu(dni);
//        System.out.println("\nKoszt wynajmu samochodu " + samochod.getMarka() + " " + samochod.getModel() + " wynosi: " + koszt + " PLN");
//    }
//
//    private void ocenSamochod() {
//        System.out.print("\nPodaj ID samochodu: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Samochod samochod = znajdzSamochod(id);
//        if (samochod == null) {
//            System.out.println("Nie znaleziono samochodu o podanym ID!");
//            return;
//        }
//
//        System.out.print("Podaj ocene samochodu (od 1 do 5): ");
//        int ocena;
//        do{
//            ocena = scanner.nextInt();
//            scanner.nextLine();
//            if(ocena<1 || 5<ocena){
//                System.out.println("Podano zla wartosc. (Podaj ocene od 1 do 5)");
//            }
//        }while(!(ocena>=1 && 5>=ocena));
//
//        samochod.dodajOcene(ocena);
//        System.out.println("Dodano ocene dla samochodu!");
//    }
//
//    private void zobaczOcenyAut(){
//        if (samochody.isEmpty()) {
//            System.out.println("Brak samochodow!");
//            return;
//        }
//        else{
//            for (Samochod samochod : samochody) {
//                System.out.println("\t" + samochod.marka + " \t " + samochod.model + "\tOcena: " + samochod.sredniaOcen());
//                }
//        }
//    }
//
//    private Samochod znajdzSamochod(int id) {
//        for (Samochod samochod : samochody) {
//            if (samochod.getId() == id) {
//                return samochod;
//            }
//        }
//        return null;
//    }
//
//
//
//    static class Samochod {
//        private int id;
//        private String marka;
//        private String model;
//        private double cena;
//        private short rokProdukcji;
//        private ArrayList<Integer> oceny;
//        private boolean czyDostepny;
//
//        public Samochod(String marka, String model, double cena, short rokProdukcji) {
//            this.id = nextId++;
//            this.marka = marka;
//            this.model = model;
//            this.cena = cena;
//            this.rokProdukcji = rokProdukcji;
//            this.oceny = new ArrayList<Integer>();
//            this.czyDostepny = true;
//        }
//
//        public int getId() { return id; }
//
//        public String getMarka() {
//            return marka;
//        }
//
//        public String getModel() {
//            return model;
//        }
//
//        public double getCena() {
//            return cena;
//        }
//        public short getRokProdukcji() { return  rokProdukcji;}
//
//        public boolean czyDostepny() {
//            return czyDostepny;
//        }
//
//        public void zarezerwuj() {
//            czyDostepny = false;
//        }
//
//        public double obliczKosztWynajmu(int dni) {
//            if(dni < 7) return cena * dni;
//            if(dni < 14){
//                System.out.println("Dodano rabat 10%. Za wynajem " + dni + " dni ");
//                return cena * dni * 0.9;
//            }
//            System.out.println("Dodano rabat 15%. Za wynajem " + dni + " dni");
//            return cena * dni * 0.85;
//        }
//
//        public void dodajOcene(int ocena) {
//            oceny.add(ocena);
//        }
//
//        public double sredniaOcen() {
//            if (oceny.isEmpty()) {
//                return 0;
//            }
//
//            double suma = 0;
//            for (int ocena : oceny) {
//                suma += ocena;
//            }
//
//            return suma / oceny.size();
//        }
//    }
//
//    public static void main(String[] args) {
//        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();
//        wypozyczalnia.menu();
//    }
//}
//
//
