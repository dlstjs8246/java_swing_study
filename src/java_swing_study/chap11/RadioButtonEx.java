package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class RadioButtonEx extends JFrame implements ItemListener, ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JPanel panelNorth;
	private JPanel panelCenter;
	private JRadioButton rdbtnApple;
	private JRadioButton rdbtnCherry;
	private JRadioButton rdbtnPear;
	private JLabel lblImg;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private HashMap<String,ImageIcon> icons;
	private JButton btnApple;
	private JButton btnPear;
	private JButton btnCherry;
	private JButton btnConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioButtonEx frame = new RadioButtonEx();
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
	public RadioButtonEx() {
		icons = new HashMap<String, ImageIcon>();
		String path = System.getProperty("user.dir") + "\\images\\";
		icons.put("사과", new ImageIcon(path + "apple.jpg"));
		icons.put("배", new ImageIcon(path + "pear.jpg"));
		icons.put("체리", new ImageIcon(path + "cherry.jpg"));
		initialize();
	}
	private void initialize() {
		setTitle("라디오버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uB77C\uB514\uC624\uBC84\uD2BC \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 0));
		
		pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		panelNorth = new JPanel();
		pLeft.add(panelNorth, BorderLayout.NORTH);
		
		rdbtnApple = new JRadioButton("사과");
		buttonGroup.add(rdbtnApple);
		panelNorth.add(rdbtnApple);
		
		rdbtnPear = new JRadioButton("배");
		buttonGroup.add(rdbtnPear);
		panelNorth.add(rdbtnPear);
		
		rdbtnCherry = new JRadioButton("체리");
		rdbtnCherry.setHorizontalAlignment(SwingConstants.LEFT);
		buttonGroup.add(rdbtnCherry);
		panelNorth.add(rdbtnCherry);
		
		panelCenter = new JPanel();
		panelCenter.setBorder(new EmptyBorder(10, 10, 10, 10));
		pLeft.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		lblImg = new JLabel("");
		lblImg.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		panelCenter.add(lblImg, BorderLayout.CENTER);
		
		pRight = new JPanel();
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnApple = new JButton("사과 선택");
		btnApple.addActionListener(this);
		pRight.add(btnApple);
		
		btnPear = new JButton("배 선택");
		btnPear.addActionListener(this);
		pRight.add(btnPear);
		
		btnCherry = new JButton("체리 선택");
		btnCherry.addActionListener(this);
		pRight.add(btnCherry);
		
		btnConfirm = new JButton("선택한 과일 확인");
		btnConfirm.addActionListener(this);
		pRight.add(btnConfirm);
		
		rdbtnApple.addItemListener(this);
		rdbtnPear.addItemListener(this);
		rdbtnCherry.addItemListener(this);
		rdbtnApple.setSelected(true);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rdbtnCherry) {
			rdbtnCherryItemStateChanged(e);
		}
		if (e.getSource() == rdbtnPear) {
			rdbtnPearItemStateChanged(e);
		}
		if (e.getSource() == rdbtnApple) {
			rdbtnAppleItemStateChanged(e);
		}
	}
	protected void rdbtnAppleItemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			lblImg.setIcon(icons.get(((JRadioButton)e.getItem()).getText()));
		}
	}
	protected void rdbtnPearItemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			lblImg.setIcon(icons.get(((JRadioButton)e.getItem()).getText()));
		}
	}
	protected void rdbtnCherryItemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			lblImg.setIcon(icons.get(((JRadioButton)e.getItem()).getText()));
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPear) {
			btnPearActionPerformed(e);
		}
		if (e.getSource() == btnApple) {
			btnAppleActionPerformed(e);
		}
		if (e.getSource() == btnCherry) {
			btnCherryActionPerformed(e);
		}
		if (e.getSource() == btnConfirm) {
			btnConfirmActionPerformed(e);
		}
	}
	protected void btnConfirmActionPerformed(ActionEvent e) {
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		while(buttons.hasMoreElements()) {
			JRadioButton b = (JRadioButton) buttons.nextElement();
			if(b.isSelected()) {
				JOptionPane.showMessageDialog(null, "선택된 과일 : " + b.getText());
			}
		}
	}
	protected void btnCherryActionPerformed(ActionEvent e) {
		rdbtnCherry.setSelected(true);
	}
	protected void btnAppleActionPerformed(ActionEvent e) {
		rdbtnApple.setSelected(true);
	}
	protected void btnPearActionPerformed(ActionEvent e) {
		rdbtnPear.setSelected(true);
	}
}
