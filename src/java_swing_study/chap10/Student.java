package java_swing_study.chap10;

public class Student {
	private String stdName;
	private int stdNo;
	private String stdDept;
	private String stdSubject;
	
	public Student(String stdName, int stdNo, String stdDept, String stdSubject) {
		this.stdName = stdName;
		this.stdNo = stdNo;
		this.stdDept = stdDept;
		this.stdSubject = stdSubject;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public int getStdNo() {
		return stdNo;
	}
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdDept() {
		return stdDept;
	}
	public void setStdDept(String stdDept) {
		this.stdDept = stdDept;
	}
	public String getStdSubject() {
		return stdSubject;
	}
	public void setStdSubject(String stdSubject) {
		this.stdSubject = stdSubject;
	}
	@Override
	public String toString() {
		return String.format("[이름=%s, 학번=%s, 학과=%s, 과목=%s]", stdName, stdNo, stdDept,
				stdSubject);
	}
	
}
