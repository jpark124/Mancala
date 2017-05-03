package mancala;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import javax.swing.*;


public class GameBoardPanel extends JLabel
{
	private int x;
	private int y;
	private int width;
	private int height;
	private Pit[] pits;
	private Pit[] pointPits;
	public GameBoardPanel(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		pits = new Pit[12];
		pointPits = new Pit[2];
	}
	
	public Pit[] getPits()
	{
		return pits;
	}
	
	public Pit[] getPointPits()
	{
		return pointPits;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void draw(Graphics2D g2)
	{
		Rectangle2D rect = new Rectangle2D.Double(x,y,width, height);
		g2.draw(rect);
	}
	
	// pointPits[0] means CPU's point pit on the right side of the board.
	// pointPits[1] means player's point pit on the left side of the board.
	public void move(int positionToMove)
	{
		int stoneNow = 0;
		boolean noMoreStone = false;
		 // the while loop stops running when there is no more stone in the pit.
		while(!noMoreStone)
		{
			//First, you get the stones in the pit first and iterate over entire board, so every next pit , it will receive a stone.
			stoneNow = pits[positionToMove].getNumOfStones();
			System.out.println("There are " + stoneNow + " stones in number " + positionToMove + " pit");
			//when there is no more stone in the pit, you cannot move anymore.
			if(pits[positionToMove].isEmpty())
			{
				noMoreStone = true;
				System.out.println("No more Stones in the pit");
			}
			
			//Take all stones in a pit
			pits[positionToMove].takeAllStones();
			
			for(int i = 0; i < stoneNow; i++)
			{
				System.out.println("I am in number " + positionToMove + " pit now!");
				positionToMove++;
				
				//It is the full round of cycle so CPU will get a point because it passes CPU's point pit at the right				
				if(positionToMove == 12)
				{
					System.out.println("CPU scores!");
					positionToMove = 0;
					pointPits[0].addStone();
					System.out.println("CPU has scored " + pointPits[1].getNumOfStones() + " points");
					
					if(pointPits[0].getNumOfStones() == 1)
					{
						System.out.println("Game Over");
						return;
					}
				}
				
				// if it makes it to the sixth pit, which is supposed to be the pit on first row.
				// That means player will get a point because it passes player's point pit.
				else if(positionToMove == 6)	
				{
					System.out.println("Player scores!");
					pointPits[1].addStone();
					System.out.println("Player has scored " + pointPits[0].getNumOfStones() + " points");
					
					if(pointPits[1].getNumOfStones() == 1)
					{
						System.out.println("Game Over");
						return;
					}
				}
				System.out.println("I add one stone in number " + positionToMove + " pit");
				pits[positionToMove].addStone();
				System.out.println("There are " + pits[positionToMove].getNumOfStones() + " stones in number " + positionToMove + " pit" + "\n");
			}
			
		}		
	}
	
}
