import java.util.Scanner;

public class MFVplatform {

	public static void main(String[] args) {
		Welcome();
		//OwnerHome oh = new OwnerHome();
		//oh.addProducts();
		//oh.OHShow();
		//oh.viewProducts();
	}
	
	public static void Welcome() {
		Scanner sc = new Scanner(System.in);
		FunctionRepository fr1 = new CustomerHome();
		FunctionRepository fr2 = new OwnerHome();
		while(true) {
			System.out.println("Welcom to MFV platform, Please follow the prompts below: ");
			System.out.println("1. Customer log in");
			System.out.println("2. MFV owner log in ");
			System.out.println("3. New Customer Register");
			System.out.println("4. Exit");
			String enter = sc.nextLine();
			switch(enter) {
			case "1":
				fr1.logIn();
				((CustomerHome) fr1).CHShow();
				break;
				
			case "2":
				fr2.logIn();
				((OwnerHome) fr2).OHShow();
				break;
				
			case "3":
				fr1.reigister();
				//((CustomerHome) fr1).CHShow();
				Welcome();
				break;
				
			case "4":
				System.out.println("Thanks for using, see you next time! ");
				System.exit(0);
			
			default:
				System.out.println("wrong input, please try again!");
				break;
			}
			
	}

}
}
