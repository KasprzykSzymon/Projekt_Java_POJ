import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowCars implements ActionListener {
    private final MyFrame myFrameNext;
    private final JButton buttonBack;
    final ArrayList<String> listCars;
    final ArrayList<JLabel> labelListCars;
    ShowCars(){
        myFrameNext = new MyFrame();
        JPanel panelStart = new JPanel();
        panelStart.setBackground(Color.GREEN);
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        JLabel centerLabel = new JLabel("Obecne samochody:");
        panelStart.add(centerLabel);
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.GREEN);
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        listCars = funcShowCars();
        labelListCars = new ArrayList<>();
        for (String car : listCars) {
            JLabel labelCar = new JLabel(car);
            labelListCars.add(labelCar);
            panel1.add(labelCar);
        }
        myFrameNext.add(panel1,BorderLayout.CENTER);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0,200,0));
        myFrameNext.add(panel2, BorderLayout.SOUTH);
        panel2.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel2.setLayout(new GridLayout(0,4,10,5));
        buttonBack = new JButton(" Powrot ");
        buttonBack.addActionListener(this);
        buttonBack.setBackground(new Color(255,100,100));
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        buttonBack.setSize(250,20);
        panel2.add(buttonBack);
    }
    public static ArrayList<String> funcShowCars() {
        ArrayList<String> listCars = new ArrayList<>();
        if (GUI.Cars.isEmpty())
            listCars.add("Nie dodano samochodow do bazy");
        else{
            for(GUI.Car car : GUI.Cars) {
                listCars.add("ID:  " + car.getId() + "  " + car.getMark() + "  " + car.getModel() + "  " + car.getYearOfProduction()) ;
            }
        }
        return listCars;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
    }
}

