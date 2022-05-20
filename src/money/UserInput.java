package money;

import java.util.Scanner;

import exception.DateFormatException;

public interface UserInput {
	public String getDate();
	public void setDate(String date) throws DateFormatException;
	
	public int getIncome();
	public void setIncome(int income);
	
	public int getExpenditure();
	public void setExpenditure(int expenditure);
	
	public void setTotal_money(int total_money);
	
	public void getUserInput(Scanner input);

	public void printInfo();
	
	public void setDate(Scanner input);
	
	public void setIncome(Scanner input);
	
	public void setExpenditure(Scanner input);
	
	public void setTotal_money();
}
