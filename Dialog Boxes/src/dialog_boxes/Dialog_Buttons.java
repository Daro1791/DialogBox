package dialog_boxes;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Dialog_Buttons extends JPanel {
	
	public Dialog_Buttons(String title, String [] options) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		group = new ButtonGroup();
		
		for (int i=0; i<options.length; i++) {
			
			JRadioButton button = new JRadioButton(options[i]);
			
			button.setActionCommand(options[i]);
			
			add(button);
			group.add(button);
			
			button.setSelected(i==0);
			
		}
		
	}
	
	public String gSelection(){
		
		return group.getSelection().getActionCommand();
		
	}
	
	ButtonGroup group;

}
