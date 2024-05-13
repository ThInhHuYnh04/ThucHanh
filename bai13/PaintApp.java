package bai13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintApp extends JFrame {
    private DrawArea drawArea;
    private JButton clearButton;
    private JButton colorButton;
    private JComboBox<String> shapesComboBox;
    private JComboBox<String> brushComboBox;

    public PaintApp() {
        drawArea = new DrawArea();
        clearButton = new JButton("Clear");
        colorButton = new JButton("Color");
        shapesComboBox = new JComboBox<>(new String[]{"Circle", "Square", "Line"});
        brushComboBox = new JComboBox<>(new String[]{"Brush 1", "Brush 2", "Brush 3"});

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawArea.clear();
            }
        });

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(PaintApp.this, "Choose a color", Color.BLACK);
                drawArea.setColor(newColor);
            }
        });

        shapesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawArea.setShape((String) shapesComboBox.getSelectedItem());
            }
        });

        brushComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBrush = (String) brushComboBox.getSelectedItem();
                if ("Brush 1".equals(selectedBrush)) {
                    drawArea.setStroke(1);
                } else if ("Brush 2".equals(selectedBrush)) {
                    drawArea.setStroke(2);
                } else if ("Brush 3".equals(selectedBrush)) {
                    drawArea.setStroke(3);
                }
            }
        });

        JPanel controls = new JPanel();
        controls.add(clearButton);
        controls.add(colorButton);
        controls.add(shapesComboBox);
        controls.add(brushComboBox);

        add(controls, BorderLayout.NORTH);
        add(drawArea, BorderLayout.CENTER);

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PaintApp();
    }
}

class DrawArea extends JPanel {
    private int stroke = 1;
    private Image image;
    private Graphics2D g2;
    private int currentX, currentY, oldX, oldY;
    private Color color = Color.BLACK;
    private String shape = "Circle";
    private String brush = "Brush 1";

    public DrawArea() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();

                if (g2 != null) {
                    g2.setPaint(color);
                    g2.setStroke(new BasicStroke(stroke));
                    if ("Circle".equals(shape)) {
                        g2.drawOval(oldX, oldY, currentX - oldX, currentY - oldY);
                    } else if ("Square".equals(shape)) {
                        g2.drawRect(oldX, oldY, currentX - oldX, currentY - oldY);
                    } else if ("Line".equals(shape)) {
                        g2.drawLine(oldX, oldY, currentX, currentY);
                        // refresh draw area to repaint
                        repaint();
                        // store current coords x,y as olds x,y
                        oldX = currentX;
                        oldY = currentY;
                    }
                    // Add other shapes as needed
                    repaint();
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            // image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // clear draw area
            clear();
        }

        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        g2.setPaint(Color.white);
        // draw white on entire draw area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(color);
        repaint();
    }

    public void setColor(Color color) {
        this.color = color;
        g2.setPaint(color);
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setBrush(String brush) {
        this.brush = brush;
    }
    public void fillShape(int x, int y, int width, int height) {
        if ("Circle".equals(shape)) {
            g2.fillOval(x - width / 2, y - height / 2, width, height);
        } else if ("Square".equals(shape)) {
            g2.fillRect(x - width / 2, y - height / 2, width, height);
        }
        // Add other shapes as needed
    }
    public void mouseReleased(MouseEvent e) {
        if (g2 != null) {
            fillShape(oldX, oldY, currentX - oldX, currentY - oldY);
            repaint();
        }
    }
    public void setStroke(int stroke) {
        this.stroke = stroke;
        g2.setStroke(new BasicStroke(stroke));
    }

}
