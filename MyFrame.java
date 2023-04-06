import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener  {


    //ImageIcon image = new ImageIcon("TITLE OF FILE WITH LOGO (TITLE.png)"); //Create an ImageIcon
//this.setIconImage(image.getImage());  //Change icon of frame
//this.getContentPane().setBackground(new Color(0,200,0)); //change color of background

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

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        saveItem.setMnemonic(KeyEvent.VK_S & KeyEvent.VK_CONTROL);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        backItem = new JMenuItem("Back");
        backItem.addActionListener(this);
        editMenu.add(backItem);


        aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(this);
        aboutMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        this.setJMenuBar(menuBar);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loadItem)
            System.out.println("Miejsce na instrukcje wczytania pliku! ");
        if(e.getSource()==saveItem)
            System.out.println("Miejsce na instrukcje zapisu danych! ");
        if(e.getSource()==exitItem)
            System.exit(0);
        if(e.getSource()==backItem)
            System.out.println("Miejsce na instruckje powrotu! ");
        if(e.getSource()==aboutItem)
            System.out.println("Miejsce na instrukcje od wyswietlenia informacji o programie! ");

    }
}
