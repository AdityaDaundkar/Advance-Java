import java.io.*;
import java.net.Socket;

public class Slip17BClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int PORT = 12345;

        try {
            Socket socket = new Socket("localhost", 7777);
            System.out.println("Connected to server.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter filename:");
            String filename = userInput.readLine();
            writer.println(filename);

            String response = reader.readLine();
            if (response.equals("File Found")) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } else {
                System.out.println("File Not Found");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
