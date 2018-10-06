package asn_463;

import java.net.*;
import java.io.*;

public class TCPClient extends TCPServer{
private static Frame2 pushF2=new Frame2();

	public void Client() {
		
		
		try {
			
		//ip address: 127.0.0.1 ---> loopback ip address
		//^ when connecting to yourself
		//when connecting to someone else you have to know their ip address//niro IP: 132.205.46.163
		Socket clientSocket = new Socket("localhost",2245);
		
		//send message to the server
		DataOutputStream outputToServer = new 
				DataOutputStream(clientSocket.getOutputStream());
		
		//use \n bc we use readline and it looks for new line character
		String sentence=  "Connection Request: Socket[addr=" + clientSocket.getLocalAddress() + ",port=" + clientSocket.getPort() + ",localport=" + clientSocket.getLocalPort() + "]\n";
	
	
		outputToServer.writeBytes(sentence);
		
		
		//reads message from server
		BufferedReader inputFromServer = new BufferedReader
				(new InputStreamReader(clientSocket.getInputStream()));
		
		String recSentence = inputFromServer.readLine();
		pushF2.writeinBox(recSentence);
		System.out.println("from server: "+ recSentence);
		
		
		
		
	}catch(Exception ex) {
		
	}
	}
	
	public static void main(String[] args) {
		
		
		pushF2.displayFrame2();
		
	
		
}
}