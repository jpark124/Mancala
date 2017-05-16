package mancala;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class SquarePit extends Pit{

	String playerName;
	public SquarePit(int width, int theX, int theY, int numberOfStones, String playerName) {
		super(width, theX, theY, numberOfStones, playerName);
		this.playerName = playerName;
	}

	public SquarePit(int width, int height, int theX, int theY, int numberOfStones) {
		super(width, height, theX, theY, numberOfStones);
	}

	/*
	 * Draws a Pit for MancalaBoard The stones it drawn with the pit
	 */
	public void drawPit(Graphics2D g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D.Double pit = new Rectangle2D.Double(theX, theY, width, height);
		// if it's point pits, where there are no pits inside.
		boolean isNormalPit = false;
		for (int i = 0; i < stones.length - 1; i++) {
			if (stones[i] != null) {
				isNormalPit = true;
				g2.setColor(Color.BLACK);
				g2.fill(pit);
			}
			if (!isNormalPit)
				g2.fill(pit);
		}

		for (int i = 0; i < stones.length - 1; i++) {
			if (stones[i] != null) {
				isNormalPit = true;
				Ellipse2D.Double stoneToDraw = new Ellipse2D.Double(30 + theX, theY + i * width / 6 + 10, width / 10,
						height / 10);
				g2.draw(stoneToDraw);
				g2.setColor(Color.WHITE);
				g2.fill(stoneToDraw);
			}
		}

		g2.setColor(Color.BLACK);

	}

	public void drawPointPit(Graphics2D g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);
		Rectangle2D.Double pointPit = new Rectangle2D.Double(theX, theY, width, height);
		if (this.isEmpty())
			g2.fill(pointPit);
		else {
			for (int i = 0; i < stones.length - 1; i++) {
				if (stones[i] != null) {
					g2.setColor(Color.BLACK);
					g2.fill(pointPit);
				}
			}

			for (int i = 0; i < stones.length - 1; i++) {
				if (stones[i] != null) {
					Ellipse2D.Double stoneToDraw = new Ellipse2D.Double(50 + theX, theY + i * width / 3, width / 10,height / 13);
					g2.setColor(Color.WHITE);
					g2.fill(stoneToDraw);
				}
			}

		}
		g2.setColor(Color.BLACK);
	}
	
	public String getPlayerNameInSquarePit()
	{
		return this.playerName;
	}

}
