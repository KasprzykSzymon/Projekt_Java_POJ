import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static javax.swing.JOptionPane.showMessageDialog;

public class AddRentCar implements ActionListener {
    private final JLabel labelStart;
    private final MyFrame myFrameNext;
    private final JTextField textFieldID;
    private final JButton buttonRentIdPass;
    private final JCheckBox checkBoxAddCarFromToday;
    private final JTextField textFieldRentDays;
    private final JButton buttonRentCalculate;
    private final JLabel labelRentCheck;
    private final JLabel labelStartRent;
    private final JTextField textFieldStartRent;
    private final JLabel labelRentStart;
    private final JLabel labelRentEnd;
    private final JButton buttonBack;
    private final JButton buttonConfirm;

    AddRentCar() {
        myFrameNext = new MyFrame();
        labelStart = new JLabel("Rezerwuj samochod: ");
        JPanel panelStart = new JPanel();
        panelStart.setBackground(new Color(0, 200, 0));
        panelStart.add(labelStart, BorderLayout.CENTER);
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 200, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1, 10, 5));
        JLabel LabelId = new JLabel("Wybierz ID samochodu: ");
        panel.add(LabelId);
        textFieldID = new JTextField();
        textFieldID.setSize(new Dimension(250, 50));
        textFieldID.setFont(new Font("Arctic", Font.PLAIN, 30));
        textFieldID.setForeground(Color.GREEN);
        textFieldID.setBackground(Color.BLACK);
        textFieldID.setCaretColor(Color.WHITE);
        panel.add(textFieldID);
        buttonRentIdPass = new JButton(" Sprawdz dostepnosc samochodu ");
        buttonRentIdPass.setSize(new Dimension(250, 20));
        buttonRentIdPass.addActionListener(this);
        buttonRentIdPass.setBorder(BorderFactory.createEtchedBorder());
        buttonRentIdPass.setBackground(new Color(50, 120, 200));
        panel.add(buttonRentIdPass);
        labelRentCheck = new JLabel("");
        panel.add(labelRentCheck);
        textFieldRentDays = new JTextField();
        textFieldRentDays.setSize(new Dimension(250, 50));
        textFieldRentDays.setFont(new Font("Arctic", Font.PLAIN, 30));
        textFieldRentDays.setForeground(Color.GREEN);
        textFieldRentDays.setBackground(Color.BLACK);
        textFieldRentDays.setCaretColor(Color.WHITE);
        textFieldRentDays.setVisible(false);
        panel.add(textFieldRentDays);
        myFrameNext.add(panel, BorderLayout.CENTER);
        checkBoxAddCarFromToday = new JCheckBox("Czy wypozyczasz od dziasiejszego dnia?");
        checkBoxAddCarFromToday.setBackground(new Color(0, 200, 0));
        checkBoxAddCarFromToday.setVisible(false);
        checkBoxAddCarFromToday.setSize(new Dimension(250, 20));
        panel.add(checkBoxAddCarFromToday);
        labelStartRent = new JLabel("*Data poczatkowa: (format daty dd.MM.yyyy)");
        labelStartRent.setVisible(false);
        panel.add(labelStartRent);
        textFieldStartRent = new JTextField();
        textFieldStartRent.setSize(new Dimension(250, 40));
        textFieldStartRent.setFont(new Font("Arctic", Font.PLAIN, 30));
        textFieldStartRent.setForeground(Color.GREEN);
        textFieldStartRent.setBackground(Color.BLACK);
        textFieldStartRent.setCaretColor(Color.WHITE);
        textFieldStartRent.setVisible(false);
        panel.add(textFieldStartRent);
        buttonRentCalculate = new JButton(" Sprawdz dni w wypozyczeniu ");
        buttonRentCalculate.setSize(new Dimension(250, 20));
        buttonRentCalculate.addActionListener(this);
        buttonRentCalculate.setBorder(BorderFactory.createEtchedBorder());
        buttonRentCalculate.setBackground(new Color(50, 120, 200));
        buttonRentCalculate.setVisible(false);
        panel.add(buttonRentCalculate);
        labelRentStart = new JLabel("");
        panel.add(labelRentStart);
        labelRentEnd = new JLabel("");
        panel.add(labelRentEnd);
        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(0, 200, 0));
        panel3.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel3.setLayout(new GridLayout(0, 4, 10, 5));
        buttonBack = new JButton(" Powrot ");
        buttonBack.addActionListener(this);
        buttonBack.setBackground(new Color(255,100,100));
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        buttonBack.setSize(250,20);
        panel3.add(buttonBack);
        JLabel lb1 = new JLabel();
        panel3.add(lb1);
        JLabel lb2 = new JLabel();
        panel3.add(lb2);
        buttonConfirm = new JButton(" Dodaj rezerwacje ");
        buttonConfirm.addActionListener(this);
        buttonConfirm.setBackground(new Color(0, 255, 0));
        buttonConfirm.setBorder(BorderFactory.createEtchedBorder());
        buttonConfirm.setSize(250,20);
        buttonConfirm.setVisible(false);
        panel3.add(buttonConfirm);
        myFrameNext.add(panel3, BorderLayout.SOUTH);
    }
    private String[] funcRentCar(Boolean fromToday,String textFieldStartRent, String day) {
        Calendar startDate = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        int days;
        if(day.isEmpty()){
            days=0;
        }
        else {
            days = Integer.parseInt(day);
        }
        if (fromToday){}
        else{
            try {
                Date date = dateFormat.parse(textFieldStartRent);
                startDate.setTime(date);
                startDate.add(Calendar.DATE, days);
            }
            catch (ParseException e) {
                showMessageDialog(myFrameNext,"Nieprawidlowy format daty!");
                return null;
            }
        }
        Calendar endDate = (Calendar) startDate.clone();
        endDate.add(Calendar.DATE, days);
        return new String[] {dateFormat.format(startDate.getTime()), dateFormat.format(endDate.getTime())};
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonRentIdPass) {
            labelStart.setText("Rezerwuj samochod: ");
            buttonConfirm.setVisible(false);
            if (textFieldID.getText().isEmpty()) {
                textFieldRentDays.setVisible(false);
                buttonRentCalculate.setVisible(false);
                checkBoxAddCarFromToday.setVisible(false);
                labelStartRent.setVisible(false);
                textFieldStartRent.setVisible(false);
                labelRentCheck.setText("Podaj liczbe identyfikatora");
                labelRentStart.setText("");
                labelRentEnd.setText("");
            }
            else {
                int ID = Integer.parseInt(textFieldID.getText());
                GUI.Car car = GUI.funcSearchCar(ID);
                if ( GUI.funcSearchCar(ID)!= null) {
                    labelStart.setText("Rezerwuj samochod: " + car.getMark()+" "+car.getModel()+ " " + car.getYearOfProduction());
                    labelRentCheck.setText("Na ile dni wypozyczasz: ");
                    textFieldRentDays.setVisible(true);
                    buttonRentCalculate.setVisible(true);
                    checkBoxAddCarFromToday.setVisible(true);
                    labelStartRent.setVisible(true);
                    textFieldStartRent.setVisible(true);
                }
                else {
                    labelRentCheck.setText("Nie ma takiego ID ");
                    textFieldRentDays.setVisible(false);
                    buttonRentCalculate.setVisible(false);
                    checkBoxAddCarFromToday.setVisible(false);
                    labelStartRent.setVisible(false);
                    textFieldStartRent.setVisible(false);
                    labelRentStart.setText("");
                    labelRentEnd.setText("");
                }
            }
        }

        if(e.getSource()==buttonRentCalculate){
            if(textFieldRentDays.getText().isEmpty()){
                showMessageDialog(myFrameNext,"Podaj ilosc dni! ");
            }
            else{
                String[] date = funcRentCar(!checkBoxAddCarFromToday.isSelected(),textFieldStartRent.getText(),textFieldRentDays.getText());
                labelRentStart.setText("Rezerwacja zaczyna sie od:  "  + date[0]);
                labelRentEnd.setText("Rezerwacja konczy sie:  " + date[1]);
                buttonConfirm.setVisible(true);
            }
        }
        if(e.getSource()==buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
        if (e.getSource() == buttonConfirm) {
            showMessageDialog(myFrameNext, "Instrukcja dodawania rezerwacji samochodu! ");
        }
    }
}