import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class AddCars implements ActionListener {
    private final MyFrame myFrameNext;
    private final MyTextField myTextFieldMark, myTextFieldModel, myTextFieldYearOfProduction, myTextFieldPriceForDay;
    private final JCheckBox checkBoxAddCar;
    private final JButton buttonConfirm, buttonBack;

    AddCars() {
        //Initialization of variables
        myFrameNext = new MyFrame();
        JPanel panelStart = new JPanel();
        JPanel panelMiddle = new JPanel();
        JPanel panelEnd = new JPanel();
        JLabel titleLabel = new JLabel("Podaj parametry samochodu:");
        JLabel Label1 = new JLabel("Podaj marke samochoduu:  \t");
        myTextFieldMark = new MyTextField();
        JLabel Label2 = new JLabel("Podaj model samochodu: \t");
        myTextFieldModel = new MyTextField();
        myTextFieldYearOfProduction = new MyTextField();
        JLabel Label4 = new JLabel("Podaj rok produkcji: \t");
        JLabel Label3 = new JLabel("Podaj cene za dzien wynajmu: \t");
        myTextFieldPriceForDay = new MyTextField();
        checkBoxAddCar = new JCheckBox();
        buttonBack = new JButton(" Powrot ");
        JLabel lb1 = new JLabel();
        JLabel lb2 = new JLabel();
        buttonConfirm = new JButton(" Zatwierdz ");
        //Changing elements in panelStart
        panelStart.setBackground(Color.GREEN);
        //Changing elements in panelMiddle
        panelMiddle.setBackground(new Color(0, 200, 0));
        panelMiddle.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panelMiddle.setLayout(new GridLayout(0, 2, 10, 5));
        Label1.setBackground(Color.GREEN);
        myTextFieldMark.setText("OPEL");
        Label2.setBackground(Color.GREEN);
        myTextFieldModel.setText("ASTRA");
        Label4.setBackground(Color.GREEN);
        myTextFieldYearOfProduction.setText("2020");
        Label3.setBackground(Color.GREEN);
        myTextFieldPriceForDay.setText("100");
        checkBoxAddCar.setText("Nie jestem robotem :)");
        checkBoxAddCar.setBackground(Color.GREEN);
        checkBoxAddCar.setFocusable(false);
        panelMiddle.setBackground(Color.GREEN);
        //Changing elements in panelEnd
        panelEnd.setBackground(new Color(0, 200, 0));
        panelEnd.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panelEnd.setLayout(new GridLayout(0, 4, 10, 5));
        buttonBack.addActionListener((ActionListener) this);
        buttonBack.setBackground(new Color(255,100,100));
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        buttonBack.setSize(250,20);
        buttonConfirm.setBackground(new Color(0, 255, 0));
        buttonConfirm.addActionListener((ActionListener) this);
        buttonConfirm.setBorder(BorderFactory.createEtchedBorder());
        buttonConfirm.setSize(250,20);
        //Add elements to panels
        panelStart.add(titleLabel);
        panelMiddle.add(Label1);
        panelMiddle.add(myTextFieldMark);
        panelMiddle.add(Label2);
        panelMiddle.add(myTextFieldModel);
        panelMiddle.add(Label4);
        panelMiddle.add(myTextFieldYearOfProduction);
        panelMiddle.add(Label3);
        panelMiddle.add(myTextFieldPriceForDay);
        panelMiddle.add(checkBoxAddCar);
        panelEnd.add(buttonBack);
        panelEnd.add(lb1);
        panelEnd.add(lb2);
        panelEnd.add(buttonConfirm);
        //Add elements to frames
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        myFrameNext.add(panelMiddle, BorderLayout.CENTER);
        myFrameNext.add(panelEnd, BorderLayout.SOUTH);
    }

    public static void funcAddCar(String mark, String model, double price, short yearOfProduction, MyFrame frame) {
        GUI.Car Car = new GUI.Car(mark, model, price, yearOfProduction);
        GUI.Cars.add(Car);
        showMessageDialog(frame,"Dodano samochod do bazy");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonConfirm) {
            if (!(!checkBoxAddCar.isSelected() | myTextFieldMark.getText().isEmpty() | myTextFieldModel.getText().isEmpty() | myTextFieldYearOfProduction.getText().isEmpty() | myTextFieldPriceForDay.getText().isEmpty())) {
                double price = Double.parseDouble(myTextFieldPriceForDay.getText());
                short year = Short.parseShort(myTextFieldYearOfProduction.getText());
                    funcAddCar(myTextFieldMark.getText(), myTextFieldModel.getText(),price,year,myFrameNext);
                if (checkBoxAddCar.isSelected())
                    myFrameNext.dispose();
                new MenuGui();
            } else
                JOptionPane.showMessageDialog(myFrameNext,"Uzupelnij puste pola");
        }
        if(e.getSource()==buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
    }
}
