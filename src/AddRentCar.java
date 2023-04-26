import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddRentCar implements ActionListener {
    private MyFrame myFrameNext;
    private JTextField textFieldID;
    private JButton buttonRentIdPass;
    private JCheckBox checkBoxAddCarFromToday;
    private JTextField textFieldRentDays;
    private JButton buttonRentCalculate;
    private JLabel labelRentCheck;
    private JTextField textFieldStartRent;
    private JLabel labelRentStart;
    private JLabel labelRentEnd;
    private JButton buttonBack;

    AddRentCar() {
        myFrameNext = new MyFrame(); //creates a myFrame
        JLabel label = new JLabel("Rezerwuj samochod: ");
        JPanel panelStart = new JPanel();
        panelStart.setBackground(new Color(0, 200, 0));
        panelStart.add(label, BorderLayout.CENTER);
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
        buttonRentIdPass = new JButton(" Sprawdz ");
        buttonRentIdPass.setSize(new Dimension(250, 20));
        buttonRentIdPass.addActionListener(this);
        buttonRentIdPass.setBorder(BorderFactory.createEtchedBorder());
        buttonRentIdPass.setBackground(new Color(50, 120, 200));
        panel.add(buttonRentIdPass);
        labelRentCheck = new JLabel("");
        panel.add(labelRentCheck);
        textFieldRentDays = new JTextField();
        textFieldRentDays.setSize(new Dimension(250, 50));
        textFieldRentDays.setFont(new Font("Arctic", Font.PLAIN, 40));
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
        textFieldStartRent = new JTextField();
        textFieldStartRent.setSize(new Dimension(250, 40));
        textFieldStartRent.setFont(new Font("Arctic", Font.PLAIN, 40));
        textFieldStartRent.setForeground(Color.GREEN);
        textFieldStartRent.setBackground(Color.BLACK);
        textFieldStartRent.setCaretColor(Color.WHITE);
        textFieldStartRent.setVisible(false);
        panel.add(textFieldStartRent);
        buttonRentCalculate = new JButton(" Sprawdz ");
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
        myFrameNext.add(panel3, BorderLayout.SOUTH);
    }
    private String[] funcRentCar(Boolean fromToday,String textFieldStartRent, int days) {
        Calendar startDate = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (fromToday) {
            System.out.println("Wypozyczanie zaczyna się od dzisiaj: " + dateFormat.format(startDate.getTime()));
        }
        else
            try {
                Date date = dateFormat.parse(textFieldStartRent);
                startDate.setTime(date);
                System.out.println("Wypozyczanie zaczyna sie od: " + dateFormat.format(startDate.getTime()));
            }
            catch (ParseException e) {
                System.out.println("Nieprawidlowy format daty!");
                return null;
            }
        Calendar endDate = (Calendar) startDate.clone();
        //endDate.add(Calendar.YEAR, 1);
        //endDate.add(Calendar.MONTH, 1);
        endDate.add(Calendar.DATE, days);
        System.out.println("Wypozyczanie konczy sie daysa: " + dateFormat.format(endDate.getTime()));
        String[] ret={dateFormat.format(startDate.getTime()), dateFormat.format(endDate.getTime())};
        return ret;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonRentIdPass) {
            if (textFieldID.getText().isEmpty()) {
                textFieldRentDays.setVisible(false);
                buttonRentCalculate.setVisible(false);
                checkBoxAddCarFromToday.setVisible(false);
                textFieldStartRent.setVisible(false);
                labelRentCheck.setText("Podaj liczbe identyfikatora");
                labelRentStart.setText("");
                labelRentEnd.setText("");
            }
            else {
                int ID = Integer.parseInt(textFieldID.getText());
                if (GUI.funcSearchCar(ID) != null) {
//                    int days = Integer.parseInt(textFieldRentDays.getText());
//                    String[] date = funcRentCar(checkBoxAddCarFromToday.isSelected(),textFieldStartRent.getText(),days);
                    labelRentCheck.setText("Na ile dni wypozyczasz: ");
                    textFieldRentDays.setVisible(true);
                    buttonRentCalculate.setVisible(true);
                    checkBoxAddCarFromToday.setVisible(true);
                    textFieldStartRent.setVisible(true);
//                    labelRentStart.setText("Rezerwacja zaczyna sie od:"  +date[0]);
//                    labelRentEnd.setText("Rezerwacja konczy sie: " +date[1]);

                }
                else {
                    labelRentCheck.setText("Nie ma takiego ID ");
                    textFieldRentDays.setVisible(false);
                    buttonRentCalculate.setVisible(false);
                    checkBoxAddCarFromToday.setVisible(false);
                    textFieldStartRent.setVisible(false);
                    labelRentStart.setText("");
                    labelRentEnd.setText("");
                }
            }
        }

        if(e.getSource()==buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
    }
}