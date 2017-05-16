
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

<<<<<<< HEAD
import javax.swing.*;

public class GameBoardPanel extends JLabel implements Icon {
	protected MancalaModel model;
=======
import javax.swing.JComponent;

public class GameBoardPanel extends JComponent {

>>>>>>> origin/master
	protected int x;
	protected int y;
	protected int width;
	protected int height;
<<<<<<< HEAD
	private int prevCount;
	private int prevIndex;
	protected Pit[] pits;
	protected Pit[] pointPits;
	protected String playerTurn;
	protected Color color;
	protected boolean gameOver;
	protected boolean undoable;
	protected boolean oneSideIsEmpty;

	public GameBoardPanel(int x, int y, int width, int height, Color color) {
		model = new MancalaModel();
		this.color = color;
=======
	private Pit[] pits;
	private Pit[] pointPits;

	public GameBoardPanel(int x, int y, int width, int height) {
>>>>>>> origin/master
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		pits = new Pit[12];
		pointPits = new Pit[2];
<<<<<<< HEAD
		gameOver = false;
		undoable = false;
		oneSideIsEmpty = false;
	}
	
	@Override
	public int getIconHeight() {
		return height;
	}

	@Override
	public int getIconWidth() 
	{
		return width;
	}

	public void setFirstPlayerToGo(String name) {
		playerTurn = name;
	}

	public Pit[] getPits() {
		return pits;
	}

	public void setPits(Pit[] pits) {
		this.pits = pits;
	}

	public Pit[] getPointPits() 
	{
		return pointPits;
	}
	
	/**
	 * Draw the board and fill it with color. Print out the labels for pits and mancala
	 * @param g2 the drawing parameter
	 */
	public void draw(Graphics2D g2) {
		Rectangle2D board = new Rectangle2D.Double(x, y, width, height);
		g2.draw(board);
		g2.setColor(color);
		g2.fill(board);
		
		// print the words for undo time left that players have
		g2.setColor(Color.BLACK);
		Font fontForUndoTime = new Font("SansSerif", Font.BOLD, 16);
		g2.setFont(fontForUndoTime);
		g2.drawString("Player " + pits[0].getPlayerName() + " Undo Times Used: " + Integer.toString(model.getplayerAUndoTime()), 2*width/3, height + 70);
		g2.drawString("Player " + pits[6].getPlayerName() + " Undo Times Used: " + Integer.toString(model.getplayerBUndoTime()), width/4, 40);
		Font fontForPits = new Font("SansSerif", Font.BOLD, 20);
		
		// print the labels for pits
		g2.setFont(fontForPits);
		for (int i = 0; i < 6; i++)
			g2.drawString("B" + (6 - i), 120 * i + 45 + width / 5, 100 + height / 4);
		for (int i = 0; i < 6; i++)
			g2.drawString("A" + (i + 1), 120 * i + 45 + width / 5, height - 100);
	
		//print the labels for mancala A:
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

		//B
		g2.drawString("M", 10, y + 60);
		g2.drawString("A", 10, y + 100);
		g2.drawString("N", 10, y + 140);
		g2.drawString("C", 10, y + 180);
		g2.drawString("A", 10, y + 220);
		g2.drawString("L", 10, y + 260);
		g2.drawString("A", 10, y + 300);
		g2.drawString("B", 10, y + 400);

	}

	/**
	 * Move stones from a pit pointPits[0] means Player's 1 point pit on the
	 * right side of the board. pointPits[1] means player's 2 point pit on the
	 * left side of the board.
	 * 
	 * @param positionToMove
	 * 		The position that is entered to be moved
	 */
	public void move(int positionToMove) {

		int stoneNow = 0;
		int counter = 0;
		for(int PlayerAPit = 0; PlayerAPit < 6; PlayerAPit++)
		{
			if(pits[PlayerAPit].getNumOfStones() == 0)
			{
				counter++;
				if(counter == 6)
					oneSideIsEmpty = true;
			}
		}
		
		counter = 0;
		
		for(int PlayerBPit = 6; PlayerBPit < 12; PlayerBPit++)
		{
			if(pits[PlayerBPit].getNumOfStones() == 0)
			{
				counter++;
				if(counter == 6)
					oneSideIsEmpty = true;
			}
		}
		
		if(oneSideIsEmpty)
		{
			System.out.println("One side has been empty");
			if(playerTurn.equals(pits[5].getPlayerName()))
			{
				System.out.println(pits[5].getPlayerName() + "'s Side is empty");
				int countA = 0;
				for(int i = 0; i < 6; i++)
				{
					countA = countA + pits[i].getNumOfStones();
					pits[i].takeAllStones();
				}
				countA = countA + pointPits[1].getNumOfStones();
				pointPits[1].takeAllStones();
				for(int i = 0; i < countA; i++)
					pointPits[1].addStone();
				System.out.println("There are total " + countA + "stones in A's side");
				if(countA > pits[1].getNumOfStones())
					playerTurn = pits[0].getPlayerName();
				else
					playerTurn = pits[6].getPlayerName();
				gameOver = true;
			}
			
			if(playerTurn.equals(pits[11].getPlayerName()))
			{
				System.out.println(pits[11].getPlayerName() + "'s Side is empty");
				int countB = 0;
				for(int i = 6; i < 12; i++)
				{
					countB = countB + pits[i].getNumOfStones();
					pits[i].takeAllStones();
				}
				
				countB = countB + pointPits[0].getNumOfStones();
				pointPits[0].takeAllStones();
				for(int i = 0; i < countB; i++)
					pointPits[0].addStone();
				System.out.println(countB);
				System.out.println("There are total " + countB + "stones in B's side");
				if(countB > pits[0].getNumOfStones())
					playerTurn = pits[6].getPlayerName();
				else
					playerTurn = pits[0].getPlayerName();
				gameOver = true;
			}
			return;
		}
		
		// First, you get the stones in the pit first and iterate over entire
		// board, so every next pit , it will receive a stone.
		stoneNow = pits[positionToMove].getNumOfStones();
		prevIndex = positionToMove;
		prevCount = pits[positionToMove].getNumOfStones();
		
		// when there is no more stone in the pit, you cannot move anymore.
		if (pits[positionToMove].isEmpty()) 
			return;
		
		if (pits[positionToMove].getPlayerName().equals(playerTurn) && !gameOver) 
		{
			// Take all stones in a pit
			// It takes all stones from the pit that is selected
			pits[positionToMove].takeAllStones();
			// This for loop correctly distribute stones into next 4 pits; 1 in
			// each
			for (int i = 0; i < stoneNow; i++) {
				positionToMove++;
				if (positionToMove == 12) 
				{
					i++;
					positionToMove = 0;
					pointPits[0].addStone();
					
					
					//if you drop your last stone in mancala, you can get a free turn.
					if (stoneNow == i) 
					{
						return;
					}
				}
				

				else if (positionToMove == 6) {
					stoneNow = stoneNow - 1;
					pointPits[1].addStone();
					//if you drop your last stone in mancala, you can get a free turn.
					if (stoneNow == i) 
					{
						return;
					}
				}
				pits[positionToMove].addStone();
				
				// check if you can get free points by dropping the last stone in an empty pit
				if(pits[positionToMove].getNumOfStones() == 1 && playerTurn.equals(pits[positionToMove].getPlayerName()) && i + 1 == stoneNow)
				{
					int oppNumOfStones = pits[11-positionToMove].getNumOfStones();
					System.out.println("Number" + positionToMove + "pit only has one stone");
					System.out.println("Whooooa, there are "+ oppNumOfStones + "in number " + (11-positionToMove) + " pit!");
					pits[11-positionToMove].takeAllStones();
					for(int oppStones = 0; oppStones < oppNumOfStones; oppStones++)
					{
						
						if(positionToMove >= 6)
						{
							pointPits[0].addStone();
						}
						else
							pointPits[1].addStone();
					}
				}
			}
			
			//next player turn after a move
			switchPlayer();

		} 
		else
			// when a player is clicking the pit that is not belonged to his/hers.
			System.out.println("You cannot move opponent's stones!");
		
		//makes undoable true, so it can be undo by players.
		undoable = true;

	}

	/**
	 * Let player go back to the last move they just made.
	 * Each player has three maximum undo times.
	 * undo two straight in a row is not allowed.
	 */
	public void undo() 
	{
		if(!undoable)
			return;
		
		// adding undo time to see if player A are out of undo times
		if(!playerTurn.equals(pits[0].getPlayerName()))
		{
			model.addplayerAUndoTime();
			if(model.getplayerAUndoTime() > 3)
			{
				model.setPlayerAUndoTime(3);
				return;
			}
		}
		
		// adding undo time to see if player A are out of undo times
		else if(!playerTurn.equals(pits[6].getPlayerName()))
		{
			model.addplayerBUndoTime();
			if(model.getplayerBUndoTime() > 3)
			{
				model.setPlayerBUndoTime(3);
				return;
			}
		}
		switchPlayer();
		int counter = 0;
		int pitLeft = -1;
		for (int i = prevIndex; i <= prevCount + prevIndex; i++) 
		{
			if(i == 12)
			{
				pitLeft = prevCount + prevIndex - i;
				pointPits[0].deleteStone();
				break;
			}
			if(i == 6)
			{
				prevCount = prevCount - 1;
				pointPits[1].deleteStone();
				counter++;
			}
			pits[i].deleteStone();
			counter++;
		}
		
		for(int i = 0; i < pitLeft; i++)
		{
			pits[i].deleteStone();
			counter++;
			if( i+1 == pitLeft)
				counter++;
		}

		
		for (int i = 1; i < counter; i++) 
		{
			pits[prevIndex].addStone();
		}
		
		//you cannot undo two times in a row 
		undoable = false;
	}

	/**
	 * Drawing basic mancala components including board, pits, and point pits.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		this.draw(g2);
		for (int i = 0; i < pits.length; i++)
			pits[i].drawPit(g2);
		for (int i = 0; i < pointPits.length; i++)
			pointPits[i].drawPointPit(g2);

	}

	public String getPlayerTurn() 
	{
		return playerTurn;
	}
	
	/**
	 * change turn to next player
	 */
	public void switchPlayer()
	{
		if (playerTurn.equals(pits[0].getPlayerName())) 
			playerTurn = pits[6].getPlayerName();
		else if(playerTurn.equals(pits[6].getPlayerName()))
			playerTurn = pits[0].getPlayerName();
	}
	
		

}
=======

	}

	public Pit[] getPits() {
		return pits;
	}

	public Pit[] getPointPits() {
		return pointPits;
	}

	public int getWidth() {
		return width;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public void draw(Graphics2D g2) {
		Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
		g2.setColor(Color.DARK_GRAY);
		g2.fill(rect);
	}

	public boolean canMakeMove(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	public void makeMove(int i) {
		// TODO Auto-generated method stub

	}

}
>>>>>>> origin/master
