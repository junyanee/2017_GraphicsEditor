package transformer;

import java.awt.Graphics;
import java.awt.Graphics2D;

import shape.GShape;

public class GMover extends GTransformer {

	public GMover(GShape shape) {
		super(shape);
	}

	@Override
	public void initTransforming(Graphics g, int x, int y) {
		this.shape.initLocation(x, y);
	}

	@Override
	public void keepTransforming(Graphics g, int x, int y) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setXORMode(g2D.getBackground());
		this.shape.draw(g2D);	//지우는거
		
		this.shape.setMove(x, y);
		this.shape.draw(g2D);	//그리는거
	}

	@Override
	public void finishTransforming(Graphics g, int x, int y) {

	}

}
