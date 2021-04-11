package frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import shape.GShape;
import shape.GAnchors.EAnchors;
import transformer.GMover;
import transformer.GResizer;
import transformer.GRotator;
import transformer.GTransformer;

public class GDrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// state
	enum EDrawingState { eIdle, eDrawing, eMoving, eResizing, eRotating };
	EDrawingState eDrawingState;
	// associative attribute from drawing toolbar
	private GShape currentTool;
	public void setCurrentTool(GShape currentTool) {
		this.currentTool = currentTool;
	}
	//그려진 도형을 저장하기 위한 집합체
	private Vector<GShape> drawingShapes;
	public Vector<GShape> getDrawingShapes(){
		return this.drawingShapes;
	}
	public void setDrawingShapes(Vector<GShape> drawingShapes){
		this.drawingShapes = drawingShapes;
		this.repaint();
	}
	// shape의 2차원 위치크기정보를 수정하는 애
	private GTransformer transformer;
	// 현재 자업중인 도형
	private GShape currentShape;
	
	
	
	public GDrawingPanel() {
		this.eDrawingState = EDrawingState.eIdle;
		this.setBackground(Color.WHITE);

		this.currentTool = null;
		
		MouseHandler mouseHandler = new MouseHandler();
		this.addMouseMotionListener(mouseHandler);
		this.addMouseListener(mouseHandler);
		this.drawingShapes = new Vector<GShape>();
		
		this.transformer = null;
		this.currentShape = null;
		
	}
	
	public void initialize() {		
	}
	
	public void paint(Graphics g) {
		super.paint(g);		
		Graphics2D g2D = (Graphics2D) g;
		for (GShape shape: this.drawingShapes) {
			shape.draw(g2D);
			shape.drawAnchor(g2D);
			repaint();
		}
	}
	
	private void setSelection() {
		this.currentShape.setSelected(true);
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		this.currentShape.drawAnchor(g2d);		
	}
	private void clearSelection() {
		for (GShape shape: this.drawingShapes) {
			shape.setSelected(false);
		}
		this.repaint();
	}
	private GShape onShape(int x, int y) {
		for (GShape shape: this.drawingShapes) {
			if (shape.isOn(x, y)) {
				return shape;
			}
		}
		return null;
	}

	private void initTransforming(int x, int y) {
		currentShape = this.onShape(x, y);
		if (currentShape == null) {
			this.currentShape = this.currentTool.clone();
			this.currentShape.setLocation(x, y);
			this.transformer = new GResizer(this.currentShape);
		} else {
			if (currentShape.getEAnchor() == EAnchors.MM) {
				this.transformer = new GMover(this.currentShape);
			} else if (currentShape.getEAnchor() == EAnchors.RR) {
				this.transformer = new GRotator(this.currentShape);
			} else {
				this.transformer = new GResizer(this.currentShape);
			}
		}
		clearSelection();
		this.transformer.initTransforming(this.getGraphics(), x, y);
	}
	private void keepTransforming(int x, int y) {
		this.transformer.keepTransforming(this.getGraphics(), x, y);
	}
	private void finishTransforming(int x, int y) {
		this.transformer.finishTransforming(this.getGraphics(), x, y);
			if(currentShape.getEAnchor() == EAnchors.SE)
				this.drawingShapes.add(this.currentShape);
			else if(currentShape.getEAnchor() == EAnchors.EE)
				this.drawingShapes.add(this.currentShape);
			
		
		this.setSelection();
	}
	
	
	private void setCursor(int x, int y) {
		this.currentShape = onShape(x, y);
		if (this.currentShape == null) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));				
		} else {
			EAnchors eAnchor = this.currentShape.getEAnchor();
			switch (eAnchor) {
			case NN:
				setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));				
				break;
			case NW:
				setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));				
				break;
			case NE:
				setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));				
				break;
			case SW:
				setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));				
				break;
			case SS:
				setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));				
				break;
			case SE:
				setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));				
				break;
			case EE:
				setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));				
				break;
			case WW:
				setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));				
				break;
			case RR:
				setCursor(new Cursor(Cursor.HAND_CURSOR));				
				break;
			case MM:
				setCursor(new Cursor(Cursor.MOVE_CURSOR));				
				break;
			default:
				break;
			}
		}
	}
	private class MouseHandler 
		implements MouseInputListener, MouseMotionListener {
		@Override
		public void mouseClicked(MouseEvent event) {
		}
		@Override
		public void mousePressed(MouseEvent event) {
			initTransforming(event.getX(), event.getY());
			eDrawingState=EDrawingState.eDrawing;
		}
		@Override
		public void mouseDragged(MouseEvent event) {
			if (eDrawingState==EDrawingState.eDrawing) {
				keepTransforming(event.getX(), event.getY());
			} 
		}
		@Override
		public void mouseReleased(MouseEvent event) {
			if (eDrawingState==EDrawingState.eDrawing) {
				finishTransforming(event.getX(), event.getY());
				eDrawingState = EDrawingState.eIdle;
			} 
		}		
		@Override
		public void mouseMoved(MouseEvent event) {
			setCursor(event.getX(), event.getY());
		}		
		@Override
		public void mouseEntered(MouseEvent event) {
		}
		@Override
		public void mouseExited(MouseEvent event) {
		}
	}
}
