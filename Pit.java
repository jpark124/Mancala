package mancala;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.*;

/**
 * This class displays its on the Mancala board and additional functions that involves with pits
 */
public class Pit {

	protected int width;
	protected int height;
	protected int theX;
	protected int theY;
	protected Stone[] stones;
	protected String playerName;

	/**
	 * Constructs a pit
	 * 
	 * @param width the width of this pit; doubles as the height of this pit.
	 * 
	 * @param x the x coordinate of this pit
	 * 
	 * @param y the y coordinate of this pit
	 * 
	 * @param numberOfStones the numberOfStones that is set to begin the game in every pit
	 * 
	 * @param playerName The name of the player who belongs this pit
	 */
	public Pit(int width, int theX, int theY, int numberOfStones, String playerName) {
		this.width = width;
		this.height = width;
		this.theX = theX;
		this.theY = theY;
		stones = new Stone[30];
		this.playerName = playerName;

		// add number of stones that users enter
		for (int i = 0; i < numberOfStones; i++) {
			stones[i] = new Stone(10, width / 3, height / 3);
			width += 10;
			height += 10;
		}

	}

	/**
	 * Con
	 * @param width
	 * @param height
	 * @param theX
	 * @param theY
	 * @param numberOfStones
	 */
	public Pit(int width, int height, int theX, int theY, int numberOfStones) {
		this.width = width;
		this.height = height;
		this.theX = theX;
		this.theY = theY;
		stones = new Stone[numberOfStones];
	}

/**
 * Draws a Pit for MancalaBoard The stones it drawn with the pit
 * @param g drawing parameter
 */
	public void drawPit(Graphics2D g) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double pit = new Ellipse2D.Double(theX, theY, width, height);
		// if it's point pits, where there are no pits inside.
		boolean isNormalPit = false;
		for (int i = 0; i < stones.length - 1; i++) {
			if (stones[i] != null) {
				isNormalPit = true;
				Ellipse2D.Double stoneToDraw = new Ellipse2D.Double(30 + theX, theY + i * width / 6, width / 10,height / 10);
				g2.draw(pit);
				g2.setColor(Color.BLACK);
				g2.fill(stoneToDraw);
				g2.draw(stoneToDraw);
			}
		}
		if (!isNormalPit)
			g2.draw(pit);
	}
	
	/**
	 * draw the point pits on both sides of the board
	 * @param g drawing parameter
	 */
	public void drawPointPit(Graphics2D g) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double pointPit = new Ellipse2D.Double(theX, theY, width, height);
		if (this.isEmpty())
			g2.draw(pointPit);
		else {
			for (int i = 0; i < stones.length - 1; i++) {
				if (stones[i] != null) {
					Ellipse2D.Double stoneToDraw = new Ellipse2D.Double(50 + theX, theY + i * width /6, width / 15,height / 20);
					g2.draw(pointPit);
					g2.setColor(Color.BLACK);
					g2.fill(stoneToDraw);
					g2.draw(stoneToDraw);
				}
			}
		}
	}

	/**
	 * Get number of stones in a pit
	 * @return number of stone in a pit
	 */
	public int getNumOfStones() {
		int count = 0;
		for (int i = 0; i < stones.length; i++) {
			if (stones[i] != null)
				count++;
		}
		return count;
	}

	/**
	 * Adding stone in a specific pit
	 */
	public void addStone() {

		if (stones.length == 0)
			System.out.println("It's an empty stone list");
		else {
			for (int i = this.getNumOfStones(); i >= 0; i--)
				if (stones[i] == null)
					stones[i] = new Stone(20, 20, 20);
		}
	}

	/**
	 * Check if there is any stones left in a pit
	 * @return true if pit is empty, and return false if there is stones left in a pit.
	 */
	public boolean isEmpty() {
		boolean empty = true;
		for (int i = 0; i < stones.length - 1; i++)
			if (stones[i] != null)
				empty = false;
		return empty;
	}

	/**
	 * It takes all stones of a pit that is chosen
	 */
	public void takeAllStones() {
		for (int i = 0; i < stones.length; i++) {
			stones[i] = null;
		}
	}

	
	
	
	// Not sure if it's necessary, pretty much the same thing in deleteStone();
	//	public void takeAStone() {
//		stones[stones.length - 1] = null;
//	}
	
	
	
	/**
	 * delete one stone from a specific stone
	 */
	public void deleteStone() {
		for (int i = stones.length - 1; i >= 0; i--) {
			if (stones[i] != null) {
				stones[i] = null;
				break;
			}
		}
	}

	/**
	 * See if the mouse point is in the shape.
	 * 
	 * @param mousePoint
	 *            the point that is going to be identify.
	 * @return true if the mousePoint is contained in the region return false if
	 *         it is not.
	 */
	public boolean contain(Point mousePoint) {
		if (mousePoint.getX() > theX && mousePoint.getX() < theX + width && mousePoint.getY() > theY
				&& mousePoint.getY() < theY + height)
			return true;
		else
			return false;
	}

	/**
	 * get the player's name for the specific pit
	 * @return the player's name for the specific pit
	 */
	public String getPlayerName() 
	{
		return playerName;
	}
	

}
