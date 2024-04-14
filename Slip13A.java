public class Slip13A {

    public static void main(String[] args) {
        // Create and start multiple threads
        Thread thread1 = new Thread(new MyRunnable(), "Thread 1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread 2");

        thread1.start();
        thread2.start();

        // Main thread will also print its name
        System.out.println("Main thread name: " + Thread.currentThread().getName());
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            // Each thread will print its own name
            System.out.println("Currently executing thread name: " + Thread.currentThread().getName());
        }
    }
}