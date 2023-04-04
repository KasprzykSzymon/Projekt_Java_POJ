import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JMenu fileMenu;
    JMenu editMenu;
    JMenu aboutMenu;
    JMenuBar menuBar;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

    JMenuItem backItem;
    JMenuItem aboutItem;

    MyFrame(){
        this.setTitle("Wypozyczalnia Samochodow");  //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true); //make frame visible
        this.setSize(500,500);

        menuBar = new JMenuBar();
        
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        aboutMenu = new JMenu("About");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        JMenuItem backItem = new JMenuItem("Back");
        editMenu.add(backItem);


        JMenuItem aboutItem = new JMenuItem("About");
        aboutMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        this.setJMenuBar(menuBar);

        



        //ImageIcon image = new ImageIcon("TITLE OF FILE WITH LOGO (TITLE.png)"); //Create an ImageIcon
        //this.setIconImage(image.getImage());  //Change icon of frame
        //this.getContentPane().setBackground(new Color(0,200,0)); //change color of background
    }
}
