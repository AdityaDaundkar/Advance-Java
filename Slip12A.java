package jdbcDemo;import java.io.*;

import java.sql.*;

 

class Slip12A {

    public static void main(String args[]) throws Exception {

 

        Statement stmt;

        ResultSet rs;

        int cnt = 0;

 

        Class.forName("com.mysql.jdbc.Driver");

 

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya", "root", "1234");

 

        stmt = con.createStatement();

 

        rs = stmt.executeQuery("select * from employee1");

 

        while (rs.next()) {

            cnt++;

        }

 

        System.out.println("Total number of records in table is : " + cnt);

 

        con.close();

    }

}

 
