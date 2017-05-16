package mancala;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class OvalBoardPanel extends GameBoardPanel {

	private SquarePit[] previousPits;
	protected SquarePit[] pits;
	protected SquarePit[] pointPits;

	public OvalBoardPanel(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		pits = new SquarePit[12];
		pointPits = new SquarePit[2];
	}

	public void draw(Graphics2D g2) {
		Ellipse2D board = new Ellipse2D.Double(x, y, width, height);
		g2.draw(board);
		g2.setColor(color);
		g2.fill(board);
		g2.setColor(Color.BLACK);
		Font fontForPits = new Font("SansSerif", Font.BOLD, 20);
		g2.setFont(fontForPits);

		// print the words for undo time left that players have
		g2.setColor(Color.BLACK);
		Font fontForUndoTime = new Font("SansSerif", Font.BOLD, 16);
		g2.setFont(fontForUndoTime);
		g2.drawString("Player A's Undo Times Used: " + Integer.toString(model.getplayerAUndoTime()), 2*width/3, height + 70);
		g2.drawString("Player B's Undo Times Used: " + Integer.toString(model.getplayerBUndoTime()), width/4, 40);		
		
		for (int i = 0; i < 6; i++)
			g2.drawString("B" + (6 - i), 120 * i + 45 + width / 5, 100 + height / 4);
		for (int i = 0; i < 6; i++)
			g2.drawString("A" + (i + 1), 120 * i + 45 + width / 5, height - 100);

		Font fontForPointpit = new Font("SansSerif", Font.BOLD, 30);
		g2.setFont(fontForPointpit);
		g2.drawString("M", x + width + 20, y + 60);
		g2.drawString("A", x + width + 20, y + 100);
		g2.drawString("N", x + width + 20, y + 140);
		g2.drawString("C", x + width + 20, y + 180);
		g2.drawString("A", x + width + 20, y + 220);
		g2.drawString("L", x + width + 20, y + 260);
		g2.drawString("A", x + width + 20, y + 300);
		g2.drawString("A", x + width + 20, y + 400);

		g2.drawString("M", 10, y + 60);
		g2.drawString("A", 10, y + 100);
		g2.drawString("N", 10, y + 140);
		g2.drawString("C", 10, y + 180);
		g2.drawString("A", 10, y + 220);
		g2.drawString("L", 10, y + 260);
		g2.drawString("A", 10, y + 300);
		g2.drawString("B", 10, y + 400);

	}

	
}
