import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener  {
    private static int currentCarNumber = 1;
    final JMenu fileMenu;
    JMenu editMenu;
    JMenu aboutMenu;
    JMenuBar menuBar;
    //    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    JMenuItem backItem;
    JMenuItem aboutItem;
    MyFrame(){
        this.setTitle("Wypozyczalnia Samochodow");  //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true); //make frame visible
        this.setSize(600,600);
        ImageIcon image = new ImageIcon("lib/Picture/TitlePicture.png"); //Create an ImageIcon
        this.setIconImage(image.getImage());  //Change icon of frame
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        aboutMenu = new JMenu("About");
//        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
//        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        saveItem.setMnemonic(KeyEvent.VK_S & KeyEvent.VK_CONTROL);
//        fileMenu.add(loadItem);
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
    private void about(){
        JOptionPane.showMessageDialog(this, "Program o nazwie Wypozyczalnia Samochodow zostal napisany na cele projektu na studia. \nSklad zespolu: \n Lider: <Szymon Kasprzyk>, \nPomocnik: <Michal Gruszczynski>, \nPowolna pomoc: Oskar Pytlewki, \nProzniak: klaudia iwanowicz");
    }
    private static void saveCarToFile() {
        try {
            File file = new File("samochody.txt");
            file.delete(); // Delete the existing file
            BufferedWriter writer = new BufferedWriter(new FileWriter("samochody.txt",true));
           /* for (GUI.Car car: GUI.Cars) {
                String ratingStr = "", rentStr = "";
                if(car.ratings.isEmpty())
                    ratingStr = "";
                else
                    for (Integer rating : car.ratings) {
                        ratingStr += "//" + rating.toString();
                    }
                if(car.rentCar.isEmpty())
                    rentStr = "";
                else
                    for (String rent : car.rentCar){
                        rentStr += ",," + rent;
                    }
                writer.write(car.getMark() + "`" + car.getModel() + "`" + car.getPrice() + "`" + car.getYearOfProduction() + "`" +ratingStr + "`"+rentStr);
                writer.newLine();
            }*/
            for (GUI.Car car : GUI.Cars) {
                String ratingStr = "";
                if (!car.ratings.isEmpty()) {
                    StringBuilder ratingBuilder = new StringBuilder();
                    for (Integer rating : car.ratings) {
                        ratingBuilder.append("`").append(rating);
                    }
                    ratingStr = ratingBuilder.toString();
                }
                ratingStr = ratingStr.replace("//", "`"); // Replace forward slashes with backticks
                String rentStr = "";
                if (!car.rentCar.isEmpty()) {
                    StringBuilder rentBuilder = new StringBuilder();
                    for (String rent : car.rentCar) {
                        rentBuilder.append("`").append(rent);
                    }
                    rentStr = rentBuilder.toString();
                }
                String carData = car.getMark() + "`" + car.getModel() + "`" + car.getPrice() + "`" + car.getYearOfProduction() + ratingStr + rentStr;
                writer.write(carData);
                writer.newLine();
            }
            writer.close();
            currentCarNumber++;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Autostart when application is started
//        if(e.getSource()==loadItem) {
////            loadDataFromFile();
//            System.out.println("Instruction to ");
//        }
        if(e.getSource()==saveItem){
            saveCarToFile();
        }
        if(e.getSource()==aboutItem)
            about();
        if(e.getSource()==exitItem)
            System.exit(0);
    }
}
