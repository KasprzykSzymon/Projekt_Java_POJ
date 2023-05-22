import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {
    MyTextField(){
        this.setSize(new Dimension(250, 40));
        this.setFont(new Font("Arctic", Font.PLAIN, 50));
        this.setForeground(Color.GREEN);
        this.setBackground(Color.BLACK);
        this.setCaretColor(Color.WHITE);
    }
}
