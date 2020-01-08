package java_swing_study.chap09.layout.openchallenge;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OpenChallengeEx extends JFrame {

	private JPanel contentPane;
	private NorthPanel pNorth;
	private CenterPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenChallengeEx frame = new OpenChallengeEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OpenChallengeEx() {
		initialize();
	}
	private void initialize() {
		setTitle("간단한 Swing  응용프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pNorth = new NorthPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		panel = new CenterPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
