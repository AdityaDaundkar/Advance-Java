<html>
<head>
<title>Check Credentials</title>
</head>
<body>
<%
        String uid=request.getParameter("id");
        String password=request.getParameter("pass");
        session.setAttribute("session-uid", uid);
        if(uid.equals("Aditya") && password.equals("1234"))
        {
			response.sendRedirect("Slip16A_success.jsp");
        }
        else
		{
            response.sendRedirect("Slip16A_failed.jsp");
        }
        %>
</body>
</html>