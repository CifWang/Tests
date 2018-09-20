package chatRoom;
/**
 * chat room server
 */

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.Container;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class ChatServerFrame extends JFrame{
	private Hashtable<String,Socket>map=new Hashtable<String,Socket>();
	ServerSocket server;
	Socket socket;
	private JTextArea ta_info=new JTextArea();
	Container container;
	
	public ChatServerFrame(String title) {
		super(title);
		container=this.getContentPane();
		container.add(ta_info,"Center");
	}
	
	/**
	 * 创建服务器的Socket，去连接用户的Socket，然后启动线程对象，对客户端发送的信息进行处理
	 */
	public void createSocket() {
		try {
			server=new ServerSocket(1982);
			while(true) {
				ta_info.append("等待新客户连接...");
				socket=server.accept();
				ta_info.append("客户端连接成功"+socket+"\n");
				new ServerThread(socket).start();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	class ServerThread extends Thread{
		Socket socket;
		public ServerThread(Socket socket) {
			this.socket=socket;
		}
		//private Thread t;
		public void run() {
			try {
				ObjectInputStream ins=new ObjectInputStream(socket.getInputStream());
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
