<html>
	<body>
		<font color="red" size="18">
		<%
			int n=Integer.parseInt(request.getParameter("tname"));
			int ld=n%10;
			while(n>9)
				n=n/10;
			
			int fd=n;
			int sum=fd+ld;
			out.println(sum);
			
		%>
		</font>
	</body>
</html>