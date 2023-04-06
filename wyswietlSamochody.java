import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wyswietlSamochody implements ActionListener {
    MyFrame myFrame = new MyFrame();
    JButton buttonPowrot ;
    JComboBox comboBoxWyswietlSampchody;
    wyswietlSamochody(){
        JPanel panelStart = new JPanel();
        panelStart.setBackground(Color.GREEN);

        myFrame.add(panelStart, BorderLayout.NORTH);

        JLabel centerLabel = new JLabel("Obecne samochody:");
        panelStart.add(centerLabel);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.GREEN);

        comboBoxWyswietlSampchody = new JComboBox();
        comboBoxWyswietlSampchody.setBackground(Color.GREEN);


        panel1.add(comboBoxWyswietlSampchody);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0,200,0));
        myFrame.add(panel2, BorderLayout.SOUTH);
//                panel2.setPreferredSize(new Dimension(100,100));
        panel2.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel2.setLayout(new GridLayout(0,4,10,5));

        buttonPowrot = new JButton(" Powrot ");
        buttonPowrot.addActionListener(this);
        buttonPowrot.setBackground(new Color(255,100,100));
        buttonPowrot.setBorder(BorderFactory.createEtchedBorder());
        buttonPowrot.setSize(250,20);
        panel2.add(buttonPowrot);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonPowrot){
            myFrame.dispose();
            GUI gui = new GUI();
        }

    }
}
