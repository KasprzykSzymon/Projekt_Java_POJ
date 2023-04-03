import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame frame = new JFrame(); //creates a frame
    MyFrame myFrame = new MyFrame();
    JButton button;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;


        public GUI(){

            JLabel label = new JLabel("Wypozyczalnia samochodow firmy: Firma");
            button = new JButton("Dodaj samochod");
            button2 = new JButton("Wyswietl samochody");
            button3 = new JButton("Rezerwuj samochod");
            button4 = new JButton("Oblicz koszt wynajmu samochodu");
            button5 = new JButton("Ocen samochod");
            button6 = new JButton("Wyswietl oceny samochodow");
            button7 = new JButton("Wyjscie");


            JPanel  panel = new JPanel();

            myFrame.add(panel, BorderLayout.CENTER);
            panel.setBackground(new Color(0,200,0));
            panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
            panel.setLayout(new GridLayout(0,1,10,5));

            panel.add(label, BorderLayout.CENTER);

            panel.add(button);
            button.addActionListener(this);
            button.setBorder(BorderFactory.createEtchedBorder());
            button.setBackground(new Color(50,120,200));

            panel.add(button2);
            button2.addActionListener(this);
            button2.setBorder(BorderFactory.createEtchedBorder());
            button2.setBackground(new Color(50,120,200));

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

            panel.add(button7);
            button7.addActionListener(this);
            button7.setBorder(BorderFactory.createEtchedBorder());
            button7.setBackground(new Color(50,120,200));



        }

        public static void main(String[] args){
            new GUI();
        }
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==button){
                myFrame.dispose();
                DodajSamochod dodajSamochod = new DodajSamochod();
            }

        }
}
