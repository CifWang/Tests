package comTests;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrameTest2 extends JFrame {
	private JTextArea ta_allIp;
	
	public static void main(String[] args) {
		FrameTest2 frame=new FrameTest2();
		frame.setVisible(true);
    	
    }
	
	public FrameTest2() {
        super();
        
        addWindowListener(new WindowAdapter() {
            public void windowOpened(final WindowEvent e) {
                try {
                    //gainAllIp();
                    ta_allIp.setText(null);
                } catch (Exception e1) {
                    ta_allIp.setText(null);
                }
            }
        });
        setTitle("获得内网的所有IP地址");
        setBounds(400, 200, 270, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_allIp = new JTextArea();
        scrollPane.setViewportView(ta_allIp);
        
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        
        final JButton button_2 = new JButton();
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    ta_allIp.setText(null);
                    //gainAllIp();
                } catch (Exception e1) {
                    ta_allIp.setText(null);
                    JOptionPane.showMessageDialog(null, "应用程序异常，请再试一次。");
                }
            }
        });
        button_2.setText("显示所有IP");
        panel.add(button_2);
	}

}
