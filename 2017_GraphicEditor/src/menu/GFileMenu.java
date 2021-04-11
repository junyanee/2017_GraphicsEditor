package menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import frame.GDrawingPanel;
import global.GConstant.EShapes;
import shape.GShape;

public class GFileMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private ActionHandler actionHandler;
	private GDrawingPanel drawingPanel;
	public void setDrawingPanel(GDrawingPanel drawingPanel){
		this.drawingPanel = drawingPanel;
	}
	public GFileMenu() {
		super("File");	
		
		this.actionHandler = new ActionHandler();
		
		JMenuItem newItem = new JMenuItem("New");
		newItem.setActionCommand("newItem");
		newItem.addActionListener(this.actionHandler);
		this.add(newItem);
		
		JMenuItem openItem = new JMenuItem("Open");
		openItem.setActionCommand("openItem");
		openItem.addActionListener(this.actionHandler);
		this.add(openItem);
		this.addSeparator();
		
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.setActionCommand("saveItem");
		saveItem.addActionListener(this.actionHandler);
		this.add(saveItem);
		
		JMenuItem saveAsItem = new JMenuItem("SaveAs");
		this.add(saveAsItem);
		this.addSeparator();
		JMenuItem closeItem = new JMenuItem("Close");
		closeItem.addActionListener(this.actionHandler);
		this.add(closeItem);
		JMenuItem printItem = new JMenuItem("Print");
		printItem.addActionListener(this.actionHandler);
		this.add(printItem);
		this.addSeparator();
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this.actionHandler);
		this.add(exitItem);
	}
	private int showSaveDialog(){
		JFileChooser fileChooser = new JFileChooser(new File("."));
//		FileNameExtensionFilter filter = new FileNameExtensionFilter("GraphicsEditor", "gps");
//		fileChooser.setFileFilter(filter);
		int reply = fileChooser.showSaveDialog(null);
		return reply;
	}
	
	private void save() throws IOException{
		this.showSaveDialog();
		try {
			File file = new File("dat/save");
			ObjectOutputStream outputStream = 
					new ObjectOutputStream(
			new BufferedOutputStream(
					new FileOutputStream(file)
					)
			
			);
			outputStream.writeObject(drawingPanel.getDrawingShapes());
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private int showOpenDialog(){
		JFileChooser fileChooser = new JFileChooser(new File("."));
		//FileNameExtensionFilter filter = new FileNameExtensionFilter("GraphicsEditor", "gps");
		//fileChooser.setFileFilter(filter);
		int reply = fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		return reply;
	}
	@SuppressWarnings("unchecked")
	private void open() {
		this.showOpenDialog();
		try{
			File file = new File("dat/save");
			ObjectInputStream inputStream =
					new ObjectInputStream(
							new BufferedInputStream (
									new FileInputStream(file)
									)
							);
			Object object = inputStream.readObject();
			drawingPanel.setDrawingShapes((Vector<GShape>) object);
			inputStream.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String actionCommand = event.getActionCommand();
			if(actionCommand.equals("saveItem")){
				try {
					save();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if (actionCommand.equals("openItem")){
				open();
			} else if (actionCommand.equals("Close")) {
				JOptionPane.showConfirmDialog(drawingPanel, "종료합니다", "close", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
				System.exit(0);
				

			} else if (actionCommand.equals("Exit")) {
				exit();
			} else if (actionCommand.equals("Print")) {
				print();
			}
		}	
	}
	public void exit() {
		JOptionPane.showConfirmDialog(drawingPanel, "종료합니다", "exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
		System.exit(0);
	}
	private void print() {
	      JEditorPane pane = new JEditorPane();
	      try {
	         pane.print();
	      } catch (PrinterException e) {
	         e.printStackTrace();
	      }
	      
	   }
}
