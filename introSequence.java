import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class introSequence {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Select A Layout");
		frame.setSize(300, 150);
		frame.setLayout(new FlowLayout());
		JButton l1 = new JButton("Layout 1");
		JButton l2 = new JButton("Layout 2");

		frame.add(l1);
		frame.add(l2);

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JButton undoButton = new JButton("Undo");
				JButton mainMenu = new JButton("Main Menu");

				frame.setVisible(false);
				JFrame frame2 = new JFrame("Layout 1");
				frame2.setLayout(new FlowLayout());
				frame2.setSize(750, 500);
				frame2.add(new JLabel(new ImageIcon("layout1.jpg")));
				frame2.add(undoButton);
				frame2.add(mainMenu);

				frame2.setVisible(true);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			}
		});

		l2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				JFrame frame3 = new JFrame("Layout 2");
				frame3.setSize(750, 500);
				JButton undoButton = new JButton("Undo");
				JButton mainMenu = new JButton("Main Menu");
				frame3.setLayout(new FlowLayout());

				frame3.add(undoButton);
				frame3.add(mainMenu);
				frame3.add(new JLabel(new ImageIcon("layout2.jpg")));
				frame3.setVisible(true);
				frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				undoButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// add code
					}

				});

				mainMenu.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						frame3.dispose();
						frame.setVisible(true);
					}

				});
			}

		});

	}

}
