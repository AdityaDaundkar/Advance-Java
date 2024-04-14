<%@page import="java.sql.*" errorPage="err.jsp"%>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya","root","1234");

int ano = Integer.parseInt(request.getParameter("ano"));
String type = request.getParameter("accType");
float bal = Float.parseFloat(request.getParameter("bal"));
PreparedStatement ps = con.prepareStatement("insert into account values(?,?,?)");
ps.setInt(1,ano);
ps.setString(2,type);
ps.setFloat(3,bal);
ps.executeUpdate();
%>
Account created successfully.<br>
<a href='Slip22B.html'>Add Account</a> <a href='Slip22B_view_accounts.jsp'>View Accounts</a>