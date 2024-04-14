import java.util.Random;

public class Slip12B {

    static class MyThread extends Thread {
        private Random random = new Random();

        public MyThread(String name) {
            super(name); // Set the name of the thread using the constructor
        }

        @Override
        public void run() {
            System.out.println(getName() + " created.");

            // Generate a random sleep time between 0 and 4999 milliseconds
            int sleepTime = random.nextInt(5000);
            System.out.println(getName() + " will sleep for " + sleepTime + " milliseconds.");

            try {
                Thread.sleep(sleepTime); // Sleep for the random time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(getName() + " is dead.");
        }
    }

    public static void main(String[] args) {
        // Create and start multiple instances of MyThread
        MyThread thread1 = new MyThread("Thread A");
        MyThread thread2 = new MyThread("Thread B");
        MyThread thread3 = new MyThread("Thread C");

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}