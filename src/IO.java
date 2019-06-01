import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class IO {
	public static ArrayList<Customer> customerList = new ArrayList();
	public static ArrayList<Owner> ownerList = new ArrayList();
	public static ArrayList<Fruits> fruitList = new ArrayList(); 
	public static ArrayList<Vegetables> vegetableList = new ArrayList(); 
	public static ArrayList<Cart> cartList = new ArrayList(); 
	public static ArrayList<User> userList = new ArrayList();
	
	public void readFile() throws IOException{
		String len1 = null;
		String len2 = null;
		String len3 = null;
		String len4 = null;
		String len5 = null;
		String len6 = null;
		try {
			BufferedReader br1 = new BufferedReader(new FileReader("Customers.txt"));
			while((len1=br1.readLine())!= null) {
				String[] str1 = len1.split(",");
					Customer cu = new Customer(str1[0], str1[1], str1[2], str1[3], str1[4], str1[5], str1[6]);
					customerList.add(cu);

			}
			br1.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BufferedReader br2 = new BufferedReader(new FileReader("Owner.txt"));
			try {
				while((len2=br2.readLine())!= null) {
					String[] str2 = len2.split(",");
					Owner owner = new Owner(str2[0], str2[1]);
					ownerList.add(owner);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			br2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��fruits
		try {
			BufferedReader br3 = new BufferedReader(new FileReader("Fruits.txt"));
			try {
				while((len3=br3.readLine())!=null) {
					String[] str3 = len3.split(",");
					Fruits fr = new Fruits(str3[0], str3[1], str3[2], str3[3], str3[str3.length-1]);
					fruitList.add(fr);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			br3.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//��vegetables
		BufferedReader br4 = new BufferedReader(new FileReader("Vegetables.txt"));
		while((len4=br4.readLine())!=null) {
			String[] str4 = len4.split(",");
			Vegetables v = new Vegetables(str4[0], str4[1], str4[2], str4[3], str4[4]);
			vegetableList.add(v);
		}
		br4.close();
		//��cart
		try {
			BufferedReader br5 = new BufferedReader(new FileReader("Cart.txt"));
			try {
				while((len5=br5.readLine())!=null) {
					String[] str5 = len5.split(",");
					Cart c = new Cart(str5[0], str5[1], str5[2], str5[3], str5[4]);
					cartList.add(c);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			br5.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//��user
		BufferedReader br6 = new BufferedReader(new FileReader("User.txt"));
		while((len6=br6.readLine())!=null) {
			String[] str6 = len6.split(",");
			User u = new User(str6[0], str6[1]);
			userList.add(u);
		}
		br6.close();
	}
}
