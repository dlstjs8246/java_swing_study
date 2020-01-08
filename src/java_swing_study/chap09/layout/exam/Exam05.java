package java_swing_study.chap09.layout.exam;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam05 extends JFrame {

	private JPanel contentPane;
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn10;
	private JButton btn11;
	private JButton btn12;
	private JButton btn13;
	private JButton btn14;
	private JButton btn15;

	public Exam05() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 0, 0));
		
		btn0 = new JButton("0");
		btn0.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btn0);
		
		btn1 = new JButton("1");
		btn1.setBackground(Color.GRAY);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBackground(Color.DARK_GRAY);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBackground(Color.RED);
		contentPane.add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBackground(Color.PINK);
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBackground(Color.ORANGE);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBackground(Color.YELLOW);
		contentPane.add(btn6);
		
		btn7 = new JButton("7");
		btn7.setBackground(Color.GREEN);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBackground(Color.MAGENTA);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBackground(Color.CYAN);
		contentPane.add(btn9);
		
		btn10 = new JButton("10");
		btn10.setBackground(Color.BLUE);
		contentPane.add(btn10);
		
		btn11 = new JButton("11");
		btn11.setBackground(SystemColor.activeCaption);
		contentPane.add(btn11);
		
		btn12 = new JButton("12");
		btn12.setBackground(SystemColor.info);
		contentPane.add(btn12);
		
		btn13 = new JButton("13");
		btn13.setBackground(new Color(128, 0, 0));
		contentPane.add(btn13);
		
		btn14 = new JButton("14");
		btn14.setBackground(new Color(128, 128, 0));
		contentPane.add(btn14);
		
		btn15 = new JButton("15");
		btn15.setBackground(new Color(255, 99, 71));
		contentPane.add(btn15);
	}

}
