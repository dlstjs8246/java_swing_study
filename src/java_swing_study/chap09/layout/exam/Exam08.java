package java_swing_study.chap09.layout.exam;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam08 extends JFrame {

	private JPanel contentPane;
	private PanelNorthExam08 panelNorth;
	private PanelCenterExam08 panelCenter;
	private PanelSouthExam08 panelSouth;

	public Exam08() {
		initialize();
	}
	private void initialize() {
		setTitle("여러 개의 패널을 가진 프레임");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorth = new PanelNorthExam08();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		panelCenter = new PanelCenterExam08();
		for(JLabel j : panelCenter.getLabel()) {
			panelCenter.add(j);
		}
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		panelSouth = new PanelSouthExam08();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
	}

}
