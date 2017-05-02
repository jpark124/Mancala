import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
			pitsList[i] = new Pit(70, 220 + 120 * i, 410, numStones);
			points.add(new Point(220 + 120 * i, 410));

		}

		for (int i = 0; i < 6; i++) {
			pitsList[i + 6] = new Pit(70, 220 + 120 * i, 90, numStones);
			points.add(new Point(220 + 120 * i, 90));

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

		frame2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				points.contains(e.getPoint());
				{
					System.out.println("Pit clicked.");
				}

			}
		});

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
			pitsList[i] = new SquarePit(70, 220 + 120 * i, 410, numStones);
			points.add(new Point(220 + 120 * i, 410));

		}

		for (int i = 0; i < 6; i++) {
			pitsList[i + 6] = new SquarePit(70, 220 + 120 * i, 90, numStones);
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

		frame2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				points.contains(e.getPoint());
				{
					System.out.println("Pit clicked.");
				}

			}
		});

		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
	}

}
