import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//-------------------//
//Start GUI//
//-------------------//
public class GUI implements ActionListener {
    public GUI(){
        start();
    }
    private String listCars = "";
    private ArrayList<Samochod> samochody = new ArrayList<Samochod>();
    private static int nextId = 1;

    MyFrame myFrameGUI ;
    JButton buttonDodajSamochod;
    JButton buttonWyswietlSamochody;
    JButton button3;
    JButton buttonCalculateCost;
    JButton button5;
    JButton button6;
    JButton exitButton;

        public void start(){


                myFrameGUI = new MyFrame();  //creates a myFrane

                JLabel label = new JLabel("Wypozyczalnia samochodow firmy: Firma");
                buttonDodajSamochod = new JButton("Dodaj samochod");
                buttonWyswietlSamochody = new JButton("Wyswietl samochody");
                button3 = new JButton("Rezerwuj samochod");
                buttonCalculateCost = new JButton("Oblicz koszt wynajmu samochodu");
                button5 = new JButton("Ocen samochod");
                button6 = new JButton("Wyswietl oceny samochodow");
                exitButton = new JButton("Wyjscie");


                JPanel panel = new JPanel();

                myFrameGUI.add(panel, BorderLayout.CENTER);
                panel.setBackground(new Color(0, 200, 0));
                panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
                panel.setLayout(new GridLayout(0, 1, 10, 5));

                panel.add(label, BorderLayout.CENTER);

                panel.add(buttonDodajSamochod);
                buttonDodajSamochod.addActionListener(this);
                buttonDodajSamochod.setBorder(BorderFactory.createEtchedBorder());
                buttonDodajSamochod.setBackground(new Color(50, 120, 200));

                panel.add(buttonWyswietlSamochody);
                buttonWyswietlSamochody.addActionListener(this);
                buttonWyswietlSamochody.setBorder(BorderFactory.createEtchedBorder());
                buttonWyswietlSamochody.setBackground(new Color(50, 120, 200));

                panel.add(button3);
                button3.addActionListener(this);
                button3.setBorder(BorderFactory.createEtchedBorder());
                button3.setBackground(new Color(50, 120, 200));

                panel.add(buttonCalculateCost);
                buttonCalculateCost.addActionListener(this);
                buttonCalculateCost.setBorder(BorderFactory.createEtchedBorder());
                buttonCalculateCost.setBackground(new Color(50, 120, 200));

                panel.add(button5);
                button5.addActionListener(this);
                button5.setBorder(BorderFactory.createEtchedBorder());
                button5.setBackground(new Color(50, 120, 200));

                panel.add(button6);
                button6.addActionListener(this);
                button6.setBorder(BorderFactory.createEtchedBorder());
                button6.setBackground(new Color(50, 120, 200));

                panel.add(exitButton);
                exitButton.addActionListener(this);
                exitButton.setBorder(BorderFactory.createEtchedBorder());
                exitButton.setBackground(new Color(50, 120, 200));



        }

//----------------------------------//
// Dodaj samochów
//----------------------------------//

    MyFrame myFrameNext;
    JTextField myTextFieldMarka ;
    JTextField myTextFieldModel ;
    JTextField myTextFieldRokProdukcji ;
    JTextField myTextFieldKwotaZaDzien ;
    JCheckBox checkBox;
    JButton buttonPowrot ;
    JButton buttonZatwierdz ;

    private void addCars(){
        myFrameNext = new MyFrame();

        JPanel panel = new JPanel();
        myFrameNext.add(panel, BorderLayout.NORTH);
        JLabel titleLabel  = new JLabel("Podaj parametry samochodu:");
        panel.add(titleLabel);
        panel.setBackground(Color.GREEN);


        JPanel panel1 = new JPanel();
        myFrameNext.add(panel1, BorderLayout.CENTER);
        panel1.setBackground(new Color(0, 200, 0));
        panel1.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel1.setLayout(new GridLayout(0,2,10,5));

        JLabel Label1 = new JLabel("Podaj marke samochodu:  \t");
        Label1.setBackground(Color.GREEN);
        panel1.add(Label1);

        myTextFieldMarka = new JTextField();
        myTextFieldMarka.setPreferredSize(new Dimension(250,40));
        myTextFieldMarka.setFont(new Font("Arctic", Font.PLAIN,35));
        myTextFieldMarka.setForeground(Color.GREEN);
        myTextFieldMarka.setBackground(Color.BLACK);
        myTextFieldMarka.setCaretColor(Color.WHITE);
        myTextFieldMarka.setText("OPEL");
        panel1.add(myTextFieldMarka);


        JLabel Label2 = new JLabel("Podaj model samochodu: \t");
        Label2.setBackground(Color.GREEN);
        panel1.add(Label2);

        myTextFieldModel = new JTextField();
        myTextFieldModel.setPreferredSize(new Dimension(250,40));
        myTextFieldModel.setFont(new Font("Arctic", Font.PLAIN,35));
        myTextFieldModel.setForeground(Color.GREEN);
        myTextFieldModel.setBackground(Color.BLACK);
        myTextFieldModel.setCaretColor(Color.WHITE);
        myTextFieldModel.setText("ASTRA");
        panel1.add(myTextFieldModel);

        JLabel Label4 = new JLabel("Podaj rok produkcji: \t");
        panel1.add(Label4);
        Label4.setBackground(Color.GREEN);

        myTextFieldRokProdukcji = new JTextField();
        myTextFieldRokProdukcji.setPreferredSize(new Dimension(250,40));
        myTextFieldRokProdukcji.setFont(new Font("Arctic", Font.PLAIN,35));
        myTextFieldRokProdukcji.setForeground(Color.GREEN);
        myTextFieldRokProdukcji.setBackground(Color.BLACK);
        myTextFieldRokProdukcji.setCaretColor(Color.WHITE);
        myTextFieldRokProdukcji.setText("2020");
        panel1.add(myTextFieldRokProdukcji);

        JLabel Label3 = new JLabel("Podaj cene za dzien wynajmu: \t");
        panel1.add(Label3);
        Label3.setBackground(Color.GREEN);

        myTextFieldKwotaZaDzien = new JTextField();
        myTextFieldKwotaZaDzien.setPreferredSize(new Dimension(250,40));
        myTextFieldKwotaZaDzien.setFont(new Font("Arctic", Font.PLAIN,35));
        myTextFieldKwotaZaDzien.setForeground(Color.GREEN);
        myTextFieldKwotaZaDzien.setBackground(Color.BLACK);
        myTextFieldKwotaZaDzien.setCaretColor(Color.WHITE);
        myTextFieldKwotaZaDzien.setText("100");
        panel1.add(myTextFieldKwotaZaDzien);

        checkBox = new JCheckBox();
        checkBox.setText("Nie jestem robotem :)");
        checkBox.setBackground(Color.GREEN);
        checkBox.setFocusable(false);
        panel1.add(checkBox);


        panel1.setBackground(Color.GREEN);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0,200,0));
        myFrameNext.add(panel2, BorderLayout.SOUTH);
//                panel2.setPreferredSize(new Dimension(100,100));
        panel2.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel2.setLayout(new GridLayout(0,4,10,5));

        buttonPowrot = new JButton(" Powrot ");
        buttonPowrot.addActionListener(this);
        buttonPowrot.setBackground(new Color(255,100,100));
        buttonPowrot.setBorder(BorderFactory.createEtchedBorder());
        buttonPowrot.setSize(250,20);
        panel2.add(buttonPowrot);

        JLabel lb1 = new JLabel();
        panel2.add(lb1);
        JLabel lb2 = new JLabel();
        panel2.add(lb2);

        buttonZatwierdz = new JButton(" Zatwierdz ");
        buttonZatwierdz.setBackground(new Color(0,255,0));
        buttonZatwierdz.setBorder(BorderFactory.createEtchedBorder());
        buttonZatwierdz.setSize(250,20);
        buttonZatwierdz.addActionListener(this);
        panel2.add(buttonZatwierdz);

    }


//----------------------------------//
// Wyświetl auta
//----------------------------------//
    private JLabel listaAut;
    protected void showCars(){
        myFrameNext = new MyFrame();

        JPanel panelStart = new JPanel();
        panelStart.setBackground(Color.GREEN);

        myFrameNext.add(panelStart, BorderLayout.NORTH);

        JLabel centerLabel = new JLabel("Obecne samochody:");
        panelStart.add(centerLabel);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.GREEN);

        String listCars = wyswietlSamochody();

        listaAut = new JLabel(listCars);
//        listaAut.setVerticalTextPosition(JLabel.BOTTOM);
        listaAut.setHorizontalTextPosition(JLabel.CENTER);
        panel1.add(listaAut);
        myFrameNext.add(panel1, BorderLayout.CENTER);



        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0,200,0));
        myFrameNext.add(panel2, BorderLayout.SOUTH);
//                panel2.setPreferredSize(new Dimension(100,100));
        panel2.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel2.setLayout(new GridLayout(0,4,10,5));

        buttonPowrot = new JButton(" Powrot ");
        buttonPowrot.addActionListener(this);
        buttonPowrot.setBackground(new Color(255,100,100));
        buttonPowrot.setBorder(BorderFactory.createEtchedBorder());
        buttonPowrot.setSize(250,20);
        panel2.add(buttonPowrot);

    }

//----------------------------------//
// Oblicz Kwotę Wynajmu
//----------------------------------//
    JTextField textFieldID;
    JButton buttonIdPass;
    JTextField textFieldIloscDni;
    JButton buttonOblicz;

    private void obliczKwoteWynajmu() {
        myFrameNext = new MyFrame(); //creates a myFrame

//             String obecnySamochod = "";
        JLabel label = new JLabel("Oblicz kwote wynajmu: ");

        JPanel panelStart = new JPanel();
        panelStart.setBackground(new Color(0, 200, 0));
        panelStart.add(label, BorderLayout.CENTER);
        myFrameNext.add(panelStart, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 200, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 2, 10, 5));


        JLabel LabelId = new JLabel("Wybierz ID Samochodu: ");
        panel.add(LabelId);

        textFieldID = new JTextField();
        textFieldID.setSize(new Dimension(250, 40));
        textFieldID.setFont(new Font("Arctic", Font.PLAIN, 35));
        textFieldID.setForeground(Color.GREEN);
        textFieldID.setBackground(Color.BLACK);
        textFieldID.setCaretColor(Color.WHITE);
        panel.add(textFieldID);


        JLabel LB = new JLabel("");
        panel.add(LB);

        buttonIdPass = new JButton(" Sprawdz ");
        buttonIdPass.addActionListener(this);
        buttonIdPass.setBorder(BorderFactory.createEtchedBorder());
        buttonIdPass.setBackground(new Color(50, 120, 200));
        panel.add(buttonIdPass);


        JLabel labelDni = new JLabel("Podaj na ile dni chcesz wypozyczyc: ");
        labelDni.setVisible(false);
        panel.add(labelDni);

        textFieldIloscDni = new JTextField();
        textFieldIloscDni.setSize(new Dimension(250, 40));
        textFieldIloscDni.setFont(new Font("Arctic", Font.PLAIN, 35));
        textFieldIloscDni.setForeground(Color.GREEN);
        textFieldIloscDni.setBackground(Color.BLACK);
        textFieldIloscDni.setCaretColor(Color.WHITE);
        textFieldIloscDni.setVisible(false);
        panel.add(textFieldIloscDni);


        JLabel LBOblicz = new JLabel("");
        LBOblicz.setVisible(false);
        panel.add(LBOblicz);

        buttonOblicz = new JButton(" Sprawdz ");
        buttonOblicz.addActionListener(this);
        buttonOblicz.setBorder(BorderFactory.createEtchedBorder());
        buttonOblicz.setBackground(new Color(50, 120, 200));
        buttonOblicz.setVisible(false);
        panel.add(buttonOblicz);

        myFrameNext.add(panel, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0, 200, 0));
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new GridLayout(0, 4, 10, 5));


        buttonPowrot = new JButton(" Powrot ");
        buttonPowrot.addActionListener(this);
        buttonPowrot.setBackground(new Color(255, 100, 100));
        buttonPowrot.setBorder(BorderFactory.createEtchedBorder());
        buttonPowrot.setSize(250, 20);
        panel2.add(buttonPowrot);

        myFrameNext.add(panel2, BorderLayout.SOUTH);
    }



    private void dodajSamochod(String marka, String model, double cena, short rokProdukcji) {

        Samochod samochod = new Samochod(marka, model, cena, rokProdukcji);
        samochody.add(samochod);
        listCars += "ID:   " + samochod.id + "   \t" + samochod.marka + "\t  " + samochod.model + "\t " + samochod.rokProdukcji + "\n";
        System.out.println("Dodano samochod!");
    }

    private String wyswietlSamochody() {

//        String listaAut = "";
//        if (samochody.isEmpty()) {
////            System.out.println("Brak samochodow!");
//            listCars = "Brak samochodow!");
//        }
//        else {
//            System.out.println("\nLista samochodow:");
//            for (Samochod samochod : samochody) {
//                listCars += "ID: " + samochod.id + "\t" + samochod.marka + "\t  " + samochod.model + "\t " + samochod.rokProdukcji + "\n";
//            }
//        }
//        return listaAut;
          return listCars;
    }

//    private void rezerwujSamochod() {
//        System.out.print("\nPodaj ID samochodu do rezerwacji: ");
//        int id = scanner.nextInt();
////        scanner.nextLine();
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



    static class Samochod {
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
    public static void main(String[] args){
        new GUI();
    }


        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==buttonDodajSamochod){
                myFrameGUI.dispose();
                addCars();
            }

            if(e.getSource()==buttonWyswietlSamochody){
                myFrameGUI.dispose();
                showCars();
            }
            if(e.getSource()==buttonCalculateCost){
                myFrameGUI.dispose();
                obliczKwoteWynajmu();
            }
            if(e.getSource()==buttonPowrot){
                myFrameNext.dispose();
                start();
            }
            if(e.getSource()==buttonIdPass){
                //Miejsce na instrukcje od sprawdzenia czy jest takie ID samochodu
            }

            if(e.getSource()==exitButton)
                System.exit(0);


            //Lower buttons

            if(e.getSource()==buttonPowrot){
                myFrameNext.dispose();
                start();
            }
            if(e.getSource()==buttonZatwierdz){
                if(!(myTextFieldMarka.getText().isEmpty() | myTextFieldModel.getText().isEmpty() | myTextFieldRokProdukcji.getText().isEmpty() | myTextFieldKwotaZaDzien.getText().isEmpty())){
                    dodajSamochod(myTextFieldMarka.getText(), myTextFieldModel.getText(),100.0,(short)2022);
                    wyswietlSamochody();
                    myFrameNext.dispose();
                    start();
                }
                else
                    System.out.println("Wypelnij puste pola.");


            }
        }
}
