package java_swing_study.chap09.layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorderLayoutEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCenter;
	private JButton btnNorth;
	private JButton btnWest;
	private JButton btnEeast;
	private JButton btnSouth;

	public BorderLayoutEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(20, 30));
		setContentPane(contentPane);
		
		btnCenter = new JButton("calculate");
		btnCenter.addActionListener(this);
		contentPane.add(btnCenter, BorderLayout.CENTER);
		
		btnNorth = new JButton("add");
		contentPane.add(btnNorth, BorderLayout.NORTH);
		
		btnWest = new JButton("div");
		contentPane.add(btnWest, BorderLayout.WEST);
		
		btnEeast = new JButton("mul");
		contentPane.add(btnEeast, BorderLayout.EAST);
		
		btnSouth = new JButton("sub");
		contentPane.add(btnSouth, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCenter) {
			btnNewButtonActionPerformed(e);
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
	}
}
