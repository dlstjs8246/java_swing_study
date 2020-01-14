package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TextAreaEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lbl;
	private JTextField tf;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextAreaEx frame = new TextAreaEx();
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
	public TextAreaEx() {
		initialize();
	}
	private void initialize() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lbl = new JLabel("입력 후 <Enter>키를 입력하세요");
		lbl.setFont(new Font("굴림", Font.BOLD, 12));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl);
		
		tf = new JTextField(20);
		tf.addActionListener(this);
		contentPane.add(tf);
		
		ta = new JTextArea(7,20);
		contentPane.add(new JScrollPane(ta));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf) {
			tfActionPerformed(e);
		}
	}
	protected void tfActionPerformed(ActionEvent e) {
		JTextField t = (JTextField)e.getSource();
		ta.append(t.getText() + "\n");
		t.setText("");
	}
}
