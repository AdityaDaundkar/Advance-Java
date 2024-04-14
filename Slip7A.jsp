<html>
	<body>
		<font color=red>
<%@page language="java"%>

<%! int cnt=0; 
 	char ch;
%>

		<%
			String email=request.getParameter("email");
						out.print(email+"");
			for(int i=0;i <email.length();i++)
			{
				ch=email.charAt(i);
				if(ch=='@')
				{
				     cnt++;
				}

				if(ch=='.')
				{
				     cnt++;
						
				}

			}
			
			if(cnt==2)
				 out.println("Valid Email Id ");	
			else
				out.println("InValid Email Id");	
			%>
		</font>
	</body>
</html>