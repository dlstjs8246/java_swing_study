package java_swing_study.chap14.exam.ui.panel;

import javax.swing.SwingConstants;

import java_swing_study.chap14.exam.dto.Student;

@SuppressWarnings("serial")
public class StudentTblPanel extends AbsTblPanel<Student> {
	/**
	 * Create the panel.
	 */
	public StudentTblPanel() {
	
	}

	@Override
	protected void setTblWidthAlign() {
		//TODO Auto-generated method stub
		tableSetWidth(50,150,50,50,50,70,70);
		tableCellAlign(SwingConstants.CENTER,0,1,2,3,4);
		tableCellAlign(SwingConstants.RIGHT,5,6);
	}

	@Override
	protected String[] getColumns() {
		// TODO Auto-generated method stub
		return new String[] {"번호","학생명","국어","수학","영어","총점","평균"};
	}

	@Override
	protected Object[] toArray(Student item) {
		// TODO Auto-generated method stub
		return new Object[] {String.format("%03d", item.getStdNo()),item.getStdName(),item.getKor(),item.getMath(),item.getEng(),item.total(),String.format("%.2f", item.avg())};
	}

	@Override
	public void updateRow(Student item, int updateIdx) {
		model.setValueAt(String.format("%03d", item.getStdNo()), updateIdx, 0);
		model.setValueAt(item.getStdName(), updateIdx, 1);
		model.setValueAt(item.getKor(), updateIdx, 2);
		model.setValueAt(item.getMath(), updateIdx, 3);
		model.setValueAt(item.getEng(), updateIdx, 4);
		model.setValueAt(item.total(), updateIdx, 5);
		model.setValueAt(String.format("%.2f", item.avg()), updateIdx, 6);
		
	}

	@Override
	public Student getSelectedItem() {
		int selectedIndex = getSelectedRowIdx();
		int stdNo = Integer.parseInt((String)(model.getValueAt(selectedIndex, 0)));
		String stdName = (String)(model.getValueAt(selectedIndex, 1));
		int kor =(int)(model.getValueAt(selectedIndex, 2));
		int eng = (int)(model.getValueAt(selectedIndex, 3));
		int math = (int)(model.getValueAt(selectedIndex, 4));
		return new Student(stdNo, stdName, kor, math, eng);
	}

}
