package jdbcDemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Slip19B extends JFrame implements ActionListener {
    private JTextField rnoField;
    private JTextField snameField;
    private JTextField perField;
    private JButton displayButton;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public Slip19B() {
        setTitle("Student Record Viewer");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Roll No:"));
        
        rnoField = new JTextField();
        panel.add(rnoField);

        panel.add(new JLabel("Name:"));
        snameField = new JTextField();
        panel.add(snameField);

        panel.add(new JLabel("Percentage:"));
        perField = new JTextField();
        panel.add(perField);

        displayButton = new JButton(" Display Student Record...!!");
        displayButton.addActionListener(this);
        panel.add(displayButton);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayButton) {
            displayFirstRecord();
        }
    }

    private void displayFirstRecord() {
        try {
            // Establishing connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya", "root", "1234");
            statement = connection.createStatement();

            // Query to select the first record from the student table
            String query = "SELECT * FROM students1 LIMIT 1";
            resultSet = statement.executeQuery(query);

            // Displaying record onto the TextFields
            if (resultSet.next()) {
                rnoField.setText(resultSet.getString("rno"));
                snameField.setText(resultSet.getString("sname"));
                perField.setText(resultSet.getString("per"));
            } else {
                JOptionPane.showMessageDialog(this, "No records found.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Slip19B().setVisible(true);
        });
    }
}
