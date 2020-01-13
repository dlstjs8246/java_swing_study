package java_swing_study.chap11;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Ex01 extends JFrame implements ActionListener, ContainerListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex01 frame = new Ex01();
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
	public Ex01() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		pLeft = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pLeft.getLayout();
		flowLayout.setVgap(10);
		pLeft.setBorder(new TitledBorder(null, "11-1\uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		
		b1 = new JButton("Magenta/Yellow Button");
		b1.addActionListener(this);
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.MAGENTA);
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
		pLeft.add(b1);
		
		b2 = new JButton("Disabled Button");
		b2.setEnabled(false);
		pLeft.add(b2);
		
		b3 = new JButton("getX(), getY()");
		b3.addActionListener(this);
		pLeft.add(b3);
		
		b4 = new JButton("Rigth Panel Add Button");
		b4.addActionListener(this);
		pLeft.add(b4);
		
		b5 = new JButton("Right Panel Remove Button");
		b5.addActionListener(this);
		pLeft.add(b5);
		
		pRight = new JPanel();
		pRight.addContainerListener(this);
		pRight.setBorder(new TitledBorder(null, "JComponent\uBA54\uC11C\uB4DC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b5) {
			try {
				b5ActionPerformed(e);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == b4) {
			b4ActionPerformed(e);
		}
		if (e.getSource() == b1) {
			b1ActionPerformed(e);
		}
		if (e.getSource() == b3) {
			b3ActionPerformed(e);
		}
	}
	protected void b3ActionPerformed(ActionEvent e) {
		JFrame frame = (JFrame) b3.getTopLevelAncestor();
		frame.setTitle(b3.getX() + "," + b3.getY());
	}
	protected void b1ActionPerformed(ActionEvent e) {
		if(b2.isEnabled()) {
			b2.setEnabled(false);
		}
		else {
			b2.setEnabled(true);
		}
		
	}
	protected void b4ActionPerformed(ActionEvent e) {
		JButton newBtn = new JButton("Added");
		newBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				frame.addWindowListener(new WindowListener() {
					
					@Override
					public void windowOpened(WindowEvent e) {
						System.out.printf("%s()%n","windowOpened");
					}
					
					@Override
					public void windowIconified(WindowEvent e) {
						System.out.printf("%s()%n","windowIconified");
						
					}
					
					@Override
					public void windowDeiconified(WindowEvent e) {
						System.out.printf("%s()%n","windowDeiconified");	
					}
					
					@Override
					public void windowDeactivated(WindowEvent e) {
						System.out.printf("%s()%n","windowDeactivated");		
					}
					
					@Override
					public void windowClosing(WindowEvent e) {
						System.out.printf("%s()%n","windowClosing");			
					}
					
					@Override
					public void windowClosed(WindowEvent e) {
						System.out.printf("%s()%n","windowClosed");		
					}
					
					@Override
					public void windowActivated(WindowEvent e) {
						System.out.printf("%s()%n","windowActivated");		
					}
				});
				frame.setVisible(true);
				frame.setBounds(0, 0, 400, 350);
			}
		});
		pRight.add(newBtn);
		pRight.revalidate();
		pRight.repaint();
	}
	 protected synchronized void b5ActionPerformed(ActionEvent e) throws InterruptedException {
		for(Component com : pRight.getComponents()) {
			pRight.remove(com);
			pRight.revalidate();
			pRight.repaint();
			Thread.sleep(500);
		}
	}
	public void componentAdded(ContainerEvent e) {
		if (e.getSource() == pRight) {
			pRightComponentAdded(e);
		}
	}
	public void componentRemoved(ContainerEvent e) {
		JOptionPane.showMessageDialog(null, "제거되었습니다.");
	}
	protected void pRightComponentAdded(ContainerEvent e) {
		JOptionPane.showMessageDialog(null, "추가되었습니다.");
	}
}
