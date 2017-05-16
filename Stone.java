import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

/**
 * This class displays stones in mancala game board
 */
public class Stone implements Icon {

	private int width;
	private int theX;
	private int theY;

/**
 * 
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
<<<<<<< HEAD
	
	/**
	 * draw the stone in game board within a pit
	 * @param g drawing parameter
	 */
	public void draw(Graphics2D g)
	{
=======

	/*
	 * Draws a Stone for MancalaBoard
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
>>>>>>> origin/master
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double pit = new Ellipse2D.Double(theX, theY, width, width);
		g2.setColor(Color.BLACK);
		g2.fill(pit);
	}
<<<<<<< HEAD
}
=======

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
>>>>>>> origin/master
