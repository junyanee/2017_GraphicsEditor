package transformer;

import java.awt.Graphics;
import java.awt.Graphics2D;

import shape.GShape;

public class GRotator extends GTransformer {

	public GRotator(GShape shape) {
		super(shape);
	}

	@Override
	public void initTransforming(Graphics g, int x, int y) {

	}

	@Override
	public void keepTransforming(Graphics g, int x, int y) {

		Graphics2D g2D = (Graphics2D) g;
		g2D.setXORMode(g2D.getBackground());
		g2D.rotate(Math.toRadians(90));
		this.shape.draw(g2D);
	}

	@Override
	public void finishTransforming(Graphics g, int x, int y) {
		
	}

}
