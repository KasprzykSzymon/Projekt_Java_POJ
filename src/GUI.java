import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class GUI{
    public static void main(String[] args){ new GUI(); }
    public GUI(){
        //Car.createDatabase();
        MenuGui.loadDataFromFile();
        new MenuGui();
    }
    public static ArrayList<Car> Cars = new ArrayList<>();
    private static int nextId = 1;

    public static Car funcSearchCar(int id) {
        for (Car Car : Cars) {
            if (Car.getId() == id) {
                return Car;
            }
        }
        return null;
    }
    static class Car {
        public static Connection connection;
        private final int id;
        private final String mark;
        private final String model;
        private final double price;
        private final short yearOfProduction;
        public final ArrayList<Integer> ratings;
        public ArrayList<String> rentCar = new ArrayList<>();
        public Car(String mark, String model, double price, short yearOfProduction) {
            this.id = nextId++;
            this.mark = mark;
            this.model = model;
            this.price = price;
            this.yearOfProduction = yearOfProduction;
            this.ratings = new ArrayList<>();
        }
        public int getId() { return id; }
        public String getMark() {
            return mark;
        }
        public String getModel() {
            return model;
        }
        public double getPrice() {
            return price;
        }
        public short getYearOfProduction() { return  yearOfProduction;}
        public double funcCalculateTheCostOfRent(MyFrame frame, int days) {
            if(days < 7) return price * days;
            if(days < 14){
                String messege = "Dodano rabat 10%. Za wynajem na "  + days +  " dni  ";
                showMessageDialog(frame, messege);
                return price * days * 0.9;
            }
            String messege = "Dodano rabat 15%. Za wynajem na " + days + " dni";
            showMessageDialog(frame, messege);
            return price * days * 0.85;
        }
        public void addRating(int rating) {
            ratings.add(rating);
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
    public boolean AddRentCar(MyFrame frame, String rentDays, int days){
            for(String dayInRent : rentCar){
                if(checkTheDate(dayInRent,rentDays,days)){
                    String[] rent = AddRentCar.funcRentCar(true ,dayInRent.substring(0,10), dayInRent.substring(11));
                    showMessageDialog(frame, rent[0]+ " do "+rent[1] + "\nTen termin jest zajety!");
                    return false;
                }
            }
            String add = rentDays + " " + String.format("%4d", days);
        rentCar.add(add);
        return true;
    }
        public boolean checkTheDate(String startRentDays, String checkDate, int d2) {
            int d1 = MenuGui.stringToInteger(startRentDays.substring(11));
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date startDate = null;
            Date start2Date = null;
            try {
                startDate = dateFormat.parse(startRentDays.substring(0, 10));
                start2Date = dateFormat.parse(checkDate);
            }
            catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Calendar startDate1 = Calendar.getInstance();
            startDate1.setTime(startDate);
            for (int i = 0; i < d1; i++) {
                startDate1.add(Calendar.DATE,1);
                Calendar startDate2 = Calendar.getInstance();
                startDate2.setTime(start2Date);
                for (int j = 0; j < d2; j++) {
                    startDate2.add(Calendar.DATE, 1);
                    if(check(startDate1.getTime(),startDate2.getTime()))
                        return true;
                }
            }
            return false;
        }
        private boolean check(Date d1, Date d2){
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String strD1 = dateFormat.format(d1);
            String strD2 = dateFormat.format(d2);
            return strD1.equals(strD2);
        }
        /*
        public static void createDatabase() {
            try {
                // Rejestrujemy sterownik JDBC
                Class.forName("oracle.jdbc.driver.OracleDriver");

                // Ustanowienie połączenia z bazą danych
                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        public static void connectToDatabase() {
            try {
                // Ustanowienie połączenia z bazą danych
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars_database", "borgon1999@gmail.com", "!Student2021");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void insertIntoDatabase() {
            try {
                // Wstawienie danych samochodu do tabeli Car w bazie danych
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO Car (id, mark, model, price, yearOfProduction) VALUES (?, ?, ?, ?, ?)");
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, mark);
                preparedStatement.setString(3, model);
                preparedStatement.setDouble(4, price);
                preparedStatement.setShort(5, yearOfProduction);
                preparedStatement.executeUpdate();

                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void addCarToDatabase(String mark, String model, double price, short yearOfProduction) {
            connectToDatabase();

            Car car = new Car(mark, model, price, yearOfProduction);
            car.insertIntoDatabase();
        }*/
    }
}