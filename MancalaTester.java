package mancala;

import java.util.ArrayList;

import javax.swing.*;

public class MancalaTester {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		
		ArrayList<Pit> pits = new ArrayList<>();
		ArrayList<Pit> pointPits = new ArrayList<>();
		for(int i = 0; i < 6; i++)
			pits.add(new Pit(100,225 + 180 * i,90));
		for(int i = 0; i < 6; i++)
			pits.add(new Pit(100,225 + 180 * i, 610));
		
		pointPits.add(new Pit(150,650,70,70));
		pointPits.add(new Pit(150,650,1250,70));
			
		GameBoardPanel board = new GameBoardPanel(50, 50, 700);
		ShapeIcon boardIcon = new ShapeIcon(board,pits, pointPits, 0, 0);
		
		JLabel label = new JLabel(boardIcon);

		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
