

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Slip6b
 */
public class Slip6b extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int i=1;
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws IOException,ServletException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String k=String.valueOf(i);
        Cookie c=new Cookie("visit",k);
        response.addCookie(c);
        int j=Integer.parseInt(c.getValue());
        if(j==1) {
            out.println("Welcome to web page ");
        }
        else {
            out.println("You are visited at "+i+" times");
        }
        i++;
    }
}