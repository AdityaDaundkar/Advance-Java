package jdbcDemo;


import java.util.*;
import java.sql.*;  //step 1 - import the package

public class Slip20A
{
	public static void main(String args[]) throws Exception
	{
	Connection con;
	PreparedStatement ps;
	String query;
	
	int a;
	
	
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Pls Enter eno");  
		a=sc.nextInt();
	}
	Class.forName("com.mysql.jdbc.Driver");  
	
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya","root","1234"); 
	
	query="delete from Employee where eno=?"; 
		
	ps=con.prepareStatement(query);  
	
	ps.setInt(1,a);
	
	
	int n=ps.executeUpdate(); 
	if(n>0)
	System.out.println(n+" RECORDs DELETED SUCCESSFULLY");
	else
	System.out.println("RECORD NOT DELETED");
	
	ps.close();		
	con.close();
	
	}
}





//CREATE TABLE Employee (eno INT PRIMARY KEY AUTO_INCREMENT, ename VARCHAR(255) NOT NULL, Salary INT NOT NULL);
//INSERT INTO Employee (eno, ename, Salary) VALUES (1, 'Aditya', 49000),(2, 'Suraj', 50000), (3, 'Mohit', 55000);
//SELECT * from Employee;
//DROP table Employee;

