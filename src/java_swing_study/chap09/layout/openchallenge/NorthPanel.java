package java_swing_study.chap09.layout.openchallenge;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class NorthPanel extends JPanel {
	private JButton btnOpen;
	private JButton btnRead;
	private JButton btnClose;

	/**
	 * Create the panel.
	 */
	public NorthPanel() {

		initialize();
	}
	private void initialize() {
		setBackground(Color.GRAY);
		
		btnOpen = new JButton("Open");
		add(btnOpen);
		
		btnRead = new JButton("Read");
		add(btnRead);
		
		btnClose = new JButton("Close");
		add(btnClose);
	}

}
