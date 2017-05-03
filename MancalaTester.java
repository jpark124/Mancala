package mancala;

import java.awt.Point;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.*;

public class MancalaTester{
	
	public static void main(String[] args) {


		System.out.println("Start");
		JFrame frame = new JFrame("Mancala Game");
		frame.setSize(2000, 2000);
		GameBoardPanel board = new GameBoardPanel(50, 50, 1000,500);
		Pit[] pitsList = board.getPits();
		Pit[] pointPits = board.getPointPits();
		
		//Setting up the pits with 2 stones
		for(int i = 0; i < 6 ; i++)
				pitsList[i]= new Pit(70,220+120 * i, 410,4);
		for(int i = 0; i < 6 ; i++)
			pitsList[i+6] = new Pit(70,220+120 * i,90,4);
		
		
		
		pointPits[0] = new Pit(120,400,70,70,10);
		pointPits[1] = new Pit(120,400,920,70,10);
		
		
		
		//You can try to remove this method so you will see the original frame. (Not Perfect though)
//		board.move(0);

		//Testing the numbers of each pit
//		System.out.println(pitsList[0].getNumOfStones());
//		System.out.println(pitsList[1].getNumOfStones());
//		System.out.println(pitsList[2].getNumOfStones());
//		System.out.println(pitsList[3].getNumOfStones());
//		System.out.println(pitsList[4].getNumOfStones());
//		System.out.println(pitsList[5].getNumOfStones());
//		System.out.println(pitsList[6].getNumOfStones());
//		System.out.println(pitsList[7].getNumOfStones());
//		System.out.println(pitsList[8].getNumOfStones());
//		System.out.println(pitsList[9].getNumOfStones());
//		System.out.println(pitsList[10].getNumOfStones());
//		System.out.println(pitsList[11].getNumOfStones());
		
		
		ShapeIcon boardIcon = new ShapeIcon(board, pitsList, pointPits, 0, 0);

		JLabel label = new JLabel(boardIcon);
		
//		label.addMouseListener(new MouseAdapter(){
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println(e.getX());
//				System.out.println(e.getY());
//				int pitClicked = (e.getX() - 220) / 120;
//				System.out.println("You are clicking number " + pitClicked + " pit");
//			}
//		});
		
			label.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int pitClicked = -1;
				boolean nothingClicked = true;
				Point mousePoint = e.getPoint();
				System.out.println("The point you are clicking is X = " + mousePoint.getX() + " , Y = " + mousePoint.getY() + "." );
				for(int i = 0; i < pitsList.length; i++)
				{
					if(pitsList[i].contain(mousePoint))
					{
						System.out.println("You are clicking number " + i + " pit.");
						nothingClicked = false;
						break;
					}						
				}	
				if(nothingClicked)
					System.out.println("You are not clicking any pit.");
			}
		});
		
		frame.add(label);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
