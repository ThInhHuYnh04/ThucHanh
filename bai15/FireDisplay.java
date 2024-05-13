package bai15;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FireDisplay extends JFrame {
    private FirePanel firePanel;
    private JComboBox<Integer> fireCountComboBox;

    public FireDisplay() {
        firePanel = new FirePanel();
        fireCountComboBox = new JComboBox<>();
        for (int i = 1; i <= 10; i++) {
            fireCountComboBox.addItem(i);
        }
        fireCountComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firePanel.setFireCount((Integer) fireCountComboBox.getSelectedItem());
            }
        });

        add(firePanel, BorderLayout.CENTER);
        add(fireCountComboBox, BorderLayout.SOUTH);

        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FireDisplay();
    }

    class FirePanel extends JPanel {
        private int fireCount = 1;
        private Image fireImage;

        public FirePanel() {
            try {
                fireImage = ImageIO.read(new File("bai15/Sprite.png")); // Replace with your fire image path
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void setFireCount(int fireCount) {
            this.fireCount = fireCount;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Random random = new Random();
            for (int i = 0; i < fireCount; i++) {
                int x = random.nextInt(getWidth() - fireImage.getWidth(null));
                int y = random.nextInt(getHeight() - fireImage.getHeight(null));
                g.drawImage(fireImage, x, y, null);
            }
        }
    }
}
