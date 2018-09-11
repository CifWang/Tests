package comTests;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GainAllIpFrame extends JFrame{
	public GainAllIpFrame() {
		//super();
		setTitle("获得内网的所有IP地址");
        setBounds(400, 200, 270, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        //scrollPane.setVisible(true);
        
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        //panel.setVisible(true);
        
        final JButton button_1 = new JButton();
        
        button_1.setText("显示所有IP");
        panel.add(button_1);
        //button_1.setVisible(true);
        
        final JButton button_2 = new JButton();
        button_2.setText("退    出");
        panel.add(button_2);
        //button_2.setVisible(true);
        
        final JButton button = new JButton();
        button.setText("New JButton");
        panel.add(button);

	}
	
	public static void main(String[] args) {
		GainAllIpFrame g=new GainAllIpFrame();
		g.setVisible(true);
	}

}
