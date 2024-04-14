import java.io.*;

import java.net.*;

public class Slip3AServer {

    public static void main(String args[]) throws Exception {

        ServerSocket ss = new ServerSocket(7006);

        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());

        int n = Integer.parseInt(dis.readLine());

        int i, cnt = 0;

        for (i = 2; i < n; i++) {

            if (n % i == 0)

                cnt++;

            break;

        }

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        if (cnt == 0)

            dos.writeBytes(n + " is prime number.");

        else

            dos.writeBytes(n + " is not prime number.");

        s.close();

    }

}
