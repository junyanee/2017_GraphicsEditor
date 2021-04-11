package menu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GColorMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	public GColorMenu() {
		super("Color");		
		JMenuItem lineColorItem = new JMenuItem("LineColor");
		this.add(lineColorItem);
		JMenuItem fillColorItem = new JMenuItem("FillColor");
		this.add(fillColorItem);
	}
}
