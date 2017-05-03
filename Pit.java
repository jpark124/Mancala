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

/*
 * The pits on the Mancala board
 */
public class Pit{

	private int width;
	private int height;
	private int theX;
	private int theY;
	private Stone[] stones;

	/*
	 * Constructs a pit
	 * 
	 * @param width the width of this pit; doubles as the height of this pit.
	 * 
	 * @param x the x coordinate of this pit
	 * 
	 * @param y the y coordinate of this pit
	 */
	public Pit(int width, int theX, int theY, int numberOfStones) 
	{
		this.width = width;
		this.height = width;
		this.theX = theX;
		this.theY = theY;
		stones = new Stone[20];
//		this.addMouseListener(new MouseAdapter(){
//			public void MouseClicked(MouseEvent e)
//			{
//				if()
//			}
//		});
		
		// add number of stones that users enter
		for(int i = 0; i < numberOfStones; i++)
		{
			stones[i] = new Stone(10, width/3, height/3);
			width += 10;
			height += 10;
		}

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
	public Pit(int width, int height, int theX, int theY, int numberOfStones) {
		this.width = width;
		this.height = height;
		this.theX = theX;
		this.theY = theY;
		stones = new Stone[numberOfStones];
	}
	

	/*
	 * Draws a Pit for MancalaBoard
	 * The stones it drawn with the pit
	 */
	public void draw(Graphics2D g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double pit = new Ellipse2D.Double(theX, theY, width, height);
		// if it's point pits, where there are no pits inside.
				boolean isNormalPit = false;
				for(int i = 0; i < stones.length-1; i++)
				{
					if(stones[i] != null)
					{
						isNormalPit = true;
						Ellipse2D.Double stoneToDraw = new Ellipse2D.Double(30 + theX, theY + i * width/6, width/10, height/10);
						g2.draw(pit);
						g2.setColor(Color.BLACK);
						g2.fill(stoneToDraw);
						g2.draw(stoneToDraw);
					}
				}
				if(!isNormalPit)
					g2.draw(pit);
	}
	/**
	 * Get number of stones in a pit
	 * @return number of stone in a pit
	 */
	public int getNumOfStones()
	{
		int count = 0;
		for(int i = 0; i < stones.length; i++)
		{
			if(stones[i] != null)
				count++;
		}
		return count;
	}
	
	/**
	 * Add stone in a pit.
	 * It is where I get stuck.
	 * (Still not perfect because haven't figured out a way to add array)
	 */
	public void addStone()
	{
		if(stones.length == 0)
			System.out.println("It's an empty stone list");
		else
		{
			for(int i = this.getNumOfStones(); i >= 0; i--)
				if(stones[i] == null)
					stones[i] = new Stone(20,20,20);
		}
	}
	
	/**
	 * Check if there is any stones left in a pit
	 * @return	true if pit is empty, and return false if there is stones left in a pit.
	 */
	public boolean isEmpty()
	{
		boolean empty = true;
		for(int i = 0; i < stones.length - 1; i++)
			if(stones[i] != null)
				empty = false;
		return empty;
	}
	
	/**
	 * It takes all stones of a pit that is chosen
	 */
	public void takeAllStones()
	{
		for(int i = 0; i < stones.length; i++ )
		{
			stones[i] = null;
		}
	}
	
	/**
	 * See if the mousepoint is in the shape.
	 * @param mousePoint the point that is going to be identify.
	 * @return true if the mousePoint is contained in the region
	 * return false if it is not.
	 */
	public boolean contain(Point mousePoint)
	{
		if(mousePoint.getX() > theX && mousePoint.getX() < theX + width && mousePoint.getY() > theY && mousePoint.getY() < theY + height)
			return true;
		else
			return false;
	}

}
