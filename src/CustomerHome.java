import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//import javax.swing.plaf.synth.SynthSpinnerUI;

public class CustomerHome implements FunctionRepository {
	Scanner sc = new Scanner(System.in);
	IO o = new IO();
	Validation check = new Validation();
	MFVplatform mp = new MFVplatform();
	static String userNameInput = null;
	Customer c = new Customer();
	
	public void CHShow() {
		while (true) {
			System.out.println("Welcome Customer! ");
			System.out.println("Please follow the prompts below to manipulate: ");
			System.out.println("1. view products ");
			System.out.println("2. Search products ");
			System.out.println("3. view cart");
			System.out.println("4. unregister your account");
			System.out.println("5. add products to your cart");
			System.out.println("6. back to main menu");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			switch (input) {
			case "1":
				viewProducts();
				break;

			case "2":
				searchProducts();
				break;

			case "3":
				viewCart();
				break;

			case "4":
				unRegister();
				break;

			case "5":
				addProducts();
				break;
				
			case "6":
				mp.Welcome();
				break;

			default:
				System.out.println("wrong input try again");
				break;
			}
		}

	}
	@Override
	public void addProducts() {
		OUT:
		while(true) {
			System.out.println("---------------add products to your cart---------------");
			System.out.println("please enter product typeID (1:fruit,2:vegetable,q:back to customerHome menu): ");
			String inputType = sc.nextLine();
			if(inputType.equals("1")) {
				System.out.println("please enter the name of fruit you want to add to your cart");
				String fruitNameInput = sc.nextLine();
				for(Fruits f:o.fruitList) {
					if(fruitNameInput.equalsIgnoreCase(f.getFruitName())) {
						while(true) {
							System.out.println("please enter the amount of this fruit to your cart");
							String amountInput = sc.nextLine();
							if(check.amnCheck(amountInput)) {
								try {
									BufferedWriter bw = new BufferedWriter(new FileWriter("Cart.txt",true));
									bw.write(userNameInput + "," + f.getFruitName() + "," + f.getShelfDate() + "," + amountInput + "," + f.getFruitPrice());
									bw.newLine();
									bw.flush();
									bw.close();
									System.out.println("add to your account cart successfully");
									break OUT;
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}else {
								System.out.println("wrong input only accept 1 to 4 digits, the first digit must not '0',try again");
							}
						}	
					}else {
						if(o.fruitList.indexOf(f)==o.fruitList.size()-1) {
							System.out.println("this fruit cannot found in MFV");
						}
						
					}
				}
			}else if(inputType.equals("2")) {
				System.out.println("please enter the name of vegetable you want to add to your cart");
				String fruitNameInput = sc.nextLine();
				for(Vegetables v:o.vegetableList) {
					if(fruitNameInput.equalsIgnoreCase(v.getVegetableName())) {
						while(true) {
							System.out.println("please enter the amount of this vegetable to your cart");
							String amountInput = sc.nextLine();
							if(check.amnCheck(amountInput)) {
								try {
									BufferedWriter bw = new BufferedWriter(new FileWriter("Cart.txt",true));
									bw.write(userNameInput + "," + v.getVegetableName() + "," + v.getShelfDate() + "," + amountInput + "," +  String.valueOf(v.getVegetablePrice()));
									bw.newLine();
									bw.flush();
									bw.close();
									System.out.println("add to your account cart successfully");
									break OUT;
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}else {
								System.out.println("wrong input only accept 1 to 4 digits, the first digit must not '0',try again");
							}
						}	
					}else {
						if(o.vegetableList.indexOf(v)==o.vegetableList.size()-1) {
							System.out.println("this fruit cannot found in MFV");
						}
						
					}
				}
			}else if(inputType.equalsIgnoreCase("q")){
				break OUT;
			}
			else {
				System.out.println("Wrong input, only accept '1', '2' or 'q', try again");
			}
		}
	}

	@Override
	public void viewProducts() {
		while(true) {
			System.out.println("---------------view Products---------------");
			System.out.println("please enter typeId (1:fruit, 2:vegetables) to view each kinds of products");
			String inputType = sc.nextLine();
			if(inputType.equalsIgnoreCase("1")){
				System.out.println("All fruits list show below: ");
				try {
					o.readFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Fruits f:o.fruitList) {
					System.out.println("Fruit name: " + f.getFruitName().toUpperCase() + "   Price: " + f.getFruitPrice() + "   shelfDate: " + f.getShelfDate() + "   lifeTime: " + f.getshelfLife());
					System.out.println("----------------------------------------------------------------------------------");
				}break;
			}else if(inputType.equalsIgnoreCase("2")) {
				try {
					o.readFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Vegetables v:o.vegetableList) {
					System.out.println("Vegetable name: " + v.getVegetableName().toUpperCase() + "   Price: " + v.getVegetablePrice() + "   shelfDate: " + v.getShelfDate() + "   lifeTime: " + v.getShelfLife());
					System.out.println("----------------------------------------------------------------------------------");
				}break;
			}else {
				System.out.println("wrong input, please enter (1:fruit, 2:vegetables) only");
				break;
			}
		}

	}

	@Override
	public void editProducts() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeProducts() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRegisterCusomer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void logIn() {
		boolean flag = true;
		boolean flag1 = true;
		while(flag) {
			System.out.println("----------------Customer log in---------------");
			System.out.println("please enter your userId");
			Scanner sc = new Scanner(System.in);
			userNameInput = sc.nextLine();
			while(flag1) {
				if(check.idCheck(userNameInput)) {
					System.out.println("please enter your password");
					String passwordInput = sc.nextLine();
					if(check.psCheck(passwordInput)) {
						try {
							o.readFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						for(Customer c: o.customerList) {
							String userIdSave = c.getUserId();
							String passwordSave = c.getPassword();
							if(userNameInput.equals( userIdSave)&& passwordInput.equals(passwordSave)) {
								System.out.println("log in successfully!");
								System.out.println();
								flag = false;
								break;
							}else {
								if(o.customerList.indexOf(c)==o.customerList.size()-1) {
									System.out.println("Either of userName or password is wrong, please check input and try again ");
								}
								//break;
							}
						}
					
				
					}else {
						System.out.println("your input format is wrong, please try again!");
						break;
					}
					}else {
						System.out.println("your input format is wrong, please try again!");
						break;
						}
				break;
				
			}
			
			
			
		}

	}

	@Override
	public void reigister() {
		boolean flag = true;
		boolean flag1 = true;
		Scanner sc = new Scanner(System.in);
		String idInput = null;
		String pasInput = null;
		String FirstNameInput = null;
		String lastNameInput = null;
		String phoneInput = null;
		String addressInput = null;
		String emailInput = null;
		System.out.println("---------------Register---------------");
		OUT:
		while(flag) {
			System.out.println("Please enter your userId");
			idInput = sc.nextLine();
			if(check.idCheck(idInput)) {
				try {
					o.readFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(User u: o.userList) {
					if(idInput.equals(u.getUserId())) {
						System.out.println("This userId has already registered, please try enter another one!");
						System.out.println();
						//flag1 = false;
						return;
					}else {
						if(o.userList.indexOf(u)==o.userList.size()-1) {
							//flag1 = true;
							
						}
					}
				}
				break;
				//flag = true;
			}else {
				System.out.println("Your userId must be '4' digits, please try again!");
			}
			
		}
		while(true) {
			System.out.println("please enter your password");
			pasInput = sc.nextLine();
			if(check.psCheck(pasInput)) {
				break;
			}else {
				System.out.println("Your password must be (3-6) letters and numbers, please try again!");
			}
		}
		while(true) {
			System.out.println("please enter your firstName");
			FirstNameInput = sc.nextLine();
			if(check.nameCheck(FirstNameInput)) {
				break;
			}else {
				System.out.println("Your firstName must be  letters, please try again!");
			}
		}
		while(true) {
			System.out.println("please enter your lastName");
			lastNameInput = sc.nextLine();
			if(check.nameCheck(lastNameInput)) {
				break;
			}else {
				System.out.println("Your lastName must be letters, please try again!");
			}
		}
		while(true) {
			System.out.println("please enter your phoneNumber");
			phoneInput = sc.nextLine();
			if(check.phnCheck(phoneInput)) {
				break;
			}else {
				System.out.println("Your phoneNumber must be 10 numbers, please try again!");
			}
		}
		while(true) {
			System.out.println("please enter your address");
			addressInput = sc.nextLine();
			if(check.addCheck(addressInput)) {
				break;
			}else {
				System.out.println("Address only contain numbers and letters, please try again!");
			}
		}
		while(true) {
			System.out.println("please enter your email address");
			emailInput = sc.nextLine();
			if(check.emailCheck(emailInput)) {
				System.out.println("your account has been created successfully, please log in");
				System.out.println();
				break;
			}else {
				System.out.println("Your email address format is wrong, please try again!");
			}
		}
		//Customer cu = new Customer(idInput, pasInput, FirstNameInput, lastNameInput, phoneInput, addressInput, emailInput);
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter("Customers.txt", true));
			bf.write(idInput + "," + pasInput + "," + FirstNameInput + "," + lastNameInput + "," + phoneInput + "," + addressInput + "," + emailInput);
			bf.newLine();
			bf.flush();
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("User.txt",true));
			bw.write(idInput + "," + pasInput);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void purchase() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unRegister() {
		OUT:
		while(true) {
			System.out.println("---------------- unregister your account -----------------");
			System.out.println("Are you sure to unregister your account from MFV system? (Y/N)");
			String input = sc.nextLine();
			if(input.equalsIgnoreCase("Y")) {
				for(int i=0;i<o.customerList.size();i++) {
					if(userNameInput.equalsIgnoreCase(o.customerList.get(i).getUserId())) {
						o.customerList.remove(o.customerList.get(i));
						System.out.println("your account: " + " " + userNameInput + "has been remove successfully");
						System.out.println();
						try {
							FileWriter fw = new FileWriter("Customers.txt",false);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter("Customers.txt",true));
							for(Customer cc: o.customerList) {
								//String userId, String password, String firstName, String lastName, String phoneNumber, String address, String email
								bw.write(cc.getUserId() + "," + cc.getPassword() + "," + cc.getFirstName() + "," + cc.getLastName() + "," + cc.getPhoneNumber() + "," + cc.getAddress() + "," + cc.getEmail());
								bw.newLine();
							}
							bw.flush();
							bw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							FileWriter fw = new FileWriter("User.txt",false);
							for(int j=0;j<o.userList.size();j++) {
								if(o.userList.get(j).getUserId().equalsIgnoreCase(userNameInput)) {
									o.userList.remove(j);
								}
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter("User.txt",true));
							for(User u: o.userList) {
								//String userId, String password, String firstName, String lastName, String phoneNumber, String address, String email
								bw.write(u.getUserId() + "," + u.getPassword());
								bw.newLine();
							}
							bw.flush();
							bw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							FileWriter fw = new FileWriter("Cart.txt",false);
							for(int k=0;k<o.cartList.size();k++) {
								if(o.cartList.get(k).getUserName().equals(userNameInput)) {
									o.cartList.remove(k);
								}
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter("Cart.txt",true));
							for(Cart c:o.cartList) {
								bw.write(c.getUserName() + "," + c.getProductName() + "," + c.getProductDate() + "," + c.getProductNumber() + "," + c.getProductPrice());
								bw.newLine();
							}
							bw.flush();
							bw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break OUT;
					}else {
						if(o.customerList.indexOf(o.customerList.get(i))==o.customerList.size()-1) {
							System.out.println("your account has already removed, now bring you to main menu");
							System.out.println();
							mp.Welcome();
						}
						
					}
				}
			}else if (input.equalsIgnoreCase("N")) {
				break;
			}else {
				System.out.println("wrong input, only accept(y/n), try again!");
				System.out.println();
			}
		}
		
		

}
	//cart
	@Override
	public void searchProducts() {
		while(true) {
			System.out.println("-----------------search products---------------");
			System.out.println("please enter the type_id that you want to search");
			System.out.println("1: fruits  2: vegetbles 'q':quit search page");
			String typeInput = sc.nextLine();
			if(typeInput.equalsIgnoreCase("1")) {
				System.out.println("please enter fruit name that you want to search");
				String nameInput = sc.nextLine();
				for(Fruits f:o.fruitList) {
					if(nameInput.equalsIgnoreCase(f.getFruitName())) {
						System.out.println("Find it, show below");
						System.out.println("Fruit name: " + f.getFruitName() + "  Fruit price: " + f.getFruitPrice() + "  Fruit shelflife: " + f.getshelfLife());
						break;
					}else {
						if(o.fruitList.indexOf(f)==o.fruitList.size()-1) {
							System.out.println("Cannot find the certain fruit! ");
							break;
						}
						
						//break;
					}
				}
			}else if(typeInput.equalsIgnoreCase("2")) {
				System.out.println("please enter vegetable name that you want to search");
				String nameInput = sc.nextLine();
				for(Vegetables v:o.vegetableList) {
					if(nameInput.equalsIgnoreCase(v.getVegetableName())) {
						System.out.println("Find it, show below");
						System.out.println("Vegetable name: " + v.getVegetableName() + "  Vegetable price: " + v.getVegetablePrice() + "  Vegetable shelflife: " + v.getShelfLife());
						break;
					}else {
						System.out.println("Cannot find the certain vegetable! ");
						break;
					}
				}
			}else if(typeInput.equalsIgnoreCase("q")){
				break;
			}else {
				System.out.println("wrong input! only accept( 1: fruits  2: vegetbles ), please try again");
				System.out.println();
			}
		}
		
	}
	
	public void viewCart() {
		for(int i=0; i<o.fruitList.size();i++) {
			o.fruitList.remove(o.fruitList.get(i));
		}
		for(int i=0;i<o.vegetableList.size();i++) {
			o.vegetableList.remove(o.vegetableList.get(i));
		}
		for(int i=0;i<o.cartList.size();i++) {
			o.cartList.remove(o.cartList.get(i));
		}
		for(int i=0;i<o.userList.size();i++) {
			o.userList.remove(o.userList.get(i));
		}
		for(int i=0;i<o.customerList.size();i++) {
			o.customerList.remove(o.customerList.get(i));
		}
		for(int i=0;i<o.ownerList.size();i++) {
			o.ownerList.remove(o.ownerList.get(i));
		}
		try {
			o.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = true;
		//public Cart(String userName, String productName, String productDate, String productNumber)
		OUT:
		while(flag) {
			for(Customer c: o.customerList ) {
				if(userNameInput.equals(c.getUserId())) {
					for(Cart cc:o.cartList) {
						if(userNameInput.equals(cc.getUserName())){
							System.out.println("your account:" + " " + cc.getUserName() + " productName: " + " " + cc.getProductName() + " productShelfDate: " + cc.getProductDate() + " theAmountOfProduct: " + cc.getProductNumber() + " productPrice(each): " + cc.getProductPrice());
							System.out.println();
							flag = false;
						}else {
							if(o.cartList.indexOf(cc)==o.cartList.size()-1) {
								System.out.println("Nothing found from your cart! bring you to customer home");
								System.out.println();
								break OUT;
							}
							
						}
					}
				}else {
					if(o.customerList.indexOf(c)==o.customerList.size()-1) {
						System.out.println("You have already delete your account, please create a new account to manipulate your cart");
						System.out.println("Now, bring you to main menu");
						mp.Welcome();
					}
					
				}
			}
		}
	}
	
	public void viewRegisteredCustomer() {
		
	}

}
