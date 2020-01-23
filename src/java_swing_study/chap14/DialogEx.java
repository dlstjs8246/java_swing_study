package java_swing_study.chap14;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java_swing_study.chap11.exam.Employee;
import java_swing_study.chap11.exam.EmployeePanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DialogEx extends JDialog implements ActionListener {

	private final EmployeePanel contentPanel = new EmployeePanel();
	private JButton okButton;
	private MenuActionEventEx parent;
	private JButton cancelButton;

	public void setParent(MenuActionEventEx parent) {
		this.parent = parent;
	}

	public DialogEx() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			cancelButtonActionPerformed(e);
		}
		if (e.getSource() == okButton) {
			okButtonActionPerformed(e);
		}
	}
	protected void okButtonActionPerformed(ActionEvent e) {
		Employee emp = contentPanel.getItem();
		System.out.println(emp);
		parent.setEmpText(emp);
		contentPanel.tfClear();
		dispose();
	}

	public void setEmp(Employee employee) {
		contentPanel.setItem(employee);
	}
	protected void cancelButtonActionPerformed(ActionEvent e) {
		setVisible(false);
	}

	public Employee getInput() {
		Employee emp = contentPanel.getItem();
		return emp;
	}
}
