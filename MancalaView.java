package mancala;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MancalaView {

	private int numStones;
	private BoardFormat bf;

	/*
	 * Empty constructor
	 */
	public MancalaView() {

	}

	public MancalaView(BoardFormat bf) {
		this.bf = bf;
	}

	public void display() {

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
				bf = new SquareFormat();
				frame.setVisible(false);
				bf.draw(numStones, frame);

			}
		});

		// Layout 2
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				bf = new OvalFormat();
				frame.setVisible(false);
				bf.draw(numStones, frame);

			}
		});
	}
}
