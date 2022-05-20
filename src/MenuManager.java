import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import log.EventLogger;

public class MenuManager {
	static EventLogger logger=new EventLogger("log.txt");

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		MoneyManager moneymanager=getObject("moneymanager.ser");
		if(moneymanager==null) {
			moneymanager=new MoneyManager(input);
		}
		
		selectMenu(input,moneymanager);
		putObject(moneymanager,"moneymanager.ser");
	}
	
	public static void selectMenu(Scanner input, MoneyManager moneymanager) {
		int num=0;   
		while(num!=5) {
			try{
				showMenu();
				num=input.nextInt();
				switch(num) {
				case 1:
					moneymanager.add_money(); 
					logger.log("add money");
					break;
				case 2:
					moneymanager.delete_money();
					logger.log("delete money");
					break;
				case 3:
					moneymanager.edit_money();
					logger.log("edit money");
					break;
				case 4:
					moneymanager.view_moneys();
					logger.log("view money");
					break;
				default :
					continue;
				}  	 
			}catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 5!");
				if(input.hasNext()) {
					input.next();
				}
				num=-1;
			}
		}
	}
	public static void showMenu() {
		System.out.println("1. Add Money");
		System.out.println("2. Delete Money");
		System.out.println("3. Edit Money");
		System.out.println("4. View Money");
		System.out.println("5. Exit");
		System.out.println("Select one number between 1-5:");
	}
	
	public static MoneyManager getObject(String fileName) {
		MoneyManager moneymanager=null;
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in=new ObjectInputStream(file);
			
			moneymanager=(MoneyManager)in.readObject();
			
			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			return moneymanager;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return moneymanager;
	}
	public static void putObject(MoneyManager moneymanager,String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out=new ObjectOutputStream(file);
			
			out.writeObject(moneymanager);
			
			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
