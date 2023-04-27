import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGui implements ActionListener {
    private final MyFrame myFrameGUI;
    private final JButton buttonAddCar;
    private final JButton buttonShowCar;
    private final JButton buttonReserveACars;
    private final JButton buttonCalculateCost;
    private final JButton buttonAddRatingCar;
    private final JButton buttonShowCarsRating;
    private final JButton exitButton;

    MenuGui() {
        myFrameGUI = new MyFrame();
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