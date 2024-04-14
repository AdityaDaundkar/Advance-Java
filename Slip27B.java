package jdbcDemo;
import java.sql.*;

public class Slip27B {

    public static void main(String[] args) {
        try {
            // Establish connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya", "root", "1234");

            // Create a statement with scrollable ResultSet
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Execute query to select all records from the Teacher table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Teacher1");

            // Move the cursor to the first row
            resultSet.first();

            // Iterate through the ResultSet and display the records
            System.out.println("Teacher Table:");
            System.out.println("TID\tTName\tSalary\tSubject");
            while (resultSet.next()) {
                int tid = resultSet.getInt("TID");
                String tName = resultSet.getString("TName");
                double salary = resultSet.getDouble("Salary");
                String subject = resultSet.getString("Subject");
                System.out.println(tid + "\t" + tName + "\t" + salary + "\t" + subject);
            }

            // Move the cursor to the last row
            resultSet.last();

            // Display the last record
            System.out.println("\nLast Record:");
            int tid = resultSet.getInt("TID");
            String tName = resultSet.getString("TName");
            double salary = resultSet.getDouble("Salary");
            String subject = resultSet.getString("Subject");
            System.out.println(tid + "\t" + tName + "\t" + salary + "\t" + subject);

            // Close the ResultSet, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




/*CREATE TABLE Teacher1(TID INT PRIMARY KEY AUTO_INCREMENT, TName VARCHAR(255) NOT NULL, Salary INT NOT NULL, Subject char(30));
INSERT INTO Teacher1 (TID, TName, Salary, Subject) VALUES (1, 'Aditya', 25000, 'java'),(2, 'Suraj',23000, 'Android'), (3, 'Mohit', 20000, 'RTIT');

select * from Teacher1;*/