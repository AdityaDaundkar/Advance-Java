import java.io.*;
import java.net.*;

public class Slip25AClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address
        int serverPort = 12345; // Server port number

        try (Socket socket = new Socket("localhost", 12345)) {
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter a number: ");
            String numberStr = userInput.readLine();

            // Send the number to the server
            out.println(numberStr);

            // Receive and print the factors from the server
            String response = in.readLine();
            System.out.println("Factors of " + numberStr + ": " + response);
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverAddress);
        } catch (IOException e) {
            System.err.println("Error with I/O: " + e.getMessage());
        }
    }
}
