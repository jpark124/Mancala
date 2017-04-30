package mancala;

import javax.swing.*;

public class MancalaTester {
	
	public static void main(String[] args) {
		System.out.println("Start");
		JFrame frame = new JFrame();
		frame.setSize(2000, 2000);
		GameBoardPanel board = new GameBoardPanel(50, 50, 1400,700);
		Pit[] pitsList = board.getPits();
		Pit[] pointPits = board.getPointPits();
		
		//Setting up the pits with 2 stones
		for(int i = 0; i < 6 ; i++)
				pitsList[i] = new Pit(100,225 + 180 * i,90,4);
		for(int i = 0; i < 6 ; i++)
				pitsList[i+6]= new Pit(100,225 + 180 * i, 610,4);
		
		
		
		pointPits[0] = new Pit(150,650,70,70,0);
		pointPits[1] = new Pit(150,650,1250,70,0);
		
		//You are gonna get endless loop because I haven't set it up to stop
		//You can try to remove this method so you will see the original frame. (Not Perfect though)
//		board.move(0);

		ShapeIcon boardIcon = new ShapeIcon(board, pitsList, pointPits, 0, 0);

		JLabel label = new JLabel(boardIcon);

		frame.add(label);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
