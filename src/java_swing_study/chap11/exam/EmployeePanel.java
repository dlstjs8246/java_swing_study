package java_swing_study.chap11.exam;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class EmployeePanel extends AbsItemPanel<Employee> {
	private JLabel lblEmpNo;
	private JTextField tfEmpNo;
	private JLabel lblEmpName;
	private JTextField tfEmpName;
	private JLabel lblTitle;
	private JLabel lblManager;
	private JTextField tfManager;
	private JLabel lblSalary;
	private JTextField tfSalary;
	private JLabel lblDno;
	private JTextField tfDno;
	private JLabel lblHireDate;
	private JLabel lblGender;
	private JSpinner sTitle;
	private JSpinner sHireDate;
	private JSpinner sGender;
	private JSpinner.DateEditor editor;

	/**
	 * Create the panel.
	 */
	public EmployeePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 10, 10));
		
		lblEmpNo = new JLabel("사원번호");
		lblEmpNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblEmpNo);
		
		tfEmpNo = new JTextField();
		tfEmpNo.setColumns(10);
		add(tfEmpNo);
		
		lblEmpName = new JLabel("사원이름");
		lblEmpName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblEmpName);
		
		tfEmpName = new JTextField();
		tfEmpName.setColumns(10);
		add(tfEmpName);
		
		lblTitle = new JLabel("직급");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitle);
		
		sTitle = new JSpinner();
		sTitle.setModel(new SpinnerListModel(new String[] {"\uC0AC\uC6D0", "\uB300\uB9AC", "\uACFC\uC7A5", "\uCC28\uC7A5", "\uBD80\uC7A5", "\uC0AC\uC7A5"}));
		add(sTitle);
		
		lblManager = new JLabel("매니저");
		lblManager.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblManager);
		
		tfManager = new JTextField();
		tfManager.setColumns(10);
		add(tfManager);
		
		lblSalary = new JLabel("급여");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSalary);
		
		tfSalary = new JTextField();
		tfSalary.setColumns(10);
		add(tfSalary);
		
		lblDno = new JLabel("부서번호");
		lblDno.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDno);
		
		tfDno = new JTextField();
		tfDno.setColumns(10);
		add(tfDno);
		
		lblHireDate = new JLabel("입사일");
		lblHireDate.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblHireDate);
		
		sHireDate = new JSpinner();
		sHireDate.setModel(initDateModel(new Date()));
		editor = new DateEditor(sHireDate, "yyyy/MM/dd");
		sHireDate.setEditor(editor);
		add(sHireDate);
		
		lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblGender);
		
		sGender = new JSpinner();
		sGender.setModel(new SpinnerListModel(new String[] {"\uB0A8", "\uC5EC"}));
		add(sGender);
	}

	private SpinnerModel initDateModel(Date date) {
		return new SpinnerDateModel(date, null, null, Calendar.DATE);
	}
	@Override
	public Employee getItem() {
		int empNo = Integer.parseInt(tfEmpNo.getText().trim());
		String empName = tfEmpName.getText().trim();
		String title = (String) sTitle.getValue();
		Employee manager = new Employee(Integer.parseInt(tfManager.getText().trim()));
		int salary = Integer.parseInt(tfSalary.getText().trim());
		Department deptNo = new Department(Integer.parseInt(tfDno.getText().trim()));
		Date hireDate = (Date)sHireDate.getValue();
		boolean gender = sGender.getValue().equals("남")?true:false;
		return new Employee(empNo, empName, title, manager, salary, deptNo, hireDate, gender);
	}

	@Override
	public void setItem(Employee item) {
		tfEmpNo.setText(item.getEmpNo()+ " ");
		tfEmpName.setText(item.getEmpName());
		sTitle.setValue(item.getTitle());
		tfManager.setText(item.getManager().getEmpNo() + " ");
		tfSalary.setText(item.getSalary() + " ");
		tfDno.setText(item.getDeptNo().getDeptNo() + " ");
		sHireDate.setValue(item.getHireDate());
		sGender.setValue(item.isGender()?"남":"여");
	}

	@Override
	public void tfClear() {
		tfEmpNo.setText("");
		tfEmpName.setText("");
		tfManager.setText("");
		tfSalary.setText("");
		tfDno.setText("");
	}

}
