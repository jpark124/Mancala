<<<<<<< HEAD
package mancala;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
=======
import java.awt.BorderLayout;
>>>>>>> origin/master
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
<<<<<<< HEAD
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//Strategy
public interface BoardFormat {
	public void draw(int numStones, JFrame frame);
}

// Concrete Strategy 1
class SquareBoard implements BoardFormat {

	private Color color;

	public SquareBoard(Color color) {
		this.color = color;
	}

	@Override
	public void draw(int numStones, JFrame frame) {

		frame.setVisible(false);
		JFrame frame1 = new JFrame("Mancala Game");
		frame1.setSize(1110, 700);
		frame1.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Layout 1");
		frame1.add(label);
		JButton mainMenu = new JButton("Main Menu");

		mainMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame1.dispose();
				frame.setVisible(true);
			}

		});
		JButton undo = new JButton("Undo");

		JPanel buttonPanel = new JPanel();

		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(mainMenu);
		buttonPanel.add(undo);

		frame1.add(buttonPanel, BorderLayout.SOUTH);

		GameBoardPanel boardPanel = new GameBoardPanel(50, 50, 1000, 500, color);

		Pit[] pitsList = boardPanel.getPits();
		Pit[] pointPits = boardPanel.getPointPits();

		for (int i = 0; i < 6; i++)
			pitsList[i] = new Pit(70, 220 + 120 * i, 410, numStones, "A");
		for (int i = 0; i < 6; i++)
			pitsList[i + 6] = new Pit(70, 820 - 120 * i, 90, numStones, "B");

		pointPits[0] = new Pit(120, 400, 70, 70, 45);
		pointPits[1] = new Pit(120, 400, 920, 70, 45);

		boardPanel.setFirstPlayerToGo("A");

		Font fontForPlayerTurn = new Font("SansSerif", Font.BOLD, 30);
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(fontForPlayerTurn);
		textArea.setText("Player " + boardPanel.getPlayerTurn() + "'s turn");

		JLabel l = new JLabel(boardPanel);
		if(boardPanel.gameOver)
			textArea.setText("Game Over! " + "Player " + boardPanel.getPlayerTurn() + " Wins the Game!");
		
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int positionToMove = -1;
				boolean nothingClicked = true;
				Point mousePoint = e.getPoint();
				if(boardPanel.gameOver == true)
				{
					textArea.setText("Game Over! " + "Player " + boardPanel.getPlayerTurn() + " Wins the Game!");
					return;
				}
				for (int i = 0; i < pitsList.length; i++) {
					if (pitsList[i].contain(mousePoint)) {
						positionToMove = i;
						nothingClicked = false;
						boardPanel.move(positionToMove);
						textArea.setText("Player " + boardPanel.getPlayerTurn() + "'s turn");
						break;
					}
				}
				if(nothingClicked)
					System.out.println("You are not clicking anything!");
				l.repaint();
			}
		});

		frame1.add(textArea, BorderLayout.NORTH);
		frame1.add(l, BorderLayout.CENTER);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);

		/*
		 * NEED TO IMPLEMENT UNDO
		 */
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boardPanel.undo();
				textArea.setText("Player " + boardPanel.getPlayerTurn() + "'s turn");
				l.repaint();
			}

		});

	}
}
	//concrete strategy 2
	class OvalBoard implements BoardFormat {

		private Color color;

		public OvalBoard(Color color) {
			this.color = color;
		}

		@Override
		public void draw(int numStones, JFrame frame) {

			frame.setVisible(false);
			JFrame frame1 = new JFrame("Mancala Game");
			frame1.setSize(1110, 700);
			frame1.setLayout(new BorderLayout());

			JButton mainMenu = new JButton("Main Menu");

			mainMenu.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame1.dispose();
					frame.setVisible(true);
				}

			});
			JButton undo = new JButton("Undo");

			JPanel buttonPanel = new JPanel();

			buttonPanel.setLayout(new FlowLayout());
			buttonPanel.add(mainMenu);
			buttonPanel.add(undo);

			frame1.add(buttonPanel, BorderLayout.SOUTH);

			OvalBoardPanel boardPanel = new OvalBoardPanel(50, 50, 1000, 500, color);

			Pit[] pitsList = boardPanel.getPits();
			Pit[] pointPits = boardPanel.getPointPits();

			for (int i = 0; i < 6; i++)
				pitsList[i] = new SquarePit(70, 220 + 120 * i, 410, numStones, "A");
			for (int i = 0; i < 6; i++)
				pitsList[i + 6] = new SquarePit(70, 820 - 120 * i, 90, numStones, "B");
			
			pointPits[0] = new SquarePit(120, 400, 70, 70, 45);
			pointPits[1] = new SquarePit(120, 400, 920, 70, 45);
			
			boardPanel.setFirstPlayerToGo("A");

			Font fontForPlayerTurn = new Font("SansSerif", Font.BOLD, 30);
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setFont(fontForPlayerTurn);
			textArea.setText("Player " + boardPanel.getPlayerTurn() + "'s turn");
			
			if(boardPanel.gameOver)
				textArea.setText("Game Over! " + "Player " + boardPanel.getPlayerTurn() + " Wins the Game!");
			
			JLabel l = new JLabel(boardPanel);

			l.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int positionToMove = -1;
					boolean nothingClicked = true;
					Point mousePoint = e.getPoint();
					if(boardPanel.gameOver == true)
					{
						textArea.setText("Game Over! " + "Player " + boardPanel.getPlayerTurn() + " Wins the Game!");
						return;
					}
					for (int i = 0; i < pitsList.length; i++) {
						if (pitsList[i].contain(mousePoint)) {
							positionToMove = i;
							nothingClicked = false;
							boardPanel.move(positionToMove);
							textArea.setText("Player " + boardPanel.getPlayerTurn() + "'s turn");
							break;
						}
					}
					if(nothingClicked)
						System.out.println("You are not clicking anything!");
					l.repaint();
				}
			});

			frame1.add(textArea, BorderLayout.NORTH);
			frame1.add(l, BorderLayout.CENTER);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setVisible(true);

			undo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					boardPanel.undo();
					textArea.setText("Player " + boardPanel.getPlayerTurn() + "'s turn");
					l.repaint();
				}
			});

		}
	}

=======
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Strategy
public interface BoardFormat {

	public void draw(int numStones, JFrame mainMenu);

}

// Concrete Strategy 1
class SquareFormat extends JComponent implements BoardFormat {
	ArrayList<Point> points = new ArrayList<Point>();

	@Override
	public void draw(int numStones, JFrame mainMenu) {
		mainMenu.setVisible(false);
		JFrame frame2 = new JFrame("Layout 1");
		frame2.setSize(1100, 625);

		GameBoardPanel board = new GameBoardPanel(50, 50, 1000, 500);
		Pit[] pitsList = board.getPits();
		Pit[] pointPits = board.getPointPits();

		// Setting up the pits with the selected number of stones
		for (int i = 0; i < 6; i++) {
			pitsList[i] = new Pit(70, 220 + 120 * i, 410, numStones, "A");
			if (pitsList[3] == pitsList[i]) {
				pitsList[i] = new Pit(70, 220 + 120 * i, 410, 5, "A");
			}
		}

		for (int i = 0; i < 6; i++) {
			pitsList[i + 6] = new Pit(70, 220 + 120 * i, 90, numStones, "B");

		}
		pointPits[0] = new Pit(120, 400, 70, 70, 10);
		pointPits[1] = new Pit(120, 400, 920, 70, 10);

		ShapeIcon boardIcon = new ShapeIcon(board, pitsList, pointPits, 0, 0);

		JLabel label = new JLabel(boardIcon);

		frame2.add(label);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame2.setLayout(new BorderLayout());
		JButton undoButton = new JButton("Undo");

		JButton menu = new JButton("Main Menu");
		menu.setBounds(100, 100, 50, 10);
		frame2.add(menu);

		frame2.add(undoButton, BorderLayout.NORTH);
		frame2.add(menu, BorderLayout.SOUTH);

		undoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// add code
			}

		});

		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				mainMenu.setVisible(true);
			}

		});

		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int pitClicked = -1;
				boolean nothingClicked = true;
				Point mousePoint = e.getPoint();

				for (int i = 0; i < pitsList.length; i++) {
					if (pitsList[i].contains(mousePoint)) {
						System.out.println("You are clicking number " + i + " pit.");
						System.out.println("Number of stones in this pit " + pitsList[i].getNumOfStones());
						nothingClicked = false;
						break;
					}
				}
				if (nothingClicked)
					System.out.println("You are not clicking any pit.");
			}
		});

		frame2.add(label);

		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);

	}

}

// Concrete Strategy 2
class OvalFormat extends JComponent implements BoardFormat {

	ArrayList<Point> points = new ArrayList<Point>();

	@Override
	public void draw(int numStones, JFrame mainMenu) {

		JFrame frame2 = new JFrame("Layout 2");
		frame2.setSize(1100, 625);

		GameBoardPanel board = new OvalPanel(50, 50, 1000, 500);
		Pit[] pitsList = board.getPits();
		Pit[] pointPits = board.getPointPits();

		// Setting up the pits with the selected number of stones
		for (int i = 0; i < 6; i++) {
			pitsList[i] = new SquarePit(70, 220 + 120 * i, 410, numStones, "A");
			points.add(new Point(220 + 120 * i, 410));

		}

		for (int i = 0; i < 6; i++) {
			pitsList[i + 6] = new SquarePit(70, 220 + 120 * i, 90, numStones, "B");
			points.add(new Point(220 + 120 * i, 90));

		}

		pointPits[0] = new SquarePit(120, 400, 70, 70, 10);
		pointPits[1] = new SquarePit(120, 400, 920, 70, 10);

		ShapeIcon boardIcon = new ShapeIcon(board, pitsList, pointPits, 0, 0);

		JLabel label = new JLabel(boardIcon);

		frame2.add(label);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame2.setLayout(new BorderLayout());
		JButton undoButton = new JButton("Undo");

		JButton menu = new JButton("Main Menu");
		mainMenu.setBounds(100, 100, 50, 10);
		frame2.add(menu);

		frame2.add(undoButton, BorderLayout.NORTH);
		frame2.add(menu, BorderLayout.SOUTH);

		undoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// add code
			}
		});
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				mainMenu.setVisible(true);
			}

		});

		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int pitClicked = -1;
				boolean nothingClicked = true;
				Point mousePoint = e.getPoint();

				for (int i = 0; i < pitsList.length; i++) {
					if (pitsList[i].contains(mousePoint)) {
						System.out.println("You are clicking number " + i + " pit.");
						System.out.println("Number of stones in this pit " + pitsList[i].getNumOfStones());
						System.out.println("Player " + pitsList[i].getPlayer() + "'s pit.");
						nothingClicked = false;
						break;
					}
				}
				if (nothingClicked)
					System.out.println("You are not clicking any pit.");
			}
		});

		frame2.add(label);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
	}

}
>>>>>>> origin/master
