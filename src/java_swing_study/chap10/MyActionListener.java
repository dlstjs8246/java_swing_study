package java_swing_study.chap10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(btn.getText().equals("액션")) {
			btn.setText("Action");
		}
		else {
			btn.setText("액션");
		}

	}

}
