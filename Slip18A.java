package jdbcDemo;
import java.util.Scanner;

public class Slip18A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number < 0) {
           // System.out.println("Factorial is not defined for negative numbers.");
        } else {
           // System.out.println("Calculating factorial...");
            try {
                long factorial = calculateFactorial(number);
                System.out.println("Factorial of " + number + " is: " + factorial);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static long calculateFactorial(int n) throws InterruptedException {
        if (n == 0 || n == 1) {
            return 1;
        }

        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
            // Introducing a sleep of 1 second for demonstration purposes
            Thread.sleep(1000);
        }
        return factorial;
    }
}
