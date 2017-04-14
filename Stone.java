import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

/*
 * A stone on the Mancala board.
 */
public class Stone implements Icon {

	private int width;
	private int theX;
	private int theY;

	/*
	 * Constructs a Stone
	 * 
	 * @param width the width of this pit; doubles as the height of this Stone.
	 * 
	 * @param x the x coordinate of this Stone
	 * 
	 * @param y the y coordinate of this Stone
	 */
	public Stone(int width, int theX, int theY) {
		this.width = width;
		this.theX = theX;
		this.theY = theY;
	}

	/*
	 * Draws a Stone for MancalaBoard
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double pit = new Ellipse2D.Double(theX, theY, width, width);
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
		return width;
	}

}
