package java_swing_study.chap11.trainingExam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExamMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnExam01;
	private JButton btnExam02;
	private JButton btnExam05;
	private JButton btnExam07;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamMain frame = new ExamMain();
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
	public ExamMain() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnExam01 = new JButton("Exam01");
		btnExam01.addActionListener(this);
		contentPane.add(btnExam01);
		
		btnExam02 = new JButton("Exam02");
		btnExam02.addActionListener(this);
		contentPane.add(btnExam02);
		
		btnExam05 = new JButton("Exam05");
		btnExam05.addActionListener(this);
		contentPane.add(btnExam05);
		
		btnExam07 = new JButton("Exam07");
		btnExam07.addActionListener(this);
		contentPane.add(btnExam07);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExam07) {
			btnExam07ActionPerformed(e);
		}
		if (e.getSource() == btnExam05) {
			btnExam05ActionPerformed(e);
		}
		if (e.getSource() == btnExam02) {
			btnExam02ActionPerformed(e);
		}
		if (e.getSource() == btnExam01) {
			btnExam01ActionPerformed(e);
		}
	}
	protected void btnExam01ActionPerformed(ActionEvent e) {
		Exam01 frame = new Exam01();
		frame.setVisible(true);
	}
	protected void btnExam02ActionPerformed(ActionEvent e) {
		Exam02 frame = new Exam02();
		frame.setVisible(true);
	}
	protected void btnExam05ActionPerformed(ActionEvent e) {
		Exam05 frame = new Exam05();
		frame.setVisible(true);
	}
	protected void btnExam07ActionPerformed(ActionEvent e) {
		Exam07 frame = new Exam07();
		frame.setVisible(true);
	}
}
