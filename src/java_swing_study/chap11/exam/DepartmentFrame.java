package java_swing_study.chap11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DepartmentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private AbsItemPanel<Department> panelNorth;
	private JPanel panelBottom;
	private JPanel panelBtn;
	private JButton btnAdd;
	private JButton btnClear;
	private ArrayList<Department> deptList;
	private DepartmentTblPanel panelTbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentFrame frame = new DepartmentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DepartmentFrame() {
		initialize();
		initData();
	}
	private void initData() {
		deptList.add(new Department(1,"영업",8));
		deptList.add(new Department(2,"기획",10));
		deptList.add(new Department(3,"개발",9));
		deptList.add(new Department(4,"총무",7));
		panelTbl.loadData(deptList);
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelNorth = new DepartmentPanel();
		contentPane.add(panelNorth);
		
		panelBottom = new JPanel();
		contentPane.add(panelBottom);
		panelBottom.setLayout(new BorderLayout(0, 0));
		
		panelBtn = new JPanel();
		panelBottom.add(panelBtn, BorderLayout.NORTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panelBtn.add(btnAdd);
		
		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		panelBtn.add(btnClear);
		
		panelTbl = new DepartmentTblPanel();
		panelBottom.add(panelTbl, BorderLayout.CENTER);
		
		deptList = new ArrayList<>();
		ActionListener popListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("수정")) {
					try {
						panelNorth.setItem(panelTbl.getSelectedItem());
						btnAdd.setText("수정");
					}
					catch(RuntimeException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}
				else {
					try {
						panelTbl.model.removeRow(panelTbl.getSelectedRowIdx());
					}
					catch(RuntimeException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}
			}
		};
		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem updateItem = new JMenuItem("수정");
		popMenu.add(updateItem);
		updateItem.addActionListener(popListener);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		popMenu.add(deleteItem);
		panelTbl.setPopupMenu(popMenu);
		deleteItem.addActionListener(popListener);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			btnClearActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("수정")) {
			panelTbl.updateRow(panelNorth.getItem(), panelTbl.getSelectedRowIdx());
			btnAdd.setText("추가");
		}
		else {
			deptList.add(panelNorth.getItem());
			panelTbl.loadData(deptList);
		}
		
	}
	protected void btnClearActionPerformed(ActionEvent e) {
		panelNorth.tfClear();
	}
}
