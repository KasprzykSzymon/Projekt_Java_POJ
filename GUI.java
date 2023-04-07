import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    MyFrame myFrameStart = new MyFrame(); //creates a myFrane
    JButton buttonDodajSamochod;
    JButton buttonWyswietlSamochody;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton exitButton;
    Wypozyczalnia firma= new Wypozyczalnia();

        public GUI(){

            JLabel label = new JLabel("Wypozyczalnia samochodow firmy: Firma");
            buttonDodajSamochod = new JButton("Dodaj samochod");
            buttonWyswietlSamochody = new JButton("Wyswietl samochody");
            button3 = new JButton("Rezerwuj samochod");
            button4 = new JButton("Oblicz koszt wynajmu samochodu");
            button5 = new JButton("Ocen samochod");
            button6 = new JButton("Wyswietl oceny samochodow");
            exitButton = new JButton("Wyjscie");


            JPanel  panel = new JPanel();

            myFrameStart.add(panel, BorderLayout.CENTER);
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

            panel.add(button4);
            button4.addActionListener(this);
            button4.setBorder(BorderFactory.createEtchedBorder());
            button4.setBackground(new Color(50,120,200));

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
//                myFrameStart.dispose();
                DodajSamochod dodajSamochod = new DodajSamochod();
            }
            if(e.getSource()==buttonWyswietlSamochody){
//                myFrameStart.dispose();
                wyswietlSamochody wyswietlSamochody = new wyswietlSamochody();
            }
            if(e.getSource()==button4){
//                myFrameStart.dispose();
                obliczKwoteWynajmu obliczKwoteWynajmu = new obliczKwoteWynajmu();
            }

            if(e.getSource()==exitButton)
                System.exit(0);

        }
}
