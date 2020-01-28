package java_swing_study.chap13;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GugudanThread extends Thread {
	private JTable gugudan;
	private ArrayList<String> gugudanList;
	private TableModel model;
	
	public GugudanThread(JTable gugudan) {
		this.gugudan = gugudan;
	}

	@Override
	public void run() {
		gugudanList = new ArrayList<>();
		for(int i=2;i<10;i++) {
			for(int j=1;j<10;j++) {
				gugudanList.add(String.format("%d * %d = %2d", i,j,i*j));
				try {
					sleep(1000);
					gugudan.setModel(initModel(gugudanList));
				} catch (InterruptedException e) {
					return;
				}
			}	
		}
	}

	private TableModel initModel(ArrayList<String> gugudanList) {
		model = new DefaultTableModel(getRows(gugudanList), getColumnNames());
		return model;
	}

	private Object[][] getRows(ArrayList<String> gugudanList) {
		Object[][] rows = new Object[9][9];
		for(int i=0;i<gugudanList.size();i++) {
			rows[i%9][i/9] = gugudanList.get(i);
		}
		return rows;
	}

	private String[] getColumnNames() {
		return new String[]{"2단","3단","4단","5단","6단","7단","8단","9단"};
	}

}
