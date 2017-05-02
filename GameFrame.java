import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameFrame {
	static int numStones;
	ArrayList<GameFrame> states = new ArrayList<GameFrame>();
	
	

	public void create() {
		JFrame frame = new JFrame("MANCALA");

		frame.setSize(200, 250);
		frame.setLayout(new FlowLayout());
		JLabel l1 = new JLabel("Enter the number of stones.");
		frame.add(l1);

		JTextField text = new JTextField("");
		text.setPreferredSize(new Dimension(30, 30));
		JButton input = new JButton("Enter");
		frame.add(text);
		frame.add(input);

		JLabel l2 = new JLabel("Pick a layout.");
		l2.setPreferredSize(new Dimension(100, 50));
		frame.add(l2);
		JButton b1 = new JButton("Layout 1");
		JButton b2 = new JButton("Layout 2");

		frame.add(b1);
		frame.add(b2);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				numStones = Integer.parseInt(text.getText());

			}

		});

		// Layout 1
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				JFrame frame2 = new JFrame("Layout 1");
				frame2.setSize(1100, 625);

				GameBoardPanel board = new GameBoardPanel(50, 50, 1000, 500);
				Pit[] pitsList = board.getPits();
				Pit[] pointPits = board.getPointPits();

				// Setting up the pits with 2 stones
				for (int i = 0; i < 6; i++)
					pitsList[i] = new Pit(70, 220 + 120 * i, 410, numStones);
				for (int i = 0; i < 6; i++)
					pitsList[i + 6] = new Pit(70, 220 + 120 * i, 90, numStones);

				pointPits[0] = new Pit(120, 400, 70, 70, 10);
				pointPits[1] = new Pit(120, 400, 920, 70, 10);

				ShapeIcon boardIcon = new ShapeIcon(board, pitsList, pointPits, 0, 0);

				JLabel label = new JLabel(boardIcon);

				frame2.add(label);
				frame2.setVisible(true);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame2.setLayout(new BorderLayout());
				JButton undoButton = new JButton("Undo");

				JButton mainMenu = new JButton("Main Menu");
				mainMenu.setBounds(100, 100, 50, 10);
				frame2.add(mainMenu);

				frame2.add(undoButton, BorderLayout.NORTH);
				frame2.add(mainMenu, BorderLayout.SOUTH);

				undoButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// add code
					}

				});

				mainMenu.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						frame2.dispose();
						frame.setVisible(true);
					}

				});

				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setVisible(true);
			}
		});

		// Layout 2

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				JFrame frame2 = new JFrame("Layout 2");
				frame2.setSize(1100, 625);

				GameBoardPanel board = new OvalPanel(50, 50, 1000, 500);
				Pit[] pitsList = board.getPits();
				Pit[] pointPits = board.getPointPits();

				// Setting up the pits with 2 stones
				for (int i = 0; i < 6; i++)
					pitsList[i] = new SquarePit(70, 220 + 120 * i, 410, numStones);
				for (int i = 0; i < 6; i++)
					pitsList[i + 6] = new SquarePit(70, 220 + 120 * i, 90, numStones);

				pointPits[0] = new SquarePit(120, 400, 70, 70, 10);
				pointPits[1] = new SquarePit(120, 400, 920, 70, 10);


				ShapeIcon boardIcon = new ShapeIcon(board, pitsList, pointPits, 0, 0);

				JLabel label = new JLabel(boardIcon);

				frame2.add(label);
				frame2.setVisible(true);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame2.setLayout(new BorderLayout());
				JButton undoButton = new JButton("Undo");

				JButton mainMenu = new JButton("Main Menu");
				mainMenu.setBounds(100, 100, 50, 10);
				frame2.add(mainMenu);

				frame2.add(undoButton, BorderLayout.NORTH);
				frame2.add(mainMenu, BorderLayout.SOUTH);

				undoButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// add code
					}
				});

				mainMenu.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						frame2.dispose();
						frame.setVisible(true);
					}

				});

				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setVisible(true);
			}
		});

	}
}
