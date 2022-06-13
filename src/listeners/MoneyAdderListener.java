package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;

import exception.DateFormatException;
import manager.MoneyManager;
import money.Money;
import money.UserInput;
import money.Worker;

public class MoneyAdderListener implements ActionListener {
	JTextField fieldDate;
	JTextField fieldIncome;
	JTextField fieldExpenditure;
	
	MoneyManager moneymanager;

	public MoneyAdderListener(JTextField fieldDate, JTextField fieldIncome, JTextField fieldExpenditure,MoneyManager moneymanager) {
		this.fieldDate = fieldDate;
		this.fieldIncome = fieldIncome;
		this.fieldExpenditure = fieldExpenditure;
		this.moneymanager=moneymanager; 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		UserInput money=new Worker();
		try {
			money.setDate(fieldDate.getText());
			money.setIncome(Integer.parseInt(fieldIncome.getText()));
			money.setExpenditure(Integer.parseInt(fieldExpenditure.getText())); 
			moneymanager.add_money(money);
			putObject(moneymanager, "moneymanager.ser");
			money.printInfo();
		} catch (DateFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void putObject(MoneyManager moneymanager,String fileName) {
		try {
			FileOutputStream file=new FileOutputStream(fileName);
			ObjectOutputStream out=new ObjectOutputStream(file);
			
			out.writeObject(moneymanager);
			
			out.close();
			file.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
