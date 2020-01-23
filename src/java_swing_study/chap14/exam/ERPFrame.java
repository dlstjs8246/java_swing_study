package java_swing_study.chap14.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java_swing_study.chap14.exam.ui.DepartmentMainPanel;
import java_swing_study.chap14.exam.ui.EmployeeMainPanel;
import java_swing_study.chap14.exam.ui.StudentMainPanel;

@SuppressWarnings("serial")
public class ERPFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMgn;
	private JMenuItem mntmStd;
	private JMenuItem mntmDept;
	private JMenuItem mntmEmp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERPFrame frame = new ERPFrame();
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
	public ERPFrame() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMgn = new JMenu("관리");
		menuBar.add(mnMgn);
		
		mntmStd = new JMenuItem("학생관리");
		mntmStd.addActionListener(this);
		mnMgn.add(mntmStd);
		
		mntmDept = new JMenuItem("부서관리");
		mntmDept.addActionListener(this);
		mnMgn.add(mntmDept);
		
		mntmEmp = new JMenuItem("사원관리");
		mntmEmp.addActionListener(this);
		mnMgn.add(mntmEmp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmEmp) {
			mntmEmpActionPerformed(e);
		}
		if (e.getSource() == mntmStd) {
			mntmStdActionPerformed(e);
		}
		if (e.getSource() == mntmDept) {
			mntmDeptActionPerformed(e);
		}
	}
	
	
	
	protected void mntmDeptActionPerformed(ActionEvent e) {
		DepartmentMainPanel deptMainPanel = new DepartmentMainPanel();
		setContentPane(deptMainPanel);
		revalidate();
		repaint();
	}
	protected void mntmStdActionPerformed(ActionEvent e) {
		StudentMainPanel stdMainPanel = new StudentMainPanel();
		setContentPane(stdMainPanel);
		revalidate();
		repaint();
	}
	protected void mntmEmpActionPerformed(ActionEvent e) {
		EmployeeMainPanel empMainPanel = new EmployeeMainPanel();
		setContentPane(empMainPanel);
		revalidate();
		repaint();
	}
}
