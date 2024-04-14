import java.awt.*;

import java.awt.event.*;

 

public class Slip3B extends Frame implements Runnable {

    private int x, y, w, h, f;

    private Color c = Color.red;

 

    public Slip3B() {

        setTitle("Bouncing Boll");

        setSize(400, 400);

        setVisible(true);

        w = getWidth();

        h = getHeight();

        x = (int) (Math.random() * getWidth());

        y = (int) (Math.random() * getHeight());

        Thread t = new Thread(this);

        t.start();

    }

 

    public void run() {

        while (true) {

            switch (f) {

                case 0:

                    y++;

                    if (y > h - 50) {

                        c = new Color((int) (Math.random() * 256), (int) (Math.random() * 256),

                                (int) (Math.random() * 256));

                        f = 1;

                    }

                    break;

                case 1:

                    y--;

                    if (y < 0) {

                        c = new Color((int) (Math.random() * 256), (int) (Math.random() * 256),

                                (int) (Math.random() * 256));

                        f = 0;

                    }

            }

            repaint();

            try {

                Thread.sleep(10);

            } catch (Exception e) {

            }

        }

    }

 

    public void paint(Graphics g) {

        super.paint(g);

        g.setColor(c);

        g.fillOval(x, y, 20, 20);

    }

 

    public static void main(String args[]) {

        new Slip3B();

    }

}