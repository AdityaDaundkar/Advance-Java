package jdbcDemo;
import java.sql.*;
import java.util.Scanner;

public class Slip16B {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/aditya";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya", "root", "1234");
            System.out.println("Connected to database.");

            // Accepting student details for at least 5 records
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 5; i++) {
                System.out.println("Enter details for Student " + (i + 1) + ":");
                System.out.print("Roll Number: ");
                int rollNumber = scanner.nextInt();
                System.out.print("Student Name: ");
                String studentName = scanner.next();
                System.out.print("Percentage: ");
                double percentage = scanner.nextDouble();

                // Inserting student details into the database
                String sql = "INSERT INTO students1 (rno, sname, per) VALUES (?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, rollNumber);
                preparedStatement.setString(2, studentName);
                preparedStatement.setDouble(3, percentage);
                preparedStatement.executeUpdate();
            }

            // Retrieving details of student with the highest percentage
            String highestPercentageQuery = "SELECT * FROM students1 WHERE per = (SELECT MAX(per) FROM students1)";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(highestPercentageQuery);

            System.out.println("\nDetails of student with the highest percentage:");
            while (resultSet.next()) {
                int rollNumber = resultSet.getInt("rno");
                String studentName = resultSet.getString("sname");
                double percentage = resultSet.getDouble("per");

                System.out.println("Roll Number: " + rollNumber + ", Student Name: " + studentName + ", Percentage: " + percentage);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



//Create Table students1 (rno int, sname Char(30), per int);
