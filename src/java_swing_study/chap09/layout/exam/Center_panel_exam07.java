package java_swing_study.chap09.layout.exam;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class Center_panel_exam07 extends JPanel {
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
	private JButton btnCE;
	private JButton btnCal;
	private JButton btnAdd;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;

	/**
	 * Create the panel.
	 */
	public Center_panel_exam07() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 4, 5, 5));
		
		btn0 = new JButton("0");
		add(btn0);
		
		btn1 = new JButton("1");
		add(btn1);
		
		btn2 = new JButton("2");
		add(btn2);
		
		btn3 = new JButton("3");
		add(btn3);
		
		btn4 = new JButton("4");
		add(btn4);
		
		btn5 = new JButton("5");
		add(btn5);
		
		btn6 = new JButton("6");
		add(btn6);
		
		btn7 = new JButton("7");
		add(btn7);
		
		btn8 = new JButton("8");
		add(btn8);
		
		btn9 = new JButton("9");
		add(btn9);
		
		btnCE = new JButton("CE");
		add(btnCE);
		
		btnCal = new JButton("계산");
		add(btnCal);
		
		btnAdd = new JButton("+");
		btnAdd.setBackground(new Color(0, 128, 128));
		add(btnAdd);
		
		btnSub = new JButton("-");
		btnSub.setBackground(new Color(0, 128, 128));
		add(btnSub);
		
		btnMul = new JButton("x");
		btnMul.setBackground(new Color(0, 128, 128));
		add(btnMul);
		
		btnDiv = new JButton("/");
		btnDiv.setBackground(new Color(0, 128, 128));
		add(btnDiv);
	}

}
