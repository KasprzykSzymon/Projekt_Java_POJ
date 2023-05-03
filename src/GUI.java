import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static javax.swing.JOptionPane.showMessageDialog;

public class GUI{
    public static void main(String[] args){ new GUI(); }
    public GUI(){ new MenuGui(); }

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
        private final int id;
        private final String mark;
        private final String model;
        private final double price;
        private final short yearOfProduction;
        private final ArrayList<Integer> ratings;
        private ArrayList<String> rentCar = new ArrayList<>();
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
                String messege = "Dodano rabat 10%. Za wynajem \" + days + \" dni  ";
                showMessageDialog(frame, messege);
                return price * days * 0.9;
            }
            String messege = "Dodano rabat 15%. Za wynajem \" + days + \" dni";
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

    public void AddRentCar(MyFrame frame, String rentDays, int days){
            for(String daysInRent : rentCar){
                if(checkTheDate(frame, daysInRent)){
                    String rent = daysInRent;
                    showMessageDialog(frame, rent);
                  return;
                }
            }
            String add = rentDays + " " + String.format("%4d", days);
        rentCar.add(add);
    }

    public boolean checkTheDate(MyFrame frame,String startRentDays){
        String start = startRentDays.substring(0, 10);
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date startDate = null;
        try {
            startDate = dateFormat.parse(startRentDays.substring(0, 10));
        }
        catch (ParseException e) {
            showMessageDialog(frame, "Ten termin jest zajety!");
            throw new RuntimeException(e);
        }
        Calendar endDate = (Calendar) startDate.clone();
        int days = Integer.parseInt(startRentDays.substring(startRentDays. length() - 4));
        endDate.add(Calendar.DATE, days);
        for(int i=0;i<days;i++){
            endDate.add(Calendar.DATE, 1);
        }
        return true;
    }

    }
}