package java_swing_study.chap09.layout;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class LayoutMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnFlowLayout;
	private JButton btnBorderLayout;
	private JButton btnGridLayoutEx;
	private JButton btnGridLayout2;
	private JButton btnAbsoluteLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutMain frame = new LayoutMain();
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
	public LayoutMain() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("배치레이아웃");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "레이아웃 예제", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnFlowLayout = new JButton("flowLayout");
		btnFlowLayout.addActionListener(this);
		contentPane.add(btnFlowLayout);
		
		btnBorderLayout = new JButton("BorderLayout");
		btnBorderLayout.addActionListener(this);
		contentPane.add(btnBorderLayout);
		
		btnGridLayoutEx = new JButton("GridLayoutEx");
		btnGridLayoutEx.addActionListener(this);
		contentPane.add(btnGridLayoutEx);
		
		btnGridLayout2 = new JButton("GridLayout2");
		btnGridLayout2.addActionListener(this);
		contentPane.add(btnGridLayout2);
		
		btnAbsoluteLayout = new JButton("absoluteLayout");
		btnAbsoluteLayout.addActionListener(this);
		contentPane.add(btnAbsoluteLayout);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAbsoluteLayout) {
			btnAbsoluteLayoutActionPerformed(e);
		}
		if (e.getSource() == btnGridLayout2) {
			btnGridLayout2ActionPerformed(e);
		}
		if (e.getSource() == btnGridLayoutEx) {
			btnGridLayoutActionPerformed(e);
		}
		if (e.getSource() == btnBorderLayout) {
			btnBorderLayoutActionPerformed(e);
		}
		if (e.getSource() == btnFlowLayout) {
			btnFlowLayoutActionPerformed(e);
		}
	}
	protected void btnFlowLayoutActionPerformed(ActionEvent e) {
		FlowLayoutEx frame = new FlowLayoutEx();
		frame.setVisible(true);
	}
	protected void btnBorderLayoutActionPerformed(ActionEvent e) {
		BorderLayoutEx frame = new BorderLayoutEx();
		frame.setVisible(true);
	}
	protected void btnGridLayoutActionPerformed(ActionEvent e) {
		GridLayoutEx frame = new GridLayoutEx();
		frame.setVisible(true);
	}
	protected void btnGridLayout2ActionPerformed(ActionEvent e) {
		GridLayoutEx02 frame = new GridLayoutEx02();
		frame.setVisible(true);
	}
	protected void btnAbsoluteLayoutActionPerformed(ActionEvent e) {
		AbsoluteLayoutEx frame = new AbsoluteLayoutEx();
		frame.setVisible(true);
	}
}
