package java_swing_study.chap09.layout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java_swing_study.chap09.layout.exam.Exam02;
import java_swing_study.chap09.layout.exam.Exam04;
import java_swing_study.chap09.layout.exam.Exam05;
import java_swing_study.chap09.layout.exam.Exam07;
import java_swing_study.chap09.layout.exam.Exam08;
import java_swing_study.chap09.layout.openchallenge.OpenChallengeEx;

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
		btnFlow.addActionListener(this);
		pLeft.add(btnFlow);
		
		btnBorder = new JButton("BorderLayout");
		btnBorder.addActionListener(this);
		pLeft.add(btnBorder);
		
		btnGrid = new JButton("GridLayoutEx");
		btnGrid.addActionListener(this);
		pLeft.add(btnGrid);
		
		btnGrid2 = new JButton("GridLayout2");
		btnGrid2.addActionListener(this);
		pLeft.add(btnGrid2);
		
		btnAbsolute = new JButton("absoluteLayout");
		btnAbsolute.addActionListener(this);
		pLeft.add(btnAbsolute);
		
		BtnOpenChallenge = new JButton("openChallenge");
		BtnOpenChallenge.addActionListener(this);
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
		btnExam05.addActionListener(this);
		pRight.add(btnExam05);
		
		btnExam07 = new JButton("exam07");
		btnExam07.addActionListener(this);
		pRight.add(btnExam07);
		
		btnExam08 = new JButton("exam08");
		btnExam08.addActionListener(this);
		btnExam08.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getButton() + ":" + e.getClickCount());
			}
			
		});
		pRight.add(btnExam08);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BtnOpenChallenge) {
			BtnOpenChallengeActionPerformed(e);
		}
		if (e.getSource() == btnAbsolute) {
			btnAbsoluteActionPerformed(e);
		}
		if (e.getSource() == btnGrid2) {
			btnGrid2ActionPerformed(e);
		}
		if (e.getSource() == btnGrid) {
			btnGridActionPerformed(e);
		}
		if (e.getSource() == btnBorder) {
			btnBorderActionPerformed(e);
		}
		if (e.getSource() == btnFlow) {
			btnFlowActionPerformed(e);
		}
		if (e.getSource() == btnExam08) {
			btnExam08ActionPerformed(e);
		}
		if (e.getSource() == btnExam07) {
			btnExam07ActionPerformed(e);
		}
		if (e.getSource() == btnExam05) {
			btnExam05ActionPerformed(e);
		}
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
	protected void btnExam05ActionPerformed(ActionEvent e) {
		Exam05 exam = new Exam05();
		exam.setVisible(true);
	}
	protected void btnExam07ActionPerformed(ActionEvent e) {
		Exam07 exam = new Exam07();
		exam.setVisible(true);
	}
	protected void btnExam08ActionPerformed(ActionEvent e) {
		Exam08 exam = new Exam08();
		exam.setVisible(true);
	}
	protected void btnFlowActionPerformed(ActionEvent e) {
		FlowLayoutEx frame = new FlowLayoutEx();
		frame.setVisible(true);	
	}
	protected void btnBorderActionPerformed(ActionEvent e) {
		BorderLayoutEx frame = new BorderLayoutEx();
		frame.setVisible(true);
	}
	protected void btnGridActionPerformed(ActionEvent e) {
		GridLayoutEx frame = new GridLayoutEx();
		frame.setVisible(true);
	}
	protected void btnGrid2ActionPerformed(ActionEvent e) {
		GridLayoutEx02 frame = new GridLayoutEx02();
		frame.setVisible(true);
	}
	protected void btnAbsoluteActionPerformed(ActionEvent e) {
		AbsoluteLayoutEx frame = new AbsoluteLayoutEx();
		frame.setVisible(true);
	}
	protected void BtnOpenChallengeActionPerformed(ActionEvent e) {
		OpenChallengeEx frame = new OpenChallengeEx();
		frame.setVisible(true);
	}
}
