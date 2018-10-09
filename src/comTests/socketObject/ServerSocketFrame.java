package comTests.socketObject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import javax.swing.text.AbstractDocument.Content;

public class ServerSocketFrame extends JFrame {
	private JTextArea ta_info;
	private JTextField tf_id;
	private JTextField tf_name;
	private ServerSocket server; //Server Socket
	private Socket socket; //Socket on Server created
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public ServerSocketFrame() {
		super();
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,379,260);
		
		final JScrollPane scrollpane=new JScrollPane();
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		
		ta_info=new JTextArea();
	    scrollpane.setViewportView(ta_info);
	    
	    final JPanel panel=new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JLabel label_id=new JLabel();
		label_id.setText("id");
		panel.add(label_id);
		tf_id = new JTextField();
        tf_id.setPreferredSize(new Dimension(70,25));
        panel.add(tf_id);
        
        final JLabel label_name=new JLabel();
		label_name.setText("name");
		panel.add(label_id);
		tf_name = new JTextField();
        tf_name.setPreferredSize(new Dimension(100,25));
        panel.add(tf_name);
        
        final JButton button=new JButton();
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(final ActionEvent e) {
        		Student stu=new Student();
        		stu.setId(tf_id.getText());
        		stu.setName(tf_name.getText());
        		ta_info.append("Server sending  id：" + tf_id.getText() + "  name："+tf_name.getText()+"\n"); 
        		 try {
                     out.writeObject(stu);
                 } catch (IOException e1) {
                     e1.printStackTrace();
                 } 

        		tf_id.setText(null); 
            tf_name.setText(null);
        	}
        });
        button.setText("send");
        panel.add(button);
	}
	
	public void getServer() {
		try {
			server=new ServerSocket(1987);
			ta_info.append("Server Socket！\n");
			while(true) { //Server Socket is connected.
				ta_info.append("waiting...\n");
				socket=server.accept();
				ta_info.append("client connected!\n");
				out=new ObjectOutputStream(socket.getOutputStream());
				in=new ObjectInputStream(socket.getInputStream());
				getClientinfo();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getClientinfo(){
		try {
			while(true) {
				Student stu= (Student) in.readObject();
				if(stu!=null) {
					ta_info.append("getting information student id: "+stu.getId()+" name: "+stu.getName()+"\n");
				}
			}
		} catch(Exception e) {
			ta_info.append("client has exited");
		}
		finally {
            try {
                if (in != null) {
                    in.close();// close stream
                }
                if (socket != null) {
                    socket.close(); // close socket
                }
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
	}
	public static void main(String[] args) {
		ServerSocketFrame frame=new ServerSocketFrame();
		frame.setVisible(true);
		frame.getServer();
	}
}