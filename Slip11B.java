import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Slip11B {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atish", "root", "1234")) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Enter start date (yyyy-mm-dd): ");
            String startDateStr = scanner.nextLine();
            System.out.print("Enter end date (yyyy-mm-dd): ");
            String endDateStr = scanner.nextLine();
            
            // Prepare SQL query to fetch sales between two dates
            String sql = "SELECT PID, PName, Qty, Rate, Amount FROM sales WHERE SaleDate BETWEEN ? AND ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, startDateStr);
                stmt.setString(2, endDateStr);
                
                // Execute the query
                ResultSet rs = stmt.executeQuery();
                
                // Display the sales details
                System.out.println("Sales details between " + startDateStr + " and " + endDateStr + ":");
                System.out.println("------------------------------------------");
                System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", "PID", "PName", "Qty", "Rate", "Amount");
                System.out.println("------------------------------------------");
                
                while (rs.next()) {
                    int pid = rs.getInt("PID");
                    String pname = rs.getString("PName");
                    int qty = rs.getInt("Qty");
                    double rate = rs.getDouble("Rate");
                    double amount = rs.getDouble("Amount");
                    
                    System.out.printf("%-5d %-20s %-10d %-10.2f %-10.2f\n", pid, pname, qty, rate, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}









/*CREATE TABLE sales (
    PID INT AUTO_INCREMENT PRIMARY KEY,
    PName VARCHAR(255),
    Qty INT,
    Rate DOUBLE,
    Amount DOUBLE,
    SaleDate DATE
);

INSERT INTO sales (PName, Qty, Rate, Amount, SaleDate)
VALUES ('Product A', 10, 15.5, 155.0, '2024-04-01');

INSERT INTO sales (PName, Qty, Rate, Amount, SaleDate)
VALUES ('Product B', 5, 20.0, 100.0, '2024-04-03');

INSERT INTO sales (PName, Qty, Rate, Amount, SaleDate)
VALUES ('Product C', 8, 12.75, 102.0, '2024-04-05');

INSERT INTO sales (PName, Qty, Rate, Amount, SaleDate)
VALUES ('Product A', 15, 15.5, 232.5, '2024-04-08');

INSERT INTO sales (PName, Qty, Rate, Amount, SaleDate)
VALUES ('Product B', 3, 20.0, 60.0, '2024-04-10');*/