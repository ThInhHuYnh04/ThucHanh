package bai11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JPanel {

	private static final int NUMBER_OF_STARS = 20;
	private static final int[] COLORS = {Color.RED.getRGB(), Color.ORANGE.getRGB(), Color.YELLOW.getRGB(), Color.GREEN.getRGB(), Color.BLUE.getRGB(), Color.MAGENTA.getRGB()};

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int width = getWidth();
		int height = getHeight();
		int radius = Math.min(width, height) / 2 - 50; // Radius of the circle
		int centerX = width / 2;
		int centerY = height / 2;

		Random random = new Random();

		for (int i = 0; i < NUMBER_OF_STARS; i++) {
			double angle = 2 * Math.PI * i / NUMBER_OF_STARS;
			int x = (int) (centerX + radius * Math.cos(angle));
			int y = (int) (centerY + radius * Math.sin(angle));

			g2d.setColor(new Color(COLORS[random.nextInt(COLORS.length)]));
			drawStar(g2d, x, y, 25, 50, 5);
		}
	}

	private void drawStar(Graphics2D g, int x, int y, double innerRadius, double outerRadius, int numRays) {
		double angleStep = Math.PI / numRays;

		Polygon star = new Polygon();
		for (int i = 0; i < numRays * 2; i++) {
			double radius = (i % 2 == 0) ? outerRadius : innerRadius;
			double angle = i * angleStep;
			int starX = (int) (x + radius * Math.sin(angle));
			int starY = (int) (y - radius * Math.cos(angle));
			star.addPoint(starX, starY);
		}

		g.fillPolygon(star);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Star Circle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.add(new main());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}