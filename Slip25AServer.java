import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Slip25AServer {
    public static void main(String[] args) {
        int port = 12345; // Port number for the server

        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port " + 12345);

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                try {
                    // Read the number sent by the client
                    String input = in.readLine();
                    int number = Integer.parseInt(input);

                    // Calculate factors of the number
                    List<Integer> factors = calculateFactors(number);

                    // Send factors back to the client
                    out.println(factors.toString());
                } catch (NumberFormatException e) {
                    out.println("Invalid number format. Please send a valid integer.");
                } finally {
                    // Close the connection
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> calculateFactors(int number) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }

        return factors;
    }
}
