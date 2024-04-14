package jdbcDemo;
import java.net.InetAddress;

public class Slip11A {
    public static void main(String[] args) {
        try {
            InetAddress clientAddr = InetAddress.getLocalHost();
            System.out.println("IP address of client machine: " + clientAddr.getHostAddress());
            System.out.println("Name of client machine: " + clientAddr.getHostName());
        } catch (Exception e) {
            System.out.println("Error while getting client machine info: " + e.getMessage());
        }
    }
}