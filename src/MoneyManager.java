import java.util.ArrayList;
import java.util.Scanner;

import money.Student;
import money.UserInput;
import money.Worker;

public class MoneyManager {
	ArrayList <UserInput> moneys=new ArrayList<UserInput>();
	Scanner input;
	
	MoneyManager(Scanner input){
		this.input=input;
	}
	
	public void add_money() {  
		int kind=0;
		UserInput userInput;
		while(kind!=1&&kind!=2) {
			System.out.println("1 for Worker");
			System.out.println("2 for Student");
			System.out.println("Select num for Person Kind between 1 and 2:");
			kind=input.nextInt();
			if(kind==1) {
				userInput=new Student();
				userInput.getUserInput(input);
				moneys.add(userInput);
				break;
			}
			else if(kind==2) {
				userInput=new Worker();
				userInput.getUserInput(input);
				moneys.add(userInput);
				break;
			}
			else {
				System.out.print("Select num for Person Kind between 1 and 2:");
			}
	   }
	
		
	}                                                        
		
	
	public void delete_money() {           
		System.out.print("Date:");              
		String Date=input.next(); 
		int index=-1;
		for(int i=0;i<moneys.size();i++) {
			if(moneys.get(i).getDate().equals(Date)) {
				index=i;
				break;
			}
		}
		if(index>0) {
			moneys.remove(index);
			System.out.println("the date "+Date+" is deleted");
		}
		
		else {
			System.out.println("the date has not been registered");
			return;
		}
		
	
	}
	
	public void edit_money() {          
		System.out.print("Date:");              
		String Date=input.next();
		for(int i=0;i<moneys.size();i++) {
			UserInput userInput=moneys.get(i);
			if(userInput.getDate().equals(Date)) {
				int num=-1;
				while(num!=4) {
					System.out.println("**Money Info Edit Menu**");
					System.out.println("1. Edit Date");
					System.out.println("2. Edit Income");
					System.out.println("3. Edit Expenditure");
					System.out.println("4. Exit");
					System.out.println("Select one number between 1-6");
					num=input.nextInt();
					if(num==1) {
						System.out.println("Date");
						String date=input.next();
						userInput.setDate(date);
					}
					else if(num==2) {
						System.out.println("Income");
						int income=input.nextInt();
						userInput.setIncome(income);
						int total_money=income-userInput.getExpenditure();
						userInput.setTotal_money(total_money);
					}
					else if(num==3) {
						System.out.println("Expenditure");
						int expenditure=input.nextInt();
						userInput.setExpenditure(expenditure);
						int total_money=userInput.getIncome()-expenditure;
						userInput.setTotal_money(total_money);
						
					}
					else {
						continue;
					}
				}
				break;
			}
		}
		
	}
	
	public void view_moneys() {        
//		System.out.print("Date:");           
//		String Date=input.next();
		for(int i=0;i<moneys.size();i++) {
			moneys.get(i).printInfo();
		}
	
		
	}

}
