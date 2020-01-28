package java_swing_study.chap13;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TimerThreadEx2 extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnStart;
	private JButton btnStop;
	private GugudanThread tThread;
	private JTable gugudanTbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimerThreadEx2 frame = new TimerThreadEx2();
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
	public TimerThreadEx2() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnStart = new JButton("시작");
		btnStart.addActionListener(this);
		panel.add(btnStart);
		
		btnStop = new JButton("중지");
		btnStop.addActionListener(this);
		panel.add(btnStop);
		
		gugudanTbl = new JTable();
		gugudanTbl.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		contentPane.add(gugudanTbl, BorderLayout.CENTER);
		
		tThread = new GugudanThread(gugudanTbl);
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
			tThread = new GugudanThread(gugudanTbl);
		}
		tThread.start();
	}
	protected void btnStopActionPerformed(ActionEvent e) {
		tThread.interrupt();
	}
}
