import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class AddCarRating implements ActionListener {
    private final MyFrame myFrameNext;
    private final JButton buttonAddRating;
    private final JTextField textFieldID;
    private final JButton buttonIdPassRating;
    private final JLabel labelCheckIdRating;
    private final JComboBox comboBoxRating;
    private final JButton buttonBack;
    AddCarRating(){
        myFrameNext = new MyFrame();
        JLabel label = new JLabel("Dodaj ocene samochoduu: ");
        JPanel panelStart = new JPanel();
        panelStart.setBackground(new Color(0, 200, 0));
        panelStart.add(label, BorderLayout.CENTER);
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 200, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 2, 10, 5));
        JLabel LabelId = new JLabel("Wybierz ID samochodu: ");
        panel.add(LabelId);
        textFieldID = new JTextField();
        textFieldID.setSize(new Dimension(250, 40));
        textFieldID.setFont(new Font("Arctic", Font.PLAIN, 50));
        textFieldID.setForeground(Color.GREEN);
        textFieldID.setBackground(Color.BLACK);
        textFieldID.setCaretColor(Color.WHITE);
        panel.add(textFieldID);
        JLabel LB = new JLabel("");
        panel.add(LB);
        buttonIdPassRating = new JButton(" Sprawdz ");
        buttonIdPassRating.addActionListener(this);
        buttonIdPassRating.setBorder(BorderFactory.createEtchedBorder());
        buttonIdPassRating.setBackground(new Color(50, 120, 200));
        panel.add(buttonIdPassRating);
        labelCheckIdRating = new JLabel("");
        panel.add(labelCheckIdRating);
        String[] rating1_5 = {"1","2","3","4","5"};
        comboBoxRating = new JComboBox<String>(rating1_5);
        comboBoxRating.setBackground(Color.BLACK);
        comboBoxRating.setForeground(Color.GREEN);
        comboBoxRating.setFont(new Font("Arctic", Font.PLAIN, 50));
        comboBoxRating.setSize(new Dimension(250, 40));
        comboBoxRating.setVisible(false);
        panel.add(comboBoxRating);
//        JLabel labelCheckRating = new JLabel("");
        myFrameNext.add(panel,BorderLayout.CENTER);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0, 200, 0));
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new GridLayout(0, 4, 10, 5));
        buttonBack = new JButton(" Powrot ");
        buttonBack.addActionListener(this);
        buttonBack.setBackground(new Color(255,100,100));
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        panel2.add(buttonBack);
        JLabel lb1 = new JLabel();
        panel2.add(lb1);
        JLabel lb2 = new JLabel();
        panel2.add(lb2);
        buttonAddRating = new JButton(" Dodaj ocene: ");
        buttonAddRating.setBackground(new Color(0,255,0));
        buttonAddRating.setBorder(BorderFactory.createEtchedBorder());
        buttonAddRating.setSize(250,20);
        buttonAddRating.addActionListener(this);
        buttonAddRating.setVisible(false);
        panel2.add(buttonAddRating);
        myFrameNext.add(panel2, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonIdPassRating){
            if (textFieldID.getText().isEmpty()) {
                comboBoxRating.setVisible(false);
                buttonAddRating.setVisible(false);
                labelCheckIdRating.setText("Podaj liczbe identyfikatora");
            }
            else {
                int ID = Integer.parseInt(textFieldID.getText());
                if (GUI.funcSearchCar(ID) != null) {
                    labelCheckIdRating.setText("Na ile oceniasz pojazd? ");
                    comboBoxRating.setVisible(true);
                    buttonAddRating.setVisible(true);
                }
                else {
                    labelCheckIdRating.setText("Nie ma takiego ID ");
                    comboBoxRating.setVisible(false);
                    buttonAddRating.setVisible(false);
                }
            }
        }
        if(e.getSource()==buttonAddRating){
            int ID = Integer.parseInt(textFieldID.getText());
            GUI.Car car = GUI.funcSearchCar(ID);
            car.addRating(comboBoxRating.getSelectedIndex()+1);
            showMessageDialog(myFrameNext,"Dodano ocene samochodu do bazy");
            myFrameNext.dispose();
            new MenuGui();
        }
        //Lower buttons
        if(e.getSource()==buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
    }
}
