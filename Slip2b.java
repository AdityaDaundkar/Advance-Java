import java.awt.*;

public class Slip2b extends Frame {

    int f = 0;

    public Slip2b() {

        Signal s = new Signal();

        s.start();

        setSize(500, 500);

        setVisible(true);

    }

    public void paint(Graphics g) {

        switch (f) {

            case 0:

                g.drawLine(150, 50, 150, 300);

            case 1:

                g.drawRect(150, 50, 100, 90);

        }

    }

    class Signal extends Thread {

        public void run() {

            while (true) {

                f = (f + 1) % 2;

                repaint();

                try {

                    Thread.sleep(1000);

                } catch (Exception e) {

                }

            }

        }

    }

    public static void main(String args[]) {

        new Slip2b();

    }

}
