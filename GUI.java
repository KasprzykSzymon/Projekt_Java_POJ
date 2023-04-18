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
    private ArrayList<Car> Cars = new ArrayList<Car>();
    private static int nextId = 1;
    MyFrame myFrameGUI ;
    JButton buttonAddCar;
    JButton buttonShowCar;
    JButton buttonReserveACars;
    JButton buttonCalculateCost;
    JButton buttonAddRatingCar;
    JButton buttonShowCarsRating;
    JButton exitButton;

    //Defoult lower buttons
    JButton buttonBack ;
    JButton buttonConfirm ;
        public void start(){
                myFrameGUI = new MyFrame();  //creates a myFrane
                JLabel label = new JLabel("Wypozyczalnia samochodow firmy: Firma");
                buttonAddCar = new JButton("Dodaj samochod");
                buttonShowCar = new JButton("Wyswietl samochody");
                buttonReserveACars = new JButton("Rezerwuj samochod");
                buttonCalculateCost = new JButton("Oblicz koszt wynajmu samochodu");
                buttonAddRatingCar = new JButton("Ocen samochod");
                buttonShowCarsRating = new JButton("Wyswietl ratings samochodow");
                exitButton = new JButton("Wyjscie");
                JPanel panel = new JPanel();
                myFrameGUI.add(panel, BorderLayout.CENTER);
                panel.setBackground(new Color(0, 200, 0));
                panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
                panel.setLayout(new GridLayout(0, 1, 10, 5));
                panel.add(label, BorderLayout.CENTER);
                panel.add(buttonAddCar);
                buttonAddCar.addActionListener(this);
                buttonAddCar.setBorder(BorderFactory.createEtchedBorder());
                buttonAddCar.setBackground(new Color(50, 120, 200));
                panel.add(buttonShowCar);
                buttonShowCar.addActionListener(this);
                buttonShowCar.setBorder(BorderFactory.createEtchedBorder());
                buttonShowCar.setBackground(new Color(50, 120, 200));
                panel.add(buttonReserveACars);
                buttonReserveACars.addActionListener(this);
                buttonReserveACars.setBorder(BorderFactory.createEtchedBorder());
                buttonReserveACars.setBackground(new Color(50, 120, 200));
                panel.add(buttonCalculateCost);
                buttonCalculateCost.addActionListener(this);
                buttonCalculateCost.setBorder(BorderFactory.createEtchedBorder());
                buttonCalculateCost.setBackground(new Color(50, 120, 200));
                panel.add(buttonAddRatingCar);
                buttonAddRatingCar.addActionListener(this);
                buttonAddRatingCar.setBorder(BorderFactory.createEtchedBorder());
                buttonAddRatingCar.setBackground(new Color(50, 120, 200));
                panel.add(buttonShowCarsRating);
                buttonShowCarsRating.addActionListener(this);
                buttonShowCarsRating.setBorder(BorderFactory.createEtchedBorder());
                buttonShowCarsRating.setBackground(new Color(50, 120, 200));
                panel.add(exitButton);
                exitButton.addActionListener(this);
                exitButton.setBorder(BorderFactory.createEtchedBorder());
                exitButton.setBackground(new Color(50, 120, 200));
        }

//----------------------------------//
// Add cars
//----------------------------------//
    MyFrame myFrameNext;
    JTextField myTextFieldMark ;
    JTextField myTextFieldModel ;
    JTextField myTextFieldYearOfProduction ;
    JTextField myTextFieldPriceForDay ;
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
        JLabel Label1 = new JLabel("Podaj marke samochoduu:  \t");
        Label1.setBackground(Color.GREEN);
        panel1.add(Label1);
        myTextFieldMark = new JTextField();
        myTextFieldMark.setPreferredSize(new Dimension(250,40));
        myTextFieldMark.setFont(new Font("Arctic", Font.PLAIN,50));
        myTextFieldMark.setForeground(Color.GREEN);
        myTextFieldMark.setBackground(Color.BLACK);
        myTextFieldMark.setCaretColor(Color.WHITE);
        myTextFieldMark.setText("OPEL");
        panel1.add(myTextFieldMark);
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
        myTextFieldYearOfProduction = new JTextField();
        myTextFieldYearOfProduction.setPreferredSize(new Dimension(250,40));
        myTextFieldYearOfProduction.setFont(new Font("Arctic", Font.PLAIN,50));
        myTextFieldYearOfProduction.setForeground(Color.GREEN);
        myTextFieldYearOfProduction.setBackground(Color.BLACK);
        myTextFieldYearOfProduction.setCaretColor(Color.WHITE);
        myTextFieldYearOfProduction.setText("2020");
        panel1.add(myTextFieldYearOfProduction);
        JLabel Label3 = new JLabel("Podaj cene za dzien wynajmu: \t");
        panel1.add(Label3);
        Label3.setBackground(Color.GREEN);
        myTextFieldPriceForDay = new JTextField();
        myTextFieldPriceForDay.setPreferredSize(new Dimension(250,40));
        myTextFieldPriceForDay.setFont(new Font("Arctic", Font.PLAIN,50));
        myTextFieldPriceForDay.setForeground(Color.GREEN);
        myTextFieldPriceForDay.setBackground(Color.BLACK);
        myTextFieldPriceForDay.setCaretColor(Color.WHITE);
        myTextFieldPriceForDay.setText("100");
        panel1.add(myTextFieldPriceForDay);
        checkBox = new JCheckBox();
        checkBox.setText("Nie jestem robotem :)");
        checkBox.setBackground(Color.GREEN);
        checkBox.setFocusable(false);
        panel1.add(checkBox);
        panel1.setBackground(Color.GREEN);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0,200,0));
        myFrameNext.add(panel2, BorderLayout.SOUTH);
        panel2.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel2.setLayout(new GridLayout(0,4,10,5));
        buttonBack = new JButton(" Powrot ");
        buttonBack.addActionListener(this);
        buttonBack.setBackground(new Color(255,100,100));
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        buttonBack.setSize(250,20);
        panel2.add(buttonBack);
        JLabel lb1 = new JLabel();
        panel2.add(lb1);
        JLabel lb2 = new JLabel();
        panel2.add(lb2);
        buttonConfirm = new JButton(" Zatwierdz ");
        buttonConfirm.setBackground(new Color(0,255,0));
        buttonConfirm.setBorder(BorderFactory.createEtchedBorder());
        buttonConfirm.setSize(250,20);
        buttonConfirm.addActionListener(this);
        panel2.add(buttonConfirm);
    }

//----------------------------------//
// Show cars
//----------------------------------//
    private JLabel labelListCars;
    protected void showCars(){
        myFrameNext = new MyFrame();
        JPanel panelStart = new JPanel();
        panelStart.setBackground(Color.GREEN);
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        JLabel centerLabel = new JLabel("Obecne samochody:");
        panelStart.add(centerLabel);
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.GREEN);
        String listCars = funcShowCars();
        labelListCars = new JLabel(listCars);
        labelListCars.setHorizontalTextPosition(JLabel.CENTER);
        panel1.add(labelListCars);
        myFrameNext.add(panel1, BorderLayout.CENTER);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0,200,0));
        myFrameNext.add(panel2, BorderLayout.SOUTH);
        panel2.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel2.setLayout(new GridLayout(0,4,10,5));
        buttonBack = new JButton(" Powrot ");
        buttonBack.addActionListener(this);
        buttonBack.setBackground(new Color(255,100,100));
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        buttonBack.setSize(250,20);
        panel2.add(buttonBack);
    }

//----------------------------------//
// Calculate amount of rent
//----------------------------------//
    JTextField textFieldID;
    JButton buttonIdPass;
    JTextField textFieldDays;
    JButton buttonCalculate;
    JLabel labelCheck;
    JLabel LBCalculate;
    JLabel labelDays;
    JLabel labelCost;

    private void funcCalculateAmountOfRent() {
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
        JLabel LabelId = new JLabel("Wybierz ID samochodu: ");
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
        labelCheck = new JLabel("");
        panel.add(labelCheck);
        textFieldDays = new JTextField();
        textFieldDays.setSize(new Dimension(250, 40));
        textFieldDays.setFont(new Font("Arctic", Font.PLAIN, 50));
        textFieldDays.setForeground(Color.GREEN);
        textFieldDays.setBackground(Color.BLACK);
        textFieldDays.setCaretColor(Color.WHITE);
        textFieldDays.setVisible(false);
        panel.add(textFieldDays);
        LBCalculate = new JLabel("");
        panel.add(LBCalculate);
        buttonCalculate = new JButton(" Oblicz ");
        buttonCalculate.addActionListener(this);
        buttonCalculate.setBorder(BorderFactory.createEtchedBorder());
        buttonCalculate.setBackground(new Color(50, 120, 200));
        buttonCalculate.setVisible(false);
        panel.add(buttonCalculate);
        labelDays = new JLabel("");
        panel.add(labelDays);
        labelCost = new JLabel("");
        panel.add(labelCost);
        myFrameNext.add(panel, BorderLayout.CENTER);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0, 200, 0));
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new GridLayout(0, 4, 10, 5));
        panel2.add(buttonBack);
        myFrameNext.add(panel2, BorderLayout.SOUTH);
    }

//----------------------------------//
// Add Car Rating
//----------------------------------//
    JButton buttonAddRating;
    JButton buttonIdPassRating;
    JLabel labelCheckIdRating;
    JLabel labelCheckRating;
    JComboBox comboBoxRating;
    private void addCarRating(){
        myFrameNext = new MyFrame(); //creates a myFrame
        JLabel label = new JLabel("Dodaj ocene samochoduu: ");
        JPanel panelStart = new JPanel();
        panelStart.setBackground(new Color(0, 200, 0));
        panelStart.add(label, BorderLayout.CENTER);
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 200, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 2, 10, 5));
        JLabel LabelId = new JLabel("Wybierz ID samochodu: ");
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
        labelCheckIdRating = new JLabel("");
        panel.add(labelCheckIdRating);
        String[] rating1_5 = {"1","2","3","4","5"};
        comboBoxRating = new JComboBox<String>(rating1_5);
        comboBoxRating.setBackground(Color.BLACK);
        comboBoxRating.setForeground(Color.GREEN);
        comboBoxRating.setFont(new Font("Arctic", Font.PLAIN, 50));
        comboBoxRating.setSize(new Dimension(250, 40));
        comboBoxRating.setVisible(false);
        panel.add(comboBoxRating);
        labelCheckRating = new JLabel("");
        myFrameNext.add(panel,BorderLayout.CENTER);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0, 200, 0));
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new GridLayout(0, 4, 10, 5));
        panel2.add(buttonBack);
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

    private void funcAddCar(String mark, String model, double price, short yearOfProduction) {
        Car Car = new Car(mark, model, price, yearOfProduction);
        Cars.add(Car);
        listCars += "ID:   " + Car.id + "   \t" + Car.mark + "\t  " + Car.model + "\t " + Car.yearOfProduction + "\n";
        System.out.println("Dodano samochod!");
    }

    private String funcShowCars() {
//        String labelListCars = "";
//        if (Cars.isEmpty()) {
////            System.out.println("Brak Carow!");
//            listCars = "Brak Carow!");
//        }
//        else {
//            System.out.println("\nLista Carow:");
//            for (Car Car : Cars) {
//                listCars += "ID: " + Car.id + "\t" + Car.mark + "\t  " + Car.model + "\t " + Car.yearOfProduction + "\n";
//            }
//        }
//        return labelListCars;
          return listCars;
    }

//    private void rezerwujCar() {
//        System.out.print("\nPodaj ID Caru do rezerwacji: ");
//        int id = scanner.nextInt();
////        scanner.nextLine();
//
//        Car Car = funcSearchCar(id);
//        if (Car == null) {
//            System.out.println("Nie znaleziono Caru o podanym ID!");
//            return;
//        } else {
//            System.out.println("Na ile days chcesz wypozyczyc Car?");
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
//            System.out.println("Wypozyczanie konczy sie daysa: " + dateFormat.format(endDate.getTime()));
//        }
//    }
//
//    private void ocenCar() {
//        System.out.print("\nPodaj ID Caru: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Car Car = funcSearchCar(id);
//        if (Car == null) {
//            System.out.println("Nie znaleziono Caru o podanym ID!");
//            return;
//        }
//
//        System.out.print("Podaj ocene Caru (od 1 do 5): ");
//        int oprice;
//        do{
//            oprice = scanner.nextInt();
//            scanner.nextLine();
//            if(oprice<1 || 5<oprice){
//                System.out.println("Podano zla wartosc. (Podaj ocene od 1 do 5)");
//            }
//        }while(!(oprice>=1 && 5>=oprice));
//
//        Car.dodajOcene(oprice);
//        System.out.println("Dodano ocene dla Caru!");
//    }

    private void seeCarRatings(){
        if (Cars.isEmpty()) {
            System.out.println("Brak samochodow!");
            return;
        }
        else{
            for (Car Car : Cars) {
                System.out.println("\t" + Car.mark + " \t " + Car.model + "\tOcena: " + Car.averageRating());
            }
        }
    }

    private Car funcSearchCar(int id) {
        for (Car Car : Cars) {
            if (Car.getId() == id) {
                return Car;
            }
        }
        return null;
    }
    static class Car {
        private int id;
        private String mark;
        private String model;
        private double price;
        private short yearOfProduction;
        private ArrayList<Integer> ratings;
        private boolean availability;
        public Car(String mark, String model, double price, short yearOfProduction) {
            this.id = nextId++;
            this.mark = mark;
            this.model = model;
            this.price = price;
            this.yearOfProduction = yearOfProduction;
            this.ratings = new ArrayList<Integer>();
            this.availability = true;
        }
        public int getId() { return id; }
        public String getMark() {
            return mark;
        }
        public String getModel() {
            return model;
        }
        public double getprice() {
            return price;
        }
        public short getYearOfProduction() { return  yearOfProduction;}
        public boolean availability() {
            return availability;
        }
        public void Rent() {
            availability = false;
        }
        public double funcCalculateTheCostOfRent(int days) {
            if(days < 7) return price * days;
            if(days < 14){
                System.out.println("Dodano rabat 10%. Za wynajem " + days + " days ");
                return price * days * 0.9;
            }
            System.out.println("Dodano rabat 15%. Za wynajem " + days + " days");
            return price * days * 0.85;
        }
        public void dodajOcene(int price) {
            ratings.add(price);
        }
        public double averageRating() {
            if (ratings.isEmpty()) {
                return 0;
            }
            double sum = 0;
            for (int price : ratings) {
                sum += price;
            }
            return sum / ratings.size();
        }
    }
    public static void main(String[] args){
        new GUI();
    }

        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==buttonAddCar){
                myFrameGUI.dispose();
                addCars();
            }
            if(e.getSource()==buttonShowCar){
                myFrameGUI.dispose();
                showCars();
            }
            if(e.getSource()==buttonCalculateCost){
                myFrameGUI.dispose();
                funcCalculateAmountOfRent();
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
                    textFieldDays.setVisible(false);
                    buttonCalculate.setVisible(false);
                    labelCheck.setText("Podaj liczbe identyfikatora");
                    labelDays.setText("");
                    labelCost.setText("");
                }
                else {
                    int ID = Integer.parseInt(textFieldID.getText());
                    if (funcSearchCar(ID) != null) {

                        labelCheck.setText("Na ile days chcesz wypozyczyc: ");
                        textFieldDays.setVisible(true);
                        buttonCalculate.setVisible(true);

                    }
                    else {
                        labelCheck.setText("Nie ma takiego ID ");
                        textFieldDays.setVisible(false);
                        buttonCalculate.setVisible(false);
                        labelDays.setText("");
                        labelCost.setText("");
                    }
                }
            }
            if(e.getSource()==buttonCalculate){
                int ID = Integer.parseInt(textFieldID.getText());
                Car Car = funcSearchCar(ID);
                int days = Integer.parseInt(textFieldDays.getText());
                double price = Car.funcCalculateTheCostOfRent(days);
                labelDays.setText("Kwota za " + Car.getMark() + " " + Car.getModel() + " wynosi: ");
                labelCost.setText(String.format("%.2f PLN", price));
            }
            //addCarRating
            if(e.getSource()==buttonIdPassRating){
                    if (textFieldID.getText().isEmpty()) {
                        textFieldDays.setVisible(false);
                        buttonCalculate.setVisible(false);
                        labelCheck.setText("Podaj liczbe identyfikatora");
                    }
                    else {
                        int ID = Integer.parseInt(textFieldID.getText());
                        if (funcSearchCar(ID) != null) {
                            labelCheckIdRating.setText("Na ile oceniasz pojazd? ");
                            comboBoxRating.setVisible(true);
                            buttonAddRating.setVisible(true);
                        }
                        else {
                            labelCheck.setText("Nie ma takiego ID ");
                            comboBoxRating.setVisible(false);
                            buttonAddRating.setVisible(false);
                        }
                    }
            }
            if(e.getSource()==buttonAddRating){
                //Miejsce na funkcje od dodania textFielda do danych oceny konkretnego auta
            }
            //Lower buttons
            if(e.getSource()==buttonBack){
                myFrameNext.dispose();
                start();
            }
            if(e.getSource()==buttonConfirm){
                if(!(myTextFieldMark.getText().isEmpty() | myTextFieldModel.getText().isEmpty() | myTextFieldYearOfProduction.getText().isEmpty() | myTextFieldPriceForDay.getText().isEmpty())){
                    double price = Double.parseDouble(myTextFieldPriceForDay.getText());
                    short year = Short.parseShort(myTextFieldYearOfProduction.getText());
                    funcAddCar(myTextFieldMark.getText(), myTextFieldModel.getText(),price,year);
                    funcShowCars();
                    myFrameNext.dispose();
                    start();
                }
                else
                    System.out.println("Wypelnij puste pola.");


            }
        }
}
