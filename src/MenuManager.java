import java.util.Scanner;

public class MenuManager {

	public static void main(String[] args) {
		int num=0;
		Scanner input=new Scanner(System.in);
		while(num!=6) {
			System.out.println("1. Add Money");
			System.out.println("2. Delete Money");
			System.out.println("3. Edit Money");
			System.out.println("4. View Money");
			System.out.println("5. Show a Menu");
			System.out.println("6. Exit");
			System.out.println("Select one number between 1-6:");
			num=input.nextInt();
			if(num==1)
				add_money();
			else if(num==2)
				delete_money();
			else if(num==3)
				edit_money();
			else if(num==4)
				view_money();
			else
				continue;
		}
		
		
	}

	

	public static void add_money() {
		Scanner input=new Scanner(System.in);
		System.out.print("Date:");
		String date=input.next();
		System.out.print("income:");
		int income=input.nextInt();
		System.out.print("expenditure:");
		int expenditure=input.nextInt();
		int total_money=income-expenditure;
		System.out.printf("total money : %dwon\n",total_money);
		
	}
	
	public static void delete_money() {
		Scanner input=new Scanner(System.in);
		System.out.print("Date:");
		String date=input.next();
	}
	
	public static void edit_money() {
		Scanner input=new Scanner(System.in);
		System.out.print("Date:");
		String date=input.next();
		
	}
	
	public static void view_money() {
		Scanner input=new Scanner(System.in);
		System.out.print("Date:");
		String date=input.next();
		
	}



}
