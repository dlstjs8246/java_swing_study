package java_swing_study.chap11.exam;

import java.util.Date;

public class Employee {
	private int empNo;
	private String empName;
	private String title;
	private Employee manager;
	private int salary;
	private Department deptNo;
	private Date hireDate;
	private boolean gender;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empNo) {
		this.empNo = empNo;
	}
	public Employee(int empNo, String empName, String title, Employee manager, int salary, Department deptNo,
			Date hireDate, boolean gender) {
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.deptNo = deptNo;
		this.hireDate = hireDate;
		this.gender = gender;
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Department deptNo) {
		this.deptNo = deptNo;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	
	@Override
	public String toString() {
		return String.format(
				"Employee [empNo=%s, empName=%s, title=%s, manager=%s, salary=%s, deptNo=%s, hireDate=%s, gender=%s]",
				empNo, empName, title, manager, salary, deptNo, hireDate, gender);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empNo == other.empNo;
	}
	
}
