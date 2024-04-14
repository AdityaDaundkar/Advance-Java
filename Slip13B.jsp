<%@page import="java.sql.*"%>
<html>
<head>
<title>College Details</title>
</head>
<body>
<h1>College Details</h1>
<table border="1">
<tr>
<th>College ID</th>
<th>College Name</th>
<th>Address</th>
</tr>
<%
try {
    // Load the JDBC driver and establish a connection to the database
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya", "root", "1234");

    // Execute a SELECT query to retrieve the college details
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT CollegeID, Coll_Name, Address FROM College");


    // Loop through the result set and display the college details in the table
    while (rs.next()) {
        %>
        <tr>
        <td><%= rs.getString("CollegeID") %></td>
        <td><%= rs.getString("Coll_Name") %></td>
        <td><%= rs.getString("Address") %></td>
        </tr>
        <%
    }

    // Clean up resources
    rs.close();
    stmt.close();
    con.close();
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
}
%>
</table>
</body>
</html>