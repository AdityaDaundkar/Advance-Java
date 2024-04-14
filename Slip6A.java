import java.awt.*;

public class Slip6A extends Frame {

    int f = 0;

    public Slip6A() {

        Blink s = new Blink();

        s.start();

        setSize(800, 500);

        setVisible(true);

    }

    class Blink extends Thread {

        public void run() {

            while (true) {

                f = (f + 1) % 2;

                repaint();

                try {

                    Thread.sleep(500);

                } catch (Exception e) {

                }

            }

        }

    }

    public void paint(Graphics g) {

        Toolkit t = Toolkit.getDefaultToolkit();

        Image img = t.getImage("./adi.jpg");

        switch (f) {

            case 0:

                g.drawImage(img, 150, 100, this);

        }

    }

    public static void main(String args[]) {

        new Slip6A();

    }

}