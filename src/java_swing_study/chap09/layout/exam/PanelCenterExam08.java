package java_swing_study.chap09.layout.exam;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelCenterExam08 extends JPanel {
	private JLabel[] label;
	public PanelCenterExam08() {
		label = new JLabel[10];
		initialize();
	}
	
	public JLabel[] getLabel() {
		return label;
	}

	private void initialize() {
		setBackground(new Color(255, 255, 255));	
		for(int i=0;i<getLabel().length;i++) {
			JLabel label = new JLabel("*");
			int x = (int)(Math.random()*150);
			int y = (int)(Math.random()*150);
			label.setBounds(x, y, 10, 10);
			label.setForeground(Color.RED);
			this.label[i] = label;
		}		
	}
}
