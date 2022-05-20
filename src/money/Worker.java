package money;

import java.util.Scanner;

public class Worker extends Money {
	
	
	public void getUserInput(Scanner input) {
		setDate(input);
		setIncome(input);
		setExpenditure(input);
		setTotal_money();
	}
	
	public void printInfo() {
		System.out.println("worker "+"date:"+date+" income:"+income+" expenditure:"+expenditure+" total_money:"+total_money);
	}
}
