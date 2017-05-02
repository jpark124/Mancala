
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

import javax.swing.JComponent;

public class GameBoardPanel extends JComponent {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	private Pit[] pits;
	private Pit[] pointPits;

	public GameBoardPanel(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		pits = new Pit[12];
		pointPits = new Pit[2];
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getX());

			}
		});

	}

	public Pit[] getPits() {
		return pits;
	}

	public Pit[] getPointPits() {
		return pointPits;
	}

	public int getWidth() {
		return width;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public void draw(Graphics2D g2) {
		Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
		g2.setColor(Color.DARK_GRAY);
		g2.fill(rect);
	}

	public boolean canMakeMove(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	public void makeMove(int i) {
		// TODO Auto-generated method stub

	}

}