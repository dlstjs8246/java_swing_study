package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java_swing_study.chap11.exam.Student;

@SuppressWarnings("serial")
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
		
		pList = new JPanel();
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pList.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		pResult = new JPanel();
		contentPane.add(pResult, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		pResult.add(btnAdd);
		
		btnCls = new JButton("취소");
		pResult.add(btnCls);
		
		btnCls.addActionListener(this);
		btnAdd.addActionListener(myPopMenuLister);
		
		stdList = new Vector<Student>();
		
		list.setComponentPopupMenu(createPopupMenu());
	}
	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenuLister);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopMenuLister);
		popMenu.add(deleteItem);
		
		return popMenu;
	}
	ActionListener myPopMenuLister = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("추가")) {
				int idx = list.getSelectedIndex();
				Student chkStd = getStudent();
				if(!(stdList.isEmpty()) && stdList.get(idx).equals(chkStd)) {
					stdList.set(idx, chkStd);
					list.setListData(stdList);
				}
				else {
					stdList.add(getStudent());
					list.setListData(stdList);
					clearTf();
				}
			}
			else if(e.getActionCommand().equals("수정")) {
				int idx = list.getSelectedIndex();
				if(idx==-1) {
					JOptionPane.showMessageDialog(null, "선택된 항목이 없습니다");
					return;
				}
				tfNo.setText(stdList.get(idx).getStdNo() + "");
				tfName.setText(stdList.get(idx).getStdName());
				tfKor.setText(stdList.get(idx).getKor() + "");
				tfMath.setText(stdList.get(idx).getMath() + "");
				tfEng.setText(stdList.get(idx).getEng() + "");			
			}
			else {
				int idx = list.getSelectedIndex();
				if(idx==-1) {
					JOptionPane.showMessageDialog(null, "선택된 항목이 없습니다");
					return;
				}
				int confirm = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?");
				if(confirm==0) {
					stdList.remove(idx);
					list.setListData(stdList);
				}
			}
		}
	};
	private JButton btnUpdate;
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCls) {
			btnClsActionPerformed(e);
		}
	}
	public Student getStudent() {
		int stdNo = Integer.parseInt(tfNo.getText().trim());
		String stdName = tfName.getText().trim();
		int kor = Integer.parseInt(tfKor.getText());
		int math = Integer.parseInt(tfMath.getText());
		int eng = Integer.parseInt(tfEng.getText());
		return new Student(stdNo, stdName, kor, math, eng);
		
	}
	public void setStudent() {
		Student student = getStudent();
		stdList.set(student.getStdNo()-1, student);
		list.setListData(stdList);
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
