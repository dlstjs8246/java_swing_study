package java_swing_study.chap09.layout.exam;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class South_Panel_Exam07 extends JPanel {
	private JLabel lblLabel;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public South_Panel_Exam07() {

		initialize();
	}
	private void initialize() {
		setBackground(new Color(173, 255, 47));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblLabel = new JLabel("계산 결과");
		lblLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblLabel);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(30);
	}

}
