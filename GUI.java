import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    MyFrame myFrameGUI = new MyFrame(); //creates a myFrane
    JButton buttonDodajSamochod;
    JButton buttonWyswietlSamochody;
    JButton button3;
    JButton buttonCalculateCost;
    JButton button5;
    JButton button6;
    JButton exitButton;

        public GUI(){

            JLabel label = new JLabel("Wypozyczalnia samochodow firmy: Firma");
            buttonDodajSamochod = new JButton("Dodaj samochod");
            buttonWyswietlSamochody = new JButton("Wyswietl samochody");
            button3 = new JButton("Rezerwuj samochod");
            buttonCalculateCost = new JButton("Oblicz koszt wynajmu samochodu");
            button5 = new JButton("Ocen samochod");
            button6 = new JButton("Wyswietl oceny samochodow");
            exitButton = new JButton("Wyjscie");


            JPanel  panel = new JPanel();

            myFrameGUI.add(panel, BorderLayout.CENTER);
            panel.setBackground(new Color(0,200,0));
            panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
            panel.setLayout(new GridLayout(0,1,10,5));

            panel.add(label, BorderLayout.CENTER);

            panel.add(buttonDodajSamochod);
            buttonDodajSamochod.addActionListener(this);
            buttonDodajSamochod.setBorder(BorderFactory.createEtchedBorder());
            buttonDodajSamochod.setBackground(new Color(50,120,200));

            panel.add(buttonWyswietlSamochody);
            buttonWyswietlSamochody.addActionListener(this);
            buttonWyswietlSamochody.setBorder(BorderFactory.createEtchedBorder());
            buttonWyswietlSamochody.setBackground(new Color(50,120,200));

            panel.add(button3);
            button3.addActionListener(this);
            button3.setBorder(BorderFactory.createEtchedBorder());
            button3.setBackground(new Color(50,120,200));

            panel.add(buttonCalculateCost);
            buttonCalculateCost.addActionListener(this);
            buttonCalculateCost.setBorder(BorderFactory.createEtchedBorder());
            buttonCalculateCost.setBackground(new Color(50,120,200));

            panel.add(button5);
            button5.addActionListener(this);
            button5.setBorder(BorderFactory.createEtchedBorder());
            button5.setBackground(new Color(50,120,200));

            panel.add(button6);
            button6.addActionListener(this);
            button6.setBorder(BorderFactory.createEtchedBorder());
            button6.setBackground(new Color(50,120,200));

            panel.add(exitButton);
            exitButton.addActionListener(this);
            exitButton.setBorder(BorderFactory.createEtchedBorder());
            exitButton.setBackground(new Color(50,120,200));



        }

        public static void main(String[] args){
            Wypozyczalnia wypozyczalnia = new Wypozyczalnia();
            new GUI();

        }
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==buttonDodajSamochod){
                myFrameGUI.dispose();
                DodajSamochod addCar = new DodajSamochod();
            }
            if(e.getSource()==buttonWyswietlSamochody){
                myFrameGUI.dispose();
                wyswietlSamochody viewCars = new wyswietlSamochody();
            }
            if(e.getSource()==buttonCalculateCost){
                myFrameGUI.dispose();
                obliczKwoteWynajmu obliczKwoteWynajmu = new obliczKwoteWynajmu();
            }

            if(e.getSource()==exitButton)
                System.exit(0);

        }
}
