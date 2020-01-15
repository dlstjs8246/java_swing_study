package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java_swing_study.chap11.exam.Student;

public class StudentListEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pBtns;
	private JPanel pList;
	private JPanel pResult;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblNo;
	private JTextField tfNo;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblKor;
	private JTextField tfKor;
	private JLabel lblMath;
	private JTextField tfMath;
	private JLabel lblEng;
	private JTextField tfEng;
	private JButton btnAdd;
	private Vector<Student> stdList;
	private JButton btnCls;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentListEx frame = new StudentListEx();
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
	public StudentListEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.NORTH);
		
		lblNo = new JLabel("번호");
		pBtns.add(lblNo);
		
		tfNo = new JTextField();
		pBtns.add(tfNo);
		tfNo.setColumns(10);
		
		lblName = new JLabel("성명");
		pBtns.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		pBtns.add(tfName);
		
		lblKor = new JLabel("국어");
		pBtns.add(lblKor);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		pBtns.add(tfKor);
		
		lblMath = new JLabel("수학");
		pBtns.add(lblMath);
		
		tfMath = new JTextField();
		tfMath.setColumns(10);
		pBtns.add(tfMath);
		
		lblEng = new JLabel("영어");
		pBtns.add(lblEng);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		pBtns.add(tfEng);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCls = new JButton("취소");
		btnCls.addActionListener(this);
		pBtns.add(btnCls);
		
		pList = new JPanel();
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pList.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		pResult = new JPanel();
		contentPane.add(pResult, BorderLayout.SOUTH);
		
		stdList = new Vector<Student>();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCls) {
			btnClsActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		setStudent(getStudent());
		list.setListData(stdList);
	}
	public Student getStudent() {
		int stdNo = Integer.parseInt(tfNo.getText().trim());
		String stdName = tfName.getText().trim();
		int kor = Integer.parseInt(tfKor.getText());
		int math = Integer.parseInt(tfEng.getText());
		int eng = Integer.parseInt(tfMath.getText());
		return new Student(stdNo, stdName, kor, math, eng);
		
	}
	public void setStudent(Student student) {
		stdList.add(getStudent());
	}
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");
		tfKor.setText("");
		tfMath.setText("");
		tfEng.setText("");
	}
	protected void btnClsActionPerformed(ActionEvent e) {
		clearTf();
	}
}
