package java_swing_study.chap09.layout.exam;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

@SuppressWarnings("serial")
public class PanelSouthExam08 extends JPanel {
	private JButton btnWordInput;
	private JTextField textField;

	public PanelSouthExam08() {

		initialize();
	}
	private void initialize() {
		setBackground(new Color(255, 255, 0));
		
		btnWordInput = new JButton("Word Input");
		btnWordInput.setFont(new Font("굴림", Font.BOLD, 12));
		add(btnWordInput);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(25);
	}

}
