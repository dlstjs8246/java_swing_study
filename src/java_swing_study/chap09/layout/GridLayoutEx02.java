package java_swing_study.chap09.layout;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GridLayoutEx02 extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblDeptNo;
	private JLabel lblDeptName;
	private JLabel lblSubject;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public GridLayoutEx02() {
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
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblDeptNo = new JLabel("학번");
		lblDeptNo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDeptNo);
		
		textField_1 = new JTextField();
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
	}

}
