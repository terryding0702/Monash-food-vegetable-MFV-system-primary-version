
public class Cart {
	private String userName;
	private String productName;
	private String productDate;
	private String productNumber;
	private String productPrice;
	public Cart() {
		
	}
	
	public Cart(String userName, String productName, String productDate, String productNumber, String productPrice) {
		super();
		this.userName = userName;
		this.productName = productName;
		this.productDate = productDate;
		this.productNumber = productNumber;
		this.productPrice = productPrice;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
}
