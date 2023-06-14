import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class MyButton extends JButton {
    MyButton(String text){
        super(text);
        this.setSize(new Dimension(250, 20));
        this.setBackground(new Color(50, 120, 200));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setSize(250,20);

    }
}
