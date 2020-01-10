package java_swing_study.chap09.layout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java_swing_study.chap10.Student;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class GridLayoutEx02 extends JFrame {
	private Student std;
	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblDeptNo;
	private JLabel lblDeptName;
	private JLabel lblSubject;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel labelRes;
	private JTextField textField_4;
	private JPasswordField pw1;
	private JLabel lblConfirm;
	private JPasswordField pw2;
	private JButton btnOK;
	private JButton btnCancel;
	private JPanel panel;
	private JButton btnSet;
	

	public JTextField getTextField_3() {
		return textField_3;
	}
	public GridLayoutEx02() {
		std = new Student();
		initialize();
	}
	private void initialize() {
		setTitle("GridLayoutEx02");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 5));
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblName);
		
		textField = new JTextField();
		//잘 기억 해놨다가 활용(일치,불일치 확인하는 용도로 주로 사용)
		textField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				msg();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				msg();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				msg();
			}
			
			public void msg() {
				textField_4.setText(String.format("%s 길이 : %d",textField.getText(), textField.getText().length()));
			}
		});
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblDeptNo = new JLabel("학번");
		lblDeptNo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDeptNo);
		
		textField_1 = new JTextField();
		textField_1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_1.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "학과를 입력하세요");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				
				
			}
		});
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		lblDeptName = new JLabel("학과");
		lblDeptName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDeptName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		lblSubject = new JLabel("과목");
		lblSubject.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblSubject);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		labelRes = new JLabel("이름글자수");
		labelRes.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(labelRes);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		pw1 = new JPasswordField();
		pw1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				isEqualPw();	
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				isEqualPw();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				isEqualPw();
			}
			public void isEqualPw() {
				String pass1 = new String(pw1.getPassword());
				String pass2 = new String(pw2.getPassword());
				if(pass1.equals(pass2)) {
					lblConfirm.setText("일치");
				}
				else {
					lblConfirm.setText("불일치");
				}
			}
		});
		contentPane.add(pw1);
		
		pw2 = new JPasswordField();
		pw2.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				isEqualPw();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				isEqualPw();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				isEqualPw();
			}
			public void isEqualPw() {
				String pass1 = new String(pw1.getPassword());
				String pass2 = new String(pw2.getPassword());
				System.out.printf("pw1 :  %s pw2 : %s%n",pass1,pass2);
				if(pass1.equals(pass2)) {
					lblConfirm.setText("일치");
				}
				else {
					lblConfirm.setText("불일치");
				}
			}
		});
		contentPane.add(pw2);
		
		lblConfirm = new JLabel("");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("굴림", Font.BOLD, 20));
		lblConfirm.setForeground(Color.RED);
		contentPane.add(lblConfirm);
		
		panel = new JPanel();
		contentPane.add(panel);
		
		btnOK = new JButton("확인");
		
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student student = new Student(textField.getText().trim(),
						Integer.parseInt(textField_1.getText().trim()),
						textField_2.getText().trim(),
						textField_3.getText().trim());
				std = student;
				JOptionPane.showMessageDialog(null,std.toString());
			}
		});
		contentPane.add(btnOK);
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		contentPane.add(btnCancel);
		
		btnSet = new JButton("데이터 입력");
		btnSet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(std.getStdName());
				textField_1.setText(Integer.toString(std.getStdNo()));
				textField_2.setText(std.getStdDept());
				textField_3.setText(std.getStdSubject());
			}
		});
		contentPane.add(btnSet);
	}

}
