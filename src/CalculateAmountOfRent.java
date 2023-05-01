import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateAmountOfRent implements ActionListener {
    private final MyFrame myFrameNext;
    private final JTextField textFieldID;
    private final JButton buttonIdPass;
    private final JTextField textFieldDays;
    private final JButton buttonCalculate;
    private final JLabel labelCheck;
    private final JLabel labelDays;
    private final JLabel labelCost;
    private final JButton buttonBack;

    CalculateAmountOfRent() {
        myFrameNext = new MyFrame();
        JLabel label = new JLabel("Oblicz kwote wynajmu: ");
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
        buttonIdPass = new JButton(" Sprawdz ");
        buttonIdPass.addActionListener(this);
        buttonIdPass.setBorder(BorderFactory.createEtchedBorder());
        buttonIdPass.setBackground(new Color(50, 120, 200));
        panel.add(buttonIdPass);
        labelCheck = new JLabel("");
        panel.add(labelCheck);
        textFieldDays = new JTextField();
        textFieldDays.setSize(new Dimension(250, 40));
        textFieldDays.setFont(new Font("Arctic", Font.PLAIN, 50));
        textFieldDays.setForeground(Color.GREEN);
        textFieldDays.setBackground(Color.BLACK);
        textFieldDays.setCaretColor(Color.WHITE);
        textFieldDays.setVisible(false);
        panel.add(textFieldDays);
        JLabel LBCalculate = new JLabel("");
        panel.add(LBCalculate);
        buttonCalculate = new JButton(" Oblicz ");
        buttonCalculate.addActionListener(this);
        buttonCalculate.setBorder(BorderFactory.createEtchedBorder());
        buttonCalculate.setBackground(new Color(50, 120, 200));
        buttonCalculate.setVisible(false);
        panel.add(buttonCalculate);
        labelDays = new JLabel("");
        panel.add(labelDays);
        labelCost = new JLabel("");
        panel.add(labelCost);
        myFrameNext.add(panel, BorderLayout.CENTER);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0, 200, 0));
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new GridLayout(0, 4, 10, 5));
        buttonBack = new JButton(" Powrot ");
        buttonBack.addActionListener(this);
        buttonBack.setBackground(new Color(255,100,100));
        buttonBack.setVisible(true);
        panel2.add(buttonBack);
        myFrameNext.add(panel2, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonIdPass) {
            if (textFieldID.getText().isEmpty()) {
                textFieldDays.setVisible(false);
                buttonCalculate.setVisible(false);
                labelCheck.setText("Podaj liczbe identyfikatora");
                labelDays.setText("");
                labelCost.setText("");
            }
            else {
                int ID = Integer.parseInt(textFieldID.getText());
                if (GUI.funcSearchCar(ID) != null) {

                    labelCheck.setText("Na ile dni chcesz wypozyczyc: ");
                    textFieldDays.setVisible(true);
                    buttonCalculate.setVisible(true);

                }
                else {
                    labelCheck.setText("Nie ma takiego ID ");
                    textFieldDays.setVisible(false);
                    buttonCalculate.setVisible(false);
                    labelDays.setText("");
                    labelCost.setText("");
                }
            }
        }
        if(e.getSource()==buttonCalculate){
            int ID = Integer.parseInt(textFieldID.getText());
            GUI.Car Car = GUI.funcSearchCar(ID);
            int days = Integer.parseInt(textFieldDays.getText());
            double price = Car.funcCalculateTheCostOfRent(myFrameNext, days);
            labelDays.setText("Kwota za " + Car.getMark() + " " + Car.getModel() + " wynosi: ");
            labelCost.setText(String.format("%.2f PLN", price));
        }
        if(e.getSource()==buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
    }
}
