import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class AddCarRating implements ActionListener {
    private final MyFrame myFrameNext = new MyFrame();
    private final MyLoverPanel panelEnd;
    private final MyButton buttonIdPassRating;
    private final MyTextField textFieldID;
    private final JLabel labelCheckIdRating;
    private final JComboBox comboBoxRating;

    AddCarRating(){
        //Initialization of variables
        myFrameNext.backItem.addActionListener(this);
        JPanel panelStart = new JPanel();
        JPanel panelMiddle = new JPanel();
        panelEnd = new MyLoverPanel(" Dodaj ocene: ");
        JLabel label = new JLabel("Dodaj ocene samochoduu: ");
        JLabel LabelId = new JLabel("Wybierz ID samochodu: ");
        textFieldID = new MyTextField();
        JLabel LB = new JLabel("");
        buttonIdPassRating = new MyButton(" Sprawdz ");
        buttonIdPassRating.addActionListener((ActionListener) this);
        labelCheckIdRating = new JLabel("");
        String[] rating1_5 = {"1","2","3","4","5"};
        comboBoxRating = new JComboBox<String>(rating1_5);
        //Changing elements in panelStart
        panelStart.setBackground(new Color(0, 200, 0));
        //Changing elements in panelMiddle
        panelMiddle.setBackground(new Color(0, 200, 0));
        panelMiddle.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panelMiddle.setLayout(new GridLayout(0, 2, 10, 5));
        buttonIdPassRating.setBackground(new Color(50, 120, 200));
        comboBoxRating.setBackground(Color.BLACK);
        comboBoxRating.setForeground(Color.GREEN);
        comboBoxRating.setFont(new Font("Arctic", Font.PLAIN, 50));
        comboBoxRating.setSize(new Dimension(250, 40));
        comboBoxRating.setVisible(false);
        //Changing elements in panelEnd
        panelEnd.buttonBack.addActionListener(this);
        panelEnd.buttonSecond.addActionListener( this);
        panelEnd.buttonSecond.setVisible(false);
        //Add elements to panels
        panelStart.add(label, BorderLayout.CENTER);
        panelMiddle.add(LabelId);
        panelMiddle.add(textFieldID);
        panelMiddle.add(LB);
        panelMiddle.add(buttonIdPassRating);
        panelMiddle.add(labelCheckIdRating);
        panelMiddle.add(comboBoxRating);
        //Add elements to frames
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        myFrameNext.add(panelMiddle,BorderLayout.CENTER);
        myFrameNext.add(panelEnd, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() ==myFrameNext.backItem){
            myFrameNext.dispose();
            new MenuGui();
        }
        if(e.getSource()==buttonIdPassRating){
            if (textFieldID.getText().isEmpty()) {
                comboBoxRating.setVisible(false);
                panelEnd.buttonSecond.setVisible(false);
                labelCheckIdRating.setText("Podaj liczbe identyfikatora");
            }
            else {
                int ID = Integer.parseInt(textFieldID.getText());
                if (GUI.funcSearchCar(ID) != null) {
                    labelCheckIdRating.setText("Na ile oceniasz pojazd? ");
                    comboBoxRating.setVisible(true);
                    panelEnd.buttonSecond.setVisible(true);
                }
                else {
                    labelCheckIdRating.setText("Nie ma takiego ID ");
                    comboBoxRating.setVisible(false);
                    panelEnd.buttonSecond.setVisible(false);
                }
            }
        }
        //Lower buttons
        if(e.getSource()==panelEnd.buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
        if(e.getSource()==panelEnd.buttonSecond){
            int ID = Integer.parseInt(textFieldID.getText());
            GUI.Car car = GUI.funcSearchCar(ID);
            car.addRating(comboBoxRating.getSelectedIndex()+1);
            showMessageDialog(myFrameNext,"Dodano ocene samochodu do bazy");
            myFrameNext.dispose();
            new MenuGui();
        }
    }
}
