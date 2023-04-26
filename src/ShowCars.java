import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCars implements ActionListener {

    private MyFrame myFrameNext;
    private JButton buttonBack ;
    private JLabel labelListCars;
    ShowCars(){
        myFrameNext = new MyFrame();
        JPanel panelStart = new JPanel();
        panelStart.setBackground(Color.GREEN);
        myFrameNext.add(panelStart, BorderLayout.NORTH);
        JLabel centerLabel = new JLabel("Obecne samochody:");
        panelStart.add(centerLabel);
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.GREEN);
        String listCars = GUI.funcShowCars();
        labelListCars = new JLabel(listCars);
        labelListCars.setHorizontalTextPosition(JLabel.CENTER);
        panel1.add(labelListCars);
        myFrameNext.add(panel1, BorderLayout.CENTER);
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
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonBack){
            myFrameNext.dispose();
            new MenuGui();
        }
    }
}
