package asn_463;

import java.net.*;
import java.io.*;

public class TCPClient extends TCPServer{

	public void getString(String s) {
		
		Frame1 sConnection= new Frame1();
		Frame2 cConnection= new Frame2();
		sConnection.setConnection(s);
		cConnection.setConnection(s);
		
	}
	
	public static void main(String[] args) throws Exception{
		TCPClient client = new TCPClient();
		
		try {
		//ip address: 127.0.0.1 ---> loopback ip address
		//^ when connecting to yourself
		//when connecting to someone else you have to know their ip address//niro IP: 132.205.46.163
		Socket clientSocket = new Socket("localhost",2245);
		
		//send message to the server
		DataOutputStream outputToServer = new 
				DataOutputStream(clientSocket.getOutputStream());
		
		//use \n bc we use readline and it looks for new line character
		String sentence= "Connected"; // maybe add here "Connected" 
		client.getString(sentence);
		
//	+"  client port #  " + clientSocket.getLocalPort()
//+ "   client ip address  " + clientSocket.getLocalAddress() + '\n';
		
//outputToServer.writeBytes("from client " + sentence);
		
		
		//reads messagefrom server
		BufferedReader inputFromServer = new BufferedReader
				(new InputStreamReader(clientSocket.getInputStream()));
		
		String recSentence = inputFromServer.readLine();
		
		System.out.println("from server: "+ recSentence);
		
		
		
		
	}catch(Exception ex) {
		
	}
}
}