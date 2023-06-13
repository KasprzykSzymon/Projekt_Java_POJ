import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowCars implements ActionListener {
    private final MyFrame myFrameNext = new MyFrame();
    MyLoverPanel panelEnd;
    final ArrayList<String> listCars;
    final ArrayList<JLabel> labelListCars;
    ShowCars(){
        //Initialization of variables
        myFrameNext.backItem.addActionListener(this);
        JPanel panelStart = new JPanel();
        JPanel panelMiddle = new JPanel();
        panelEnd = new MyLoverPanel();
        JLabel centerLabel = new JLabel("Obecne samochody:");
        listCars = funcShowCars();
        labelListCars = new ArrayList<>();
        //Changing elements in panelStart
        panelStart.setBackground(Color.GREEN);
        //Changing elements in panel
        panelMiddle.setBackground(Color.GREEN);
        panelMiddle.setLayout(new BoxLayout(panelMiddle,BoxLayout.Y_AXIS));
        //Changing elements in panelEnd
        panelEnd.buttonBack.addActionListener((ActionListener) this);
        //Add elements to panels
        panelStart.add(centerLabel);
        for (String car : listCars) {
            JLabel labelCar = new JLabel(car);
            labelListCars.add(labelCar);
            panelMiddle.add(labelCar);
        }
        panelEnd.add(panelEnd.buttonBack);
        //Add elements to frames
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        myFrameNext.add(panelMiddle,BorderLayout.CENTER);
        myFrameNext.add(panelEnd, BorderLayout.SOUTH);
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
        if(e.getSource() == myFrameNext.backItem){
            myFrameNext.dispose();
            new MenuGui();
        }
        if(e.getSource()==panelEnd.buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
    }
}

