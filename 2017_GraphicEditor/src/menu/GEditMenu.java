package menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import frame.GDrawingPanel;
import shape.GShape;



public class GEditMenu extends JMenu {
	private ActionHandler actionHandler;
	private GDrawingPanel drawingPanel;
	public void setDrawingPanel(GDrawingPanel drawingPanel){
		this.drawingPanel = drawingPanel;
	}
   private static final long serialVersionUID = 1L;
   public GEditMenu() {
      super("Edit");   
      this.actionHandler = new ActionHandler();
      JMenuItem cutItem = new JMenuItem("Cut");
      this.add(cutItem);
      JMenuItem pasteItem = new JMenuItem("Paste");
      this.add(pasteItem);
      JMenuItem deleteItem = new JMenuItem("Delete");
      this.add(deleteItem);
      deleteItem.addActionListener(this.actionHandler);
      this.addSeparator();
      JMenuItem doItem = new JMenuItem("Do");
      this.add(doItem);
      JMenuItem undoItem = new JMenuItem("Undo");
      this.add(undoItem);
      this.addSeparator();
      JMenuItem selectAllItem = new JMenuItem("SelectAll");
      this.add(selectAllItem);
      this.addSeparator();
      JMenuItem groupItem = new JMenuItem("Group");
      this.add(groupItem);
      JMenuItem ungorupItem = new JMenuItem("UnGroup");
      this.add(ungorupItem);

      }
   private class ActionHandler implements ActionListener {
      
            
      @Override
      public void actionPerformed(ActionEvent event) {
         String actionCommand = event.getActionCommand();
         if(actionCommand.equals("Delete")){
            delete();
         }
      }

      private void delete() {
    	  
    	  drawingPanel.equals(drawingPanel.getDrawingShapes());
    	  drawingPanel.getDrawingShapes().clear();
    	     	      	  
         
      }
      
   }
}
