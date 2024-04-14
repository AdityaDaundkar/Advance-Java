package jdbcDemo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Slip8A {

    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya","root","1234");
        Statement st=con.createStatement();
        ResultSet rs =st.executeQuery("select * from emp Where ename like 'A%' ");
        System.out.println("ename");
       while(rs.next())
        {
           System.out.println(rs.getString(2));
        }
con.close();
rs.close();
st.close();
    }

}








/*CREATE TABLE emp (eno INT PRIMARY KEY AUTO_INCREMENT, ename VARCHAR(255) NOT NULL,Department VARCHAR(44), Salary INT NOT NULL);
INSERT INTO emp (eno, ename, Department, Salary) VALUES (11, 'Omkar', 'Computer Science', 45000),(22, 'Rohit','BCOM',51000), (33, 'Atish', 'BA',65000);
SELECT * from emp;
*/