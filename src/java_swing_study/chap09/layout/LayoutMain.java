package java_swing_study.chap09.layout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java_swing_study.chap09.layout.exam.Exam02;
import java_swing_study.chap09.layout.exam.Exam04;

@SuppressWarnings("serial")
public class LayoutMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JButton btnFlow;
	private JButton btnBorder;
	private JButton btnGrid;
	private JButton btnGrid2;
	private JButton btnAbsolute;
	private JButton BtnOpenChallenge;
	private JPanel pRight;
	private JButton btnExam02;
	private JButton btnExam04;
	private JButton btnExam05;
	private JButton btnExam07;
	private JButton btnExam08;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutMain frame = new LayoutMain();
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
	public LayoutMain() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("배치레이아웃");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uB808\uC774\uC544\uC6C3 \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "\uB808\uC774\uC544\uC6C3 \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnFlow = new JButton("flowLayout");
		pLeft.add(btnFlow);
		
		btnBorder = new JButton("BorderLayout");
		pLeft.add(btnBorder);
		
		btnGrid = new JButton("GridLayoutEx");
		pLeft.add(btnGrid);
		
		btnGrid2 = new JButton("GridLayout2");
		pLeft.add(btnGrid2);
		
		btnAbsolute = new JButton("absoluteLayout");
		pLeft.add(btnAbsolute);
		
		BtnOpenChallenge = new JButton("openChallenge");
		pLeft.add(BtnOpenChallenge);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "\uC2E4\uC2B5\uBB38\uC81C \uD480\uC774", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnExam02 = new JButton("exam02");
		btnExam02.addActionListener(this);
		pRight.add(btnExam02);
		
		btnExam04 = new JButton("exam04");
		btnExam04.addActionListener(this);
		pRight.add(btnExam04);
		
		btnExam05 = new JButton("exam05");
		pRight.add(btnExam05);
		
		btnExam07 = new JButton("exam07");
		pRight.add(btnExam07);
		
		btnExam08 = new JButton("exam08");
		pRight.add(btnExam08);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExam04) {
			btnExam04ActionPerformed(e);
		}
		if (e.getSource() == btnExam02) {
			btnExam02ActionPerformed(e);
		}
	}
	protected void btnExam02ActionPerformed(ActionEvent e) {
		Exam02 exam02 = new Exam02();
		exam02.setVisible(true);
	}
	protected void btnExam04ActionPerformed(ActionEvent e) {
		Exam04 exam = new Exam04();
		exam.setVisible(true);
	}
}
