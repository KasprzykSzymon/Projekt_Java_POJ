import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowRatingsCars implements ActionListener {
    private final MyFrame myFrameNext;
    private final JButton buttonBack;
    ShowRatingsCars(){
        myFrameNext = new MyFrame();
        JPanel panelStart = new JPanel();
        panelStart.setBackground(Color.GREEN);
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        JLabel centerLabel = new JLabel("Oceny samochodow:");
        panelStart.add(centerLabel);
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.GREEN);
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        ArrayList<String> ratingCars = funcRatingsCars();
        ArrayList<JLabel> labelRatingsCars = new ArrayList<>();
        for (String car : ratingCars){
            JLabel labelRatingCar = new JLabel(car);
            labelRatingsCars.add(labelRatingCar);
            panel1.add(labelRatingCar);
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
