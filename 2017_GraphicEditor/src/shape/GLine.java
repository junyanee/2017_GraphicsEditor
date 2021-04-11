package shape;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

public class GLine extends GShape {
	private Line2D shape;
	
	public GLine() {
		this.shape = new Line2D.Double(0, 0, 0, 0);
		
	}

	public void setLocation(int x, int y) {
		this.shape.setLine( x, y, 0, 0);
		
	}

	public void setSize(int x, int y) {
		this.shape.setLine( this.shape.getX1(), this.shape.getY1(),	x , y );

	}

	@Override
	public void draw(Graphics2D g2D) {
		g2D.setXORMode(g2D.getBackground());
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2D.setStroke(new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
		g2D.draw(this.shape);
		if(this.selected == true) {
			this.anchors.draw(g2D, this.shape.getBounds());
		}
	}
	@Override
	public boolean isOn(int x, int y) {
		return this.shape.contains(x, y, px, py);
	}

	public void initMoving(int x, int y) {
		px = x;
		py = y;
		
	}
	public void keepMoving(int x, int y) {
		
	}

	@Override
	public void setReSize(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMove(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
