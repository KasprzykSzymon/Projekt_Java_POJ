import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateAmountOfRent implements ActionListener {
    private final MyFrame myFrameNext = new MyFrame();
    private final MyLoverPanel panelEnd;
    private final MyTextField textFieldID, textFieldDays;
    private final MyButton buttonIdPass;
    private final JLabel labelCheck, labelDays, labelCost;

    CalculateAmountOfRent() {
        //Initialization of variables
        myFrameNext.backItem.addActionListener(this);
        JPanel panelStart = new JPanel();
        JPanel panel = new JPanel();
        panelEnd = new MyLoverPanel(" Oblicz ");
        JLabel label = new JLabel("Oblicz kwote wynajmu: ");
        JLabel LabelId = new JLabel("Wybierz ID samochodu: ");
        textFieldID = new MyTextField();
        JLabel LB = new JLabel("");
        buttonIdPass = new MyButton(" Sprawdz ");
        labelCheck = new JLabel("");
        labelDays = new JLabel("");
        labelCost = new JLabel("");
        JLabel LBCalculate = new JLabel("");
        //Changing elements in panelStart
        panelStart.setBackground(new Color(0, 200, 0));
        //Changing elements in panelMiddle
        panel.setBackground(new Color(0, 200, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 2, 10, 5));
        buttonIdPass.addActionListener((ActionListener) this);
        textFieldDays = new MyTextField();
        textFieldDays.setVisible(false);
        panelEnd.buttonSecond.addActionListener((ActionListener) this);
        panelEnd.buttonSecond.setVisible(false);
        //Changing elements in panelEnd
        panelEnd.setBackground(new Color(0, 200, 0));
        panelEnd.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panelEnd.setLayout(new GridLayout(0, 4, 10, 5));
        panelEnd.buttonBack.addActionListener((ActionListener) this);
        //Add elements to panels
        panelStart.add(label, BorderLayout.CENTER);
        panel.add(LabelId);
        panel.add(textFieldID);
        panel.add(LB);
        panel.add(buttonIdPass);
        panel.add(labelCheck);
        panel.add(textFieldDays);
        panel.add(labelDays);
        panel.add(labelCost);
        //Add elements to frames
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        myFrameNext.add(panel, BorderLayout.CENTER);
        myFrameNext.add(panelEnd, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == myFrameNext.backItem){
            myFrameNext.dispose();
            new MenuGui();
        }
        if(e.getSource()==buttonIdPass) {
            if (textFieldID.getText().isEmpty()) {
                textFieldDays.setVisible(false);
                panelEnd.buttonSecond.setVisible(false);
                labelCheck.setText("Podaj liczbe identyfikatora");
                labelDays.setText("");
                labelCost.setText("");
            }
            else {
                int ID = Integer.parseInt(textFieldID.getText());
                if (GUI.funcSearchCar(ID) != null) {

                    labelCheck.setText("Na ile dni chcesz wypozyczyc: ");
                    textFieldDays.setVisible(true);
                    panelEnd.buttonSecond.setVisible(true);

                }
                else {
                    labelCheck.setText("Nie ma takiego ID ");
                    textFieldDays.setVisible(false);
                    panelEnd.buttonSecond.setVisible(false);
                    labelDays.setText("");
                    labelCost.setText("");
                }
            }
        }
        if(e.getSource()==panelEnd.buttonSecond){
            int ID = Integer.parseInt(textFieldID.getText());
            GUI.Car Car = GUI.funcSearchCar(ID);
            int days = Integer.parseInt(textFieldDays.getText());
            double price = Car.funcCalculateTheCostOfRent(myFrameNext, days);
            labelDays.setText("Kwota za " + Car.getMark() + " " + Car.getModel() + " wynosi: ");
            labelCost.setText(String.format("%.2f PLN", price));
        }
        if(e.getSource()==panelEnd.buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
    }
}
