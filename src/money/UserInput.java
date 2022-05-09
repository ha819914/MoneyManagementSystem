package money;

import java.util.Scanner;

public interface UserInput {
	public String getDate();
	public void setDate(String date);
	
	public int getIncome();
	public void setIncome(int income);
	
	public int getExpenditure();
	public void setExpenditure(int expenditure);
	
	public void setTotal_money(int total_money);
	
	public void getUserInput(Scanner input);

	public void printInfo();
}
