package comTests.socketObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerSocketFrame extends JFrame {
	private JTextArea ta_info;
	private JTextField ta_id;
	private JTextField ta_name;
	private ServerSocket server;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public void getServer() {
		try {
			server=new ServerSocket(1982);
			ta_info.append("Server Socket创建成功！");
			//Socket可以连接
			while(true) {
				ta_info.append("等待client连接...");
				socket=server.accept();//连接
				ta_info.append("client连接成功！");
				//TODO Still got doubts
				out = new ObjectOutputStream(socket.getOutputStream());
	            in = new ObjectInputStream(socket.getInputStream());
	            getClientInfo(); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getClientInfo() {}
	
	public ServerSocketFrame() {
		super();
	}
	
	public static void main(String[] args) {
		
	}
	
}
