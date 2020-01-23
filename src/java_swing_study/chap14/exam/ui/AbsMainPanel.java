package java_swing_study.chap14.exam.ui;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java_swing_study.chap14.exam.ui.panel.AbsTblPanel;

@SuppressWarnings("serial")
public abstract class AbsMainPanel<T> extends JPanel {
	private JPanel pItem;
	private JPanel pBtn;
	private AbsTblPanel<T> pTbl;
	protected JButton btnAdd;
	protected JButton btnCancel;
	protected ArrayList<T> itemList;
	protected JPopupMenu popMenu;
	public AbsMainPanel() {
		initialize();
	}
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pItem = getItemPanel();
		add(pItem);
		
		pBtn = new JPanel();
		add(pBtn);
		
		btnAdd = new JButton("추가");
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		pBtn.add(btnCancel);
		
		pTbl = getTblPanel();
		add(pTbl);
	}
	protected abstract JPanel getItemPanel();
	protected abstract AbsTblPanel<T> getTblPanel();
	protected abstract void initItemList();
	protected abstract void addBtnListener();
	protected abstract void initPopMenu();
}
