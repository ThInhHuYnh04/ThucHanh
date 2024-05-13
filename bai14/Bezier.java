package bai14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;

public class Bezier extends JFrame {
    private Path2D path;
    private float[] coords = new float[6];
    private float t = 0.0f;
    private String name;

    public Bezier() {
        path = new Path2D.Float();
        path.moveTo(50, 300);
        path.curveTo(100, 100, 200, 200, 300, 50);
         name = JOptionPane.showInputDialog("Enter your name: ");

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t += 0.01f;
                if (t > 1.0f) {
                    t = 0.0f;
                }
                repaint();
            }
        });
        timer.start();

        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.draw(path);

        PathIterator iterator = path.getPathIterator(null);
        float lastX = 0, lastY = 0;

        while (!iterator.isDone()) {
            int type = iterator.currentSegment(coords);
            if (type == PathIterator.SEG_CUBICTO) {
                float x = interpolate(coords[0], coords[2], coords[4], t);
                float y = interpolate(coords[1], coords[3], coords[5], t);
                g2d.drawString(name, x, y);
                lastX = x;
                lastY = y;
            }
            iterator.next();
        }
    }

    private float interpolate(float a, float b, float c, float t) {
        return a * (1 - t) * (1 - t) + 2 * b * (1 - t) * t + c * t * t;
    }

    public static void main(String[] args) {
        new Bezier();
    }
}
