import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyButton extends JButton {
    MyButton(String text){
        this.setBackground(new Color(0,255,0));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setSize(250,20);
        this.addActionListener((ActionListener) this);
    }

}
