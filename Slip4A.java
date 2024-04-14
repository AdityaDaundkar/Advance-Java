package jdbcDemo;

import java.sql.*; 

public class Slip4A
{
	public static void main(String args[]) throws Exception
	{
	        Class.forName("com.mysql.jdbc.Driver");

	        Connection con = DriverManager.getConnection
	        		("jdbc:mysql://localhost:3306/aditya", "root", "1234");

	        Statement stmt = con.createStatement();

	        int n = stmt.executeUpdate("delete from Student where Sname like 'S%'");

	 

	        System.out.println(n + " rows deleted..");
	 

	        con.close();

	 

	    }

	}

	 












/*CREATE TABLE Student (Sno INT PRIMARY KEY AUTO_INCREMENT, Sname VARCHAR(255) NOT NULL);
INSERT INTO Student (Sno, Sname) VALUES (1, 'Aditya'),(2, 'Suraj'), (3, 'Mohit');
INSERT INTO Student (Sno, Sname) VALUES (4, 'Sumit'),(5, 'Sujay'), (6, 'Gaurav');
SELECT * from Student;*/
	