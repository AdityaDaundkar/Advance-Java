package servlet;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class Mark extends HttpServlet
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String sno=req.getParameter("t1");
String sn=req.getParameter("t2");
String cn=req.getParameter("t3");
int tm=Integer.parseInt(req.getParameter("t4"));
int p=tm/6;
String gd;
if(p>=70)
{
gd="Dist";
}
else if(p>=60 && p<70)
{
gd="First";
}
else if(p>=50 && p<60)
{
gd="Second";
}
else if(p>=40 && p<50)
{
gd="Pass";
}
else
gd="Fail"; 
pw.println("<table border=1>" + "<th>SeatNo</th>" + "<th>Stud Name</th>" +"<th>Class</th>" +"<th>Percentage</th>" +"<th>Grad</th>" );
pw.println("<tr>");
pw.println("<td>" + sno + "</td>");
pw.println("<td>" + sn +"</td>");
pw.println("<td>" + cn + "</td>");
pw.println("<td>" + p + "</td>");
pw.println("<td>" + gd + "</td>");
pw.println("</tr>");
pw.println("</table>");
}
}