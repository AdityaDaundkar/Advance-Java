public class Slip21A {

    public static void main(String args[]) {

        Thread t = Thread.currentThread();

        t.setPriority(2);

        System.out.println("Thread Name : " + t.getName());

        System.out.println("Thread Prioriy : " + t.getPriority());

    }

}