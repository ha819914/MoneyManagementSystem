package manager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import money.Money;
import money.Student;
import money.UserInput;
import money.Worker;

public class MoneyManager implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8724864075470199013L;
	
	ArrayList <UserInput> moneys=new ArrayList<UserInput>();
	transient Scanner input;
	
	MoneyManager(Scanner input){
		this.input=input;
	}
	
	public void add_money(String date, String income, String expenditure) {
		UserInput userInput=new Worker();
		userInput.getUserInput(input);
		moneys.add(userInput);
	}
	
	public void add_money(UserInput userInput) {
		moneys.add(userInput);
	}
	
	public void add_money() {  
		int kind=0;
		UserInput userInput;
		while(kind<1||kind>2) {
			try {
				System.out.println("1 for Worker");
				System.out.println("2 for Student");
				System.out.println("Select num 1, 2 for Person Kind:");
				kind=input.nextInt();
				if(kind==1) {
					userInput=new Worker();
					userInput.getUserInput(input);
					moneys.add(userInput);
					break;
				}
				else if(kind==2) {
					userInput=new Student();
					userInput.getUserInput(input);
					moneys.add(userInput);
					break;
				}
				else {
					System.out.print("Select num for Person Kind between 1 and 2:");
				}
			}catch(InputMismatchException e) {
				System.out.println("Please put an integer 1 or 2!");
				if(input.hasNext()) {
					input.next();
				}
				kind=-1;
			}
	   }
	
		
	}                                                        
		
	public int delete_user() {
		System.out.println("1 for Worker");
		System.out.println("2 for Student");
		System.out.println("Select num for Person Kind between 1 and 2:");
		int kind=input.nextInt();
		return kind;
	}
	public void delete_money() {
		int user=delete_user();
		System.out.print("Date:");              
		String Date=input.next(); 
		int index=findIndex(user,Date);
		removefromMoneys(index, Date);
	}
	
	public int findIndex(int user,String Date) {
		UserInput userInput;
		int index=-1;
		switch(user) {
		case 1:	userInput=new Worker();
			for(int i=0;i<moneys.size();i++) {
				if(moneys.get(i).getDate().equals(Date)) {
					index=i;
					break;
				}
			}
		case 2: userInput=new Student();
			for(int i=0;i<moneys.size();i++) {
				if(moneys.get(i).getDate().equals(Date)) {
					index=i;
					break;
				}
			}
		}return index;
	}	
	public int removefromMoneys(int index, String Date) {
		if(index>=0) {
			moneys.remove(index);
			System.out.println("the date "+Date+" is deleted");
			return 1;
		}
		
		else {
			System.out.println("the date has not been registered");
			return -1;
		}
	}

	public void edit_money() {
		System.out.print("Date:");              
		String Date=input.next();
		for(int i=0;i<moneys.size();i++) {
			UserInput user=moneys.get(i);
			if(user.getDate().equals(Date)) {
				int num=-1;
				while(num!=4) {
					showEditMenu();
					num=input.nextInt();
					switch(num){
					case 1:
						user.setDate(input);
						break;
					case 2:
						user.setIncome(input);
						break;
					case 3:
						user.setExpenditure(input);
						break;
					default :
						continue;
					}
				}
				break;
			}
		}
		
	}
	
	public void view_moneys() {        
		for(int i=0;i<moneys.size();i++) {
			moneys.get(i).printInfo();
		}	
	}
	
	public int size() {
		return moneys.size();
	}
	
	public UserInput get(int index) {
		return (Money) moneys.get(index);
	}
	
	public void showEditMenu() {
		System.out.println("**Money Info Edit Menu**");
		System.out.println("1. Edit Date");
		System.out.println("2. Edit Income");
		System.out.println("3. Edit Expenditure");
		System.out.println("4. Exit");
		System.out.println("Select one number between 1-6");
	}

}
