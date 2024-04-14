package jdbcDemo;
public class Slip29A extends Thread {
    private int start;
    private int end;
    
    public Slip29A(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public void run() {
        if (start == 1) {
            displayOddNumbers();
        } else {
            displayPrimeNumbers();
        }
    }
    
    private void displayOddNumbers() {
        System.out.println("Odd numbers between 1 to " + end + ":");
        for (int i = 1; i <= end; i += 2) {
            System.out.println(i);
        }
    }
    
    private void displayPrimeNumbers() {
        System.out.println("Prime numbers between 1 to " + end + ":");
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int n = 20; // Change n to whatever value you want
        Slip29A oddThread = new Slip29A(1, n);
        Slip29A primeThread = new Slip29A(2, n);
        
        oddThread.start();
        primeThread.start();
    }
}
