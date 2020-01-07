package java_swing_study.chap09.layout;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class GridLayoutEx extends JFrame {

	private JPanel contentPane;
	private JButton btnOne;
	private JButton btnTwo;
	private JButton btnThree;
	private JButton btnFour;
	private JButton btnFive;
	private JButton btnSix;
	private JButton btnSeven;
	private JButton btnEight;
	private JButton btnNine;
	private JButton btnAsterisk;
	private JButton btnZero;

	/**
	 * Create the frame.
	 */
	public GridLayoutEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 5));
		
		btnOne = new JButton("1");
		contentPane.add(btnOne);
		
		btnTwo = new JButton("2");
		contentPane.add(btnTwo);
		
		btnThree = new JButton("3");
		contentPane.add(btnThree);
		
		btnFour = new JButton("4");
		contentPane.add(btnFour);
		
		btnFive = new JButton("5");
		contentPane.add(btnFive);
		
		btnSix = new JButton("6");
		contentPane.add(btnSix);
		
		btnSeven = new JButton("7");
		contentPane.add(btnSeven);
		
		btnEight = new JButton("8");
		contentPane.add(btnEight);
		
		btnNine = new JButton("9");
		contentPane.add(btnNine);
		
		btnAsterisk = new JButton("*");
		contentPane.add(btnAsterisk);
		
		btnZero = new JButton("0");
		contentPane.add(btnZero);
	}

}
