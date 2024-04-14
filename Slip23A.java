package jdbcDemo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Slip23A extends JFrame {
    private DefaultTableModel model;

    public Slip23A() {
        setTitle("College Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Create a JTable with DefaultTableModel
        model = new DefaultTableModel();
        JTable table = new JTable(model);

        // Add columns to the model
        model.addColumn("CID");
        model.addColumn("CName");
        model.addColumn("Address");
        model.addColumn("Year");

        // Fetch data from database and populate the table
        fetchCollegeDetails();

        // Add the table to a scroll pane and add it to the frame
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    private void fetchCollegeDetails() {
        try {
            // Establish connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya", "root", "1234");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute query to select all records from the College table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM College2");

            // Iterate through the ResultSet and add each row to the table model
            while (resultSet.next()) {
                String cid = resultSet.getString("CID");
                String cname = resultSet.getString("CName");
                String address = resultSet.getString("Address");
                int year = resultSet.getInt("Year");

                model.addRow(new Object[]{cid, cname, address, year});
            }

            // Close the ResultSet, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Slip23A::new);
    }
}





/*
  CREATE TABLE College2(CID INT PRIMARY KEY AUTO_INCREMENT, CName VARCHAR(255) NOT NULL, Address varchar(100), Year int); 
INSERT INTO College2(CID, CName, Address, Year) VALUES (1, 'HRM', 'Rajgurunagar', 1999),(2, 'GPA', 'Avasari', 2000), (3, 'MIT', 'Alandi', 2001);
 */