package java_swing_study.chap14.exam.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java_swing_study.chap14.exam.dto.Student;
import java_swing_study.chap14.exam.ui.panel.AbsTblPanel;
import java_swing_study.chap14.exam.ui.panel.StudentPanel;
import java_swing_study.chap14.exam.ui.panel.StudentTblPanel;

@SuppressWarnings("serial")
public class StudentMainPanel extends AbsMainPanel<Student> {
	private StudentPanel stdItemPanel;
	private StudentTblPanel stdTblPanel;
	
	public StudentMainPanel() {
		initialize();
	}
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	@Override
	protected AbsTblPanel<Student> getTblPanel() {
		stdTblPanel = new StudentTblPanel();
		initItemList();
		popMenu = new JPopupMenu();
		initPopMenu();
		
		stdTblPanel.setPopupMenu(popMenu);
		addBtnListener();
		return stdTblPanel;
	}
	protected void initPopMenu() {
		JMenuItem deleteItem = new JMenuItem("삭제");
		JMenuItem updateItem = new JMenuItem("수정");
		ActionListener popListner = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("삭제")) {
					itemList.remove(stdTblPanel.getSelectedRowIdx());
					stdTblPanel.loadData(itemList);
				}
				else {
					stdItemPanel.setItem(stdTblPanel.getSelectedItem());
					btnAdd.setText("수정");
				}
			}
		};
		deleteItem.addActionListener(popListner);
		updateItem.addActionListener(popListner);
		popMenu.add(updateItem);
		popMenu.add(deleteItem);
	}
	@Override
	protected JPanel getItemPanel() {
		stdItemPanel = new StudentPanel();
		return stdItemPanel;
	}
	@Override
	protected void addBtnListener() {
		btnAdd.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("수정")) {
					int selectedIdx = stdTblPanel.getTable().getSelectedRow();
					if(selectedIdx==-1) {
						throw new RuntimeException("선택부터 해주세요");
					}
					try {
						stdTblPanel.updateRow(stdItemPanel.getItem(),stdTblPanel.getTable().getSelectedRow());
						stdItemPanel.tfClear();
						stdTblPanel.clearSection();
						btnAdd.setText("추가");
					}
					catch(RuntimeException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
					
				}
				if(e.getActionCommand().equals("추가")) {
					itemList.add(stdItemPanel.getItem());
					stdTblPanel.loadData(itemList);
					stdItemPanel.tfClear();
					stdTblPanel.clearSection();
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stdItemPanel.tfClear();
			}
		});
	}
	@Override
	protected void initItemList() {
		itemList = new ArrayList<Student>();
		itemList.add(new Student(1,"박인선",100,100,100));
		itemList.add(new Student(2,"이상원",90,80,70));
		stdTblPanel.loadData(itemList);
	}
}
