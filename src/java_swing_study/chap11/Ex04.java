package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyledEditorKit.BoldAction;

@SuppressWarnings("serial")
public class Ex04 extends JFrame implements ItemListener, ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JLabel lblTop;
	private JPanel panelCenter;
	private JLabel lblBottom;
	private JCheckBox chckbxApple;
	private JCheckBox chckbxPear;
	private JCheckBox chckbxCherry;
	private int sum;
	private JButton btnApple;
	private JButton btnPear;
	private JButton btnAllItem;
	private JButton btnChk;
	private JButton btnCherry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex04 frame = new Ex04();
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
	public Ex04() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC608\uC81C11-4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		lblTop = new JLabel("사과 100원,배 500원,체리 20000원");
		lblTop.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lblTop, BorderLayout.NORTH);
		
		panelCenter = new JPanel();
		pLeft.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		chckbxApple = new JCheckBox("사과");
		chckbxApple.addItemListener(this);
		chckbxApple.setBorderPainted(true);
		panelCenter.add(chckbxApple);
		
		chckbxPear = new JCheckBox("배");
		chckbxPear.addItemListener(this);
		chckbxPear.setBorderPainted(true);
		panelCenter.add(chckbxPear);
		
		chckbxCherry = new JCheckBox("체리");
		chckbxCherry.addItemListener(this);
		chckbxCherry.setBorderPainted(true);
		panelCenter.add(chckbxCherry);
		
		lblBottom = new JLabel("현재 0원 입니다.");
		lblBottom.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lblBottom, BorderLayout.SOUTH);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "selected&deselected", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnApple = new JButton("사과");
		btnApple.addActionListener(this);
		pRight.add(btnApple);
		
		btnPear = new JButton("배");
		btnPear.addActionListener(this);
		pRight.add(btnPear);
		
		btnAllItem = new JButton("모든 과일 선택");
		btnAllItem.addActionListener(this);
		
		btnCherry = new JButton("체리");
		btnCherry.addActionListener(this);
		pRight.add(btnCherry);
		pRight.add(btnAllItem);
		
		btnChk = new JButton("확인");
		btnChk.addActionListener(this);
		pRight.add(btnChk);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == chckbxCherry) {
			chckbxCherryItemStateChanged(e);
		}
		if (e.getSource() == chckbxPear) {
			chckbxPearItemStateChanged(e);
		}
		if (e.getSource() == chckbxApple) {
			chckbxAppleItemStateChanged(e);
		}
	}
	protected void chckbxAppleItemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			sum += 100;
		}
		else {
			sum -= 100;
		}
		lblBottom.setText("현재" + sum + "원입니다.");
	}
	protected void chckbxPearItemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			sum += 500;
		}
		else {
			sum -= 500;
		}
		lblBottom.setText("현재" + sum + "원입니다.");
	}
	protected void chckbxCherryItemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			sum += 20000;
		}
		else {
			sum -= 20000;
		}
		lblBottom.setText("현재" + sum + "원입니다.");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCherry) {
			btnCherryActionPerformed(e);
		}
		if (e.getSource() == btnChk) {
			btnChkActionPerformed(e);
		}
		if (e.getSource() == btnAllItem) {
			btnAllItemActionPerformed(e);
		}
		if (e.getSource() == btnPear) {
			btnPearActionPerformed(e);
		}
		if (e.getSource() == btnApple) {
			btnAppleActionPerformed(e);
		}
	}
	protected void btnAppleActionPerformed(ActionEvent e) {
		if(chckbxApple.isSelected()) {
			chckbxApple.setSelected(false);
			btnApple.setText("사과 선택");
			if(!(chckbxApple.isSelected() && chckbxPear.isSelected() && chckbxCherry.isSelected())) {
				btnAllItem.setText("모든 과일 선택");
			}
		}
		else {
			chckbxApple.setSelected(true);
			btnApple.setText("사과 취소");
			if(chckbxApple.isSelected() && chckbxPear.isSelected() && chckbxCherry.isSelected()) {
				btnAllItem.setText("모든 과일 취소");
			}
		}
	}
	protected void btnPearActionPerformed(ActionEvent e) {
		if(chckbxPear.isSelected()) {
			chckbxPear.setSelected(false);
			btnPear.setText("배 선택");
			if(!(chckbxApple.isSelected() && chckbxPear.isSelected() && chckbxCherry.isSelected())) {
				btnAllItem.setText("모든 과일 선택");
			}
		}
		else {
			chckbxPear.setSelected(true);
			btnPear.setText("배 취소");
			if(chckbxApple.isSelected() && chckbxPear.isSelected() && chckbxCherry.isSelected()) {
				btnAllItem.setText("모든 과일 취소");
			}
		}
	}
	
	protected void btnAllItemActionPerformed(ActionEvent e) {
		if(chckbxApple.isSelected() && chckbxPear.isSelected() && chckbxCherry.isSelected()) {
			chckbxApple.setSelected(false);
			chckbxPear.setSelected(false);
			chckbxCherry.setSelected(false);
			btnApple.setText("사과 선택");
			btnPear.setText("배 선택");
			btnCherry.setText("체리 선택");
			btnAllItem.setText("모든 과일 선택");
		}
		else {
			chckbxApple.setSelected(true);
			chckbxPear.setSelected(true);
			chckbxCherry.setSelected(true);
			btnApple.setText("사과 취소");
			btnPear.setText("배 취소");
			btnCherry.setText("체리 취소");
			btnAllItem.setText("모든 과일 취소");
		}
	}
	
	protected void btnChkActionPerformed(ActionEvent e) {
		String text = "선택한 과일은 ";
		if(chckbxApple.isSelected()) {
			text += chckbxApple.getText() + " ";
		}
		if(chckbxPear.isSelected()) {
			text += chckbxPear.getText() + " ";
		}
		if(chckbxCherry.isSelected()) {
			text += chckbxCherry.getText() + " ";
		}
		if(chckbxApple.isSelected()||chckbxPear.isSelected()||chckbxCherry.isSelected()) {
			JOptionPane.showMessageDialog(null, text);
		}
		else {
			JOptionPane.showMessageDialog(null, text + " 없습니다.");
		}
		
	}
	protected void btnCherryActionPerformed(ActionEvent e) {
		if(chckbxCherry.isSelected()) {
			chckbxCherry.setSelected(false);
			btnCherry.setText("체리 선택");
			if(!(chckbxApple.isSelected() && chckbxPear.isSelected() && chckbxCherry.isSelected())) {
				btnAllItem.setText("모든 과일 선택");
			}
		}
		else {
			chckbxCherry.setSelected(true);
			btnCherry.setText("체리 취소");
			if(chckbxApple.isSelected() && chckbxPear.isSelected() && chckbxCherry.isSelected()) {
				btnAllItem.setText("모든 과일 취소");
			}
		}
	}
}
