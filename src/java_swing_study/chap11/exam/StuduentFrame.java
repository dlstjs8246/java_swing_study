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
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StuduentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private AbsItemPanel<Student> panelNorth;
	private JPanel panelBottom;
	private JPanel panelBtn;
	private JButton btnAdd;
	private JButton btnClear;
	private ArrayList<Student> stdList;
	private StudentTblPanel panelTbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuduentFrame frame = new StuduentFrame();
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
	public StuduentFrame() {
		initialize();
		initData();
	}
	private void initData() {
		String[] names = {"이상원","박인선","이동주","황하나","유경진","권수진","정아름","황태원","장현서","현재승"};
		for(int i=0;i<names.length;i++) {
			stdList.add(new Student(i+1, names[i], (int)Math.floor(Math.random()*100), (int)Math.floor(Math.random()*100), (int)Math.floor(Math.random()*100)));
		}
		panelTbl.loadData(stdList);
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelNorth = new StudentPanel();
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
		
		panelTbl = new StudentTblPanel();
		panelBottom.add(panelTbl, BorderLayout.CENTER);
		
		stdList = new ArrayList<Student>();
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
			stdList.add(panelNorth.getItem());
			panelTbl.loadData(stdList);
		}
		
	}
	protected void btnClearActionPerformed(ActionEvent e) {
		panelNorth.tfClear();
	}
}
