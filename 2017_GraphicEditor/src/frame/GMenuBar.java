package frame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import menu.GColorMenu;
import menu.GEditMenu;
import menu.GFileMenu;

public class GMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private GDrawingPanel drawingPanel;
	public void setDrawingPanel(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}
	private GFileMenu fileMenu;
	private GEditMenu editMenu;
	private GColorMenu colorMenu;
	
	public GMenuBar() {
		super();
		this.fileMenu = new GFileMenu();
		this.add(fileMenu);
		this.editMenu = new GEditMenu();
		this.add(editMenu);
		this.colorMenu = new GColorMenu();
		this.add(colorMenu);
	}
	public void initialize(){
		this.fileMenu.setDrawingPanel(this.drawingPanel);
		this.editMenu.setDrawingPanel(this.drawingPanel);
	}
	
}
