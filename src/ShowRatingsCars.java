import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowRatingsCars implements ActionListener {
    private final MyFrame myFrameNext;
    private final JButton buttonBack;
    ShowRatingsCars(){
        //Initialization of variables
        myFrameNext = new MyFrame();
        JPanel panelStart = new JPanel();
        JPanel panelMiddle = new JPanel();
        JPanel panelEnd = new JPanel();
        JLabel centerLabel = new JLabel("Oceny samochodow:");
        ArrayList<String> ratingCars = funcRatingsCars();
        ArrayList<JLabel> labelRatingsCars = new ArrayList<>();
        //Changing elements in panelStart
        panelStart.setBackground(Color.GREEN);
        //Changing elements in panelMiddle
        panelMiddle.setBackground(Color.GREEN);
        panelMiddle.setLayout(new BoxLayout(panelMiddle,BoxLayout.Y_AXIS));
        //Changing elements in panelEnd
        panelEnd.setBackground(new Color(0,200,0));
        panelEnd.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panelEnd.setLayout(new GridLayout(0,4,10,5));
        buttonBack = new JButton(" Powrot ");
        buttonBack.addActionListener((ActionListener) this);
        buttonBack.setBackground(new Color(255,100,100));
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        buttonBack.setSize(250,20);
        //Add elements to panels
        panelStart.add(centerLabel);
        for (String car : ratingCars){
            JLabel labelRatingCar = new JLabel(car);
            labelRatingsCars.add(labelRatingCar);
            panelMiddle.add(labelRatingCar);
        }
        panelEnd.add(buttonBack);
        //Add elements to frames
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        myFrameNext.add(panelMiddle,BorderLayout.CENTER);
        myFrameNext.add(panelEnd, BorderLayout.SOUTH);

    }
    private static ArrayList<String> funcRatingsCars(){
        ArrayList<String> ratingsCars = new ArrayList<>();
        double averageRatings;
        if (GUI.Cars.isEmpty())
            ratingsCars.add("Nie dodano samochodow do bazy");
        else{
            for(GUI.Car car : GUI.Cars) {
                averageRatings = car.averageRating();
                ratingsCars.add(String.format("ID:   %d   \t%s\t %s \t Ocena: %1.2f \n",car.getId(), car.getMark(), car.getModel(), averageRatings));
            }
        }
        return ratingsCars;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
    }
}
