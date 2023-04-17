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
import java.text.DecimalFormat;

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
    JButton buttonWyswietlSamochody;JButton buttonRezerwojSamochod;
    JButton buttonCalculateCost;
    JButton buttonAddRatingCar;
    JButton buttonWyswietlOcenySamochodow;
    JButton exitButton;

    //Przyciski funkcyjne dolne

    JButton buttonPowrot ;
    JButton buttonZatwierdz ;

        public void start(){


                myFrameGUI = new MyFrame();  //creates a myFrane

                JLabel label = new JLabel("Wypozyczalnia samochodow firmy: Firma");
                buttonDodajSamochod = new JButton("Dodaj samochod");
                buttonWyswietlSamochody = new JButton("Wyswietl samochody");
                buttonRezerwojSamochod = new JButton("Rezerwuj samochod");
                buttonCalculateCost = new JButton("Oblicz koszt wynajmu samochodu");
                buttonAddRatingCar = new JButton("Ocen samochod");
                buttonWyswietlOcenySamochodow = new JButton("Wyswietl oceny samochodow");
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

                panel.add(buttonRezerwojSamochod);
                buttonRezerwojSamochod.addActionListener(this);
                buttonRezerwojSamochod.setBorder(BorderFactory.createEtchedBorder());
                buttonRezerwojSamochod.setBackground(new Color(50, 120, 200));

                panel.add(buttonCalculateCost);
                buttonCalculateCost.addActionListener(this);
                buttonCalculateCost.setBorder(BorderFactory.createEtchedBorder());
                buttonCalculateCost.setBackground(new Color(50, 120, 200));

                panel.add(buttonAddRatingCar);
                buttonAddRatingCar.addActionListener(this);
                buttonAddRatingCar.setBorder(BorderFactory.createEtchedBorder());
                buttonAddRatingCar.setBackground(new Color(50, 120, 200));

                panel.add(buttonWyswietlOcenySamochodow);
                buttonWyswietlOcenySamochodow.addActionListener(this);
                buttonWyswietlOcenySamochodow.setBorder(BorderFactory.createEtchedBorder());
                buttonWyswietlOcenySamochodow.setBackground(new Color(50, 120, 200));

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
        myTextFieldMarka.setFont(new Font("Arctic", Font.PLAIN,50));
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
        myTextFieldModel.setFont(new Font("Arctic", Font.PLAIN,50));
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
        myTextFieldRokProdukcji.setFont(new Font("Arctic", Font.PLAIN,50));
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
        myTextFieldKwotaZaDzien.setFont(new Font("Arctic", Font.PLAIN,50));
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
        listaAut.setHorizontalTextPosition(JLabel.CENTER);
        panel1.add(listaAut);
        myFrameNext.add(panel1, BorderLayout.CENTER);



        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0,200,0));
        myFrameNext.add(panel2, BorderLayout.SOUTH);
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
    JLabel labelSprawdz;
    JLabel LBOblicz;
    JLabel labelIloscDni;
    JLabel labelCost;


    private void obliczKwoteWynajmu() {
        myFrameNext = new MyFrame(); //creates a myFrame

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
        textFieldID.setFont(new Font("Arctic", Font.PLAIN, 50));
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

        labelSprawdz = new JLabel("");
        panel.add(labelSprawdz);

        textFieldIloscDni = new JTextField();
        textFieldIloscDni.setSize(new Dimension(250, 40));
        textFieldIloscDni.setFont(new Font("Arctic", Font.PLAIN, 50));
        textFieldIloscDni.setForeground(Color.GREEN);
        textFieldIloscDni.setBackground(Color.BLACK);
        textFieldIloscDni.setCaretColor(Color.WHITE);
        textFieldIloscDni.setVisible(false);
        panel.add(textFieldIloscDni);


        LBOblicz = new JLabel("");
        panel.add(LBOblicz);

        buttonOblicz = new JButton(" Oblicz ");
        buttonOblicz.addActionListener(this);
        buttonOblicz.setBorder(BorderFactory.createEtchedBorder());
        buttonOblicz.setBackground(new Color(50, 120, 200));
        buttonOblicz.setVisible(false);
        panel.add(buttonOblicz);

        labelIloscDni = new JLabel("");
        panel.add(labelIloscDni);
        labelCost = new JLabel("");
        panel.add(labelCost);




        myFrameNext.add(panel, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0, 200, 0));
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new GridLayout(0, 4, 10, 5));


        panel2.add(buttonPowrot);

        myFrameNext.add(panel2, BorderLayout.SOUTH);
    }

//----------------------------------//
// Dodaj ocene samochodu
//----------------------------------//

    JButton buttonAddRating;
    JButton buttonIdPassRating;
    JLabel labelSprawdzIdOcene;
    JLabel labelSprawdzOcene;
    JComboBox comboBoxRating;
    private void addCarRating(){
        myFrameNext = new MyFrame(); //creates a myFrame

        JLabel label = new JLabel("Dodaj ocene samochodu: ");

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
        textFieldID.setFont(new Font("Arctic", Font.PLAIN, 50));
        textFieldID.setForeground(Color.GREEN);
        textFieldID.setBackground(Color.BLACK);
        textFieldID.setCaretColor(Color.WHITE);
        panel.add(textFieldID);


        JLabel LB = new JLabel("");
        panel.add(LB);

        buttonIdPassRating = new JButton(" Sprawdz ");
        buttonIdPassRating.addActionListener(this);
        buttonIdPassRating.setBorder(BorderFactory.createEtchedBorder());
        buttonIdPassRating.setBackground(new Color(50, 120, 200));
        panel.add(buttonIdPassRating);

        labelSprawdzIdOcene = new JLabel("");
        panel.add(labelSprawdzIdOcene);

        String[] ocena1_5 = {"1","2","3","4","5"};
        comboBoxRating = new JComboBox(ocena1_5);
        comboBoxRating.setBackground(Color.BLACK);
        comboBoxRating.setForeground(Color.GREEN);
        comboBoxRating.setFont(new Font("Arctic", Font.PLAIN, 50));
        comboBoxRating.setSize(new Dimension(250, 40));
        comboBoxRating.setVisible(false);
        panel.add(comboBoxRating);

        labelSprawdzOcene = new JLabel("");

        myFrameNext.add(panel,BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0, 200, 0));
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new GridLayout(0, 4, 10, 5));
        panel2.add(buttonPowrot);

        JLabel lb1 = new JLabel();
        panel2.add(lb1);
        JLabel lb2 = new JLabel();
        panel2.add(lb2);

        buttonAddRating = new JButton(" Dodaj ocene: ");
        buttonAddRating.setBackground(new Color(0,255,0));
        buttonAddRating.setBorder(BorderFactory.createEtchedBorder());
        buttonAddRating.setSize(250,20);
        buttonAddRating.addActionListener(this);
        buttonAddRating.setVisible(false);
        panel2.add(buttonAddRating);

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
            if(e.getSource()==buttonAddRatingCar){
                myFrameGUI.dispose();
                addCarRating();
            }


            if(e.getSource()==exitButton)
                System.exit(0);

            //calculateCost

            if(e.getSource()==buttonIdPass) {
                if (textFieldID.getText().isEmpty()) {
                    textFieldIloscDni.setVisible(false);
                    buttonOblicz.setVisible(false);
                    labelSprawdz.setText("Podaj liczbe identyfikatora");
                    labelIloscDni.setText("");
                    labelCost.setText("");
                }
                else {
                    int ID = Integer.parseInt(textFieldID.getText());
                    if (znajdzSamochod(ID) != null) {

                        labelSprawdz.setText("Na ile dni chcesz wypozyczyc: ");
                        textFieldIloscDni.setVisible(true);
                        buttonOblicz.setVisible(true);

                    }
                    else {
                        labelSprawdz.setText("Nie ma takiego ID ");
                        textFieldIloscDni.setVisible(false);
                        buttonOblicz.setVisible(false);
                        labelIloscDni.setText("");
                        labelCost.setText("");
                    }
                }
            }

            if(e.getSource()==buttonOblicz){
                int ID = Integer.parseInt(textFieldID.getText());
                Samochod samochod = znajdzSamochod(ID);
                int dni = Integer.parseInt(textFieldIloscDni.getText());
                double kwota = samochod.obliczKosztWynajmu(dni);
                labelIloscDni.setText("Kwota za " + samochod.getMarka() + " " + samochod.getModel() + " wynosi: ");
                labelCost.setText(String.format("%.2f PLN", kwota));
            }

            //addCarRating

            if(e.getSource()==buttonIdPassRating){
                    if (textFieldID.getText().isEmpty()) {
                        textFieldIloscDni.setVisible(false);
                        buttonOblicz.setVisible(false);
                        labelSprawdz.setText("Podaj liczbe identyfikatora");
                    }
                    else {
                        int ID = Integer.parseInt(textFieldID.getText());
                        if (znajdzSamochod(ID) != null) {

                            labelSprawdzIdOcene.setText("Na ile oceniasz pojazd? ");
                            comboBoxRating.setVisible(true);
                            buttonAddRating.setVisible(true);

                        }
                        else {
                            labelSprawdz.setText("Nie ma takiego ID ");
                            comboBoxRating.setVisible(false);
                            buttonAddRating.setVisible(false);
                        }
                    }
            }
            if(e.getSource()==buttonAddRating){


            }


            //Lower buttons

            if(e.getSource()==buttonPowrot){
                myFrameNext.dispose();
                start();
            }
            if(e.getSource()==buttonZatwierdz){
                if(!(myTextFieldMarka.getText().isEmpty() | myTextFieldModel.getText().isEmpty() | myTextFieldRokProdukcji.getText().isEmpty() | myTextFieldKwotaZaDzien.getText().isEmpty())){
                    double cena = Double.parseDouble(myTextFieldKwotaZaDzien.getText());
                    short rok = Short.parseShort(myTextFieldRokProdukcji.getText());
                    dodajSamochod(myTextFieldMarka.getText(), myTextFieldModel.getText(),cena,rok);
                    wyswietlSamochody();
                    myFrameNext.dispose();
                    start();
                }
                else
                    System.out.println("Wypelnij puste pola.");


            }
        }
}
