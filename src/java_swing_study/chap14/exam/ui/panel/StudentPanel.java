package java_swing_study.chap14.exam.ui.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java_swing_study.chap14.exam.dto.Student;

@SuppressWarnings("serial")
public class StudentPanel extends AbsItemPanel<Student> {
	private JLabel lblStdNo;
	private JTextField tfStdNo;
	private JLabel lblStdName;
	private JTextField tfStdName;
	private JLabel lblKor;
	private JTextField tfKor;
	private JLabel lblMath;
	private JTextField tfMath;
	private JLabel lblEng;
	private JTextField tfEng;

	public StudentPanel() {
		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uD559\uC0DD \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		lblStdNo = new JLabel("학생번호");
		lblStdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStdNo);
		
		tfStdNo = new JTextField();
		add(tfStdNo);
		tfStdNo.setColumns(10);
		
		lblStdName = new JLabel("학생이름");
		lblStdName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStdName);
		
		tfStdName = new JTextField();
		tfStdName.setColumns(10);
		add(tfStdName);
		
		lblKor = new JLabel("국어");
		lblKor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblKor);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		add(tfKor);
		
		lblMath = new JLabel("수학");
		lblMath.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblMath);
		
		tfMath = new JTextField();
		tfMath.setColumns(10);
		add(tfMath);
		
		lblEng = new JLabel("영어");
		lblEng.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblEng);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		add(tfEng);	
	}
	@Override
	public void tfClear() {
		tfStdNo.setText("");
		tfStdName.setText("");
		tfKor.setText("");
		tfMath.setText("");
		tfEng.setText("");
	}
	@Override
	public Student getItem() {
		int stdNo = Integer.parseInt((tfStdNo.getText().trim()));
		String stdName = tfStdName.getText().trim();
		int kor = Integer.parseInt(tfKor.getText().trim());
		int math = Integer.parseInt(tfMath.getText().trim());
		int eng = Integer.parseInt(tfEng.getText().trim());
		return new Student(stdNo, stdName, kor, math, eng);
	}
	@Override
	public void setItem(Student std) {
		tfStdNo.setText(Integer.toString(std.getStdNo()));
		tfStdName.setText(std.getStdName());
		tfKor.setText(Integer.toString(std.getKor()));
		tfMath.setText(Integer.toString(std.getMath()));
		tfEng.setText(Integer.toString(std.getEng()));
	}
}
