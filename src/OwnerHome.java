import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OwnerHome implements FunctionRepository {
	Scanner sc = new Scanner(System.in);
	Validation check = new Validation();
	MFVplatform mp = new MFVplatform();
	Fruits f = new Fruits();
	IO o = new IO();

	public void OHShow() {
		while (true) {
			System.out.println("Welcome owner");
			System.out.println("------------------------------");
			System.out.println("1.Add products to the shelf");
			System.out.println("2.Edit products from the shelf");
			System.out.println("3.remove products");
			System.out.println("4.view products");
			System.out.println("5.view registered customer");
			System.out.println("6.remove Registered Cusomer");
			System.out.println("7.back to main menu");
			String enterInput = sc.nextLine();
			switch (enterInput) {
			case "1":
				addProducts();
				break;
			case "2":
				editProducts();
				break;
			case "3":
				removeProducts();
				break;
			case "4":
				viewProducts();
				break;
			case "5":
				viewRegisteredCustomer();
				break;
			case "6":
				removeRegisterCusomer();
				break;
			case "7":
				mp.Welcome();
				break;
			default:
				System.out.println("wrong input, please follow the instruction��");
				break;
			}

		}
	}

	@Override
	public void addProducts() {
		boolean flag = true;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		String typeId = null;
		String productName = null;
		String productPrice = null;
		String productShelfLife = null;
		while (flag) {
			System.out.println("---------------add Products---------------");
			System.out.println("please enter product type_id (1:fruits, 2:vegetables)");
			typeId = sc.nextLine();
			while (true) {
				if ((typeId.equals("1") || typeId.equals("2"))) {
					flag = false;
					break;
				} else {
					System.out.println("wrong input, must input 1 or 2 (1:fruits, 2: vegetables)");
					break;
				}
			}
		}
		while (flag1) {
			System.out.println("please enter Product Name");
			productName = sc.nextLine();
			while (true) {
				if (check.addCheck(productName)) {
					flag1 = false;
					break;
				} else {
					System.out.println("wrong input, please check the input format");
					break;
				}
			}

		}
		while (flag2) {
			System.out.println("please enter Product Price");
			productPrice = sc.nextLine();
			while (true) {
				if (check.priceCheck(productPrice)) {
					flag2 = false;
					break;
				} else {
					System.out.println("wrong input, please check the input format");
					break;
				}
			}
		}
		while (flag3) {
			System.out.println("please enter Product shelf life (0-99)days");
			productShelfLife = sc.nextLine();
			while (true) {
				if (check.shelfLifeCheck(productShelfLife)) {
					System.out.println("add products successfully");
					flag3 = false;
					break;
				} else {
					System.out.println("wrong input, please check the input format");
					break;
				}
			}
		}
		if (typeId.equals("1")) {
			try {
				FileWriter fw = new FileWriter("Fruits.txt",false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				BufferedWriter bw1 = new BufferedWriter(new FileWriter("Fruits.txt", true));
				for(int i=0;i<o.fruitList.size();i++) {
					bw1.write(o.fruitList.get(i).getFruitNumber() + "," + o.fruitList.get(i).getFruitName() + "," + o.fruitList.get(i).getFruitPrice() + "," + o.fruitList.get(i).getShelfDate() + "," + o.fruitList.get(i).getshelfLife());
					bw1.newLine();

				}
				bw1.flush();
				Fruits fNew = new Fruits(typeId, productName, productPrice, f.getShelfDate(), productShelfLife);
					o.fruitList.add(fNew);
				bw1.write(typeId + "," + productName + "," + productPrice + "," + f.getShelfDate() + ","
						+ productShelfLife);
				bw1.newLine();
				bw1.flush();
				bw1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				FileWriter fw = new FileWriter("Vegetables.txt",false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				BufferedWriter bw2 = new BufferedWriter(new FileWriter("Vegetables.txt", true));
				for(int i=0;i<o.vegetableList.size();i++) {
					bw2.write(o.vegetableList.get(i).getVegetableNumber() + "," + o.vegetableList.get(i).getVegetableName() + "," + o.vegetableList.get(i).getVegetablePrice() + "," + o.vegetableList.get(i).getShelfDate() + "," + o.vegetableList.get(i).getShelfLife());
					bw2.newLine();

				}
				bw2.flush();
				Vegetables vNew = new Vegetables(typeId, productName, productPrice, f.getShelfDate(), productShelfLife);
				o.vegetableList.add(vNew);
				bw2.write(typeId + "," + productName + "," + productPrice + "," + f.getShelfDate() + ","
						+ productShelfLife);
				bw2.newLine();
				bw2.flush();
				bw2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
				for(Fruits f:o.fruitList) {
					System.out.println("Fruit name: " + f.getFruitName().toUpperCase() + "   Price: " + f.getFruitPrice() + "   shelfDate: " + f.getShelfDate() + "   lifeTime: " + f.getshelfLife());
					System.out.println("----------------------------------------------------------------------------------");
				}break;
			}else if(inputType.equalsIgnoreCase("2")) {
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
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		String productName = null;
		for(int i=0;i<o.fruitList.size();i++) {
			o.fruitList.remove(i);
		}
		for(int i=0;i<o.vegetableList.size();i++) {
			o.vegetableList.remove(i);
		}
		try {
			o.readFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		OUTER: while (flag1) {
			System.out.println("---------------Edit Products---------------");
			System.out.println("please enter the product type id ('1' or '2' only)!'");
			String typeId = sc.nextLine();
			while (true) {
				if ((typeId.equals("1") || typeId.equals("2"))) {
					// flag1 = false;
					break;
				} else {
					System.out.println("wrong input, must input 1 or 2 (1:fruits, 2: vegetables), try again");
					return;
				} // break;
			}
			while (flag2) {
				System.out.println("please enter Product Name");
				productName = sc.nextLine();
				OUT: while (flag3) {
					if (check.addCheck(productName)) {
						if (typeId.equals("1")) {
							for (Fruits f : o.fruitList) {
								if (productName.equals(f.getFruitName())) {
									System.out.println("Find successfully, please edit");
									while (true) {
										System.out.println("change " + f.getFruitName() + "'s price: ");
										String fruitPrice = sc.nextLine();
										if (check.priceCheck(fruitPrice)) {
											f.setFruitPrice(fruitPrice);
											flag1 = false;
											flag2 = false;
											flag3 = false;
											break;
										} else {
											System.out.println("wrong format, try again");
										}

									}
									while (true) {
										System.out.println("change " + f.getFruitName() + "'s shelfDate: ");
										System.out.println("If you want refresh shelfDate? (Y or N)");
										String enterDate = sc.nextLine();
										if (enterDate.equalsIgnoreCase("Y")) {
											System.out.println("ShelfDate has already been refreshed");
											f.setShelfDate(f.getShelfDate());
											break;
										} else if (enterDate.equalsIgnoreCase("N")) {
											System.out.println("ShelfDate reamin the original one");
											break;
										} else {
											System.out.println("wrong input, try again");
										}
									}
									while (true) {
										System.out.println("change " + f.getFruitName() + "'s shelfLife: ");
										String shelfLife = sc.nextLine();
										if (check.shelfLifeCheck(shelfLife)) {
											f.setShelfLife(shelfLife);
											flag1 = false;
											flag2 = false;
											flag3 = false;
											try {
												FileWriter fw = new FileWriter("Fruits.txt",false);
//												fw.flush();
//												fw.close();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											try {
												BufferedWriter bw = new BufferedWriter(
														new FileWriter("Fruits.txt", true));
												for (Fruits newF : o.fruitList) {
													bw.write(newF.getFruitNumber() + "," + newF.getFruitName() + ","
															+ newF.getFruitPrice() + "," + newF.getShelfDate() + ","
															+ newF.getshelfLife());
													bw.newLine();
												}
												bw.flush();
												bw.close();
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											System.out.println("Edit products finish.");
											break OUTER;
										} else {
											System.out.println("wrong format, try again");
										}
									}
								} else {
									if (o.fruitList.indexOf(f) == o.fruitList.size() - 1) {
										System.out.println("cannot find the certain products, try again");
										break OUT;
									}
								}
							}
						} else {
							for (Vegetables v : o.vegetableList) {
								if (productName.equals(v.getVegetableName())) {
									System.out.println("Find successfully, please edit");
									while (true) {
										System.out.println("change " + v.getVegetableName() + "'s price: ");
										String vegetablePrice = sc.nextLine();
										if (check.priceCheck(vegetablePrice)) {
											f.setFruitPrice(vegetablePrice);
											break;
										} else {
											System.out.println("wrong format, try again");
										}

									}
									while (true) {
										System.out.println("change " + v.getVegetableName() + "'s shelfDate: ");
										System.out.println("If you want refresh shelfDate? (Y or N)");
										String enterDate = sc.nextLine();
										if (enterDate.equalsIgnoreCase("Y")) {
											System.out.println("ShelfDate has already been refreshed");
											v.setShelfDate(v.getShelfDate());
											break;
										} else if (enterDate.equalsIgnoreCase("N")) {
											System.out.println("ShelfDate reamin the original one");
											break;
										} else {
											System.out.println("wrong input, try again");
										}
									}
									while (true) {
										System.out.println("change " + v.getVegetableName() + "'s shelfLife: ");
										String shelfLife = sc.nextLine();
										if (check.shelfLifeCheck(shelfLife)) {
											v.setShelfLife(shelfLife);
											try {
												FileWriter fw = new FileWriter("Vegetables.txt",false);
												fw.flush();
												fw.close();
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											try {
												BufferedWriter bw = new BufferedWriter(
														new FileWriter("Vegetables.txt", true));
												for (Vegetables newV : o.vegetableList) {
													bw.write(newV.getVegetableNumber() + "," + newV.getVegetableName()
															+ "," + newV.getVegetablePrice() + "," + newV.getShelfDate()
															+ "," + newV.getShelfLife());
													bw.newLine();
												}
												bw.flush();
												bw.close();
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											System.out.println("Edit products finish.");
											break OUTER;
										} else {
											System.out.println("wrong format, try again");
										}
									}
								} else {
									if (o.vegetableList.indexOf(v) == o.vegetableList.size() - 1) {
										System.out.println("cannot find the certain products, try again");
										break OUT;
									}
								}
							}
						}
					} else {
						System.out.println("wrong input, please check the input format");
						break OUT;
					}
				}

			}

		}

	}

	@Override
	public void removeProducts() {
		String inputName1 = null;
		String inputName2 = null;
		String typeInput = null;
		OUT:
		while(true) {
			System.out.println("---------------Remove Products---------------");
			System.out.println("please enter product type_id (1:fruits, 2:vegetables)");
			typeInput = sc.nextLine();
			if(typeInput.equals("1")) {
				System.out.println("please enter the name of certain fruit, enter 'q' to cancel remove action");
				inputName1 = sc.nextLine();
				if(inputName1.equalsIgnoreCase("q")) {
					return;
				}else {
					for(Fruits f : o.fruitList) {
						if(inputName1.equalsIgnoreCase(f.getFruitName())) {
							o.fruitList.remove(o.fruitList.indexOf(f));
							System.out.println("find it, delete successfully");
							System.out.println();
							try {
								FileWriter fw = new FileWriter("Fruits.txt",false);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							try {
								BufferedWriter bw1 = new BufferedWriter(new FileWriter("Fruits.txt",true));
								for(Fruits f1 : o.fruitList) {
									bw1.write(f1.getFruitNumber() + "," + f1.getFruitName() + "," + f1.getFruitPrice() + "," + f1.getShelfDate() + "," + f1.getshelfLife());
									bw1.newLine();
								}
								bw1.flush();
								bw1.close();	
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break OUT;
						}else {
							if(o.fruitList.indexOf(f)==o.fruitList.size()-1) {
								System.out.println("cannot find the certain fruits");
							}
							
						}
					}

				}

			}else if(typeInput.equals("2")) {
				System.out.println("please enter the name of certain fruit, enter 'q' to cancel remove action");
				inputName2 = sc.nextLine();
				if(inputName2.equalsIgnoreCase("q")) {
					return;
				}else {
				}
				for(Vegetables v : o.vegetableList) {
					if(inputName2.equalsIgnoreCase(v.getVegetableName())) {
						o.vegetableList.remove(o.vegetableList.indexOf(v));
						System.out.println("find it can delete successfully");
						try {
							FileWriter fw = new FileWriter("Vegetables.txt",false);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter("Vegetables.txt",true));
							for(Vegetables v1:o.vegetableList) {
								bw.write(v1.getVegetableNumber() + "," + v1.getVegetableName() + "," + v1.getVegetablePrice() + "," + v1.getShelfDate() + "," + v1.getShelfLife());
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
						if(o.vegetableList.indexOf(v)==o.vegetableList.size()-1) {
							System.out.println("cannot find the certain vegetable");
							//break;
						}
						
					}
				}		
			}else {
				System.out.println("wrong input, try again");
			}
		}
		
		
	}

	@Override
	public void removeRegisterCusomer() {
		OUT:
		while(true) {
			System.out.println("---------------Remove registered customer---------------");
			System.out.println("enter '1' to view all registered customer");
			System.out.println("enter '2' to remove registered customer");
			String enterInput = sc.nextLine();
			if(enterInput.equals("1")) {
				for(Customer c:o.customerList) {
					System.out.println("customr ID: " + c.getUserId() + "   customer name: " + c.getFirstName() +" "+ c.getLastName() + "   customer email: " + c.getEmail());
					System.out.println("--------------------------------------------------------");
					if(o.customerList.indexOf(c)==o.customerList.size()-1) {
						break;
					}
				}
			}else if(enterInput.equals("2")) {
				while(true) {
					System.out.println("please enter customerID that you want to remove");
					String idInput = sc.nextLine();
					for(Customer c: o.customerList) {
						if(idInput.equalsIgnoreCase(c.getUserId())) {
							o.customerList.remove(o.customerList.indexOf(c));
							System.out.println("remove the certain customer information successfully");
							try {
								FileWriter f = new FileWriter("Customers.txt",false);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								BufferedWriter bf = new BufferedWriter(new FileWriter("Customers.txt",true));
								for(int i=0;i<o.customerList.size();i++) {
									bf.write(o.customerList.get(i).getUserId() + "," + o.customerList.get(i).getPassword() + "," + o.customerList.get(i).getFirstName() + "," + o.customerList.get(i).getLastName() + "," + o.customerList.get(i).getPhoneNumber() + "," + o.customerList.get(i).getAddress() + "," + o.customerList.get(i).getEmail());
									bf.newLine();
								}
								bf.flush();
								bf.close();
							}catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							try {
								FileWriter f1 = new FileWriter("User.txt",false);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								BufferedWriter bf1 = new BufferedWriter(new FileWriter("User.txt",true));
								for(int i=0;i<o.userList.size();i++) {
									if(idInput.equalsIgnoreCase(o.userList.get(i).getUserId())) {
										o.userList.remove(o.userList.indexOf(o.userList.get(i)));
									}else {
										bf1.write(o.userList.get(i).getUserId() + "," + o.userList.get(i).getPassword());
										bf1.newLine();
									}
									
								}
								bf1.flush();
								bf1.close();
							}catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break OUT;
						}else {
							if(o.customerList.indexOf(c)==o.customerList.size()-1) {
								System.out.println("cannot found the certain customer, please try again!");
							}	
						}
					}
				}
			}else {
				System.out.println("wrong input, try again!");
			}
		}
	}

	@Override
	public void reigister() {

	}

	@Override
	public void purchase() {

	}

	@Override
	public void unRegister() {

	}

	@Override
	public void logIn() {
		boolean flag = true;
		boolean flag1 = true;
		while (flag) {
			System.out.println("----------------Owner log in---------------");
			System.out.println("please enter your userId");
			Scanner sc = new Scanner(System.in);
			String userNameInput = sc.nextLine();
			while (flag1) {
				if (check.idCheck(userNameInput)) {
					System.out.println("please enter your password");
					String passwordInput = sc.nextLine();
					if (check.psCheck(passwordInput)) {
						// flag1 = false;
						// flag = false;
						try {
							o.readFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						for (Owner o : IO.ownerList) {
							String ownerIdSave = o.getUserId();
							String passwordSave = o.getPassword();
							if (userNameInput.equals(ownerIdSave) && passwordInput.equals(passwordSave)) {
								System.out.println("log in successfully!");
								flag = false;
								break;
							} else {
								if (IO.ownerList.indexOf(o) == IO.ownerList.size() - 1) {
									System.out.println(
											"Either of userName or password is wrong, please check input and try again ");
									break;
								}

							}
						}
					} else {
						System.out.println("your input format is wrong, please try again!");
						break;
					}
				} else {
					System.out.println("your input format is wrong, please try again!");
					break;
				}
				break;

			}

		}
		OHShow();
	}

	@Override
	public void searchProducts() {
		// TODO Auto-generated method stub

	}

	public void viewRegisteredCustomer() {
		boolean flag = true;
		while (flag) {
			System.out.println("---------------view registered customer---------------");
			System.out.println("show below");
			for (Customer c : o.customerList) {
				if (o.customerList.indexOf(c) < o.customerList.size()) {
					System.out.println("customr ID: " + c.getUserId() + "   customer name: " + c.getFirstName() + " "
							+ c.getLastName() + "   customer email: " + c.getEmail());
					System.out.println("--------------------------------------------------------");
				}
				flag = false;
			}

		}

	}
	}
