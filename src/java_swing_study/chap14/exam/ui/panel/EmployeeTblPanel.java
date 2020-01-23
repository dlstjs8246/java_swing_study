package java_swing_study.chap14.exam.ui.panel;

import java.util.Date;

import javax.swing.SwingConstants;

import java_swing_study.chap14.exam.dto.Department;
import java_swing_study.chap14.exam.dto.Employee;

@SuppressWarnings("serial")
public class EmployeeTblPanel extends AbsTblPanel<Employee> {

	/**
	 * Create the panel.
	 */
	public EmployeeTblPanel() {

	}

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(100, 100, 100, 100, 100, 100, 100, 100);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7);
	}

	@Override
	protected String[] getColumns() {
		return new String[] { "사원번호", "사원이름", "직급", "매니저", "급여", "부서번호", "입사일", "성별" };
	}

	@Override
	protected Object[] toArray(Employee item) {
		return new Object[] { item.getEmpNo(), item.getEmpName(), item.getTitle(), item.getManager().getEmpNo(), item.getSalary(),
				item.getDeptNo().getDeptNo(), item.getHireDate().getTime(), item.isGender()?"남":"여"};
	}

	@Override
	public void updateRow(Employee item, int updateIdx) {
		model.setValueAt(item.getEmpNo(), updateIdx, 0);
		model.setValueAt(item.getEmpName(), updateIdx, 1);
		model.setValueAt(item.getTitle(), updateIdx, 2);
		model.setValueAt(item.getManager().getEmpNo(), updateIdx, 3);
		model.setValueAt(item.getSalary(), updateIdx, 4);
		model.setValueAt(item.getDeptNo().getDeptNo(), updateIdx, 5);
		model.setValueAt(item.getHireDate(), updateIdx, 6);
		model.setValueAt(item.isGender()?"남":"여", updateIdx, 7);
	}

	@Override
	public Employee getSelectedItem() {
		int selectedIndex = getSelectedRowIdx();
		int empNo = (Integer)(model.getValueAt(selectedIndex, 0));
		String empName = (String) (model.getValueAt(selectedIndex, 1));
		String title = (String) (model.getValueAt(selectedIndex, 2));
		Employee manager = new Employee((int)model.getValueAt(selectedIndex, 3));
		int salary = (Integer)(model.getValueAt(selectedIndex, 4));
		Department deptNo = new Department((int)model.getValueAt(selectedIndex, 5));
		Date hireDate = new Date((long)model.getValueAt(selectedIndex, 6));
		boolean gender = model.getValueAt(selectedIndex, 7).equals("남")?true:false;
		return new Employee(empNo, empName, title, manager, salary, deptNo, hireDate, gender);
	}

}
