import java.io.*;

import java.net.*;

public class Slip3AClient {

    public static void main(String args[]) throws Exception {

        Socket s = new Socket("localhost", 7006);

        DataInputStream din = new DataInputStream(System.in);

        System.out.print("Enter any number:");

        String n = din.readLine();

        System.out.println("====================");

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        dos.writeBytes(n + "\n");

        DataInputStream dis = new DataInputStream(s.getInputStream());

        System.out.println(dis.readLine());

    }

}
