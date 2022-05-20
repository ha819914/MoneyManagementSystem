package money;

import java.io.Serializable;
import java.util.Scanner;

import exception.DateFormatException;

public abstract class Money implements UserInput,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1871436379457502823L;
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

	public void setDate(String date) throws DateFormatException {
		if(!date.contains("/")) {
			throw new DateFormatException();
		}
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
	
	public void setDate(Scanner input) {
		String date="";
		while(!date.contains("/")) {
			System.out.println("Date");
			date=input.next();
			try {
				this.setDate(date);
			}catch(DateFormatException e){
				System.out.println("Incorrect Date Format. put the date that contains /");
			}
		}	
	}
	public void setIncome(Scanner input) {
		System.out.println("Income");
		int income=input.nextInt();
		this.setIncome(income);
		int total_money=income-this.getExpenditure();
		this.setTotal_money(total_money);
	}
	public void setExpenditure(Scanner input) {
		System.out.println("Expenditure");
		int expenditure=input.nextInt();
		this.setExpenditure(expenditure);
		int total_money=this.getIncome()-expenditure;
		this.setTotal_money(total_money);
	}
	public void setTotal_money() {
		int total_money=this.getIncome()-this.getExpenditure();
		this.setTotal_money(total_money);
	}
}
