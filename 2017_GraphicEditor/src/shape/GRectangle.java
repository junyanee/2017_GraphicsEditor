package shape;

import java.awt.Rectangle;

public class GRectangle extends GShape {
	
	public GRectangle(){
		this.shape = new Rectangle(0, 0, 0, 0);
		}
	
	@Override
	public void setReSize(int x, int y) {
		Rectangle myShape = (Rectangle) this.shape;
		myShape.setSize(x-myShape.x, y-myShape.y);
	}

	@Override
	public void setLocation(int x, int y) {
		Rectangle myShape = (Rectangle) this.shape;
		myShape.setLocation(x, y);
		
	}

	@Override
	public void setMove(int x, int y) {
		Rectangle myShape = (Rectangle) this.shape;
		myShape.x = myShape.x + x - px;
		myShape.y = myShape.y + y - py;
		px = x;
		py = y;
	}
}