package shape;

import java.awt.Graphics2D;
import java.awt.Polygon;

public class GPolygon extends GShape {
	private Polygon shape;
	private int[] xpoints = new int[10];
	private int[] ypoints = new int[10];
	private int npoints;
	public GPolygon() {
		this.shape = new Polygon(xpoints, ypoints, npoints);
	}

	@Override
	public void setLocation(int x, int y) {
	    for (int i = 0; i < 6; i++){
	        shape.addPoint((int) (x + 50 * Math.cos(i * 2 * Math.PI / 6)),
	            (int) (y + 50 * Math.sin(i * 2 * Math.PI / 6)));}
	    
	}

	public void setSize(int x, int y) {
		
	}

	@Override
	public void draw(Graphics2D g2D) {
		g2D.setXORMode(g2D.getBackground());
		g2D.draw(this.shape);
	}

	public int[] getYpoints() {
		return ypoints;
	}

	public void setYpoints(int[] ypoints) {
		this.ypoints = ypoints;
	}

	public int[] getXpoints() {
		return xpoints;
	}

	public void setXpoints(int[] xpoints) {
		this.xpoints = xpoints;
	}
	@Override
	public boolean isOn(int x, int y) {
		return this.shape.contains(x, y);
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
