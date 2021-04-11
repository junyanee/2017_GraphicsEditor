package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import global.GConstant;
import global.GConstant.EShapes;

public class GDrawingToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;
	
	private GDrawingPanel drawingPanel;
	//association
	public void setDrawingPanel(GDrawingPanel drawingPanel){
		this.drawingPanel = drawingPanel;
	}
	
	public GDrawingToolBar() {
		
		ActionHandler actionHandler = new ActionHandler();
		// i = 0; i < EShapes.values.length(); i++;
		ButtonGroup buttonGroup = new ButtonGroup();
		for (EShapes eshape : EShapes.values()) {
			JRadioButton button = new JRadioButton(); //누르면 눌린상태로 다른걸 누르면 누른상태가 풀림
			buttonGroup.add(button);
			
			//set image icon
			button.setIcon(new ImageIcon(eshape.getIconName()));
			button.setSelectedIcon(new ImageIcon(eshape.getIconSLTName()));
			
			//add event handler
			button.setActionCommand(eshape.toString());
			button.addActionListener(actionHandler);
			
			// register as a component
			this.add(button);
		}
	}
	public void initialize(){
		JRadioButton button = (JRadioButton) this.getComponent(EShapes.eRectangle.ordinal());
		button.doClick();
	}
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String actionCommand = event.getActionCommand();
			drawingPanel.setCurrentTool(EShapes.valueOf(actionCommand).getShape()); //이 글자와 똑같은 메모리 값으로 바꾸어줌
			System.out.println(event.getActionCommand());			
		}		
	}

}
