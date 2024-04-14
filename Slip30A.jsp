<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reversed String</title>
</head>
<body>
    <h2>Reversed String:</h2>
    <%
        // Retrieve the string entered by the user
        String inputString = request.getParameter("inputString");
        
        // Reverse the string
        StringBuilder reversedString = new StringBuilder(inputString);
        reversedString.reverse();
        
        // Display the reversed string
        out.println("<p>" + reversedString.toString() + "</p>");
    %>
</body>
</html>
