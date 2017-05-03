import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class SquarePit extends Pit {

	public SquarePit(int width, int theX, int theY, int numberOfStones, String player) {
		super(width, theX, theY, numberOfStones, player);
		// TODO Auto-generated constructor stub
	}

	public SquarePit(int width, int height, int theX, int theY, int numberOfStones) {
		super(width, height, theX, theY, numberOfStones);
		// stones = new Stone[numberOfStones];
	}
	


	public void draw(Graphics2D g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		Rectangle2D.Double pit = new Rectangle2D.Double(theX, theY, width, height);
		// if it's point pits, where there are no pits inside.
		if (stones == null) {
			g2.setColor(Color.BLACK);
			g2.draw(pit);
			g2.setColor(Color.WHITE);
			g2.fill(pit);
		} else {
			for (int i = 1; i <= stones.length; i++) {
				g2.fill(pit);
				g2.setColor(Color.BLACK);
				g2.draw(pit);
				g2.setColor(Color.WHITE);
			}
			for (int i = 1; i <= stones.length; i++) {

				Ellipse2D.Double stoneToDraw = new Ellipse2D.Double(25 + theX, theY + i * width / 6 + 15, width / 10,
						height / 10);
				g2.setColor(Color.BLACK);
				g2.fill(stoneToDraw);
				g2.draw(stoneToDraw);
			}
		}
	}
}
