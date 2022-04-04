import java.util.Scanner;

public class MenuManager {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		MoneyManager moneymanager=new MoneyManager(input);
		int num=0;   
		while(num!=5) {                          
			System.out.println("1. Add Money");
			System.out.println("2. Delete Money");
			System.out.println("3. Edit Money");
			System.out.println("4. View Money");
			System.out.println("5. Exit");
			System.out.println("Select one number between 1-5:"); 
			num=input.nextInt();    
			if(num==1)             
				moneymanager.add_money();          
			else if(num==2)         
				moneymanager.delete_money();
			else if(num==3)        
				moneymanager.edit_money();
			else if(num==4)       
				moneymanager.view_money();
			else                  
				continue; 
		}			
	}
}
