package tcpTest;
/**
 * one-way connection
 * client sending messages to server
 * server code
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTcp {
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	void getserver() {
		try {
			server=new ServerSocket(8998);
			System.out.println("Server socket successfully set up ");
			while(true) {
				System.out.println("waiting for connection...");
				socket=server.accept();
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getClientMessage() {
		try {
			while(true) {
				System.out.println("Client: "+reader.readLine());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(reader!=null) {
				reader.close();
			}
			if(socket!=null) {
				socket.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	public static void main(String[] args) {
		MyTcp tcp=new MyTcp();
		tcp.getserver();
	}*/

}