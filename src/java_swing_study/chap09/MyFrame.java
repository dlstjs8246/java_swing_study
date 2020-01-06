package java_swing_study.chap09;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() throws HeadlessException {
		setTitle("300X300 스윙 프레임 만들기");
		setSize(300, 300);
		setVisible(true);
	}
	
}
