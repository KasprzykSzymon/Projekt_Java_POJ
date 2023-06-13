import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowRatingsCars implements ActionListener {
    private final MyFrame myFrameNext = new MyFrame();
    private final MyLoverPanel panelEnd;
    ShowRatingsCars(){
        //Initialization of variables
        myFrameNext.backItem.addActionListener(this);
        JPanel panelStart = new JPanel();
        JPanel panelMiddle = new JPanel();
        panelEnd = new MyLoverPanel();
        JLabel centerLabel = new JLabel("Oceny samochodow:");
        ArrayList<String> ratingCars = funcRatingsCars();
        ArrayList<JLabel> labelRatingsCars = new ArrayList<>();
        //Changing elements in panelStart
        panelStart.setBackground(Color.GREEN);
        //Changing elements in panelMiddle
        panelMiddle.setBackground(Color.GREEN);
        panelMiddle.setLayout(new BoxLayout(panelMiddle,BoxLayout.Y_AXIS));
        //Changing elements in panelEnd
        panelEnd.buttonBack.addActionListener(this);
        //Add elements to panels
        panelStart.add(centerLabel);
        for (String car : ratingCars){
            JLabel labelRatingCar = new JLabel(car);
            labelRatingsCars.add(labelRatingCar);
            panelMiddle.add(labelRatingCar);
        }
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
