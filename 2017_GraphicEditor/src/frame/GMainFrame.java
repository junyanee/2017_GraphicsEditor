package frame;
import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class GMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	// components
	private GMenuBar menuBar;
	private GDrawingToolBar drawingToolBar;
	private GDrawingPanel drawingPanel;
	// constructor
	public GMainFrame(String title) {
		// invoke super's constructor
		super(title);
		// initialize attributes - 속성, 자신의 이야기
		this.setLocation(100,  50);
		this.setSize(400,  600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		// initialize components -Aggregation Hierarchy에서 자식을 의미
		this.menuBar = new GMenuBar();
		this.setJMenuBar(menuBar);
		
		this.drawingToolBar = new GDrawingToolBar();
		this.add(drawingToolBar, BorderLayout.NORTH);
		
		this.drawingPanel = new GDrawingPanel();
		this.add(drawingPanel, BorderLayout.CENTER);	
		
		//Association 드로잉 툴바와 드로잉 패널을 연결 자식사이에서 연결
		this.drawingToolBar.setDrawingPanel(drawingPanel);
		this.menuBar.setDrawingPanel(drawingPanel);
	}
	
	public void initialize(){
		this.menuBar.initialize();
		this.drawingPanel.initialize();
		this.drawingToolBar.initialize();
	}
}
