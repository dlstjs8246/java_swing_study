package java_swing_study.chap13;

import javax.swing.JLabel;

public class TimerThread extends Thread {
	private JLabel timerLbl;

	public TimerThread(JLabel timerLbl) {
		this.timerLbl = timerLbl;
	}
	@Override
	public void run() {
		int n = 0;
		while(true) {
			timerLbl.setText(Integer.toString(n));
			n++;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				timerLbl.setText("중지");
				return;
			}
		}
	}
}
