<html>
<body>
<% 
int sum1=((Integer)session.getAttribute("p1")).intValue();
int sum2=0;
String []values=request.getParameterValues("item");
if(values!=null)
{
	for(int i=0;i<values.length;i++)
	{
		sum2=sum2+Integer.parseInt(values[i]);
	}
}
int total=sum1+sum2;
out.println("<html>");
out.println("<h2>Summary</h2>");
out.println("sum of Page 1:   "+sum1);
out.println("<br>");
out.println("Sum of Page 2:   "+sum2);
out.println("<br>");
out.println("Total Bill"+total);
out.println("</body>");
out.println("</html>");
%>
</body>
</html>
