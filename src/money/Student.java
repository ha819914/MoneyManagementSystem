package money;

import java.util.Scanner;

import exception.DateFormatException;

public class Student extends Money {
	
	public void getUserInput(Scanner input) {
		setDate(input);
		setIncome(input);
		setExpenditure(input);
		setTotal_money();
	}
	
	public void printInfo() {
		System.out.println("student "+"date:"+date+" income:"+income+" expenditure:"+expenditure+" total_money:"+total_money);
	}
}
