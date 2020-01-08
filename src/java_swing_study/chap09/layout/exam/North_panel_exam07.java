package java_swing_study.chap09.layout.exam;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class North_panel_exam07 extends JPanel {
	private JLabel lblNorthName;
	private JTextField textFieldNorth;

	/**
	 * Create the panel.
	 */
	public North_panel_exam07() {

		initialize();
	}
	private void initialize() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNorthName = new JLabel("수식입력");
		lblNorthName.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNorthName.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblNorthName);
		
		textFieldNorth = new JTextField();
		add(textFieldNorth);
		textFieldNorth.setColumns(30);
	}

}
