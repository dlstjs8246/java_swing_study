package java_swing_study.chap11.trainingExam;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Exam05 extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JSlider slider;
	private JPanel panel;
	private JLabel label;

	public Exam05() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		slider = new JSlider();
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(20);
		slider.setMinimum(100);
		slider.setMaximum(200);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		contentPane.add(slider);
		
		panel = new JPanel();
		panel.setBackground(Color.GREEN);
		contentPane.add(panel);
		
		label = new JLabel("수치");
		label.setFont(new Font("굴림", Font.BOLD, 12));
		label.setBackground(Color.WHITE);
		panel.add(label);
		
		slider.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider) {
			sliderStateChanged(e);
		}
	}
	protected void sliderStateChanged(ChangeEvent e) {
		label.setText(slider.getValue() + " ");
	}
}
