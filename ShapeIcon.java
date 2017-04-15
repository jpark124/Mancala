package mancala;
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class ShapeIcon implements Icon{
	private int width;
	private int height;
	private GameBoardPanel board;
	private ArrayList<Pit> pits;
	private ArrayList<Pit> pointPits;
	public ShapeIcon(GameBoardPanel board,ArrayList<Pit> pits, ArrayList<Pit> pointPits, int width, int height)
	{
		this.board = board;
		this.width = width;
		this.height = height;
		this.pits = pits;
		this.pointPits = pointPits;
	}
	public int getIconWidth()
	{ 
		return width; 
	}
	public int getIconHeight()
	{ 
		return height; 
	}
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		board.draw(g2);
		for(Pit eachPit : pits)
			eachPit.draw(g2);
		for(Pit aPit: pointPits)
			aPit.draw(g2);
			
	}
	}
