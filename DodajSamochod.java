import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajSamochod implements ActionListener {
        MyFrame myFrame = new MyFrame();

        JLabel Label = new JLabel("Marka:  \t");
        JTextField myTextField = new JTextField();
        JButton Button = new JButton("Zatwierdz dodanie samochodu");

        DodajSamochod(){
                JPanel panel = new JPanel();
                myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                myFrame.setSize(500,500);
                myFrame.setLayout(null);
                myFrame.setVisible(true);

                panel.setBackground(new Color(0,200,0));
                panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
                panel.setLayout(new GridLayout(0,2,10,5));

                panel.add(Label);
                panel.add(myTextField);
                panel.setBackground(Color.GRAY);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
}
