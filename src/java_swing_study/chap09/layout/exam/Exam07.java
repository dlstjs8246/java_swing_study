package java_swing_study.chap09.layout.exam;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;

@SuppressWarnings("serial")
public class Exam07 extends JFrame {

	private JPanel contentPane;
	private North_panel_exam07 panel;
	private South_Panel_Exam07 panel_1;
	private Center_panel_exam07 panel_2;

	public Exam07() {
		initialize();
	}
	private void initialize() {
		setTitle("계산기 프레임");
		setBackground(new Color(0, 139, 139));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new North_panel_exam07();
		panel.setBounds(new Rectangle(0, 0, 50, 20));
		contentPane.add(panel, BorderLayout.NORTH);
		
		panel_1 = new South_Panel_Exam07();
		panel_1.setBounds(new Rectangle(0, 0, 50, 20));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		panel_2 = new Center_panel_exam07();
		panel_2.setBounds(new Rectangle(50, 0, 300, 200));
		contentPane.add(panel_2, BorderLayout.CENTER);
	}

}
