import java.awt.*;

 

public class Slip5B extends Frame {

 

    int f = 0;

 

    public Slip5B() {

        Signal s = new Signal();

        s.start();

        setSize(500, 500);

        setVisible(true);

    }

 

    public void paint(Graphics g) {

        switch (f) {

 

            case 0:

                g.setColor(Color.red);

                g.fillOval(60, 60, 50, 50);

                g.setColor(Color.black);

                g.fillOval(60, 120, 50, 50);

                g.fillOval(60, 180, 50, 50);

                break;

 

            case 1:

                g.setColor(Color.yellow);

                g.fillOval(60, 120, 50, 50);

                g.setColor(Color.black);

                g.fillOval(60, 60, 50, 50);

                g.fillOval(60, 180, 50, 50);

                break;

 

            case 2:

                g.setColor(Color.green);

                g.fillOval(60, 180, 50, 50);

                g.setColor(Color.black);

                g.fillOval(60, 120, 50, 50);

                g.fillOval(60, 60, 50, 50);

                break;

        }

    }

 

    class Signal extends Thread {

        public void run() {

            while (true) {

                f = (f + 1) % 3;

                repaint();

                try {

                    Thread.sleep(1000);

                } catch (Exception e) {

 

                }

            }

        }

    }

 

    public static void main(String args[]) {

        new Slip5B();

    }

}