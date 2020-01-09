package java_swing_study.chap10;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyAction3Listener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn;
		if(e.getSource() instanceof JButton) {
			btn = (JButton) e.getSource();
			if(btn.getParent().getParent().getBackground()==Color.YELLOW) {
				btn.getParent().getParent().setBackground(Color.RED);
			}
			else {
				btn.getParent().getParent().setBackground(Color.YELLOW);
			}
		}
		
	}

}
