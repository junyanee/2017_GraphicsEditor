package shape;

import java.awt.geom.Ellipse2D;

public class GEllipse extends GShape {
	
	public GEllipse(){
		super();
		this.shape = new Ellipse2D.Double(0, 0, 0, 0);
	}
	
	public void setReSize(int x, int y) {
		Ellipse2D myShape = (Ellipse2D) this.shape;
		int w = (int) (x - myShape.getX());
		int h = (int) (y - myShape.getY());
		myShape.setFrame(myShape.getX(), myShape.getY(), w, h);

	}

	@Override
	public void setLocation(int x, int y) {
		Ellipse2D myShape = (Ellipse2D) this.shape;
		myShape.setFrame(x, y, 0, 0);
		
	}

	@Override
	public void setMove(int x, int y) {
		Ellipse2D myShape = (Ellipse2D) this.shape;
		int newX = (int) (myShape.getX() + x - px);
		int newY = (int) (myShape.getY() + y - py);
		myShape.setFrame(newX, newY, myShape.getWidth(), myShape.getHeight());
		
		px = x;
		py = y;
	}

}
