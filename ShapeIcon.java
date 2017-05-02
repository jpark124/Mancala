import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ShapeIcon implements Icon {
	private int width;
	private int height;
	private GameBoardPanel board;
	private Pit[] pits;
	private Pit[] pointPits;

	public ShapeIcon(GameBoardPanel board, Pit[] pits, Pit[] pointPits, int width, int height) {
		this.board = board;
		this.width = width;
		this.height = height;
		this.pits = pits;
		this.pointPits = pointPits;
	}

	public int getIconWidth() {
		return width;
	}

	public int getIconHeight() {
		return height;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		board.draw(g2);
		for (int i = 0; i < pits.length; i++)
			pits[i].draw(g2);
		for (int i = 0; i < pointPits.length; i++)
			pointPits[i].draw(g2);

	}
}