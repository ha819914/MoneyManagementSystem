package gui;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import manager.MoneyManager;
import money.UserInput;

public class MoneyViewer extends JPanel {
	
	WindowFrame frame;
	MoneyManager moneymanager;
	
	public MoneyViewer(WindowFrame frame, MoneyManager moneymanager) {
		this.frame=frame;
		this.moneymanager=moneymanager;
		
		System.out.println("***"+moneymanager.size()+"***");
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Date");
		model.addColumn("Income");
		model.addColumn("Expenditure");
		model.addColumn("Contact Info.");
		
		for(int i=0;i<moneymanager.size();i++) {
			Vector row=new Vector();
			UserInput ui=moneymanager.get(i);
			row.add(ui.getDate());
			row.add(ui.getIncome());
			row.add(ui.getExpenditure());
			model.addRow(row);
		}
		
		JTable table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		
		this.add(sp);

		
	}

}
