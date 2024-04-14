<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Details</title>
</head>
<body>
    <h2>Teacher Details</h2>
    <ul>
        <li><strong>Teacher ID:</strong> <%= request.getParameter("tid") %></li>
        <li><strong>Teacher Name:</strong> <%= request.getParameter("tname") %></li>
        <li><strong>Designation:</strong> <%= request.getParameter("desg") %></li>
        <li><strong>Subject:</strong> <%= request.getParameter("subject") %></li>
        <li><strong>Qualification:</strong> <%= request.getParameter("qualification") %></li>
    </ul>
</body>
</html>
