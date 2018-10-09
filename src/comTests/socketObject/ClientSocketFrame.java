package comTests.socketObject;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author cifengwang
 *
 */
public class ClientSocketFrame extends JFrame{
	private JTextArea ta_info;
	private JTextField tf_id;
	private JTextField tf_name;
	private Socket socket;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	private Container container;
	private JPanel panel;
	private JLabel label_id;
	private JLabel label_name;
	private JButton button;
	
	public ClientSocketFrame() {
		super();
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,373,257);
		container=this.getContentPane();
		
		final JScrollPane scrollpane=new JScrollPane();
		container.add(scrollpane, BorderLayout.CENTER);
		
		ta_info=new JTextArea();
		scrollpane.setViewportView(ta_info);
		
		container.add(getPanel(), BorderLayout.NORTH);
	}
	
	public void connect() {
		ta_info.append("trying to connect...\n");
		try {
			socket=new Socket("192.168.31.169",1978);
			while(true) {
				out=new ObjectOutputStream(socket.getOutputStream());
				in=new ObjectInputStream(socket.getInputStream());
				getClientInfo();
				ta_info.append("connected!\n");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getClientInfo() {//getting in from Server
		try {
			while(true) {
				Student stu=(Student) in.readObject();
				if(stu!=null) {}
				ta_info.append("getting id: "+stu.getId()+" +name: "+stu.getName()+"\n");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close(); 
                }
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
	}
	
	protected JPanel getPanel() {
		if(panel==null) {
			panel=new JPanel();
			panel.add(getLabel_id());
			tf_id=new JTextField();
			tf_id.setPreferredSize(new Dimension(70, 25));
	        panel.add(tf_id);
	        
	        panel.add(getLabel_name());
	        tf_name=new JTextField();
	        panel.add(tf_name);
	        tf_name.setPreferredSize(new Dimension(100, 25));
	        panel.add(getButton());
		}
		return panel;
	}
	
	protected JLabel getLabel_id() {
		if(label_id==null) {
			label_id=new JLabel();
			label_id.setText("id: ");
		}
		return label_id;
	}
	
	protected JLabel getLabel_name() {
		if(label_name==null) {
			label_name=new JLabel();
			label_name.setText("name: ");
		}
		return label_name;
	}
	
	protected JButton getButton() {
		if(button==null) {
			button=new JButton();
			//sending info to Server
			button.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					Student stu=new Student();
					stu.setId(tf_id.getText());
					stu.setName(tf_name.getText());
					ta_info.append("Client sending   id: "+tf_id.getText()+" name: "+tf_name.getText()+"/n");
					try {
						out.writeObject(stu);
					} catch(IOException e1) {
						e1.printStackTrace();
					}
					tf_id.setText(null);
					tf_id.setText(null);
				}
			});
			button.setText("send");
		}
		return button;
	}
	
	 public static void main(String[] args) { 
	        ClientSocketFrame clien = new ClientSocketFrame(); 
	        clien.setVisible(true); 
	        clien.connect(); 
	    }


}
