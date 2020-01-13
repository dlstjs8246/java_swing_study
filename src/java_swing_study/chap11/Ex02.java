package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Ex02 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNorth;
	private JLabel lblCenter;
	private JLabel lblBottom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex02 frame = new Ex02();
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
	public Ex02() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		setContentPane(contentPane);
		
		lblNorth = new JLabel("사랑합니다.");
		lblNorth.setFont(new Font("굴림", Font.BOLD, 12));
		lblNorth.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNorth, BorderLayout.NORTH);
		
		lblCenter = new JLabel("");
		lblCenter.setHorizontalAlignment(SwingConstants.CENTER);
		String dirPath = System.getProperty("user.dir") + "\\images\\";
		lblCenter.setIcon(new ImageIcon(dirPath + "beauty.jpg"));
		lblCenter.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				switch(e.getButton()) {
				case 1:
					JOptionPane.showMessageDialog(null, e.getButton());
					lblCenter.setIcon(new ImageIcon(dirPath + "image3.jpg"));
					break;
				case 3:
					JOptionPane.showMessageDialog(null, e.getButton());
					lblCenter.setIcon(new ImageIcon(dirPath + "beauty.jpg"));
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "휠 버튼을 누르지 마세요");
					break;
				}
			}
		});
		contentPane.add(lblCenter, BorderLayout.CENTER);
		
		lblBottom = new JLabel("보고싶으면 연락하세요");
		lblBottom.setIcon(new ImageIcon(dirPath + "normalIcon.gif"));
		lblBottom.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBottom, BorderLayout.SOUTH);
	}

}
