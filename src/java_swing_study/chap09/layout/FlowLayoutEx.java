package java_swing_study.chap09.layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class FlowLayoutEx extends JFrame {

	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;
	private JButton btnCalculate;

	public FlowLayoutEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("FlowLayoutEx");
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		
		btnAdd = new JButton("add");
		contentPane.add(btnAdd);
		
		btnSub = new JButton("sub");
		contentPane.add(btnSub);
		
		btnMul = new JButton("mul");
		contentPane.add(btnMul);
		
		btnDiv = new JButton("div");
		contentPane.add(btnDiv);
		
		btnCalculate = new JButton("calculate");
		contentPane.add(btnCalculate);
	}

}
