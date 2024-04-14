<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Number to Words Converter</title>
</head>
<body>
    <h2>Number in Words:</h2>
    <% 
        // Java code to convert number to words
        String number = request.getParameter("number");
        if (number != null && !number.isEmpty()) {
            String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < number.length(); i++) {
                int digit = Character.getNumericValue(number.charAt(i));
                result.append(words[digit]).append(" ");
            }
    %>
    <p style="color: red;"><%= result.toString().trim() %></p>
    <% } else { %>
    <p>No number entered.</p>
    <% } %>
</body>
</html>
