package money;

import java.util.Scanner;

public abstract class Money {
	protected PersonKind kind=PersonKind.Worker;
	protected String date;
	protected int income;
	protected int expenditure;
	protected int total_money;
	
	public Money() {
		
	}
	
	public Money(String date, int income, int expediture, int total_money) {
		this.date=date;
		this.income=income;
		this.expenditure=expenditure;
		this.total_money=total_money;
	}
	public PersonKind getKind() {
		return kind;
	}

	public void setKind(PersonKind kind) {
		this.kind = kind;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(int expenditure) {
		this.expenditure = expenditure;
	}

	public int getTotal_money() {
		return total_money;
	}

	public void setTotal_money(int total_money) {
		this.total_money = total_money;
	}

	
	public abstract void printInfo();
	
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
}
