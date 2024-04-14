import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Slip17BServer {
    public static void main(String[] args) {
        final int PORT = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            System.out.println("Server started. Waiting for a client...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String filename = reader.readLine();
                File file = new File(filename);

                if (file.exists()) {
                    writer.println("File Found");
                    BufferedReader fileReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = fileReader.readLine()) != null) {
                        writer.println(line);
                    }
                    fileReader.close();
                } else {
                    writer.println("File Not Found");
                }

                socket.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
