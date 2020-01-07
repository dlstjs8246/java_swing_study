package java_swing_study.chap09;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContentPaneEx2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnOK;
	private JButton btnCancel;
	private JButton btnIgnore;

	public ContentPaneEx2() {
		initialize();
	}
	private void initialize() {
		setTitle("Contentpane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 85);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		contentPane.add(btnOK);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
		
		btnIgnore = new JButton("Ignore");
		btnIgnore.addActionListener(this);
		contentPane.add(btnIgnore);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIgnore) {
			btnIgnoreActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnOK) {
			btnOKActionPerformed(e);
		}
	}
	protected void btnOKActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
	protected void btnIgnoreActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
}
