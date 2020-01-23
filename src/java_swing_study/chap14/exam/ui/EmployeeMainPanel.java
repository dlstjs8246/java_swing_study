package java_swing_study.chap14.exam.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java_swing_study.chap14.exam.dto.Department;
import java_swing_study.chap14.exam.dto.Employee;
import java_swing_study.chap14.exam.ui.panel.AbsTblPanel;
import java_swing_study.chap14.exam.ui.panel.EmployeePanel;
import java_swing_study.chap14.exam.ui.panel.EmployeeTblPanel;

@SuppressWarnings("serial")
public class EmployeeMainPanel extends AbsMainPanel<Employee> {
	private EmployeePanel empItemPanel;
	private EmployeeTblPanel empTblPanel;
	/**
	 * Create the panel.
	 */
	public EmployeeMainPanel() {

	}

	@Override
	protected JPanel getItemPanel() {
		empItemPanel = new EmployeePanel();
		return empItemPanel;
	}

	@Override
	protected AbsTblPanel<Employee> getTblPanel() {
		empTblPanel = new EmployeeTblPanel();
		initItemList();
		popMenu = new JPopupMenu();
		initPopMenu();
		
		empTblPanel.setPopupMenu(popMenu);
		addBtnListener();
		return empTblPanel;
	}

	@Override
	protected void initItemList() {
		itemList = new ArrayList<Employee>();
		itemList.add(new Employee(1001,"천일","인턴",new Employee(4337),1500000,new Department(1),new Date(),true));
		itemList.add(new Employee(1002,"천이","인턴",new Employee(4337),1500000,new Department(1),new Date(),true));
		empTblPanel.loadData(itemList);
		
	}

	@Override
	protected void addBtnListener() {
		btnAdd.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("수정")) {
					int selectedIdx = empTblPanel.getTable().getSelectedRow();
					if(selectedIdx==-1) {
						throw new RuntimeException("선택부터 해주세요");
					}
					try {
						empTblPanel.updateRow(empItemPanel.getItem(),empTblPanel.getTable().getSelectedRow());
						empItemPanel.tfClear();
						empTblPanel.clearSection();
						btnAdd.setText("추가");
					}
					catch(RuntimeException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
					
				}
				if(e.getActionCommand().equals("추가")) {
					itemList.add(empItemPanel.getItem());
					empTblPanel.loadData(itemList);
					empItemPanel.tfClear();
					empTblPanel.clearSection();
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				empItemPanel.tfClear();
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
					itemList.remove(empTblPanel.getSelectedRowIdx());
					empTblPanel.loadData(itemList);
				}
				else {
					empItemPanel.setItem(empTblPanel.getSelectedItem());
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
