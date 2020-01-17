package java_swing_study.chap11.trainingExam;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<String> comboBox;

	public Exam02() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		textField.addActionListener(this);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox<>();
		contentPane.add(comboBox);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == textField) {
			textFieldActionPerformed(e);
		}
	}
	protected void textFieldActionPerformed(ActionEvent e) {
		comboBox.addItem(textField.getText().trim());
	}
}
