import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){
        this.setTitle("Wypozyczalnia Samochodow");  //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true); //make frame visible
        this.setSize(500,500);

        //ImageIcon image = new ImageIcon("TITLE OF FILE WITH LOGO (TITLE.png)"); //Create an ImageIcon
        //this.setIconImage(image.getImage());  //Change icon of frame
        //this.getContentPane().setBackground(new Color(0,200,0)); //change color of background
    }
}
