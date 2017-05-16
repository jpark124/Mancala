package mancala;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MancalaController {

	protected int numStones;
	boolean format;
	private MancalaView theView;
	private MancalaModel theModel;
	private BoardFormat bf;

	public MancalaController(MancalaView theView, MancalaModel theModel) {

		this.theView = theView;
		this.theModel = theModel;

		JFrame frame = new JFrame("MANCALA");

		frame.setSize(200, 250);
		frame.setLayout(new FlowLayout());
		JLabel l1 = new JLabel("Enter the number of stones.");
		frame.add(l1);

		
		JButton threeStones = new JButton("3");
		JButton fourStones = new JButton("4");
		frame.add(threeStones);
		frame.add(fourStones);

		JLabel l2 = new JLabel("Pick a layout.");

		l2.setPreferredSize(new Dimension(100, 50));
		frame.add(l2);
		JButton b1 = new JButton("Layout 1");
		JButton b2 = new JButton("Layout 2");

		frame.add(b1);
		frame.add(b2);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		threeStones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				theModel.setStones(2);
			}
		});
		
		fourStones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				theModel.setStones(4);
			}
		});

		// Layout 1
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bf = new SquareBoard(Color.GRAY);
				bf.draw(theModel.getNumStones(), frame);
			}
		});

		// Layout 2
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bf = new OvalBoard(Color.RED);
				bf.draw(theModel.getNumStones(), frame);

			}
		});
	}

}
