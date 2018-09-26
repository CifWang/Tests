package chatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientFrame extends JFrame {
	private ObjectOutputStream out;
	private JTextArea ta_info;
	private JTextField tf_send;
	 private JList user_list;
	//创建套接字对象、创建输出流对象以及启动线程对象对服务器转发的信息进行处理
	public void createClientSocket() {
		try {
			Socket socket=new Socket("192.168.31.169",1982);
			out=new ObjectOutputStream(socket.getOutputStream());
			new ClientThread(socket).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//内部线程类
	class ClientThread extends Thread {
		Socket socket;
		public ClientThread(Socket socket) {
			this.socket=socket;
		}
				
		public void run() {
			 try {
	                BufferedReader in = new BufferedReader(new InputStreamReader(
	                        socket.getInputStream()));
	                DefaultComboBoxModel model = (DefaultComboBoxModel) user_list
	                        .getModel();// 获得列表框的模型
	                while (true) {
	                    String info = in.readLine().trim();// 读取信息
	                    if (!info.startsWith("MSG:")) {// 接收到的不是消息
	                        if (info.startsWith("退出：")) {// 接收到的是退出消息
	                            model.removeElement(info.substring(3));// 从用户列表中移除用户
	                        } else {// 接收到的是登录用户
	                            boolean itemFlag = false;// 标记是否为列表框添加列表项，为true不添加，为false添加
	                            for (int i = 0; i < model.getSize(); i++) {// 对用户列表进行遍历
	                                if (info.equals((String) model.getElementAt(i))) {// 如果用户列表中存在该用户名
	                                    itemFlag = true;// 设置为true，表示不添加到用户列表
	                                    break;// 结束for循环
	                                }
	                            }
	                            if (!itemFlag) {
	                                    model.addElement(info);// 将登录用户添加到用户列表
	                            } 
	                        }
	                    } else {// 如果获得的是消息，则在文本域中显示接收到的消息
	                        DateFormat df = DateFormat.getDateInstance();// 获得DateFormat实例
	                        String dateString = df.format(new Date());         // 格式化为日期
	                        df = DateFormat.getTimeInstance(DateFormat.MEDIUM);// 获得DateFormat实例
	                        String timeString = df.format(new Date());         // 格式化为时间
	                        String sendUser = info.substring(4,info.indexOf("：发送给："));// 获得发送信息的用户
	                        String receiveInfo = info.substring(info.indexOf("：的信息是：")+6);// 获得接收到的信息
	                        ta_info.append("  "+sendUser + "    " +dateString+"  "+timeString+"\n  "+receiveInfo+"\n");// 在文本域中显示信息
	                        ta_info.setSelectionStart(ta_info.getText().length()-1);// 设置选择起始位置
	                        ta_info.setSelectionEnd(ta_info.getText().length());// 设置选择的结束位置
	                        tf_send.requestFocus();// 使发送信息文本框获得焦点
	                    }
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	
		}
}
