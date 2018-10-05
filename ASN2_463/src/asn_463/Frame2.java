package asn_463;

import java.awt.Color;
import java.awt.FlowLayout;//imports basic layout so we don't have to create one

import javax.swing.JButton;
import javax.swing.JFrame;// gives you basic features of windows (title bar, maximize, minimize...)
import javax.swing.JLabel;//lets you output text and images
import javax.swing.JTextField;
import java.awt.event.ActionListener;//ways for user to do something ex press enter
import java.awt.event.ActionEvent;

public class Frame2 extends JFrame{
	
	private JLabel connectLabel;
	private JTextField box;
	private JButton button;
	
	
	//Constructor
	public Frame2() {
		
		super("Client TCP"); //gives title
		//types of layout you can use: FlowLayout, GridLayout ...
		setLayout(new FlowLayout()); //gives default layout
		//connectLabel= new JLabel();
		box= new JTextField(22);//make a text box
		button= new JButton("Connect");
	

	}
	
	public void setConnection(String connect) {
		
		if(connect.equals("Not Connected")) {
			connectLabel= new JLabel("Connection Status: "+ connect );
			connectLabel.setForeground(Color.RED);
			
		}else {
			connectLabel= new JLabel("Connection Status: "+ connect );
			connectLabel.setForeground(Color.BLUE);
			
		}
		
		displayFrame2();
	}
	
	public void displayFrame2() {
		
		add(connectLabel);
		add(box);
		add(button);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(275,180);
		setVisible(true);
		
	}
	
		
	
	
}