package java_swing_study.chap10;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MouseAdapterEx extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MouseAdapterEx frame = new MouseAdapterEx();
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
	public MouseAdapterEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbl = new JLabel("New Label");
		lbl.setBounds(85, 74, 66, 15);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				// TODO Auto-generated method stub
				System.out.printf("마우스 (%d,%d)%n",x,y);
				lbl.setLocation(x, y);
				System.out.printf("모니터 (%d,%d)%n",e.getXOnScreen(),e.getYOnScreen());
			}
			
		});
		contentPane.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.printf("%s%n","mouseClicked");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.printf("%s%n","mouseReleased");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.printf("%s%n","mouseEntered");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.printf("%s%n","mouseExited");
			}
			
		});
		contentPane.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.printf("%s%n","mouseDragged");
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.printf("%s%n","mouseMoved");
			}
		});
		
		
		contentPane.add(lbl);
	}
}
