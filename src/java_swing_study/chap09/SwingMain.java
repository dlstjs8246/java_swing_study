package java_swing_study.chap09;

import java.awt.EventQueue;

public class SwingMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContentPaneEx2 frame = new ContentPaneEx2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
