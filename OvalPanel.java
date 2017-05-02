import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class OvalPanel extends GameBoardPanel {

	public OvalPanel(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g2) {
		Ellipse2D bg = new Ellipse2D.Double(x, y, width, height);
		g2.draw(bg);
		g2.setColor(Color.LIGHT_GRAY);
		g2.fill(bg);

	}

}
