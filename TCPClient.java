package asn_463;

import java.net.*;
import java.io.*;

public class TCPClient extends TCPServer{
    
    private static ClientFrame2 frame = new ClientFrame2();

	public void startClient() {
		
		try {
			
		//ip address: 127.0.0.1 ---> loopback ip address
		//^ when connecting to yourself
		//when connecting to someone else you have to know their ip address
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
		frame.writeinBox2(recSentence);
		System.out.println("from server: "+ recSentence);
		
    	}catch(Exception ex) {}
		
	}
	
	public void stopClient() {
		
      try {
		
        Socket clientSocket = new Socket("localhost",2245);
        
		// Send message to the server
		DataOutputStream outputToServer = new 
				DataOutputStream(clientSocket.getOutputStream());
		
		//use \n bc we use readline and it looks for new line character
		String data =  "Disconnection Request: Socket[addr=" + clientSocket.getLocalAddress() + ",port=" + clientSocket.getPort() + ",localport=" + clientSocket.getLocalPort() + "]\n";
		
        // Send data to server
		outputToServer.writeBytes(data);
		
		// Client is no longer connected to Server
		
		
      }catch(Exception ex) { }
      
	}
  
  
	public static void main(String[] args) {
      
		frame.displayFrame2();
      
	}
}