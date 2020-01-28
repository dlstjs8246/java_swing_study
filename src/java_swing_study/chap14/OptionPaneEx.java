package java_swing_study.chap14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java_swing_study.chap14.exam.ui.panel.StudentPanel;

public class OptionPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pTop;
	private JPanel pCenter;
	private JPanel pPopupDlg;
	private JPanel pFileDlg;
	private JPanel pColorDlg;
	private JButton btnPopupInput;
	private JButton btnPopupConfirm;
	private JButton btnPopupMessage;
	private JButton btnFileOpen;
	private JButton btnFileSave;
	private JLabel lblImg;
	private JLabel lblPopup;
	private JFileChooser chooser;
	private JButton btnColor;
	private JLabel lblColor;
	private JTabbedPane tabbedPane;
	private JLabel lblTab1;
	private StudentPanel pStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionPaneEx frame = new OptionPaneEx();
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
	public OptionPaneEx() {
		initialize();
	}

	private void initialize() {
		chooser = new JFileChooser(System.getProperty("user.dir") + "\\images\\");
		setTitle("팝업다이얼로그, 파일다이얼로그, 컬러다이얼로그");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pTop = new JPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 3, 0, 0));

		pPopupDlg = new JPanel();
		pPopupDlg.setBorder(new TitledBorder(null, "\uD31D\uC5C5 \uB2E4\uC774\uC5BC\uB85C\uADF8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pTop.add(pPopupDlg);
		pPopupDlg.setLayout(new GridLayout(0, 1, 0, 0));

		btnPopupInput = new JButton("입력 다이얼로그");

		pPopupDlg.add(btnPopupInput);

		btnPopupConfirm = new JButton("확인 다이얼로그");

		pPopupDlg.add(btnPopupConfirm);

		btnPopupMessage = new JButton("메시지 다이얼로그");

		pPopupDlg.add(btnPopupMessage);

		lblPopup = new JLabel("");
		pPopupDlg.add(lblPopup);

		pFileDlg = new JPanel();
		pFileDlg.setBorder(
				new TitledBorder(null, "\uD30C\uC5F4\uC5F4\uAE30/\uC800\uC7A5 \uB2E4\uC774\uC5B4\uB85C\uADF8",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTop.add(pFileDlg);
		pFileDlg.setLayout(new BoxLayout(pFileDlg, BoxLayout.Y_AXIS));

		btnFileOpen = new JButton("파일 열기");
		btnFileOpen.addActionListener(this);
		pFileDlg.add(btnFileOpen);

		btnFileSave = new JButton("파일 저장");
		btnFileSave.addActionListener(this);
		pFileDlg.add(btnFileSave);

		lblImg = new JLabel("");
		pFileDlg.add(lblImg);

		pColorDlg = new JPanel();
		pColorDlg.setBorder(new TitledBorder(null, "\uCEEC\uB7EC \uB2E4\uC774\uC5B4\uB85C\uADF8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pTop.add(pColorDlg);
		pColorDlg.setLayout(new BorderLayout(0, 0));
		
		btnColor = new JButton("색깔 선택");
		btnColor.addActionListener(this);
		pColorDlg.add(btnColor, BorderLayout.NORTH);
		
		lblColor = new JLabel("Test Data");
		lblColor.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 20));
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		pColorDlg.add(lblColor, BorderLayout.CENTER);

		pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pCenter.add(tabbedPane, BorderLayout.CENTER);
		
		lblTab1 = new JLabel(new ImageIcon(System.getProperty("user.dir")+"\\images\\wonderwoman.jpg"));
		tabbedPane.addTab("tab1", null, lblTab1, null);
		
		pStudent = new StudentPanel();
		tabbedPane.addTab("학생관리", null, pStudent, null);

		btnPopupInput.addActionListener(this);
		btnPopupConfirm.addActionListener(this);
		btnPopupMessage.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnColor) {
			btnColorActionPerformed(e);
		}
		if (e.getSource() == btnFileSave) {
			btnFileSaveActionPerformed(e);
		}
		if (e.getSource() == btnFileOpen) {
			btnFileOpenActionPerformed(e);
		}
		if (e.getSource() == btnPopupConfirm) {
			btnPopupConfirmActionPerformed(e);
		}
		if (e.getSource() == btnPopupMessage) {
			btnPopupMessageActionPerformed(e);
		}
		if (e.getSource() == btnPopupInput) {
			btnPopupInputActionPerformed(e);
		}
	}

	protected void btnPopupInputActionPerformed(ActionEvent e) {
		String[] selectionValues = { "국어", "영어", "수학" };
		String res = (String) JOptionPane.showInputDialog(this, "과목을 선택하세요", "과목선택", JOptionPane.QUESTION_MESSAGE, null,
				selectionValues, selectionValues[0]);
		if (res == null) {
			lblPopup.setText("선택없음");
			return;
		}
		System.out.println(res);
	}

	protected void btnPopupMessageActionPerformed(ActionEvent e) {
		ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\images\\icon1.png");
		JOptionPane.showMessageDialog(null, "열시미", "자바 프로젝트", JOptionPane.ERROR_MESSAGE, icon);
	}

	protected void btnPopupConfirmActionPerformed(ActionEvent e) {
		int res = JOptionPane.showConfirmDialog(this, "잠오니 상원아?", "졸음 체크", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE, null);
		System.out.println(res);
		if (res == JOptionPane.YES_OPTION) {
			System.out.println("확인");
		}
		if (res == JOptionPane.NO_OPTION) {
			System.out.println("아니오");
		}
		if (res == JOptionPane.CANCEL_OPTION) {
			System.out.println("취소");
		}
		if (res == JOptionPane.CLOSED_OPTION) {
			System.out.println("닫기");
		}
	}

	protected void btnFileOpenActionPerformed(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG", "jpg", "gif", "png");
		chooser.setFileFilter(filter);
		int res = chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(this, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String FilePath = chooser.getSelectedFile().getPath();
		lblImg.setIcon(new ImageIcon(FilePath));
	}

	protected void btnFileSaveActionPerformed(ActionEvent e) {
		int res = chooser.showSaveDialog(this);
		String FilePath = chooser.getSelectedFile().getPath();
		//추가 구현 나중에 하기
	}
	protected void btnColorActionPerformed(ActionEvent e) {
		Color color = JColorChooser.showDialog(this, "Color", Color.yellow);
		if(color!=null) {
			lblColor.setForeground(color);
		}
	}
}
