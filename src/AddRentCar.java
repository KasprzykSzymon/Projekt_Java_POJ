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
    private final MyFrame myFrameNext = new MyFrame();
    private final MyLoverPanel panelEnd;
    private final JLabel labelStart, labelRentCheck, labelStartRent, labelRentStart, labelRentEnd;
    private final MyTextField textFieldID, textFieldRentDays, textFieldStartRent;
    private final MyButton buttonRentIdPass, buttonRentCalculate;
    private final JCheckBox checkBoxAddCarFromToday;
    AddRentCar() {
        //Initialization of variables
        myFrameNext.backItem.addActionListener(this);
        JPanel panelStart = new JPanel();
        JPanel panelMiddle = new JPanel();
        panelEnd = new MyLoverPanel(" Dodaj rezerwacje ");
        labelStart = new JLabel("Rezerwuj samochod: ");
        JLabel LabelId = new JLabel("Wybierz ID samochodu: ");
        textFieldID = new MyTextField();
        buttonRentIdPass = new MyButton(" Sprawdz dostepnosc samochodu ");
        labelRentCheck = new JLabel("");
        textFieldRentDays = new MyTextField();
        checkBoxAddCarFromToday = new JCheckBox("Czy wypozyczasz nie od dziasiejszego dnia?");
        labelStartRent = new JLabel("*Data poczatkowa: (format daty dd.MM.yyyy)");
        textFieldStartRent = new MyTextField();
        buttonRentCalculate = new MyButton(" Sprawdz dni w wypozyczeniu ");
        labelRentStart = new JLabel("");
        labelRentEnd = new JLabel("");
        //Changing elements in panelStart
        panelStart.setBackground(new Color(0, 200, 0));
        //Changing elements in panel
        panelMiddle.setBackground(new Color(0, 200, 0));
        panelMiddle.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panelMiddle.setLayout(new GridLayout(0, 1, 10, 5));
        textFieldID.setSize(new Dimension(250, 50));
        textFieldID.setFont(new Font("Arctic", Font.PLAIN, 30));
        buttonRentIdPass.addActionListener((ActionListener) this);
        textFieldRentDays.setSize(new Dimension(250, 50));
        textFieldRentDays.setFont(new Font("Arctic", Font.PLAIN, 30));
        textFieldRentDays.setVisible(false);
        checkBoxAddCarFromToday.setBackground(new Color(0, 200, 0));
        checkBoxAddCarFromToday.setVisible(false);
        checkBoxAddCarFromToday.setSize(new Dimension(250, 20));
        labelStartRent.setVisible(false);
        textFieldStartRent.setFont(new Font("Arctic", Font.PLAIN, 30));
        textFieldStartRent.setVisible(false);
        buttonRentCalculate.addActionListener((ActionListener) this);
        buttonRentCalculate.setVisible(false);
        //Changing elements in panelEnd
        panelEnd.setBackground(new Color(0, 200, 0));
        panelEnd.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panelEnd.setLayout(new GridLayout(0, 4, 10, 5));
        panelEnd.buttonBack.addActionListener((ActionListener) this);
        panelEnd.buttonSecond.addActionListener((ActionListener) this);
        panelEnd.buttonSecond.setVisible(false);
        //Add elements to panels
        panelStart.add(labelStart, BorderLayout.CENTER);
        panelMiddle.add(LabelId);
        panelMiddle.add(textFieldID);
        panelMiddle.add(buttonRentIdPass);
        panelMiddle.add(labelRentCheck);
        panelMiddle.add(textFieldRentDays);
        panelMiddle.add(checkBoxAddCarFromToday);
        panelMiddle.add(labelStartRent);
        panelMiddle.add(textFieldStartRent);
        panelMiddle.add(buttonRentCalculate);
        panelMiddle.add(labelRentStart);
        panelMiddle.add(labelRentEnd);
        //Add elements to frames
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        myFrameNext.add(panelMiddle, BorderLayout.CENTER);
        myFrameNext.add(panelEnd, BorderLayout.SOUTH);
    }
    protected static String[] funcRentCar(Boolean fromToday, String textFieldStartRent, String day) {
        Calendar startDate = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        int days;
        if(day.isEmpty()){
            days=0;
        }
        else {
            days = MenuGui.stringToInteger(day);
        }
        if (fromToday){}
        else{
            try {
                Date date = dateFormat.parse(textFieldStartRent);
                startDate.setTime(date);
            }
            catch (ParseException e) {
                return null;
            }
        }
        Calendar endDate = (Calendar) startDate.clone();
        endDate.add(Calendar.DATE, days);
        return new String[] {dateFormat.format(startDate.getTime()), dateFormat.format(endDate.getTime())};
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() ==myFrameNext.backItem){
            myFrameNext.dispose();
            new MenuGui();
        }
        if(e.getSource()==buttonRentIdPass) {
            try{
                labelStart.setText("Rezerwuj samochod: ");
                panelEnd.buttonSecond.setVisible(false);
                textFieldRentDays.setVisible(false);
                buttonRentCalculate.setVisible(false);
                checkBoxAddCarFromToday.setVisible(false);
                labelStartRent.setVisible(false);
                textFieldStartRent.setVisible(false);
                panelEnd.buttonSecond.setVisible(false);
                labelRentStart.setText("");
                labelRentEnd.setText("");
                if (textFieldID.getText().isEmpty()) {
                    labelRentCheck.setText("Podaj liczbe identyfikatora");
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
                    }
                }
            }
            catch (Exception e1){
                showMessageDialog(myFrameNext, "To nie jest liczba!");
                throw new RuntimeException(e1);
            }
        }
        if(e.getSource()==buttonRentCalculate){
            panelEnd.buttonSecond.setVisible(false);
            if(textFieldRentDays.getText().isEmpty()){
                showMessageDialog(myFrameNext,"Podaj ilosc dni! ");
            }
            else{
                try{
                    String[] date = funcRentCar(!checkBoxAddCarFromToday.isSelected(),textFieldStartRent.getText(),textFieldRentDays.getText());
                    labelRentStart.setText("Rezerwacja zaczyna sie od:  "  + date[0]);
                    labelRentEnd.setText("Rezerwacja konczy sie:  " + date[1]);
                    panelEnd.buttonSecond.setVisible(true);
                }
                catch (Exception e1){
                    showMessageDialog(myFrameNext, "To nie jest liczba!");
                    throw new RuntimeException(e1);
                }
            }
        }
        if(e.getSource()==panelEnd.buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
        if (e.getSource() == panelEnd.buttonSecond) {
            int ID = Integer.parseInt(textFieldID.getText());
            GUI.Car car = GUI.funcSearchCar(ID);
            if(car.AddRentCar(myFrameNext,labelRentStart.getText().substring(28),Integer.parseInt(textFieldRentDays.getText())))
                showMessageDialog(myFrameNext,"Dodano rezerwacje! ");
            myFrameNext.dispose();
            new MenuGui();
        }
    }
}