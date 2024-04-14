package jdbcDemo;
import java.sql.*;

class Slip26A {
    public static void main(String args[]) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya", "root", "1234");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select CName from college1");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        con.close();
    }
}



//CREATE TABLE college1 (CID INT PRIMARY KEY AUTO_INCREMENT, CName VARCHAR(233) NOT NULL, addr CHAR(45));
//INSERT INTO college1(CID, CName, addr) VALUES (101, 'HRM', 'Rajgurunagar'),(102, 'MIT', 'Alandi'), (103, 'DY.Patil', 'Pimpri');
//select * from college1;
