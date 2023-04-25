import java.util.ArrayList;

public class GUI{
    public static void main(String[] args){ new GUI(); }
    public GUI(){ new MenuGui(); }

    public static ArrayList<Car> Cars = new ArrayList<Car>();
    private static int nextId = 1;
    public static String funcShowCars() {
        String listCars = "";
        for(Car car : Cars) {
            listCars += "ID:   " + car.id + "   \t" + car.mark + "\t  " + car.model + "\t " + car.yearOfProduction + "\n";
        }
          return listCars;
    }
    public static Car funcSearchCar(int id) {
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
        public double getPrice() {
            return price;
        }
        public short getYearOfProduction() { return  yearOfProduction;}
        public boolean getAvailability() {
            return availability;
        }
        public void Rent() {
            availability = false;
        }
        public double funcCalculateTheCostOfRent(int days) {
            if(days < 7) return price * days;
            if(days < 14){
                System.out.println("Dodano rabat 10%. Za wynajem " + days + " dni ");
                return price * days * 0.9;
            }
            System.out.println("Dodano rabat 15%. Za wynajem " + days + " dni");
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
    }
}