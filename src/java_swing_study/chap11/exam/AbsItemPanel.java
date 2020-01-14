package java_swing_study.chap11.exam;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class AbsItemPanel<T> extends JPanel {

	public AbsItemPanel() {
		
	}

	public abstract T getItem();
	
	public abstract void setItem(T item);
	
	public abstract void tfClear();
}
