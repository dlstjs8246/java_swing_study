package java_swing_study.chap11;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java_swing_study.chap11.exam.Student;

import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class ComboBoxEx extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JComboBox<String> cmbFruit;
	private DefaultComboBoxModel<String> fruitModel;
	private JTextField tfFruit;
	private JLabel lblFruit;
	private JButton btnConfirm;
	private JComboBox<Student> cmbStudent;
	private JLabel lblStudent;
	private JButton btnStdConfirm;
	private JPanel panel;
	private JLabel lblStdNo;
	private JTextField tfStdNo;
	private JButton btnStdSearch;
	private DefaultComboBoxModel<Student> stdModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBoxEx frame = new ComboBoxEx();
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
	public ComboBoxEx() {
		initialize();
	}
	private void initialize() {
		setTitle("콤보박스 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "\uC608\uC81C11-12", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		cmbFruit = new JComboBox<>();
		cmbFruit.addItemListener(this);
		cmbFruit.setMaximumRowCount(5);
		pLeft.add(cmbFruit);
		
		tfFruit = new JTextField();
		tfFruit.addActionListener(this);
		pLeft.add(tfFruit);
		tfFruit.setColumns(10);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "\uC608\uC81C11-13", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		cmbStudent = new JComboBox<>();
		cmbStudent.addItemListener(this);
		pRight.add(cmbStudent);
		
		lblStudent = new JLabel("학생정보");
		lblStudent.setForeground(Color.RED);
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		pRight.add(lblStudent);
		
		btnStdConfirm = new JButton("학생 확인");
		btnStdConfirm.addActionListener(this);
		pRight.add(btnStdConfirm);
		
		panel = new JPanel();
		pRight.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		lblStdNo = new JLabel("번호");
		lblStdNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblStdNo);
		
		tfStdNo = new JTextField();
		panel.add(tfStdNo);
		tfStdNo.setColumns(10);
		
		btnStdSearch = new JButton("검색");
		btnStdSearch.addActionListener(this);
		panel.add(btnStdSearch);
		
		cmbFruit.setModel(fruitGetModel());
		cmbFruit.setSelectedIndex(-1);
		
		lblFruit = new JLabel("과일");
		lblFruit.setHorizontalAlignment(SwingConstants.CENTER);
		lblFruit.setForeground(Color.RED);
		lblFruit.setFont(new Font("굴림", Font.PLAIN, 12));
		pLeft.add(lblFruit);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		pLeft.add(btnConfirm);
		
		cmbStudent.setModel(stdGetModel());
		cmbStudent.setSelectedIndex(-1);
	}

	private ComboBoxModel<String> fruitGetModel() {
		fruitModel = new DefaultComboBoxModel<String>();
		String[] fruits = {"Apple", "Banana", "Kiwi", "Mango", "Pear", "Peach", "Berry", "Strawberry", "Blackberry"};
		for(String s : fruits) {
			fruitModel.addElement(s);
		}
		return fruitModel;
	}
	private ComboBoxModel<Student> stdGetModel() {
		stdModel = new DefaultComboBoxModel<Student>();
		ArrayList<Student> student = new ArrayList<Student>();
		String[] names = {"박인선","이상원","유경진","황하나","이동주","권수진","정아름","장현서","황태원","현재승"};
		for(int i=0;i<names.length;i++) {
			student.add(new Student(i+1,names[i],(int)Math.ceil((Math.random()*100)),(int)Math.ceil((Math.random()*100)),(int)Math.ceil((Math.random()*100))));
		}
		for(Student s : student) {
			stdModel.addElement(s);
		}
		return stdModel;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStdSearch) {
			btnStdSearchActionPerformed(e);
		}
		if (e.getSource() == btnStdConfirm) {
			btnStdConfirmActionPerformed(e);
		}
		if (e.getSource() == btnConfirm) {
			btnConfirmActionPerformed(e);
		}
		if (e.getSource() == tfFruit) {
			tfActionPerformed(e);
		}
	}
	protected void tfActionPerformed(ActionEvent e) {
		fruitModel.addElement(tfFruit.getText().trim());
		tfFruit.setText(" ");
	}
	protected void btnConfirmActionPerformed(ActionEvent e) {
		String msg = "선택된 과일은 " + (String)fruitModel.getSelectedItem();
		JOptionPane.showMessageDialog(null, msg);
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbStudent) {
			cmbStudentItemStateChanged(e);
		}
		if (e.getSource() == cmbFruit) {
			cmbFruitItemStateChanged(e);
		}
	}
	protected void cmbFruitItemStateChanged(ItemEvent e) {
		if(fruitModel.getSelectedItem()!=null) {
			lblFruit.setText((String)fruitModel.getSelectedItem());
		}
	}
	protected void btnStdConfirmActionPerformed(ActionEvent e) {
		String msg = "선택된 학생은 " + stdModel.getSelectedItem().toString();
		JOptionPane.showMessageDialog(null, msg);
	}
	protected void btnStdSearchActionPerformed(ActionEvent e) {
		Student std = searchStd();
		int idx = stdModel.getIndexOf(std);
		if(idx==-1) {
			JOptionPane.showMessageDialog(null, "없는 학생 번호입니다.");
			return;
		}
		lblStudent.setText(stdModel.getElementAt(idx).toString());
	}
	private Student searchStd() {
		int stdNo = Integer.parseInt(tfStdNo.getText());
		return new Student(stdNo);
	}

	protected void cmbStudentItemStateChanged(ItemEvent e) {
		if(stdModel.getSelectedItem()!=null) {
			Student student = (Student)stdModel.getSelectedItem();
			lblStudent.setText(student.getStdNo() + " " + student.getStdName() + " " + student.getKor() + " " + student.getMath() + " " + student.getMath() + " " + student.total() + " " + String.format("%.2f", student.avg()));
		}
	}
}
