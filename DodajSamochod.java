import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajSamochod extends JFrame implements ActionListener {

        JTextField myTextFieldMarka ;
        JTextField myTextFieldModel ;
        JTextField myTextFieldRokProdukcji ;
        JTextField myTextFieldKwotaZaDzien ;
        JCheckBox checkBox;
        JButton buttonPowrot ;
        JButton buttonZatwierdz ;

        DodajSamochod(){
                this.setTitle("Wypozyczalnia Samochodow");  //sets title of frame
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.pack();
                this.setVisible(true); //make frame visible
                this.setSize(500,500);
                this.setLayout(new BorderLayout());


                JPanel panel = new JPanel();
                this.add(panel, BorderLayout.NORTH);
                JLabel titleLabel  = new JLabel("Podaj parametry samochodu:");
                panel.add(titleLabel);
                panel.setBackground(Color.GREEN);


                JPanel panel1 = new JPanel();
                this.add(panel1, BorderLayout.CENTER);
                panel1.setBackground(new Color(0, 200, 0));
                panel1.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
                panel1.setLayout(new GridLayout(0,2,10,5));

                JLabel Label1 = new JLabel("Podaj marke samochodu:  \t");
                Label1.setBackground(Color.GREEN);
                panel1.add(Label1);

                myTextFieldMarka = new JTextField();
                myTextFieldMarka.setPreferredSize(new Dimension(250,40));
                myTextFieldMarka.setFont(new Font("Arctic", Font.PLAIN,35));
                myTextFieldMarka.setForeground(Color.GREEN);
                myTextFieldMarka.setBackground(Color.BLACK);
                myTextFieldMarka.setCaretColor(Color.WHITE);
//                myTextFieldMarka.setText("(Np OPEL)");
                panel1.add(myTextFieldMarka);


                JLabel Label2 = new JLabel("Podaj model samochodu: \t");
                Label2.setBackground(Color.GREEN);
                panel1.add(Label2);

                myTextFieldModel = new JTextField();
                myTextFieldModel.setPreferredSize(new Dimension(250,40));
                myTextFieldModel.setFont(new Font("Arctic", Font.PLAIN,35));
                myTextFieldModel.setForeground(Color.GREEN);
                myTextFieldModel.setBackground(Color.BLACK);
                myTextFieldModel.setCaretColor(Color.WHITE);
//                myTextFieldModel.setText("(Np ASTRA)");
                panel1.add(myTextFieldModel);

                JLabel Label4 = new JLabel("Podaj rok produkcji: \t");
                panel1.add(Label4);
                Label4.setBackground(Color.GREEN);

                myTextFieldRokProdukcji = new JTextField();
                myTextFieldRokProdukcji.setPreferredSize(new Dimension(250,40));
                myTextFieldRokProdukcji.setFont(new Font("Arctic", Font.PLAIN,35));
                myTextFieldRokProdukcji.setForeground(Color.GREEN);
                myTextFieldRokProdukcji.setBackground(Color.BLACK);
                myTextFieldRokProdukcji.setCaretColor(Color.WHITE);
//                myTextFieldRokProdukcji.setText("(Np 2020)");
                panel1.add(myTextFieldRokProdukcji);

                JLabel Label3 = new JLabel("Podaj cene za dzien wynajmu: \t");
                panel1.add(Label3);
                Label3.setBackground(Color.GREEN);

                myTextFieldKwotaZaDzien = new JTextField();
                myTextFieldKwotaZaDzien.setPreferredSize(new Dimension(250,40));
                myTextFieldKwotaZaDzien.setFont(new Font("Arctic", Font.PLAIN,35));
                myTextFieldKwotaZaDzien.setForeground(Color.GREEN);
                myTextFieldKwotaZaDzien.setBackground(Color.BLACK);
                myTextFieldKwotaZaDzien.setCaretColor(Color.WHITE);
//                myTextFieldKwotaZaDzien.setText("(Np 100)");
                panel1.add(myTextFieldKwotaZaDzien);

                checkBox = new JCheckBox();
                checkBox.setText("Nie jestem robotem :)");
                checkBox.setBackground(Color.GREEN);
                checkBox.setFocusable(false);
                panel1.add(checkBox);


                panel1.setBackground(Color.GREEN);

                JPanel panel2 = new JPanel();
                panel2.setBackground(new Color(0,200,0));
                this.add(panel2, BorderLayout.SOUTH);
//                panel2.setPreferredSize(new Dimension(100,100));
                panel2.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
                panel2.setLayout(new GridLayout(0,4,10,5));

                buttonPowrot = new JButton(" Powrot ");
                panel2.add(buttonPowrot);
                buttonPowrot.setBackground(new Color(255,100,100));
                buttonPowrot.setBorder(BorderFactory.createEtchedBorder());
                buttonPowrot.setSize(250,20);


                JLabel lb1 = new JLabel();
                panel2.add(lb1);
                JLabel lb2 = new JLabel();
                panel2.add(lb2);

                buttonZatwierdz = new JButton(" Zatwierdz ");
                panel2.add(buttonZatwierdz);
                buttonZatwierdz.setBackground(new Color(0,255,0));
                buttonZatwierdz.setBorder(BorderFactory.createEtchedBorder());
                buttonZatwierdz.setSize(250,20);
                buttonZatwierdz.addActionListener(this);


        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource()==buttonPowrot){

                }
                if(e.getSource()==buttonZatwierdz){
                        myTextFieldMarka.getText();
                        myTextFieldModel.getText();
                        myTextFieldKwotaZaDzien.getText();
                        myTextFieldKwotaZaDzien.getText();


                }

        }
}
