package asn_463;

import java.awt.Color;
import java.awt.FlowLayout;//imports basic layout so we don't have to create one

import javax.swing.JButton;
import javax.swing.JFrame;// gives you basic features of windows (title bar, maximize, minimize...)
import javax.swing.JLabel;//lets you output text and images
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;//ways for user to do something ex press enter
import java.awt.event.ActionEvent;

public class Frame2 extends JFrame{
	
	private JLabel connectLabel= new JLabel();
	private JTextArea box= new JTextArea(5,20);
	private JButton button= new JButton("Connect");
	private Frame1 f1= new Frame1();
	private TCPClient runClient = new TCPClient();
	//Constructor
	public Frame2() {
		
		super("Client TCP"); //gives title
		//types of layout you can use: FlowLayout, GridLayout ...
		setLayout(new FlowLayout()); //gives default layout
		defaultConnection();
		getConnect();

	}
	
	private void defaultConnection() {
		
		connectLabel.setText("Connection Status: Not Connected");
		connectLabel.setForeground(Color.RED);
		
	}

	public void getConnect() {
		
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			connectLabel.setText("Connection Status: Connected");
			connectLabel.setForeground(Color.BLUE);
			button.setVisible(false);
			//TCPClient runClient = new TCPClient();
			runClient.Client();
			//outputAns.setText(firstField.getText()+" "+ "x" + secondField.getText()+" "+"= " + multiplication());			
		}

	});
	
	}
	
	public void setConnection(String connect) {
		
		if(connect.equals("Not Connected")) {
			connectLabel= new JLabel("Connection Status: "+ connect );
			connectLabel.setForeground(Color.RED);
			
		}else {
			connectLabel= new JLabel("Connection Status: "+ connect );
			connectLabel.setForeground(Color.BLUE);
			
		}
		
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