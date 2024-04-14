import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Slip1A extends JFrame {
    private JLabel scrollingLabel;

    public Slip1A() {
        setTitle("Text Scroller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        setLocationRelativeTo(null);

        scrollingLabel = new JLabel("Welcome Aditya", JLabel.CENTER);
        scrollingLabel.setFont(new Font("Arial", Font.BOLD, 20));

        getContentPane().add(scrollingLabel);

        Timer timer = new Timer(5, new ScrollText());
        timer.start();
    }

    private class ScrollText implements ActionListener {
        private int direction = 1;
        private int currentX = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            Dimension size = scrollingLabel.getSize();
            int labelWidth = size.width;

            if (currentX >= labelWidth) {
                direction = -1;
            } else if (currentX <= 0) {
                direction = 1;
            }

            currentX += direction;

            scrollingLabel.setLocation(scrollingLabel.getLocation().x + direction, scrollingLabel.getLocation().y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Slip1A demo = new Slip1A();
            demo.setVisible(true);
        });
    }
}
