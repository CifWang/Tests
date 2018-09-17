package testSwing;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JScrollPaneTest extends JFrame{
	public JScrollPaneTest() {
		Container c=getContentPane();
		JTextArea ta=new JTextArea(20,50);
		ta.setText("带滚动条的文字编译器");
		
		JScrollPane sp=new JScrollPane();
		sp.setViewportView(ta);
		
		//JScrollPane sp=new JScrollPane(ta);
		c.add(sp,BorderLayout.CENTER);
		setSize(200,100);//设置窗体大小
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JScrollPaneTest();
	}

}
