package java_swing_study.chap11.trainingExam;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam01 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JCheckBox chckbxBtnToggle;
	private JCheckBox chckbxBtnHide;
	private JButton btn;

	/**
	 * Create the frame.
	 */
	public Exam01() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		chckbxBtnToggle = new JCheckBox("버튼 비활성화");
		chckbxBtnToggle.addActionListener(this);
		contentPane.add(chckbxBtnToggle);
		
		chckbxBtnHide = new JCheckBox("버튼 감추기");
		chckbxBtnHide.addActionListener(this);
		contentPane.add(chckbxBtnHide);
		
		btn = new JButton("test Button");
		contentPane.add(btn);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == chckbxBtnHide) {
			chckbxBtnHideActionPerformed(e);
		}
		if (e.getSource() == chckbxBtnToggle) {
			chckbxBtnToggleActionPerformed(e);
		}
	}
	protected void chckbxBtnToggleActionPerformed(ActionEvent e) {
		if(btn.isEnabled()) {
			btn.setEnabled(false);
		}
		else {
			btn.setEnabled(true);
		}
	}
	protected void chckbxBtnHideActionPerformed(ActionEvent e) {
		if(btn.isVisible()) {
			btn.setVisible(false);
		}
		else {
			btn.setVisible(true);
		}
		
	}
}
