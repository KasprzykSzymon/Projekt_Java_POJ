import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class AddCars implements ActionListener {
    private final JButton buttonConfirm;
    private final MyFrame myFrameNext;
    private final JTextField myTextFieldMark;
    private final JTextField myTextFieldModel;
    private final JTextField myTextFieldYearOfProduction;
    private final JTextField myTextFieldPriceForDay;
    private final JCheckBox checkBoxAddCar;
    private final JButton buttonBack;

    AddCars() {
        myFrameNext = new MyFrame();
        JPanel panel = new JPanel();
        myFrameNext.add(panel, BorderLayout.NORTH);
        JLabel titleLabel = new JLabel("Podaj parametry samochodu:");
        panel.add(titleLabel);
        panel.setBackground(Color.GREEN);
        JPanel panel1 = new JPanel();
        myFrameNext.add(panel1, BorderLayout.CENTER);
        panel1.setBackground(new Color(0, 200, 0));
        panel1.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel1.setLayout(new GridLayout(0, 2, 10, 5));
        JLabel Label1 = new JLabel("Podaj marke samochoduu:  \t");
        Label1.setBackground(Color.GREEN);
        panel1.add(Label1);
        myTextFieldMark = new JTextField();
        myTextFieldMark.setPreferredSize(new Dimension(250, 40));
        myTextFieldMark.setFont(new Font("Arctic", Font.PLAIN, 50));
        myTextFieldMark.setForeground(Color.GREEN);
        myTextFieldMark.setBackground(Color.BLACK);
        myTextFieldMark.setCaretColor(Color.WHITE);
        myTextFieldMark.setText("OPEL");
        panel1.add(myTextFieldMark);
        JLabel Label2 = new JLabel("Podaj model samochodu: \t");
        Label2.setBackground(Color.GREEN);
        panel1.add(Label2);
        myTextFieldModel = new JTextField();
        myTextFieldModel.setPreferredSize(new Dimension(250, 40));
        myTextFieldModel.setFont(new Font("Arctic", Font.PLAIN, 50));
        myTextFieldModel.setForeground(Color.GREEN);
        myTextFieldModel.setBackground(Color.BLACK);
        myTextFieldModel.setCaretColor(Color.WHITE);
        myTextFieldModel.setText("ASTRA");
        panel1.add(myTextFieldModel);
        JLabel Label4 = new JLabel("Podaj rok produkcji: \t");
        panel1.add(Label4);
        Label4.setBackground(Color.GREEN);
        myTextFieldYearOfProduction = new JTextField();
        myTextFieldYearOfProduction.setPreferredSize(new Dimension(250, 40));
        myTextFieldYearOfProduction.setFont(new Font("Arctic", Font.PLAIN, 50));
        myTextFieldYearOfProduction.setForeground(Color.GREEN);
        myTextFieldYearOfProduction.setBackground(Color.BLACK);
        myTextFieldYearOfProduction.setCaretColor(Color.WHITE);
        myTextFieldYearOfProduction.setText("2020");
        panel1.add(myTextFieldYearOfProduction);
        JLabel Label3 = new JLabel("Podaj cene za dzien wynajmu: \t");
        panel1.add(Label3);
        Label3.setBackground(Color.GREEN);
        myTextFieldPriceForDay = new JTextField();
        myTextFieldPriceForDay.setPreferredSize(new Dimension(250, 40));
        myTextFieldPriceForDay.setFont(new Font("Arctic", Font.PLAIN, 50));
        myTextFieldPriceForDay.setForeground(Color.GREEN);
        myTextFieldPriceForDay.setBackground(Color.BLACK);
        myTextFieldPriceForDay.setCaretColor(Color.WHITE);
        myTextFieldPriceForDay.setText("100");
        panel1.add(myTextFieldPriceForDay);
        checkBoxAddCar = new JCheckBox();
        checkBoxAddCar.setText("Nie jestem robotem :)");
        checkBoxAddCar.setBackground(Color.GREEN);
        checkBoxAddCar.setFocusable(false);
        panel1.add(checkBoxAddCar);
        panel1.setBackground(Color.GREEN);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0, 200, 0));
        myFrameNext.add(panel2, BorderLayout.SOUTH);
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new GridLayout(0, 4, 10, 5));
        buttonBack = new JButton(" Powrot ");
        buttonBack.addActionListener(this);
        buttonBack.setBackground(new Color(255, 100, 100));
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        buttonBack.setSize(250, 20);
        panel2.add(buttonBack);
        JLabel lb1 = new JLabel();
        panel2.add(lb1);
        JLabel lb2 = new JLabel();
        panel2.add(lb2);
        buttonConfirm = new JButton(" Zatwierdz ");
        buttonConfirm.setBackground(new Color(0, 255, 0));
        buttonConfirm.setBorder(BorderFactory.createEtchedBorder());
        buttonConfirm.setSize(250, 20);
        buttonConfirm.addActionListener(this);
        panel2.add(buttonConfirm);
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
