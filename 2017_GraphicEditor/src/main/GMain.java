package main;
import javax.swing.JFrame;

import frame.GMainFrame;

public class GMain {

	public static void main(String[] args) {
		// memory allocation
		// constructor invocation
		GMainFrame mainFrame = new GMainFrame("GraphicsEditor");
		mainFrame.initialize();
		// draw mainFrame
		mainFrame.setVisible(true);
		
	}
}
