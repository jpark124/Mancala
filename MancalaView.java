package mancala;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MancalaView {

	public void display(int numStones, BoardFormat bf, JFrame frame) {

		frame.setVisible(false);
		bf.draw(numStones, frame);

	}

}
