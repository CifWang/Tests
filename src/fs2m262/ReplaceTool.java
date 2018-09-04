package fs2m262;
/**
 * 继承JFrame，画窗口图
 * @author cifengwang
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;//跳出来的小框
import javax.swing.JFileChooser;//选择文件
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplaceTool extends JFrame{
	private JTextField beforeTextField=new JTextField();
	private JTextField afterTextField=new JTextField();
	
	private File textFile;
	
	public ReplaceTool() {
		final JFrame frame=new JFrame("字符串替换");
		frame.setLayout(null);
		frame.setLayout(null);
		frame.setSize(400, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出应用程序默认窗口关闭操作
		frame.setVisible(true);//缺了这个会显示不出来
		
		//画button
		final JButton btn1=new JButton("选择文件");
		final JButton btn2=new JButton("开始替换");
		btn1.setBounds(300, 50, 90, 30);
		btn2.setBounds(300, 100, 90, 30);
		btn1.setVisible(true);
		btn2.setVisible(true);
		frame.add(btn1);
		frame.add(btn2);
		
		final Font fontBtn=new Font("宋体",Font.BOLD, 11);
		btn1.setFont(fontBtn);
		btn2.setFont(fontBtn);
		
		//给选择文件按钮加事件监听器
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chooseButton_actionPerformed(e);
			}
		});
		
		//给开始替换按钮加事件监听器
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_replaceButton_actionPerformed(e);
			}
		});
		
		
		//画显示框
		final JLabel label1=new JLabel("替换前字符串：");
		final JLabel label2=new JLabel("替换后字符串：");
		label1.setBounds(25, 50, 90, 30);
		label2.setBounds(25, 100, 90, 30);
		label1.setVisible(true);
		label2.setVisible(true);
		frame.add(label1);
		frame.add(label2);
		
		final Font fontLabel=new Font("宋体",Font.BOLD,11);
		label1.setFont(fontLabel);
		label2.setFont(fontLabel);
		
		//画文本框
		
		beforeTextField.setBounds(120, 50, 180, 40);
		afterTextField.setBounds(120, 100, 180, 40);
		beforeTextField.setVisible(true);
		afterTextField.setVisible(true);
		frame.add(beforeTextField);
		frame.add(afterTextField);
	}
	
	/**
	 * 给开始替换按钮添加监听器
	 * @param e
	 */
	protected void do_replaceButton_actionPerformed(ActionEvent e) {
		String before=beforeTextField.getText();
		//验证
		if(before.isEmpty()) {
			JOptionPane.showMessageDialog(this, "请输入替换前的字符串","警告信息",JOptionPane.WARNING_MESSAGE);
			return;
		}
		String after=afterTextField.getText();
		if(after.isEmpty()) {
			JOptionPane.showMessageDialog(this, "请输入替换后的字符串","警告信息",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		FileReader reader=null;
		FileWriter writer=null;
		
		
	}
	
	/**
	 * 选择文件按钮的事件监听器
	 * @param e
	 */
	protected void do_chooseButton_actionPerformed(ActionEvent e) {
		JFileChooser chooser=new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("文本文件","txt"));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setMultiSelectionEnabled(false);
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION) {
			textFile=chooser.getSelectedFile();
		}
	}
	
	
	public static void main(String[] args) {
		ReplaceTool t=new ReplaceTool();
	}

}
