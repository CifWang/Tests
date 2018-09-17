package testSwing;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BorderLayoutPosition extends JFrame {
	//BorderLayout.CENTER，在容器中添加组件时，组件置于中间开始填充，直到与其他组件边界链接
	String[] border= {BorderLayout.CENTER,BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.EAST,BorderLayout.WEST};//组件摆放位置
	String[] buttonName= {"center button","north button","south button","east button","west button"};
	public BorderLayoutPosition() {
		setTitle("这个窗体使用边界布局管理器");
		Container c=getContentPane();
		setLayout(new BorderLayout());
		for(int i=0;i<border.length;i++) {
			c.add(border[i], new JButton(buttonName[i]));
		}
		setSize(350,200);//设置窗体大小
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BorderLayoutPosition();
	}

}
