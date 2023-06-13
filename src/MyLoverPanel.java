import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;

public class MyLoverPanel extends JPanel{
    static JButton buttonBack, buttonSecond;
    MyLoverPanel(String secButton){
        super();
        this.setBackground(new Color(0, 235, 0));
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        this.setLayout(new GridLayout(0, 4, 10, 5));
        buttonBack = new JButton(" Powrot ");
        buttonBack.setBackground(new Color(255,100,100));
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        buttonBack.setSize(250,20);
        buttonSecond = new JButton(secButton);
        buttonSecond.setBackground(new Color(0, 255, 0));
        buttonSecond.setBorder(BorderFactory.createEtchedBorder());
        buttonSecond.setSize(250,20);
        JLabel lb1 = new JLabel("") , lb2 = new JLabel("");
        this.add(buttonBack);
        this.add(lb1);
        this.add(lb2);
        this.add(buttonSecond);
    }
    MyLoverPanel(){
        this.setBackground(new Color(00, 235, 0));
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        this.setLayout(new GridLayout(0, 4, 10, 5));
        buttonBack = new JButton(" Powrot ");
        buttonBack.setBackground(new Color(255,100,100));
        buttonBack.setBorder(BorderFactory.createEtchedBorder());
        buttonBack.setSize(250,20);
        this.add(buttonBack);
    }
}
