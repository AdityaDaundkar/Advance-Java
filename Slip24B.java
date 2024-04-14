package jdbcDemo;

import java.sql.*;
import java.util.Scanner;

public class Slip24B {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/aditya\", \"root\", \"1234";

    static final String USER = "root";
    static final String PASS = "1234";

    static Connection conn = null;
    static Statement stmt = null;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya\", \"root\" \"1234");
            stmt = conn.createStatement();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nEmployee Management System");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. Search");
                System.out.println("5. Display");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertEmployee();
                        break;
                    case 2:
                        updateEmployee();
                        break;
                    case 3:
                        deleteEmployee();
                        break;
                    case 4:
                        searchEmployee();
                        break;
                    case 5:
                        displayEmployees();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        if (conn != null) conn.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertEmployee() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nInsert Employee");
        System.out.print("Enter Employee Number: ");
        int eno = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        String ename = scanner.next();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter Designation: ");
        String desg = scanner.next();

        String sql = "INSERT INTO Emp(ENo, EName, salary, Desg) VALUES (" + eno + ", '" + ename + "', " + salary + ", '" + desg + "')";
        int rowsAffected = stmt.executeUpdate(sql);
        if (rowsAffected > 0) {
            System.out.println("Employee inserted successfully.");
        } else {
            System.out.println("Failed to insert employee.");
        }
    }

    private static void updateEmployee() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nUpdate Employee");
        System.out.print("Enter Employee Number to update: ");
        int eno = scanner.nextInt();
        System.out.print("Enter new Salary: ");
        double salary = scanner.nextDouble();

        String sql = "UPDATE Emp SET salary = " + salary + " WHERE ENo = " + eno;
        int rowsAffected = stmt.executeUpdate(sql);
        if (rowsAffected > 0) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found or update failed.");
        }
    }

    private static void deleteEmployee() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDelete Employee");
        System.out.print("Enter Employee Number to delete: ");
        int eno = scanner.nextInt();

        String sql = "DELETE FROM Emp WHERE ENo = " + eno;
        int rowsAffected = stmt.executeUpdate(sql);
        if (rowsAffected > 0) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found or delete failed.");
        }
    }

    private static void searchEmployee() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSearch Employee");
        System.out.print("Enter Employee Number to search: ");
        int eno = scanner.nextInt();

        String sql = "SELECT * FROM Emp WHERE ENo = " + eno;
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            System.out.println("Employee Details:");
            System.out.println("Employee Number: " + rs.getInt("ENo"));
            System.out.println("Employee Name: " + rs.getString("EName"));
            System.out.println("Salary: " + rs.getDouble("salary"));
            System.out.println("Designation: " + rs.getString("Desg"));
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void displayEmployees() throws SQLException {
        System.out.println("\nEmployee List");
        String sql = "SELECT * FROM Emp";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println("Employee Number: " + rs.getInt("ENo"));
            System.out.println("Employee Name: " + rs.getString("EName"));
            System.out.println("Salary: " + rs.getDouble("salary"));
            System.out.println("Designation: " + rs.getString("Desg"));
            System.out.println("--------------------");
        }
    }
}
