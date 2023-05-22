import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class AddCarRating implements ActionListener {
    private final MyFrame myFrameNext;
    private final JButton buttonIdPassRating, buttonAddRating;
    private final MyTextField textFieldID;
    private final JLabel labelCheckIdRating;
    private final JComboBox comboBoxRating;
    private final JButton buttonBack;
    AddCarRating(){
        //Initialization of variables
        myFrameNext = new MyFrame();
        JPanel panelStart = new JPanel();
        JPanel panelMiddle = new JPanel();
        JPanel panelEnd = new JPanel();
        JLabel label = new JLabel("Dodaj ocene samochoduu: ");
        JLabel LabelId = new JLabel("Wybierz ID samochodu: ");
        textFieldID = new MyTextField();
        JLabel LB = new JLabel("");
        buttonIdPassRating = new JButton(" Sprawdz ");
        buttonIdPassRating.setBackground(new Color(0,255,0));
        buttonIdPassRating.setBorder(BorderFactory.createEtchedBorder());
        buttonIdPassRating.setSize(250,20);
        buttonIdPassRating.addActionListener((ActionListener) this);
        labelCheckIdRating = new JLabel("");
        String[] rating1_5 = {"1","2","3","4","5"};
        comboBoxRating = new JComboBox<String>(rating1_5);
        buttonBack = new JButton(" Powrot ");
        buttonBack.addActionListener((ActionListener) this);
        buttonBack.setBackground(new Color(255,100,100));
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        buttonBack.setSize(250,20);
        JLabel lb1 = new JLabel();
        JLabel lb2 = new JLabel();
        buttonAddRating = new JButton(" Dodaj ocene: ");
        buttonAddRating.setBackground(new Color(0,255,0));
        buttonAddRating.setBorder(BorderFactory.createEtchedBorder());
        buttonAddRating.setSize(250,20);
        buttonAddRating.addActionListener((ActionListener) this);
        //Changing elements in panelStart
        panelStart.setBackground(new Color(0, 200, 0));
        //Changing elements in panelMiddle
        panelMiddle.setBackground(new Color(0, 200, 0));
        panelMiddle.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panelMiddle.setLayout(new GridLayout(0, 2, 10, 5));
        //Changing elements in panelEnd
        buttonIdPassRating.setBackground(new Color(50, 120, 200));
        comboBoxRating.setBackground(Color.BLACK);
        comboBoxRating.setForeground(Color.GREEN);
        comboBoxRating.setFont(new Font("Arctic", Font.PLAIN, 50));
        comboBoxRating.setSize(new Dimension(250, 40));
        comboBoxRating.setVisible(false);
        panelEnd.setBackground(new Color(0, 200, 0));
        panelEnd.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panelEnd.setLayout(new GridLayout(0, 4, 10, 5));
        buttonAddRating.setVisible(false);
        //Add elements to panels
        panelStart.add(label, BorderLayout.CENTER);
        panelMiddle.add(LabelId);
        panelMiddle.add(textFieldID);
        panelMiddle.add(LB);
        panelMiddle.add(buttonIdPassRating);
        panelMiddle.add(labelCheckIdRating);
        panelMiddle.add(comboBoxRating);
        panelEnd.add(buttonBack);
        panelEnd.add(lb1);
        panelEnd.add(lb2);
        panelEnd.add(buttonAddRating);
        //Add elements to frames
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        myFrameNext.add(panelMiddle,BorderLayout.CENTER);
        myFrameNext.add(panelEnd, BorderLayout.SOUTH);
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
