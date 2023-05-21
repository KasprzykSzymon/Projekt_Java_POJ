/*
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
*//*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCars extends JFrame implements ActionListener {

    private JLabel labelMark, labelModel, labelYearOfProduction, labelPriceForDay;
    private JTextField myTextFieldMark, myTextFieldModel, myTextFieldYearOfProduction, myTextFieldPriceForDay;
    private JButton myButtonAdd;

    private Connection connection;

    public AddCars() {
        this.connection = connection;
        setTitle("Add Car");
        setLayout(new GridLayout(5, 2));

        labelMark = new JLabel("Mark: ");
        add(labelMark);
        myTextFieldMark = new JTextField(20);
        add(myTextFieldMark);

        labelModel = new JLabel("Model: ");
        add(labelModel);
        myTextFieldModel = new JTextField(20);
        add(myTextFieldModel);

        labelYearOfProduction = new JLabel("Year of Production: ");
        add(labelYearOfProduction);
        myTextFieldYearOfProduction = new JTextField(20);
        add(myTextFieldYearOfProduction);

        labelPriceForDay = new JLabel("Price for Day: ");
        add(labelPriceForDay);
        myTextFieldPriceForDay = new JTextField(20);
        add(myTextFieldPriceForDay);

        myButtonAdd = new JButton("Add");
        add(myButtonAdd);
        myButtonAdd.addActionListener(this);

        setSize(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myButtonAdd) {
            try {
                addCarToDatabase();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error adding car to database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addCarToDatabase() throws SQLException {
        String mark = myTextFieldMark.getText();
        String model = myTextFieldModel.getText();
        int yearOfProduction = Integer.parseInt(myTextFieldYearOfProduction.getText());
        double priceForDay = Double.parseDouble(myTextFieldPriceForDay.getText());

        String query = "INSERT INTO cars (mark, model, year_of_production, price_for_day) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, mark);
        preparedStatement.setString(2, model);
        preparedStatement.setInt(3, yearOfProduction);
        preparedStatement.setDouble(4, priceForDay);
        preparedStatement.executeUpdate();

        JOptionPane.showMessageDialog(this, "Car added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        clearFields();
    }

    private void clearFields() {
        myTextFieldMark.setText("");
        myTextFieldModel.setText("");
        myTextFieldYearOfProduction.setText("");
        myTextFieldPriceForDay.setText("");
    }
}
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class AddCars extends JFrame implements ActionListener {

    private JLabel labelMark, labelModel, labelYearOfProduction, labelPriceForDay;
    private JTextField myTextFieldMark, myTextFieldModel, myTextFieldYearOfProduction, myTextFieldPriceForDay;
    private JButton myButtonAdd;

    private Connection connection;

    public AddCars() {
        try {
            // Establish a connection to the PostgreSQL database
            String url = "jdbc:postgresql://localhost/rental";
            String username = "postgres";
            String password = "1234";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // Exit the program if there's an error connecting to the database
        }

        setTitle("Add Car");
        setLayout(new GridLayout(5, 2));

        labelMark = new JLabel("Mark: ");
        add(labelMark);
        myTextFieldMark = new JTextField(20);
        add(myTextFieldMark);

        labelModel = new JLabel("Model: ");
        add(labelModel);
        myTextFieldModel = new JTextField(20);
        add(myTextFieldModel);

        labelYearOfProduction = new JLabel("Year of Production: ");
        add(labelYearOfProduction);
        myTextFieldYearOfProduction = new JTextField(20);
        add(myTextFieldYearOfProduction);

        labelPriceForDay = new JLabel("Price for Day: ");
        add(labelPriceForDay);
        myTextFieldPriceForDay = new JTextField(20);
        add(myTextFieldPriceForDay);

        myButtonAdd = new JButton("Add");
        add(myButtonAdd);
        myButtonAdd.addActionListener(this);

        setSize(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myButtonAdd) {
            try {
                addCarToDatabase();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error adding car to the database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addCarToDatabase() throws SQLException {
        String make = myTextFieldMark.getText();
        String model = myTextFieldModel.getText();
        int yearOfProduction = Integer.parseInt(myTextFieldYearOfProduction.getText());
        double priceForDay = Double.parseDouble(myTextFieldPriceForDay.getText());

        String query = "INSERT INTO cars (make, model, year, rental_price) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, make);
        preparedStatement.setString(2, model);
        preparedStatement.setInt(3, yearOfProduction );
        preparedStatement.setDouble(4, priceForDay);
        preparedStatement.executeUpdate();

        JOptionPane.showMessageDialog(this, "Car added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        clearFields();
    }

    private void clearFields() {
        myTextFieldMark.setText("");
        myTextFieldModel.setText("");
        myTextFieldYearOfProduction.setText("");
        myTextFieldPriceForDay.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddCars());
    }
}

