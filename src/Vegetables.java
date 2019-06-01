import java.text.SimpleDateFormat;
import java.util.Date;

public class Vegetables {
	private String vegetableNumber;
	private String vegetableName;
	private String vegetablePrice;
	private String shelfLife;
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd");
	private String shelfDate;
	public String getVegetableNumber() {
		return vegetableNumber;
	}
	public void setVegetableNumber(String vegetableNumber) {
		this.vegetableNumber = vegetableNumber;
	}
	public String getVegetableName() {
		return vegetableName;
	}
	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}
	public String getVegetablePrice() {
		return vegetablePrice;
	}
	public void setVegetablePrice(String vegetablePrice) {
		this.vegetablePrice = vegetablePrice;
	}
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	public String getShelfDate() {
		return shelfDate;
	}
	public void setShelfDate(String shelfDate) {
		this.shelfDate = shelfDate;
	}
	public Vegetables(String vegetableNumber, String vegetableName, String vegetablePrice, String shelfLife,
			String shelfDate) {
		super();
		this.vegetableNumber = vegetableNumber;
		this.vegetableName = vegetableName;
		this.vegetablePrice = vegetablePrice;
		this.shelfLife = shelfLife;
		this.shelfDate = shelfDate;
	}
	public Vegetables() {
		
	}
}
