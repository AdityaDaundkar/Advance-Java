import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Slip23B extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // JDBC connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/atish";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Initialize connection and statement objects
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atish", "root", "1234") ){
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // User found, display success message
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h2>Login Successful!</h2>");
                out.println("<p>Welcome, " + username + "!</p>");
                out.println("</body></html>");
            } else {
                // User not found, display error message
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h2>Login Failed</h2>");
                out.println("<p>Invalid username or password.</p>");
                out.println("</body></html>");
            }
        } catch (SQLException e) {
            throw new ServletException("Database access error!", e);
        }
    }
}










/*CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);

-- Insert sample data into the users table
INSERT INTO users (username, password) VALUES ('aditya', '1234');
INSERT INTO users (username, password) VALUES ('atish', '4321');
INSERT INTO users (username, password) VALUES ('admin', 'pass123');
*/