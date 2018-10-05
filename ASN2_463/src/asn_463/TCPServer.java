package asn_463;

import java.io.IOException;
import java.net.*;
import java.io.*;

public class TCPServer {
	
	public TCPServer() {
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		
		try {
			//port #
			ServerSocket welcomeSocket = new ServerSocket(2245);

			Frame1 sConnection= new Frame1();
			Frame2 cConnection= new Frame2();
			sConnection.setConnection("Not Connected");
			cConnection.setConnection("Not Connected");
			
		while(true) {
			
			Socket connectionSocket = welcomeSocket.accept();
			
			sConnection.setConnection("Connected");
			cConnection.setConnection("Connected");
	
			
			//reads message sent by client
			BufferedReader inputFromClient = new BufferedReader
					(new InputStreamReader(connectionSocket.getInputStream()));
			
			String recSentence = inputFromClient.readLine();
			
			
			System.out.println(recSentence);
			
			
			//send message to the client
			DataOutputStream outputToClient = new 
					DataOutputStream(connectionSocket.getOutputStream());
			
			//use \n bc we use readline before and it looks for new line character
			String sentence= "sup it's fisher what up, copy" + connectionSocket.getLocalAddress()+ '\n';
			
			outputToClient.writeBytes("from server" + sentence);
	
			
		}
		//we cant close becaause we have an infinite loop so we keep cocket open
		//welcomeSocket.close();
		
	}catch(Exception ex) {
		
	}

}
}