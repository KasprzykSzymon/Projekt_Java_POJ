import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyButtonEnd extends JButton{
        MyButtonEnd(String text){

            this.addActionListener((ActionListener) this);
            this.setBackground(new Color(255,100,100));
            this.setBorder(BorderFactory.createEtchedBorder());
            this.setSize(250,20);
        }
}
