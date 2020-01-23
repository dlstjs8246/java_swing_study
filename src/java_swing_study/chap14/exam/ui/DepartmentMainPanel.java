package java_swing_study.chap14.exam.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java_swing_study.chap14.exam.dto.Department;
import java_swing_study.chap14.exam.ui.panel.AbsTblPanel;
import java_swing_study.chap14.exam.ui.panel.DepartmentPanel;
import java_swing_study.chap14.exam.ui.panel.DepartmentTblPanel;

@SuppressWarnings("serial")
public class DepartmentMainPanel extends AbsMainPanel<Department> {
	private DepartmentPanel deptItemPanel;
	private DepartmentTblPanel deptTblPanel;
	/**
	 * Create the panel.
	 */
	public DepartmentMainPanel() {
		initialize();
	}
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	@Override
	protected JPanel getItemPanel() {
		deptItemPanel = new DepartmentPanel();
		return deptItemPanel;
	}

	@Override
	protected AbsTblPanel<Department> getTblPanel() {
		deptTblPanel = new DepartmentTblPanel();
		initItemList();
		popMenu = new JPopupMenu();
		initPopMenu();
		
		deptTblPanel.setPopupMenu(popMenu);
		addBtnListener();
		return deptTblPanel;
	}

	@Override
	protected void initItemList() {
		itemList = new ArrayList<Department>();
		itemList.add(new Department(1,"영업",3));
		itemList.add(new Department(2,"회계",5));
		deptTblPanel.loadData(itemList);
	}

	@Override
	protected void addBtnListener() {
		btnAdd.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("수정")) {
					int selectedIdx = deptTblPanel.getTable().getSelectedRow();
					if(selectedIdx==-1) {
						throw new RuntimeException("선택부터 해주세요");
					}
					try {
						deptTblPanel.updateRow(deptItemPanel.getItem(),deptTblPanel.getTable().getSelectedRow());
						deptItemPanel.tfClear();
						deptTblPanel.clearSection();
						btnAdd.setText("추가");
					}
					catch(RuntimeException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
					
				}
				if(e.getActionCommand().equals("추가")) {
					itemList.add(deptItemPanel.getItem());
					deptTblPanel.loadData(itemList);
					deptItemPanel.tfClear();
					deptTblPanel.clearSection();
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deptItemPanel.tfClear();
			}
		});
	}

	@Override
	protected void initPopMenu() {
		JMenuItem updateItem = new JMenuItem("수정");
		JMenuItem deleteItem = new JMenuItem("삭제");
		ActionListener popListner = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("삭제")) {
					itemList.remove(deptTblPanel.getSelectedRowIdx());
					deptTblPanel.loadData(itemList);
				}
				else {
					deptItemPanel.setItem(deptTblPanel.getSelectedItem());
					btnAdd.setText("수정");
				}
			}
		};
		deleteItem.addActionListener(popListner);
		updateItem.addActionListener(popListner);
		popMenu.add(updateItem);
		popMenu.add(deleteItem);
		
	}

}
