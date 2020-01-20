package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;

import java_swing_study.chap11.exam.Student;

@SuppressWarnings("serial")
public class StudentTableEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pBtns;
	private JPanel pResult;
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
	private ArrayList<Student> stdList;
	private JButton btnCls;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTableEx frame = new StudentTableEx();
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
	public StudentTableEx() {
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
		
		pResult = new JPanel();
		contentPane.add(pResult, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		pResult.add(btnAdd);
		
		btnCls = new JButton("취소");
		pResult.add(btnCls);
		
		btnCls.addActionListener(this);
		btnAdd.addActionListener(myPopMenuLister);
		
		panel = new StudentTblPanel();
		panel.getTable().getColumnModel().addColumnModelListener(new TableColumnModelListener() {
			
			@Override
			public void columnSelectionChanged(ListSelectionEvent e) {
				int idx = panel.getTable().getSelectedColumn();
				getTableLanderer(panel.getTable().getSelectedColumn());
			}
			
			@Override
			public void columnRemoved(TableColumnModelEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void columnMoved(TableColumnModelEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void columnMarginChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void columnAdded(TableColumnModelEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel.setPopupMenu(createPopupMenu());
		contentPane.add(panel, BorderLayout.CENTER);
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
				stdList.add(getStudent());
				panel.loadData(stdList);
				clearTf();
			}
			else if(e.getActionCommand().equals("취소")) {
				clearTf();
			}
			else if(e.getActionCommand().equals("삭제")) {
				panel.removeRow();
				getTableLanderer(panel.getTable().getSelectedColumn());
			}
			else if(e.getActionCommand().equals("수정")) {
				Student std = panel.getSelectedItem();
				tfNo.setText(std.getStdNo() + " ");
				tfName.setText(std.getStdName());
				tfKor.setText(std.getKor() + " ");
				tfMath.setText(std.getMath()+ " ");
				tfEng.setText(std.getEng()+ " ");
				btnAdd.setText("확인");
			}
			else if(e.getActionCommand().equals("확인")) {
				panel.updateRow(getStudent(), getStudent().getStdNo()-1);
				clearTf();
				btnAdd.setText("추가");
			}
		}
	};
	private StudentTblPanel panel;
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
	private void getTableLanderer(int idx) {
		idx = panel.getTable().getSelectedColumn();
		if(idx!=-1) {
			panel.getTable().getColumnModel().getColumn(idx).setCellRenderer(panel.getTableLanderer());
		}
	}
}
