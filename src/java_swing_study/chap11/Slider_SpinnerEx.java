package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.Component;

@SuppressWarnings("serial")
public class Slider_SpinnerEx extends JFrame implements ChangeListener, ActionListener {

	private JPanel contentPane;
	private JPanel pSlider1;
	private JPanel pSlider2;
	private JPanel pSpinner1;
	private JPanel pSpinner2;
	private JSlider slider1;
	private JLabel lblSlider;
	private JPanel pNorth;
	private JPanel pCenter;
	private JSlider sBlue;
	private JSlider sGreen;
	private JSlider sRed;
	private JPanel pBottom;
	private JLabel lblNewLabel;
	private JLabel lblRed;
	private JTextField tfRed;
	private JLabel lblBlue;
	private JTextField tfBlue;
	private JLabel lblGreen;
	private JTextField tfGreen;
	private JButton btnConfirm;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JSpinner spList;
	private JLabel lblList;
	private JSpinner spNumber;
	private JLabel lblNumber;
	private JSpinner spDate;
	private JLabel lblDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slider_SpinnerEx frame = new Slider_SpinnerEx();
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
	public Slider_SpinnerEx() {
		initialize();
	}
	@SuppressWarnings("deprecation")
	private void initialize() {
		setTitle("JSilder와 JSpinner 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		pSlider1 = new JPanel();
		pSlider1.setBorder(new TitledBorder(null, "\uC608\uC81C 11-14", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSlider1);
		pSlider1.setLayout(new BorderLayout(0, 0));
		
		slider1 = new JSlider();
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setValue(100);
		slider1.setMinorTickSpacing(10);
		slider1.setMajorTickSpacing(50);
		pSlider1.add(slider1);
		
		lblSlider = new JLabel("0");
		lblSlider.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlider.setForeground(Color.RED);
		lblSlider.setBackground(Color.WHITE);
		lblSlider.setFont(new Font("굴림", Font.BOLD, 12));
		pSlider1.add(lblSlider, BorderLayout.SOUTH);
		
		pSlider2 = new JPanel();
		pSlider2.setBorder(new TitledBorder(null, "\uC608\uC81C11-15", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSlider2);
		pSlider2.setLayout(new BorderLayout(0, 0));
		
		pNorth = new JPanel();
		pSlider2.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 7, 0, 0));
		
		lblRed = new JLabel("Red");
		lblRed.setHorizontalAlignment(SwingConstants.CENTER);
		pNorth.add(lblRed);
		
		tfRed = new JTextField();
		pNorth.add(tfRed);
		tfRed.setColumns(10);
		
		lblBlue = new JLabel("Blue");
		lblBlue.setHorizontalAlignment(SwingConstants.CENTER);
		pNorth.add(lblBlue);
		
		tfBlue = new JTextField();
		tfBlue.setColumns(10);
		pNorth.add(tfBlue);
		
		lblGreen = new JLabel("Green");
		lblGreen.setHorizontalAlignment(SwingConstants.CENTER);
		pNorth.add(lblGreen);
		
		tfGreen = new JTextField();
		tfGreen.setColumns(10);
		pNorth.add(tfGreen);
		
		btnConfirm = new JButton("적용");
		btnConfirm.addActionListener(this);
		pNorth.add(btnConfirm);
		
		pCenter = new JPanel();
		pSlider2.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		sBlue = new JSlider();
		
		sRed = new JSlider();
		sRed.setValue(0);
		sRed.setPaintTicks(true);
		sRed.setPaintLabels(true);
		sRed.setMinorTickSpacing(10);
		sRed.setMaximum(255);
		sRed.setMajorTickSpacing(50);
		sRed.setForeground(Color.RED);
		sRed.setBackground(Color.WHITE);
		pCenter.add(sRed);
		
		sGreen = new JSlider();
		sGreen.setValue(0);
		sGreen.setPaintTicks(true);
		sGreen.setPaintLabels(true);
		sGreen.setMinorTickSpacing(10);
		sGreen.setMaximum(255);
		sGreen.setMajorTickSpacing(50);
		sGreen.setForeground(Color.GREEN);
		pCenter.add(sGreen);
		sBlue.setValue(0);
		sBlue.setPaintTicks(true);
		sBlue.setPaintLabels(true);
		sBlue.setMinorTickSpacing(10);
		sBlue.setMaximum(255);
		sBlue.setMajorTickSpacing(50);
		sBlue.setForeground(Color.BLUE);
		pCenter.add(sBlue);
		
		pBottom = new JPanel();
		pBottom.setBackground(Color.GRAY);
		pSlider2.add(pBottom, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("SLIDER EXAMPLE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		pBottom.add(lblNewLabel);
		
		pSpinner1 = new JPanel();
		pSpinner1.setBorder(new TitledBorder(null, "JSpinner \uC608\uC81C1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSpinner1);
		pSpinner1.setLayout(new GridLayout(0, 1, 0, 0));
		
		p1 = new JPanel();
		p1.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSpinner1.add(p1);
		p1.setLayout(new GridLayout(0, 2, 0, 0));
		
		spList = new JSpinner();
		spList.setModel(new SpinnerListModel(new String[] {"\uC18C\uC124", "\uC7A1\uC9C0", "\uC804\uACF5\uC11C\uC801", "\uCDE8\uBBF8"}));
		p1.add(spList);
		
		lblList = new JLabel("New label");
		lblList.setForeground(Color.MAGENTA);
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		p1.add(lblList);
		
		p2 = new JPanel();
		p2.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSpinner1.add(p2);
		p2.setLayout(new GridLayout(0, 2, 0, 0));
		
		spNumber = new JSpinner();
		p2.add(spNumber);
		
		lblNumber = new JLabel("New label");
		lblNumber.setForeground(Color.MAGENTA);
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(lblNumber);
		
		p3 = new JPanel();
		p3.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSpinner1.add(p3);
		p3.setLayout(new GridLayout(0, 2, 0, 0));
		
		spDate = new JSpinner();
		spDate.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.SECOND));
		p3.add(spDate);
		
		lblDate = new JLabel("New label");
		lblDate.setForeground(Color.MAGENTA);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		p3.add(lblDate);
		
		pSpinner2 = new JPanel();
		pSpinner2.setBorder(new TitledBorder(null, "JSpinner \uC608\uC81C2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSpinner2);
		
		slider1.addChangeListener(this);
		slider1.setMaximum(200);
		
		sRed.addChangeListener(this);
		sBlue.addChangeListener(this);
		sGreen.addChangeListener(this);
		
		spList.addChangeListener(this);
		spNumber.addChangeListener(this);
		spDate.addChangeListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			btnConfirmActionPerformed(e);
		}
	}
	protected void btnConfirmActionPerformed(ActionEvent e) {
		sRed.setValue(Integer.parseInt(tfRed.getText().trim()));
		sGreen.setValue(Integer.parseInt(tfGreen.getText().trim()));
		sBlue.setValue(Integer.parseInt(tfBlue.getText().trim()));
	}
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == spDate) {
			spDateStateChanged(e);
		}
		if (e.getSource() == spNumber) {
			spNumberStateChanged(e);
		}
		if (e.getSource() == spList) {
			spListStateChanged(e);
		}
		if (e.getSource() == sRed) {
			sRedStateChanged(e);
		}
		else if (e.getSource() == sGreen) {
			sGreenStateChanged(e);
		}
		else if (e.getSource() == sBlue) {
			sBlueStateChanged(e);
		}
	}
	private void sBlueStateChanged(ChangeEvent e) {
		if(pBottom!=null) {
			tfBlue.setText(sBlue.getValue() + " ");
			pBottom.setBackground(new Color(sRed.getValue(),sGreen.getValue(),sBlue.getValue()));
		}
	}
	private void sRedStateChanged(ChangeEvent e) {
		if(pBottom!=null) {
			tfRed.setText(sRed.getValue() + " ");
			pBottom.setBackground(new Color(sRed.getValue(),sGreen.getValue(),sBlue.getValue()));
		}
	}

	protected void sGreenStateChanged(ChangeEvent e) {
		if(pBottom!=null) {
			tfGreen.setText(sGreen.getValue() + " ");
			pBottom.setBackground(new Color(sRed.getValue(),sGreen.getValue(),sBlue.getValue()));
		}	
	}
	protected void spListStateChanged(ChangeEvent e) {
		lblList.setText(spList.getValue().toString());
	}
	protected void spNumberStateChanged(ChangeEvent e) {
		lblNumber.setText(spNumber.getValue().toString());
	}
	protected void spDateStateChanged(ChangeEvent e) {
		lblDate.setText(spDate.getValue().toString());
	}
}
