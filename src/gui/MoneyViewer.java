package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MoneyViewer extends JFrame {
	public MoneyViewer() {
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Date");
		model.addColumn("Income");
		model.addColumn("Expenditure");
		model.addColumn("Contact Info.");
		
		
		JTable table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		
		this.add(sp);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
