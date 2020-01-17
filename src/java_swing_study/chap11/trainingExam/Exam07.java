package java_swing_study.chap11.trainingExam;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Exam07 extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JLabel lblText;
	private JSlider slider;

	/**
	 * Create the frame.
	 */
	public Exam07() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblText = new JLabel("I Love Java");
		lblText.setFont(new Font("굴림", Font.BOLD, 12));
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblText, BorderLayout.CENTER);
		
		slider = new JSlider();
		slider.addChangeListener(this);
		slider.setValue(12);
		slider.setFont(new Font("굴림", Font.BOLD, 12));
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinimum(1);
		contentPane.add(slider, BorderLayout.NORTH);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider) {
			sliderStateChanged(e);
		}
	}
	protected void sliderStateChanged(ChangeEvent e) {
		lblText.setFont(new Font("굴림", Font.BOLD, slider.getValue()));
	}
}
