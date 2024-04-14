<html>
<body>
<% 
int sum=0;
String []values=request.getParameterValues("item");
if(values!=null)
{
	for(int i=0;i<values.length;i++)
	{
		sum=sum+Integer.parseInt(values[i]);
	}
}
session.setAttribute("p1",sum);
response.sendRedirect("Slip9B1.html");
%>
</body>
</html>