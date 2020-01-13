package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Ex03 extends JFrame {

	private JPanel contentPane;
	private JButton btnCenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex03 frame = new Ex03();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ex03() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnCenter = new JButton("call~");
		String userPath = System.getProperty("user.dir") + "\\images\\";
		ImageIcon normalIcon = new ImageIcon(userPath + "normalIcon.gif");
		ImageIcon rollOverIcon = new ImageIcon(userPath + "rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon(userPath + "pressdIcon.gif");
		
		btnCenter.setIcon(normalIcon);
		btnCenter.setRolloverIcon(rollOverIcon);
		btnCenter.setPressedIcon(pressedIcon);
		contentPane.add(btnCenter, BorderLayout.CENTER);
	}

}
