package java_swing_study.chap11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class EmployeeFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelBottom;
	private JPanel panelBtn;
	private JButton btnAdd;
	private JButton btnClear;
	private ArrayList<Employee> empList;
	private EmployeeTblPanel panelTbl;
	private JPanel panelNorth;
	private JPanel pNorthImg;
	private EmployeePanel pNorthTable;
	private JPanel pAddImg;
	private JButton btnAddImg;
	private JPanel pImg;
	private JLabel lblImg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame();
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
	public EmployeeFrame() {
		initialize();
		initData();
	}
	private void initData() {
		empList.add(new Employee(1003,"조민희","과장",new Employee(4337),3000000,new Department(2),new Date(Long.parseLong("20100528")),false));
		empList.add(new Employee(1365,"김상원","사원",new Employee(3426),1500000,new Department(1),new Date(Long.parseLong("20190713")),true));
		empList.add(new Employee(2016,"김창섭","대리",new Employee(1003),2500000,new Department(2),new Date(Long.parseLong("20170409")),true));
		empList.add(new Employee(3011,"이수민","부장",new Employee(4337),4000000,new Department(3),new Date(Long.parseLong("20051117")),false));
		empList.add(new Employee(3426,"박영권","과장",new Employee(4337),3000000,new Department(1),new Date(Long.parseLong("20090821")),true));
		empList.add(new Employee(3427,"최종철","사원",new Employee(3011),1500000,new Department(3),new Date(Long.parseLong("20181224")),true));
		empList.add(new Employee(4337,"이성래","사장",new Employee(4337),5000000,new Department(2),new Date(Long.parseLong("20090821")),true));
		panelTbl.loadData(empList);
		for(Employee e : empList) {
			System.out.println(e);
		}
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelNorth = new JPanel();
		contentPane.add(panelNorth);
		panelNorth.setLayout(new BorderLayout(0, 0));
		
		pNorthImg = new JPanel();
		panelNorth.add(pNorthImg, BorderLayout.WEST);
		pNorthImg.setLayout(new BoxLayout(pNorthImg, BoxLayout.Y_AXIS));
		
		pImg = new JPanel();
		pNorthImg.add(pImg);
		
		lblImg = new JLabel();
		lblImg.setSize(100, 100);
		lblImg.setIcon(new ImageIcon(new ImageIcon("D:\\workspace_java\\java_swing_study\\images\\사진추가.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		pImg.add(lblImg);
		
		pAddImg = new JPanel();
		pNorthImg.add(pAddImg);
		
		btnAddImg = new JButton("사진 추가");
		btnAddImg.addActionListener(this);
		pAddImg.add(btnAddImg);
		
		pNorthTable = new EmployeePanel();
		panelNorth.add(pNorthTable, BorderLayout.CENTER);
		
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
		
		panelTbl = new EmployeeTblPanel();
		panelBottom.add(panelTbl, BorderLayout.CENTER);
		
		empList = new ArrayList<Employee>();
		
		ActionListener popListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("수정")) {
					try {
						pNorthTable.setItem(panelTbl.getSelectedItem());
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
		deleteItem.addActionListener(popListener);
		panelTbl.setPopupMenu(popMenu);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddImg) {
			btnAddImgActionPerformed(e);
		}
		if (e.getSource() == btnClear) {
			btnClearActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("수정")) {
			panelTbl.updateRow(pNorthTable.getItem(), panelTbl.getSelectedRowIdx());
			btnAdd.setText("추가");
			pNorthTable.tfClear();
		}
		else {
			empList.add(pNorthTable.getItem());
			panelTbl.loadData(empList);
			pNorthTable.tfClear();
			panelTbl.clearSection();
		}
		
	}
	protected void btnClearActionPerformed(ActionEvent e) {
		pNorthTable.tfClear();
	}
	protected void btnAddImgActionPerformed(ActionEvent e) {
		JFileChooser imgFile = new JFileChooser(System.getProperty("user.dir")+"\\images\\");
		int req = imgFile.showOpenDialog(this);
		if(req==JFileChooser.APPROVE_OPTION) {
			lblImg.setIcon(new ImageIcon(new ImageIcon(imgFile.getSelectedFile().getPath()).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		}
	}
}
