package bai12;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class main extends JFrame {

    private CirclePanel circlePanel;
    private JSlider slider;

    public main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);

        circlePanel = new CirclePanel();
        slider = new JSlider(0, 400, 200); // Initial value of 200, range from 0 to 400

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                circlePanel.setRadius(slider.getValue());
            }
        });

        add(circlePanel, BorderLayout.CENTER);
        add(slider, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new main();
            }
        });
    }

    class CirclePanel extends JPanel {
        private int radius = 200; // Initial radius

        public void setRadius(int radius) {
            this.radius = radius;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(getWidth() / 2 - radius / 2, getHeight() / 2 - radius / 2, radius, radius);
        }
    }
}