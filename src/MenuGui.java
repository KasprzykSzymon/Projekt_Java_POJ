import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MenuGui implements ActionListener {
    private static MyFrame myFrameGUI;
    private final JButton buttonAddCar,buttonShowCar,buttonReserveACars,buttonCalculateCost,buttonAddRatingCar,buttonShowCarsRating,exitButton;
    MenuGui() {
        myFrameGUI = new MyFrame();
        myFrameGUI.editMenu.setVisible(false);
        JLabel label = new JLabel("Wypozyczalnia samochodow firmy: Firma ");
        buttonAddCar = new JButton("Dodaj samochod");
        buttonShowCar = new JButton("Wyswietl samochody");
        buttonReserveACars = new JButton("Rezerwuj samochod");
        buttonCalculateCost = new JButton("Oblicz koszt wynajmu samochodu");
        buttonAddRatingCar = new JButton("Ocen samochod");
        buttonShowCarsRating = new JButton("Wyswietl oceny samochodow");
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
    protected static void loadDataFromFile() {

        try {
            String[] parametrs, ratings, rents;
            BufferedReader reader = new BufferedReader(new FileReader("samochody.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                parametrs = line.split("`");
                GUI.Car car = new GUI.Car(parametrs[0], parametrs[1], Double.parseDouble(parametrs[2]), Short.parseShort(parametrs[3]));
                GUI.Cars.add(car);
                if (parametrs.length > 4 && !parametrs[4].isEmpty()) {
                    ratings = parametrs[4].split("//");
                    for (String rating : ratings) {
                        if (!rating.isEmpty()) {
                            car.addRating(Integer.parseInt(rating));
                        }
                    }
                    if (parametrs.length > 5 && !parametrs[5].isEmpty()) {
                        rents = parametrs[5].split(",,");
                        for (String rent : rents) {
                            if (!rent.isEmpty()) {
                                String date = rent.substring(0, 10);
                                int duration = stringToInteger(rent.substring(11, 15));
                                car.AddRentCar(myFrameGUI, date, duration);
                            }
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /*  try {
          String[] parametrs, ratings, rents;
          BufferedReader reader = new BufferedReader(new FileReader("samochody.txt"));
          String line;
          while ((line = reader.readLine()) != null) {
              parametrs = line.split("`");
              GUI.Car Car = new GUI.Car(parametrs[0], parametrs[1], Double.parseDouble(parametrs[2]), Short.parseShort(parametrs[3]));
              GUI.Cars.add(Car);
              if(parametrs.length > 4 & parametrs[4]!="") {
                  ratings = parametrs[4].split("//");
                  for (int i = 0; i < ratings.length; i++) {
                      Car.addRating(Integer.parseInt(ratings[i]));
                  }
                  if(parametrs.length > 5& parametrs[5]!=""){
                      rents = parametrs[5].split(",,");
                      for(int i = 0; i< rents.length;i++)
                          Car.AddRentCar(myFrameGUI ,rents[i].substring(0,10), stringToInteger(rents[i].substring(11,15)));
                  }
              }
          }
          reader.close();
      } catch (IOException ex) {
          ex.printStackTrace();
      }
  }*/
    protected static int stringToInteger(String S){
        char numbers[] = {'1','2','3','4','5','6','7','8','9','0'};
        for (int i = 0; i<S.length()-1;i++){
            for(char s : numbers)
                if(S.charAt(i) == s)
                    return Integer.valueOf(S.substring(i,S.length()));
        }
        return 0;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonAddCar){
            myFrameGUI.dispose();
            new AddCars();
        }
        if(e.getSource()==buttonShowCar){
            myFrameGUI.dispose();
            new ShowCars();
        }
        if(e.getSource()==buttonReserveACars){
            myFrameGUI.dispose();
            new AddRentCar();
        }
        if(e.getSource()==buttonCalculateCost){
            myFrameGUI.dispose();
            new CalculateAmountOfRent();
        }
        if(e.getSource()==buttonAddRatingCar){
            myFrameGUI.dispose();
            new AddCarRating();
        }
        if(e.getSource()==buttonShowCarsRating){
            myFrameGUI.dispose();
            new ShowRatingsCars();
        }
        if (e.getSource() == exitButton)
            System.exit(0);
    }
}