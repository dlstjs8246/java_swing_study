package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.DropMode;

@SuppressWarnings("serial")
public class JListEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ArrayList<String> listFruits;
	private JPanel p1;
	private JPanel p2;
	private JList strList;
	private JPanel p1North;
	private JButton btnOk1;
	private JButton btnSet1;
	private JPanel p2North;
	private JButton btnOk2;
	private JButton btnSet2;
	private JScrollPane scrollPane;
	private JList imgList;
	private Vector<ImageIcon> iconList;
	private Vector<String> addList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListEx frame = new JListEx();
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
	public JListEx() {
		loadListData();
		initialize();
	}

	private void loadListData() {
		listFruits = new ArrayList<String>();
		listFruits.add("apple");
		listFruits.add("banana");
		listFruits.add("kiwi");
		listFruits.add("mango");
		listFruits.add("pear");
		listFruits.add("peach");
		listFruits.add("berry");
		listFruits.add("strawberry");
		listFruits.add("blackberry");
		
		iconList = new Vector<ImageIcon>();
		String path = System.getProperty("user.dir") + "\\images\\";
		iconList.add(new ImageIcon(path + "icon1.png"));
		iconList.add(new ImageIcon(path + "icon2.png"));
		iconList.add(new ImageIcon(path + "icon3.png"));
		iconList.add(new ImageIcon(path + "icon4.png"));
		
		addList = new Vector<String>();
	}
	private void initialize() {
		setTitle("JList & JComboBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		p1 = new JPanel();
		p1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JList \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(p1);
		p1.setLayout(new BorderLayout(0, 0));
		
		strList = new JList<>(new Vector<String>(listFruits));
		p1.add(strList, BorderLayout.CENTER);
		
		p1North = new JPanel();
		p1.add(p1North, BorderLayout.NORTH);
		p1North.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnOk1 = new JButton("확인");
		btnOk1.addActionListener(this);
		p1North.add(btnOk1);
		
		btnSet1 = new JButton("선택하기");
		btnSet1.addActionListener(this);
		p1North.add(btnSet1);
		
		p2 = new JPanel();
		p2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JList\uC608\uC81C2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(p2);
		p2.setLayout(new BorderLayout(0, 0));
		
		p2North = new JPanel();
		p2.add(p2North, BorderLayout.NORTH);
		p2North.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnOk2 = new JButton("확인");
		btnOk2.addActionListener(this);
		p2North.add(btnOk2);
		
		btnSet2 = new JButton("선택하기");
		btnSet2.addActionListener(this);
		p2North.add(btnSet2);
		
		scrollPane = new JScrollPane();
		p2.add(scrollPane, BorderLayout.CENTER);
		imgList = new JList<>(iconList);
		scrollPane.setViewportView(imgList);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk2) {
			btnOk2ActionPerformed(e);
		}
		if (e.getSource() == btnSet2) {
			btnSet2ActionPerformed(e);
		}
		if (e.getSource() == btnSet1) {
			btnSet1ActionPerformed(e);
		}
		if (e.getSource() == btnOk1) {
			btnOk1ActionPerformed(e);
		}
	}
	protected void btnOk1ActionPerformed(ActionEvent e) {
		String str = "";
		for(Object o : strList.getSelectedValuesList()) {
			String s = (String)o;
			str += s + " ";
		}
		JOptionPane.showMessageDialog(null, "선택한 과일은? " + str);
	}
	protected void btnSet1ActionPerformed(ActionEvent e) {
		String str = JOptionPane.showInputDialog("선택하고 싶은 과일을 입력하세요");
		strList.setSelectedValue(str.trim(),true);
	}
	protected void btnSet2ActionPerformed(ActionEvent e) {
		String str = JOptionPane.showInputDialog("선택하고 싶은 이미지 인덱스 번호를 입력하세요");
		imgList.setSelectedIndex(Integer.parseInt(str.trim()));
	}
	protected void btnOk2ActionPerformed(ActionEvent e) {
		String str = "";
		for(Object o : imgList.getSelectedValuesList()) {
			ImageIcon icon = (ImageIcon)o;
			int idx = icon.getDescription().lastIndexOf("\\");
			str += icon.getDescription().substring(idx+1, icon.getDescription().length()) + " ";
		}
		JOptionPane.showMessageDialog(null, str);
		
	}
}
