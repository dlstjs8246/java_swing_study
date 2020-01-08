package java_swing_study.chap09.layout.openchallenge;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {
	private JLabel lblHello;
	private JLabel lblJava;
	private JLabel lblLove;

	/**
	 * Create the panel.
	 */
	public CenterPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		lblHello = new JLabel("Hello");
		lblHello.setBounds(182, 58, 57, 15);
		add(lblHello);
		
		lblJava = new JLabel("Java");
		lblJava.setBounds(47, 217, 57, 15);
		add(lblJava);
		
		lblLove = new JLabel("Love");
		lblLove.setBounds(328, 201, 57, 15);
		add(lblLove);
	}

}
