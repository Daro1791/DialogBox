package dialog_boxes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Dialog_Frame extends JFrame{
	
	public Dialog_Frame() {
		
		setTitle("Dialogue Box Test");
		
		setBounds(400, 200, 600, 450);
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(2, 3));
		
		String first[] = {"Message", "Confirm", "Option", "Input"};
		
		panel_type = new Dialog_Buttons("Type", first);
		
		panel_type_message = new Dialog_Buttons("Type Messages", new String [] {
			"ERROR_MESSAGE",
			"INFORMATION_MESSAGE",
			"WARNING_MESSAGE",
			"QUESTION_MESSAGE",
			"PLAIN_MESSAGE"
		});
		
		panel_message = new Dialog_Buttons("Message", new String [] {
			"String",
			"Icon",
			"Component",
			"Other",
			"Object[]"
		});
		
		panel_type_option = new Dialog_Buttons("Type Option", new String [] {
			"DEFAULT_OPTION",
			"YES_NO_OPTION",
			"YES_NO_CANCEL_OPTION",
			"OK_CANCEL_OPTION"
		});
		
		panel_options = new Dialog_Buttons("Option[]", new String [] {
			"String[]",
			"Icon[]",
			"Object[]"
		});
		
		panel_entry = new Dialog_Buttons("Input", new String [] {
			"Input Text",
			"Combo"
		});
		
		setLayout(new BorderLayout());
		
		panel.add(panel_type);
		panel.add(panel_type_message);
		panel.add(panel_message);
		panel.add(panel_type_option);
		panel.add(panel_options);
		panel.add(panel_entry);
		
		JPanel panel_show = new JPanel();
		JButton button_show = new JButton("Show");
		
		button_show.addActionListener(new ShowAction());
		
		panel_show.add(button_show);
		
		add(panel, BorderLayout.CENTER);
		add(panel_show, BorderLayout.SOUTH);
	}
	
	public Object gMessage() {
		
		String s = panel_message.gSelection();
		
		if(s.equals("String")) {
			
			return messageString;
			
		} else if(s.equals("Icon")) {
			
			return messageIcon;
			
		} else if(s.equals("Component")) {
			
			return messageComponent;
			
		}else if(s.equals("Other")) {
			
			return messageObject;
			
		} else if(s.equals("Object[]")) {
			
			return new Object[] {
					messageString,
					messageIcon,
					messageComponent,
					messageObject
			};
			
		} else {
			return null;
		}
	}
	
	public int gType(Dialog_Buttons panel) {
		
		String s = panel.gSelection();
		
		if(s.equals("ERROR_MESSAGE") || s.equals("YES_NO_OPTION")) {
			return 0;
		}else if(s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION")) {
			return 1;
		} else if(s.equals("WARNING_MESSAGE") || s.equals("OK_CANCEL_OPTION")) {
			return 2;
		} else if(s.equals("QUESTION_MESSAGE")) {
			return 3;
		} else if(s.equals("PLAIN_MESSAGE") || s.equals("DEFAULT_OPTION") ) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public Object[] gOptions(Dialog_Buttons panel) {
		
		String s = panel.gSelection();
		
		if(s.equals("String[]")) {
			return new String[] {
					"Yellow", 
					"Blue", 
					"Red"
					};
			} else if(s.equals("Icon[]")) {
				return new Object[] {new ImageIcon("src/dialog_boxes/blue.jpg"), 
						new ImageIcon("src/dialog_boxes/yellow.jpg"),
						new ImageIcon("src/dialog_boxes/red.jpg")
				};
			}else if(s.equals("Object[]")) {
				
				return new Object[] {
						messageString,
						messageIcon,
						messageComponent,
						messageObject
				};
				
			}else {
				return null;
			}
	}
	
	private class ShowAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(panel_type.gSelection());
			if(panel_type.gSelection().equals("Message")) {
				JOptionPane.showMessageDialog(Dialog_Frame.this, gMessage(), "Title", gType(panel_type_message));
			} else if (panel_type.gSelection().equals("Confirm")) {
				JOptionPane.showConfirmDialog(Dialog_Frame.this, gMessage(), "Title", gType(panel_type_option), gType(panel_type_message));
			} else if (panel_type.gSelection().equals("Input")) {
				
				if(panel_entry.gSelection().equals("Input Text")) {
					
					JOptionPane.showInputDialog(Dialog_Frame.this, gMessage(), "Title", gType(panel_type_message));
				
				} else {
					
					JOptionPane.showInputDialog(Dialog_Frame.this, gMessage(), "Title", gType(panel_type_message), null, new String[] {"Yellow", "Blue", "Red"}, "Blue");
				}
				
			} else if (panel_type.gSelection().equals("Option")) {
				JOptionPane.showOptionDialog(Dialog_Frame.this, gMessage(), "Title", 1, gType(panel_type_message), null, gOptions(panel_options), null);
			} 
		}
		
	}
	
	
	private Dialog_Buttons panel_type, panel_type_message, panel_message, panel_type_option, panel_options, panel_entry; 
	private String messageString = "Message";
	private Icon messageIcon = new ImageIcon("src/dialog_boxes/red.jpg");
	private Object messageObject = new Date();
	private Component messageComponent = new examplePanel();
	
}


class examplePanel extends JPanel{
	
	public void paintComponent(Graphics p) {
		
		super.paintComponent(p);
		
		Graphics2D g2 = (Graphics2D) p;
		
		Rectangle2D rectangle = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
		
		g2.setPaint(Color.yellow);
		
		g2.fill(rectangle);
	}
}