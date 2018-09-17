package fs2m369;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InternetContentFrame extends JFrame {
	private JTextField url_input;
	private JTextArea webinfo;
	public InternetContentFrame() {
		super();
		addWindowListener(new WindowAdapter() {
			public void windowOpened(final WindowEvent e) {
				try {
					webinfo.setText(null);
				} catch(Exception e1) {
					webinfo.setText(null);
				}
			}
		});
		setTitle("解析网页的内容");
		setBounds(100,100,484,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JScrollPane scrollPane=new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		//final JScrollPane scrollPane2=new JScrollPane();
		//getContentPane().add(scrollPane2, BorderLayout.SOUTH);
		
		webinfo=new JTextArea();
		webinfo.setFont(new Font("", Font.BOLD, 14));
		scrollPane.setViewportView(webinfo);
		//scrollPane2.setViewportView(webinfo);
		
		final JPanel panel=new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		/**
		url_input=new JTextField();
		url_input.setBounds(100,50,300,50);
		panel.add(url_input);*/
		
		final JLabel label = new JLabel();
        label.setText("输入网址：");
        panel.add(label);
		
		url_input= new JTextField();
		url_input.setPreferredSize(new Dimension(260,25));
        panel.add(url_input);
		
		final JButton button=new JButton();
		button.setText("解析网页");
		panel.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String address=url_input.getText().trim();
				List urlCollection=getURLConnection(address);
				Iterator it=urlCollection.iterator();
				while(it.hasNext()) {
					webinfo.append((String)it.next()+"\n");
				}
			}
		});
		
	}
	
	/**
	public Collection<String> getURLConnection(String urlString){
		URL url=null;
		URLConnection conn=null;
		Collection<String> urlCollection=new ArrayList<String>();
		try {
			url=new URL(urlString);
			conn=url.openConnection();
			conn.connect();
			InputStream is=conn.getInputStream();
			InputStreamReader in=new InputStreamReader(is,"UTF-8");
			BufferedReader br=new BufferedReader(in);
			String nextLine=br.readLine();
			while(nextLine!=null) {
				urlCollection.add(nextLine);
				nextLine=br.readLine();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return urlCollection;
	}*/
	
	public List<String> getURLConnection(String urlString){
		URL url=null;
		URLConnection conn=null;
		List<String> urlCollection=new ArrayList<String>();
		try {
			url=new URL(urlString);
			conn=url.openConnection();
			conn.connect();
			InputStream is=conn.getInputStream();
			InputStreamReader in=new InputStreamReader(is,"UTF-8");
			BufferedReader br=new BufferedReader(in);
			String nextLine=br.readLine();
			while(nextLine!=null) {
				urlCollection.add(nextLine);
				nextLine=br.readLine();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return urlCollection;
	}
	
	public static void main(String[] args) {
		InternetContentFrame icf=new InternetContentFrame();
		icf.setVisible(true);
	}

}
