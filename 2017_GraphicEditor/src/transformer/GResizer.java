package transformer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import shape.GShape;
import shape.GAnchors.EAnchors;

public class GResizer extends GTransformer {

	public GResizer(GShape shape) {
		super(shape);
		
	}

	@Override
	public void initTransforming(Graphics g, int x, int y) {
		
	}

	@Override
	public void keepTransforming(Graphics g, int x, int y) {
		EAnchors eAnchor = this.shape.getEAnchor();
		Graphics2D g2D = (Graphics2D) g;
		g2D.setXORMode(g2D.getBackground());
		this.shape.draw(g2D);
//		int w, h;
		switch (eAnchor){
		case NN:
			break;
		case NW:
			
			break;
		case EE:
			
			break;
		case NE:
			break;
		case SE:
			this.shape.setReSize(x, y);
			break;
		case SS:
			break;
		case SW:
			break;
		case WW:
			break;
		default:
			break;
	}
		this.shape.draw(g2D);
	}

	@Override
	public void finishTransforming(Graphics g, int x, int y) {

	}

}
