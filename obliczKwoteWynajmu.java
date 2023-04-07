import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class obliczKwoteWynajmu implements ActionListener {
    MyFrame myFrame = new MyFrame(); //creates a myFrame
    JTextField textField;
    JButton buttonOblicz;


        public obliczKwoteWynajmu(){

            String obecnySamochod = "";
            JLabel label = new JLabel("Oblicz kwote wynajmu: ");
            
            
            JPanel panelStart =new JPanel();
            panelStart.setBackground(new Color(0,200,0));
          
            panelStart.add(label, BorderLayout.CENTER);
            
            myFrameStart.add(panelStart, BorderLayout.NORTH);

            JPanel panel = new JPanel();
          
            buttonOblicz = new JButton("Oblicz");
            panel.add(buttonOblicz);
            buttonOblicz.addActionListener(this);
            buttonOblicz.setBorder(BorderFactory.createEtchedBorder());
            buttonOblicz.setBackground(new Color(50,120,200));
          
            textField = new JTextField();
            texfField.background(Color.BLACK);
            panel.add(textField);
          
            myFrame.add(panel, BorderLayout.CENTER);
            panel.setBackground(new Color(0,200,0));
            panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
            panel.setLayout(new GridLayout(0,2,10,5));
            

            


        }
        }
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==buttonDodajSamochod){
                myFrameStart.dispose();
                DodajSamochod dodajSamochod = new DodajSamochod();
            }

        }
}
