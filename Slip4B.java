

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 

public class Slip4B extends HttpServlet implements Servlet {

 

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        res.setContentType("html/text");

        PrintWriter pw = res.getWriter();

        pw.println("<html><body><h1><b>INFORMATION OF SERVER</b></h1>");

        pw.println("<br>Server Name:" + req.getServerName());

        pw.println("<br>Server Port:" + req.getServerPort());

        pw.println("<br> Ip Address:" + req.getRemoteAddr());

        pw.println("<br> CLient Browser:" + req.getHeader("User-Agent"));

        pw.println("</body></html>");

        pw.close();

    }

}