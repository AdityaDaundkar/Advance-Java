package jdbcDemo;
import java.sql.*;
import java.util.Scanner;

class Slip9A {
    public static void main(String args[]) throws Exception {
        Connection con;
        PreparedStatement pstmt;
        int e1, s;
        String enm;

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya", "root", "1234");

        pstmt = con.prepareStatement("create table employee1(eid int(8),ename varchar(20),sal int(8))");
        pstmt.executeUpdate();

        System.out.println("Table Created Successfully!!!!!!");
        System.out.println("=====================================");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee Id:");
        e1 = scanner.nextInt();

        System.out.println("Enter Employee Name:");
        enm = scanner.next();

        System.out.println("Enter Employee Salary:");
        s = scanner.nextInt();

        pstmt = con.prepareStatement("insert into employee1 values(?,?,?)");

        pstmt.setInt(1, e1);
        pstmt.setString(2, enm);
        pstmt.setInt(3, s);

        pstmt.executeUpdate();
        System.out.println("Record Inserted Successfully!!!!!!");

        con.close();
        scanner.close();
    }
}
