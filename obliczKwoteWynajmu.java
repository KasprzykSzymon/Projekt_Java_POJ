import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class obliczKwoteWynajmu implements ActionListener {
    MyFrame myFrame = new MyFrame(); //creates a myFrame
    JTextField textField;
    JButton buttonOblicz;
    JButton buttonPowrot;


        public obliczKwoteWynajmu(){

//             String obecnySamochod = "";
            JLabel label = new JLabel("Oblicz kwote wynajmu: ");
            
            JPanel panelStart =new JPanel();
            panelStart.setBackground(new Color(0,200,0));
          
            panelStart.add(label, BorderLayout.CENTER);
            
            myFrame.add(panelStart, BorderLayout.NORTH);

            JPanel panel = new JPanel();
            panel.setBackground(new Color(0,200,0));
            panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
            panel.setLayout(new GridLayout(0,2,10,5));
          
            buttonOblicz = new JButton("Oblicz");
            
            buttonOblicz.addActionListener(this);
            buttonOblicz.setBorder(BorderFactory.createEtchedBorder());
            buttonOblicz.setBackground(new Color(50,120,200));
            panel.add(buttonOblicz);
            
            textField = new JTextField();
            textField.setPreferredSize(new Dimension(250,40));
            textField.setFont(new Font("Arctic", Font.PLAIN,35));
            textField.setForeground(Color.GREEN);
            textField.setBackground(Color.BLACK);
            textField.setCaretColor(Color.WHITE);
            panel.add(textField);
         
            myFrame.add(panel, BorderLayout.CENTER);
            
            
            JPanel panel2 = new JPanel();
            panel2.setBackground(new Color(0,200,0));
            panel2.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
            panel2.setLayout(new GridLayout(0,4,10,5));
            
            myFrame.add(panel2, BorderLayout.SOUTH);

            buttonPowrot = new JButton(" Powrot ");
            buttonPowrot.addActionListener(this);
            buttonPowrot.setBackground(new Color(255,100,100));
            buttonPowrot.setBorder(BorderFactory.createEtchedBorder());
            buttonPowrot.setSize(250,20);
            panel2.add(buttonPowrot);

        
        }

        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==buttonPowrot){
                myFrame.dispose();
                GUI gui = new GUI();
            }
        
        }
}
