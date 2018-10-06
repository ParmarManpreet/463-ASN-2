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
	
	private JLabel connectLabel2= new JLabel();
	private JTextArea box= new JTextArea(5,20);
	private JButton button= new JButton("Connect");
	//private JButton button2= new JButton("Disconnect");
	private Frame1 f1= new Frame1();
	private TCPClient runClient = new TCPClient();
	//Constructor
	public Frame2() {
		
		super("Client TCP"); //gives title
		//types of layout you can use: FlowLayout, GridLayout ...
		setLayout(new FlowLayout()); //gives default layout
		defaultConnection();
		clickConnect();

	}
	
	public void writeinBox(String input) {
		box.append(input+"\n");
	}
	
	private void defaultConnection() {
		
		connectLabel2.setText("Connection Status: Not Connected");
		connectLabel2.setForeground(Color.RED);
		
	}
	
	public void clickConnect() {
		
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			checkConnection();
			//setConnection("Connected");
			//connectLabel.setText("Connection Status: Connected");
			//connectLabel.setForeground(Color.BLUE);
			//button.setVisible(false);;
			//TCPClient runClient = new TCPClient();
			runClient.Client();
			//outputAns.setText(firstField.getText()+" "+ "x" + secondField.getText()+" "+"= " + multiplication());			
		}

	});
	
	}
	
	public void checkConnection() {
		
		if (button.getText().equals("Connect")) {
			button.setText("Disconnect");
			connectLabel2= new JLabel("Connection Status: Connected" );
			connectLabel2.setForeground(Color.RED);
			//setConnection("Connected");
		
		}else {
			button.setText("Connect");
			connectLabel2= new JLabel("Connection Status: Not Connected" );
			connectLabel2.setForeground(Color.BLUE);
			//setConnection("Not Connected");

		}
	}
	
	public void setConnection(String connect) {
		
		if(connect.equals("Not Connected")) {
			connectLabel2= new JLabel("Connection Status: "+ connect );
			connectLabel2.setForeground(Color.RED);
		
			
		}else {
			connectLabel2= new JLabel("Connection Status: "+ connect );
			connectLabel2.setForeground(Color.BLUE);
		
		}
		
	}
	
	public void displayFrame2() {
		
		add(connectLabel2);
		add(box);
		add(button);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(275,180);
		setVisible(true);
		
	}
	
		
	
	
}