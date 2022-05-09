package money;

import java.util.Scanner;

public class Student extends Money implements UserInput{
	public void getUserInput(Scanner input) {
		System.out.print("Date:");                          
		String date=input.next();
		this.setDate(date);
		
		System.out.print("income:");           
		int income=input.nextInt();
		this.setIncome(income);
		
		System.out.print("expenditure:"); 
		int expenditure=input.nextInt();
		this.setExpenditure(expenditure);
		
		int total_money=income-expenditure;
		this.setTotal_money(total_money);
	}
	
	public void printInfo() {
		System.out.println("date:"+date+" income:"+income+" expenditure:"+expenditure+" total_money:"+total_money);
	}

}
