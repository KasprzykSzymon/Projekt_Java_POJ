//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class obliczKwoteWynajmu implements ActionListener {
//    MyFrame myFrame = new MyFrame(); //creates a myFrame
//    JTextField textFieldID;
//    JButton buttonIdPass;
//    JTextField textFieldIloscDni;
//    JButton buttonOblicz;
//    JButton buttonPowrot;
//
//
//        public obliczKwoteWynajmu(){
//
////             String obecnySamochod = "";
//            JLabel label = new JLabel("Oblicz kwote wynajmu: ");
//
//            JPanel panelStart =new JPanel();
//            panelStart.setBackground(new Color(0,200,0));
//            panelStart.add(label, BorderLayout.CENTER);
//            myFrame.add(panelStart, BorderLayout.NORTH);
//
//            JPanel panel = new JPanel();
//            panel.setBackground(new Color(0,200,0));
//            panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
//            panel.setLayout(new GridLayout(0,2,10,5));
//
//
//            JLabel LabelId = new JLabel("Wybierz ID Samochodu: ");
//            panel.add(LabelId);
//
//            textFieldID = new JTextField();
//            textFieldID.setSize(new Dimension(250,40));
//            textFieldID.setFont(new Font("Arctic", Font.PLAIN,35));
//            textFieldID.setForeground(Color.GREEN);
//            textFieldID.setBackground(Color.BLACK);
//            textFieldID.setCaretColor(Color.WHITE);
//            panel.add(textFieldID);
//
//
//            JLabel LB = new JLabel("");
//            panel.add(LB);
//
//            buttonIdPass = new JButton(" Sprawdz ");
//            buttonIdPass.addActionListener(this);
//            buttonIdPass.setBorder(BorderFactory.createEtchedBorder());
//            buttonIdPass.setBackground(new Color(50,120,200));
//            panel.add(buttonIdPass);
//
//
//            JLabel labelDni = new JLabel("Podaj na ile dni chcesz wypozyczyc: ");
//            labelDni.setVisible(false);
//            panel.add(labelDni);
//
//            textFieldIloscDni = new JTextField();
//            textFieldIloscDni.setSize(new Dimension(250,40));
//            textFieldIloscDni.setFont(new Font("Arctic", Font.PLAIN,35));
//            textFieldIloscDni.setForeground(Color.GREEN);
//            textFieldIloscDni.setBackground(Color.BLACK);
//            textFieldIloscDni.setCaretColor(Color.WHITE);
//            textFieldIloscDni.setVisible(false);
//            panel.add(textFieldIloscDni);
//
//
//            JLabel LBOblicz = new JLabel("");
//            LBOblicz.setVisible(false);
//            panel.add(LBOblicz);
//
//            buttonOblicz = new JButton(" Sprawdz ");
//            buttonOblicz.addActionListener(this);
//            buttonOblicz.setBorder(BorderFactory.createEtchedBorder());
//            buttonOblicz.setBackground(new Color(50,120,200));
//            buttonOblicz.setVisible(false);
//            panel.add(buttonOblicz);
//
//            myFrame.add(panel, BorderLayout.CENTER);
//
//            JPanel panel2 = new JPanel();
//            panel2.setBackground(new Color(0,200,0));
//            panel2.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
//            panel2.setLayout(new GridLayout(0,4,10,5));
//
//
//
//            buttonPowrot = new JButton(" Powrot ");
//            buttonPowrot.addActionListener(this);
//            buttonPowrot.setBackground(new Color(255,100,100));
//            buttonPowrot.setBorder(BorderFactory.createEtchedBorder());
//            buttonPowrot.setSize(250,20);
//            panel2.add(buttonPowrot);
//
//            myFrame.add(panel2, BorderLayout.SOUTH);
//
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e){
//            if(e.getSource()==buttonPowrot){
//                myFrame.dispose();
//                GUI gui = new GUI();
//            }
//            if(e.getSource()==buttonIdPass){
//                //Miejsce na instrukcje od sprawdzenia czy jest takie ID samochodu
//            }
//
//        }
//}
