package servlet;

import java.io.*;
import java.net.*;

public class TimeClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost"; // Server address
        int port = 1234; // Port number

        Socket socket = new Socket(serverAddress, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Receive date and time from the server
        String serverDateTime = in.readLine();
        System.out.println("Server's date and time: " + serverDateTime);

        socket.close();
    }
}
