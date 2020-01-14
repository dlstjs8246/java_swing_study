package java_swing_study.chap11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam extends JFrame implements ActionListener {

	private JPanel contentPane;
	private AbsItemPanel<Student> panelNorth;
	private JPanel panelBottom;
	private JPanel panel;
	private JButton btnAdd;
	private JButton btnClear;
	private JTextArea textArea;
	private ArrayList<Student> stdList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam frame = new Exam();
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
	public Exam() {
		initialize();
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
		
		panel = new JPanel();
		panelBottom.add(panel, BorderLayout.NORTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel.add(btnAdd);
		
		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		panel.add(btnClear);
		
		textArea = new JTextArea();
		panelBottom.add(new JScrollPane(textArea), BorderLayout.CENTER);
		
		stdList = new ArrayList<Student>();
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
		stdList.add(panelNorth.getItem());
		String str = "";
		for(Student s : stdList) {
			str += s.toString();
			textArea.setText(str);
		}
	}
	protected void btnClearActionPerformed(ActionEvent e) {
		panelNorth.tfClear();
	}
}
