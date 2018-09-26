package chatRoom;
/**
 * chat room server
 */

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

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
				while(true) {
					Vector v=null;
					try {
						v=(Vector)ins.readObject();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(v!=null&&v.size()>0) {
						for(int i=0;i<v.size();i++) {
							String info=(String)v.get(i);
							String key="";
							if(info.startsWith("用户：")){
								key=info.substring(3, info.length());
								map.put(key, socket);
								Set<String> set=map.keySet();
								Iterator<String> keyIt=set.iterator();
								while(keyIt.hasNext()) {
									String receiveKey=keyIt.next();
									Socket s=map.get(receiveKey);
									PrintWriter out=new PrintWriter(s.getOutputStream(),true);
									//因为iterator.next()一次之后，就会往后移，所以要重头开始的话，就要重新声明一个iterator
									Iterator<String> keyIt1=set.iterator();
									while(keyIt1.hasNext()) {
										String receiveKey1=keyIt1.next();
										out.println(receiveKey1);
										out.flush();
									}
								}
							}
							else if(info.startsWith("退出：")) {
								key=info.substring(3);
								map.remove(key);
								Set<String> set=map.keySet();
								Iterator<String> keyIt=set.iterator();
								while(keyIt.hasNext()) {
									String receiveKey=keyIt.next();
									Socket s=map.get(receiveKey);
									PrintWriter out=new PrintWriter(s.getOutputStream(),true);
									//因为iterator.next()一次之后，就会往后移，所以要重头开始的话，就要重新声明一个iterator
									Iterator<String> keyIt1=set.iterator();
									while(keyIt1.hasNext()) {
										String receiveKey1=keyIt1.next();
										out.println(receiveKey1);
										out.flush();
									}
								}
							}
							//不是新建用户，也不是退出删除用户，是发送消息
							else {
								key=info.substring(info.indexOf("：发送给：")+5,info.indexOf("：的信息是："));//接收方的key值，也就是接收方的用户名
								String sendUser=info.substring(0,info.indexOf("：发送给："));//发送方的key值
								Set<String> set = map.keySet();// 获得集合中所有键的Set视图
                                Iterator<String> keyIt = set.iterator();// 获得所有键的迭代器
                                while (keyIt.hasNext()) {
                                	String reveiveKey=keyIt.next();
                                	if(key.equals(reveiveKey)&&!sendUser.equals(reveiveKey)) {
                                		Socket s=map.get(reveiveKey);
                                		PrintWriter out = new PrintWriter(s.getOutputStream(), true);// 创建输出流对象
                                        out.println("MSG:" + info);// 发送信息
                                        out.flush();// 刷新输出缓冲区
                                    }
                                }

							}
						}
					}
					
				}
				
			} catch(IOException e) {
				ta_info.append(socket+"已经退出。\n");
			}
		}
	}
	
	public void showFrame() {
		this.setVisible(true);
		this.setState(NORMAL);
	}
	
	 public ChatServerFrame() {
	        super();
	        addWindowListener(new WindowAdapter() {
	            public void windowIconified(final WindowEvent e) {
	                setVisible(false);
	            }
	        });
	        setTitle("聊天室服务器端");
	        setBounds(100, 100, 385, 266);
	        
	        final JScrollPane scrollPane = new JScrollPane();
	        getContentPane().add(scrollPane, BorderLayout.CENTER);
	        
	        ta_info = new JTextArea();
	        scrollPane.setViewportView(ta_info);
	        
	        //托盘
	        if (SystemTray.isSupported()){                                      // 判断是否支持系统托盘
	            URL url=ChatServerFrame.class.getResource("server.png");          // 获取图片所在的URL
	            ImageIcon icon = new ImageIcon(url);                            // 实例化图像对象
	            Image image=icon.getImage();                                    // 获得Image对象
	            TrayIcon trayIcon=new TrayIcon(image);                          // 创建托盘图标
	            trayIcon.addMouseListener(new MouseAdapter(){                   // 为托盘添加鼠标适配器
	                public void mouseClicked(MouseEvent e){                     // 鼠标事件
	                    if (e.getClickCount()==2){                              // 判断是否双击了鼠标
	                        showFrame();                                    // 调用方法显示窗体
	                    }
	                }
	            });
	            trayIcon.setToolTip("系统托盘");                                    // 添加工具提示文本
	            PopupMenu popupMenu=new PopupMenu();                    // 创建弹出菜单
	            MenuItem exit=new MenuItem("退出");                           // 创建菜单项
	            exit.addActionListener(new ActionListener() {                   // 添加事件监听器
	                public void actionPerformed(final ActionEvent arg0) {
	                    System.exit(0);                                     // 退出系统
	                }
	            });
	            popupMenu.add(exit);                                        // 为弹出菜单添加菜单项
	            trayIcon.setPopupMenu(popupMenu);                           // 为托盘图标加弹出菜弹
	            SystemTray systemTray=SystemTray.getSystemTray();           // 获得系统托盘对象
	            try{
	                systemTray.add(trayIcon);                               // 为系统托盘加托盘图标
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	        }
	    }


}
