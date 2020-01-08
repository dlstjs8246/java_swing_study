package java_swing_study.chap09.layout.exam;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;

@SuppressWarnings("serial")
public class PanelNorthExam08 extends JPanel {
	private JButton btnOpen;
	private JButton btnClose;
	private JButton btnExit;

	public PanelNorthExam08() {

		initialize();
	}
	private void initialize() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		setBackground(new Color(128, 128, 128));
		
		btnOpen = new JButton("열기");
		btnOpen.setFont(new Font("굴림", Font.BOLD, 12));
		add(btnOpen);
		
		btnClose = new JButton("닫기");
		btnClose.setFont(new Font("굴림", Font.BOLD, 12));
		add(btnClose);
		
		btnExit = new JButton("나가기");
		btnExit.setFont(new Font("굴림", Font.BOLD, 12));
		add(btnExit);
	}

}
