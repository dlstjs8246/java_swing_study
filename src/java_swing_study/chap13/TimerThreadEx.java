package java_swing_study.chap13;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TimerThreadEx extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblTimer;
	private JPanel panel;
	private JButton btnStart;
	private JButton btnStop;
	private TimerThread tThread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimerThreadEx frame = new TimerThreadEx();
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
	public TimerThreadEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		
		lblTimer = new JLabel("");
		lblTimer.setFont(new Font("굴림", Font.BOLD, 30));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		tThread = new TimerThread(lblTimer);
		contentPane.add(lblTimer, BorderLayout.CENTER);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnStart = new JButton("시작");
		btnStart.addActionListener(this);
		panel.add(btnStart);
		
		btnStop = new JButton("중지");
		btnStop.addActionListener(this);
		panel.add(btnStop);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStop) {
			btnStopActionPerformed(e);
		}
		if (e.getSource() == btnStart) {
			btnStartActionPerformed(e);
		}
	}
	protected void btnStartActionPerformed(ActionEvent e) {
		if(tThread.getState()==Thread.State.TERMINATED) {
			tThread = new TimerThread(lblTimer);
		}
		tThread.start();
	}
	protected void btnStopActionPerformed(ActionEvent e) {
		tThread.interrupt();
	}
}
