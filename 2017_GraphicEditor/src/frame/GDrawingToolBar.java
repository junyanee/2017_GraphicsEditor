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
			JRadioButton button = new JRadioButton(); //������ �������·� �ٸ��� ������ �������°� Ǯ��
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
			drawingPanel.setCurrentTool(EShapes.valueOf(actionCommand).getShape()); //�� ���ڿ� �Ȱ��� �޸� ������ �ٲپ���
			System.out.println(event.getActionCommand());			
		}		
	}

}
