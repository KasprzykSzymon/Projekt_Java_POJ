import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class MyFrame extends JFrame implements ActionListener  {
    private static int currentCarNumber = 1;
    final JMenu fileMenu;
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
        this.setSize(600,600);
        ImageIcon image = new ImageIcon("lib/Picture/TitlePicture.png"); //Create an ImageIcon
        this.setIconImage(image.getImage());  //Change icon of frame
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
    private void about(){
        JOptionPane.showMessageDialog(this, "Program o nazwie Wypozyczalnia Samochodow zostal napisany na cele projektu na studia. \nSklad zespolu: \n Lider: <Szymon Kasprzyk>, \nPomocnik: <Michal Gruszczynski>, \nPowolna pomoc: Oskar Pytlewki, \nProzniak: klaudia iwanowicz");
    }
    private static void saveCarToFile() {
        try {
            String ratingStr="", rentStr="";
            BufferedWriter writer = new BufferedWriter(new FileWriter("samochody.txt", true));
            for (GUI.Car car: GUI.Cars) {
//                if(car.ratings.isEmpty())
//                    ratingStr = "0";
//                else
//                    for (Integer rating : car.ratings) {
//                        ratingStr += ",," + rating.toString();
//                    }
//                if(car.rentCar.isEmpty())
//                    rentStr = "0";
//                else
//                    for (String rent : car.rentCar){
//                        rentStr += ",," + rent.substring(28);
//                    }
                writer.write(car.getMark() + "," + car.getModel() + "," + car.getPrice() + "," + car.getYearOfProduction() + "," +ratingStr + ","+rentStr);
                writer.newLine();
            }
            writer.close();
            currentCarNumber++;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private static void loadDataFromFile() {
        try {
            String[] parametrs, ratings, rents;
            BufferedReader reader = new BufferedReader(new FileReader("samochody.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                parametrs = line.split(",");
                GUI.Car Car = new GUI.Car(parametrs[0], parametrs[1], Double.parseDouble(parametrs[2]), Short.parseShort(parametrs[3]));
                GUI.Cars.add(Car);
//                if(parametrs.length > 4) {
//                    ratings = parametrs[4].split(",,");
//                    for (int i = 0; i < ratings.length - 1; i++)
//                        Car.addRating(Integer.parseInt(ratings[i]));
//                    if(parametrs.length > 5){
//                        rents = parametrs[5].split((".."));
//                        for (int i = 0; i < rents.length - 1; i++){
//                            Car.AddRentCarFromLoad(rents[i].substring(0,10), Integer.parseInt(rents[i].substring(11,14)));
//                        }
//                    }
                }
//            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loadItem) {
            loadDataFromFile();
        }
        if(e.getSource()==saveItem){
            saveCarToFile();
        }
        if(e.getSource()==aboutItem)
            about();
        if(e.getSource()==exitItem)
            System.exit(0);
    }
}
