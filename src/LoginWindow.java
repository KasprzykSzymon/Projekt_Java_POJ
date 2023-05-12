
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LoginWindow {
    private JFrame frame;
    private JPanel panel;
    private JLabel lblUsername;

    private JTextField txtUsername;
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginWindow() {
        frame = new JFrame("Login");
        panel = new JPanel();
        lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(20);
        lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField(20);
        btnLogin = new JButton("Login");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:postgresql://localhost:5432/";
                String dbName = "rental";
                String driver = "org.postgresql.Driver";
                String username = txtUsername.getText();
                String password = String.valueOf(txtPassword.getPassword());

                Connection conn = null;
                Statement statement = null;
                ResultSet resultSet = null;

                try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(url + dbName, username, password);

                    // Check if the "cars" table exists
                    statement = conn.createStatement();
                    resultSet = statement.executeQuery("SELECT to_regclass('public.cars')");

                    if (resultSet.next() && resultSet.getString(1) == null) {
                        // "cars" table doesn't exist, create it
                        String createTableQuery = "CREATE TABLE cars (id SERIAL PRIMARY KEY, make VARCHAR(255), model VARCHAR(255), year INTEGER, rental_price FLOAT)";
                        statement.executeUpdate(createTableQuery);
                        System.out.println("Table created successfully");
                    } else {
                        // "cars" table exists, do nothing
                        System.out.println("Table already exists");
                    }

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        if (resultSet != null) resultSet.close();
                        if (statement != null) statement.close();
                        if (conn != null) conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    frame.dispose();
                }
            }
        });

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Launch the LoginWindow
        LoginWindow loginWindow = new LoginWindow();
    }
}

