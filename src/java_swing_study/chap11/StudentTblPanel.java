package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java_swing_study.chap11.exam.Student;

@SuppressWarnings("serial")
public class StudentTblPanel extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private ArrayList<Student> stdList;
	private NotEditableModel model;
	
	/**
	 * Create the panel.
	 */
	public StudentTblPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		stdList = new ArrayList<>();
		String[] names = new String[] {"박인선","이상원","유경진"};
		for(int i=0;i<names.length;i++) {
			stdList.add(new Student(i+1,names[i],(int)Math.ceil((Math.random()*100)),(int)Math.ceil((Math.random()*100)),(int)Math.ceil(Math.random()*100)));
		}
		loadData(stdList);
	}
	
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public NotEditableModel getModel() {
		return model;
	}
	public void setModel(NotEditableModel model) {
		this.model = model;
	}
	public ArrayList<Student> getStdList() {
		return stdList;
	}
	
	public void setStdList(ArrayList<Student> stdList) {
		this.stdList = stdList;
	}
	public void setPopupMenu(JPopupMenu popupMenu) {
		scrollPane.setComponentPopupMenu(popupMenu);
		table.setComponentPopupMenu(popupMenu);
	}
	public void loadData(ArrayList<Student> stdList) {
		model = new NotEditableModel(getRows(stdList),getColumns());
		table.setModel(model);
		
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
				
		setTblWidthAlign();
	}
	public TableCellRenderer getTableLanderer() {
		return new ReturnTableCellRenderer();
	}
	private void setTblWidthAlign() {
		tableSetWidth(50,150,50,50,50,70,70);
		tableCellAlign(SwingConstants.CENTER,0,1,2,3,4);
		tableCellAlign(SwingConstants.RIGHT,5,6);
	}
	private void tableCellAlign(int align, int...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0;i<idx.length;i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
		
	}
	private void tableSetWidth(int...width) { //가변인수 형태
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0;i<width.length;i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	private String[] getColumns() {
		return new String[] {"번호","학생명","국어","수학","영어","총점","평균"};
	}
	private Object[][] getRows(ArrayList<Student> stdList) {
		Object[][] rows = new Object[stdList.size()][];
		for(int i=0;i<rows.length;i++) {
			rows[i] = toArray(stdList.get(i));
		}
		return rows;
	}
	private Object[] toArray(Student student) {
		return new Object[] {String.format("%03d", student.getStdNo()),student.getStdName(),student.getKor(),student.getMath(),student.getEng(),student.total(),String.format("%.2f", student.avg())};
	}
	public void removeRow() {
		int selectedIdx = getSelectedRowIdx();
		model.removeRow(selectedIdx);
	}
	public void updateRow(Student std, int updateIdx) {
		model.setValueAt(String.format("%03d", std.getStdNo()), updateIdx, 0);
		model.setValueAt(std.getStdName(), updateIdx, 1);
		model.setValueAt(std.getKor(), updateIdx, 2);
		model.setValueAt(std.getMath(), updateIdx, 3);
		model.setValueAt(std.getEng(), updateIdx, 4);
		model.setValueAt(std.total(), updateIdx, 5);
		model.setValueAt(String.format("%.2f", std.avg()), updateIdx, 6);
	}
	public void addItem(Student std) {
		model.addRow(toArray(std));
	}
	
	public Student getSelectedItem() {
		int selectedIndex = getSelectedRowIdx();
		int stdNo = Integer.parseInt((String)(model.getValueAt(selectedIndex, 0)));
		String stdName = (String)(model.getValueAt(selectedIndex, 1));
		int kor =(int)(model.getValueAt(selectedIndex, 2));
		int eng = (int)(model.getValueAt(selectedIndex, 3));
		int math = (int)(model.getValueAt(selectedIndex, 4));
		return new Student(stdNo, stdName, kor, math, eng);
		
	}
	
	private int getSelectedRowIdx() {
		int selectedIdx = table.getSelectedRow();
		if(selectedIdx==-1) {
			throw new RuntimeException("삭제를 하기전에 선택부터 해주세요");
		}
		return selectedIdx;
	}
	
	private class NotEditableModel extends DefaultTableModel {

		public NotEditableModel(Object[][] rows, String[] columns) {
			super(rows,columns);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	}
	private class ReturnTableCellRenderer extends JLabel implements TableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (value==null) return this;
			setText(value.toString());
			setOpaque(true);
			setHorizontalAlignment(JLabel.CENTER);
			
			if (Integer.parseInt(table.getValueAt(row, 2).toString())>=90) {
				setBackground(Color.CYAN);
			}else if(Integer.parseInt(table.getValueAt(row, 2).toString())>=80) {
				setBackground(Color.LIGHT_GRAY);
			}
			else {
				setBackground(Color.WHITE);
			}
			if (isSelected) {
				setBackground(Color.orange);
			}
			return this;
		}
		
	}
}
