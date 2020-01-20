package java_swing_study.chap11.trainingExam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OpenChallenge extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblImg;
	private JPanel panel;
	private JButton btnLeft;
	private JButton btnRight;
	private ImageIcon[] imgIcons;
	private int idx;

	public OpenChallenge() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblImg = new JLabel("");
		lblImg.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		String path = System.getProperty("user.dir") + "\\images\\";
		imgIcons = new ImageIcon[] {new ImageIcon(path + "spiderman.jpg"),new ImageIcon(path + "wonderwoman.jpg"),new ImageIcon(path + "batman.jpg"),new ImageIcon(path + "superman.jpg")};
		lblImg.setIcon(imgIcons[idx]);
		contentPane.add(lblImg, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setForeground(Color.GRAY);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnLeft = new JButton("");
		btnLeft.addActionListener(this);
		btnLeft.setIcon(new ImageIcon("D:\\workspace_java\\java_swing_study\\images\\leftArrow.jpg"));
		panel.add(btnLeft);
		
		btnRight = new JButton("");
		btnRight.addActionListener(this);
		btnRight.setIcon(new ImageIcon("D:\\workspace_java\\java_swing_study\\images\\rightArrow.jpg"));
		panel.add(btnRight);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLeft) {
			btnLeftActionPerformed(e);
		}
		if (e.getSource() == btnRight) {
			btnRightActionPerformed(e);
		}
	}
	protected void btnRightActionPerformed(ActionEvent e) {
		if(idx==3) {
			idx = 0;
			lblImg.setIcon(imgIcons[idx]);
		}
		else {
			lblImg.setIcon(imgIcons[++idx]);
		}
	}
	protected void btnLeftActionPerformed(ActionEvent e) {
		if(idx==0) {
			idx = 3;
			lblImg.setIcon(imgIcons[idx]);
		}
		else {
			lblImg.setIcon(imgIcons[--idx]);
		}
	}
}
