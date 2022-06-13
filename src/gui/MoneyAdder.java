package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import listeners.MoneyAdderCancelListener;
import listeners.MoneyAdderListener;
import manager.MoneyManager;

public class MoneyAdder extends JPanel {
	WindowFrame frame;
	MoneyManager moneymanager;
	
	public MoneyAdder(WindowFrame frame,MoneyManager moneymanager) {
		this.frame=frame;
		this.moneymanager=moneymanager;
		
		JPanel panel=new JPanel();
		panel.setLayout(new SpringLayout());
		
		
		JLabel labelDate=new JLabel("Date: ",JLabel.TRAILING);
		JTextField fieldDate=new JTextField(10);
		labelDate.setLabelFor(fieldDate);
		panel.add(labelDate);
		panel.add(fieldDate);
		
		
		JLabel labelIncome=new JLabel("Income: ",JLabel.TRAILING);
		JTextField fieldIncome=new JTextField(10);
		labelIncome.setLabelFor(fieldIncome);
		panel.add(labelIncome);
		panel.add(fieldIncome);
		
		JLabel labelExpenditure=new JLabel("Expenditure: ",JLabel.TRAILING);
		JTextField fieldExpenditure=new JTextField(10);
		labelExpenditure.setLabelFor(fieldExpenditure);
		
		JButton saveButton=new JButton("save");
		saveButton.addActionListener(new MoneyAdderListener(fieldDate,fieldIncome,fieldExpenditure,moneymanager));
		
		JButton cancelButton=new JButton("cancel");
		cancelButton.addActionListener(new MoneyAdderCancelListener(frame));
		
		panel.add(labelExpenditure);
		panel.add(fieldExpenditure);
		
		panel.add(saveButton);
		panel.add(cancelButton);

		
		SpringUtilities.makeCompactGrid(panel,4,2,6,6,6,6);
		

		this.add(panel);
		this.setVisible(true);
	}

}
