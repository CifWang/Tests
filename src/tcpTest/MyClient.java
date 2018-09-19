package tcpTest;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author cifengwang
 * client code
 * input in text area, and send to server
 */

public class MyClient extends JFrame{
	Socket socket;
	private PrintWriter writer;
	private JTextArea ta=new JTextArea();
	private JTextField tf=new JTextField();
	Container c;
	
	public MyClient(String title) {
		super(title);
		c=this.getContentPane();
		c.add(ta, "North");
		c.add(tf,"South");
		
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writer.println(tf.getText());
				ta.append(tf.getText()+"\n");
				tf.setText("");
			}
		});
	}
	
	private void connect() {
		ta.append("connecting...\n");
		try {
			socket=new Socket("192.168.31.169",8998);
			writer=new PrintWriter(socket.getOutputStream(),true);
			ta.append("connected!\n");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	public static void main(String[] arg) {
		MyClient client=new MyClient("sending messages to server");
		client.setBounds(300,260,340,220);
		client.setVisible(true);
		client.connect();
	}*/
}
