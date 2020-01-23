package java_swing_study.chap14;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import java_swing_study.chap11.exam.Department;
import java_swing_study.chap11.exam.Employee;
import java_swing_study.chap11.exam.StudentPanel;

@SuppressWarnings("serial")
public class MenuActionEventEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnScreen;
	private JMenuItem mntmLoad;
	private JMenuItem mntmHide;
	private JMenuItem mntmReShow;
	private JMenuItem mntmExit;
	private JLabel lblImg;
	private JMenuItem mntmStd;
	private JSeparator separator;
	private JToolBar toolBar;
	private JButton btnNew;
	private JButton btnImg;
	private JButton btnModal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuActionEventEx frame = new MenuActionEventEx();
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
	public MenuActionEventEx() {
		initialize();
	}
	private void initialize() {
		setTitle("Menu 달기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnScreen = new JMenu("Screen");
		
		menuBar.add(mnScreen);
		
		mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(this);
		mnScreen.add(mntmLoad);
		
		mntmHide = new JMenuItem("HIde");
		mnScreen.add(mntmHide);
		
		mntmReShow = new JMenuItem("Reshow");
		mnScreen.add(mntmReShow);
		
		mntmStd = new JMenuItem("Student");
		mntmStd.addActionListener(this);
		mnScreen.add(mntmStd);
		
		separator = new JSeparator();
		mnScreen.add(separator);
		
		mntmExit = new JMenuItem("Exit");
		mnScreen.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblImg = new JLabel("");
		contentPane.add(lblImg, BorderLayout.CENTER);
		
		mnScreen.addActionListener(this);
		mntmHide.addActionListener(this);
		mntmReShow.addActionListener(this);
		mntmExit.addActionListener(this);
		
		toolBar = new JToolBar();
		toolBar.setName("Kite Menu");
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnNew = new JButton("사원 정보 입력");
		btnNew.addActionListener(this);
		btnNew.setToolTipText("사원정보 대화상자");
		toolBar.add(btnNew);
		
		btnImg = new JButton("");
		btnImg.setIcon(new ImageIcon("D:\\workspace_java\\java_swing_study\\images\\open.jpg"));
		toolBar.add(btnImg);
		toolBar.addSeparator();
		
		btnModal = new JButton("모달 대화상자");
		btnModal.addActionListener(this);
		toolBar.add(btnModal);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnModal) {
			btnModelActionPerformed(e);
		}
		if (e.getSource() == btnNew) {
			btnNewActionPerformed(e);
		}
		if (e.getSource() == mntmStd) {
			mntmStdActionPerformed(e);
		}
		if (e.getSource() == mntmHide) {
			mntmHideActionPerformed(e);
		}
		if (e.getSource() == mntmExit) {
			mntmExitActionPerformed(e);
		}
		if (e.getSource() == mntmReShow) {
			mntmReShowActionPerformed(e);
		}
		if (e.getSource() == mntmLoad) {
			mntmLoadActionPerformed(e);
		}
	}
	private void btnModelActionPerformed(ActionEvent e) {
		DialogEx dialog = new DialogEx();
		dialog.setModal(true);
		dialog.setEmp(new Employee(1111,"박인선","사원",new Employee(4337),1500000,new Department(2),new Date(),false));
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		//다이얼로그 대화상자 닫히면 수행
		Employee emp = dialog.getInput();
		lblImg.setText(emp.toString());
	}

	protected void mntmLoadActionPerformed(ActionEvent e) {
		lblImg.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\images\\spiderman.jpg"));
	}
	protected void mntmReShowActionPerformed(ActionEvent e) {
		if(!lblImg.isVisible()) {
			lblImg.setVisible(true);
		}
	}
	protected void mntmExitActionPerformed(ActionEvent e) {
		System.exit(0);
	}
	protected void mntmHideActionPerformed(ActionEvent e) {
		if(lblImg.isVisible()) {
			lblImg.setVisible(false);
		}
	}
	protected void mntmStdActionPerformed(ActionEvent e) {
		StudentPanel sp = new StudentPanel();
		contentPane.add(sp,BorderLayout.SOUTH);
		revalidate();
		repaint();
	}
	protected void btnNewActionPerformed(ActionEvent e) {
		DialogEx dialog = new DialogEx();
		dialog.setParent(this);
		dialog.setEmp(new Employee(1111,"박인선","사원",new Employee(4337),1500000,new Department(2),new Date(),false));
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	public void setEmpText(Employee emp) {
		lblImg.setText(emp.toString());
	}
}
