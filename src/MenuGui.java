import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGui implements ActionListener {
    private final MyFrame myFrameGUI;
    private final MyButtonMenu buttonAddCar,buttonShowCar,buttonReserveACars,buttonCalculateCost,buttonAddRatingCar,buttonShowCarsRating,exitButton;

    MenuGui() {
        //Initialization of variables
        myFrameGUI = new MyFrame();
        JLabel label = new JLabel("Wypozyczalnia samochodow firmy: Firma ");
        buttonAddCar = new MyButtonMenu("Dodaj samochod");
        buttonShowCar = new MyButtonMenu("Wyswietl samochody");
        buttonReserveACars = new MyButtonMenu("Rezerwuj samochod");
        buttonCalculateCost = new MyButtonMenu("Oblicz koszt wynajmu samochodu");
        buttonAddRatingCar = new MyButtonMenu("Ocen samochod");
        buttonShowCarsRating = new MyButtonMenu("Wyswietl oceny samochodow");
        exitButton = new MyButtonMenu("Wyjscie");
        JPanel panel = new JPanel();
        //Add elements to panel
        panel.setBackground(new Color(0, 200, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1, 10, 5));
        //Add elements to panel
        panel.add(label, BorderLayout.CENTER);
        panel.add(buttonAddCar);
        panel.add(buttonShowCar);
        panel.add(buttonReserveACars);
        panel.add(buttonCalculateCost);
        panel.add(buttonAddRatingCar);
        panel.add(buttonShowCarsRating);
        panel.add(exitButton);
        //Add elements to frame
        myFrameGUI.add(panel, BorderLayout.CENTER);
    }
    private class MyButtonMenu extends JButton{
        MyButtonMenu(String text){
            this.addActionListener((ActionListener) this);
            this.setBorder(BorderFactory.createEtchedBorder());
            this.setBackground(new Color(50, 120, 200));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAddCar) {
            myFrameGUI.dispose();
            new AddCars();
        }
        if (e.getSource() == buttonShowCar) {
            myFrameGUI.dispose();
            new ShowCars();
        }
        if (e.getSource() == buttonReserveACars) {
            myFrameGUI.dispose();
            new AddRentCar();
        }
        if (e.getSource() == buttonCalculateCost) {
            myFrameGUI.dispose();
            new CalculateAmountOfRent();
        }
        if (e.getSource() == buttonAddRatingCar) {
            myFrameGUI.dispose();
            new AddCarRating();
        }
        if (e.getSource() == buttonShowCarsRating) {
            myFrameGUI.dispose();
            new ShowRatingsCars();
        }
        if (e.getSource() == exitButton)
            System.exit(0);
    }
}


