package servlet;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 1234; // Port number
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");

            // Send current date and time to the client
            LocalDateTime now = LocalDateTime.now();
            String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(formattedDateTime);

            clientSocket.close();
        }
    }
}
