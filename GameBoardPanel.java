package mancala;

import java.awt.*;
import java.awt.geom.*;

public class GameBoardPanel
{
	private int x;
	private int y;
	private int width;
	public GameBoardPanel(int x, int y, int width)
	{
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	public void draw(Graphics2D g2)
	{
		Rectangle2D rect = new Rectangle2D.Double(x,y,2*width, width);
		g2.draw(rect);
	}
}
