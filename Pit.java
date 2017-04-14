import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

/*
 * The pits on the Mancala board
 */
public class Pit implements Icon {

	private int width;
	private int height;
	private int theX;
	private int theY;

	/*
	 * Constructs a pit
	 * 
	 * @param width the width of this pit; doubles as the height of this pit.
	 * 
	 * @param x the x coordinate of this pit
	 * 
	 * @param y the y coordinate of this pit
	 */
	public Pit(int width, int theX, int theY) {
		this.width = width;
		this.height = width;
		this.theX = theX;
		this.theY = theY;
	}

	/*
	 * A pit that is a player point pit will have a defined height.
	 * 
	 * @param width the width of this pit
	 * 
	 * @param height the height of this pit
	 * 
	 * @param x the x coordinate of this pit
	 * 
	 * @param y the y coordinate of this pit
	 */
	public Pit(int width, int height, int theX, int theY) {
		this.width = width;
		this.height = height;
		this.theX = theX;
		this.theY = theY;
	}

	/*
	 * Draws a Pit for MancalaBoard
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double pit = new Ellipse2D.Double(theX, theY, width, height);
		g2.setColor(Color.BLACK);
		g2.fill(pit);
	}

	/*
	 * Returns the width of this Icon
	 */
	public int getIconWidth() {
		return width;
	}

	/*
	 * Returns the height of this Icon
	 */
	public int getIconHeight() {
		return height;
	}

	
}
