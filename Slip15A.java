package jdbcDemo;
class Slip15A implements Runnable {
    public void run() {
        try {
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.println(c);
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void main(String[] d) {
        Slip15A x = new Slip15A();
        Thread y = new Thread(x);
        y.start();
        // x.run();
    }
}
