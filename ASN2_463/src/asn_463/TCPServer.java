package asn_463;

import java.io.IOException;
import java.net.*;
import java.io.*;

public class TCPServer {
	
	private Frame1 pushF1=new Frame1();

	public void Server() {
		
	try {
		//port #
		ServerSocket welcomeSocket = new ServerSocket(2245);
		
	while(true) {
		
		Socket connectionSocket = welcomeSocket.accept();
		
		//reads message sent by client
		BufferedReader inputFromClient = new BufferedReader
				(new InputStreamReader(connectionSocket.getInputStream()));
		
		String recSentence = inputFromClient.readLine();
		
		pushF1.writeinBox(recSentence);
		pushF1.setConnection("Connected");
		System.out.println(recSentence);
		
		//send message to the client
		DataOutputStream outputToClient = new 
				DataOutputStream(connectionSocket.getOutputStream());
		
		//use \n bc we use readline before and it looks for new line character
		String sentence= "sup it's fisher what up, copy" + connectionSocket.getLocalAddress()+ '\n';
		
		outputToClient.writeBytes("from server" + sentence);

		
	}
	//we can't close because we have an infinite loop so we keep socket open
	//welcomeSocket.close();
	
}catch(Exception ex) {
	
}
	}
	
	public static void main(String[] args) {
		
		Frame1 f1=new Frame1();
		f1.displayFrame();
		TCPServer runServer= new TCPServer();
		runServer.Server();

		
		
}

}
