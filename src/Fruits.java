import java.text.SimpleDateFormat;
import java.util.Date;

public class Fruits {
	private String fruitNumber;
	private String fruitName;
	private String fruitPrice;
	//private String currentDate;
	private String shelfLife;
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd");
	private String shelfDate = sdf.format(d);
	//private String expireDate = String.valueOf(Integer.parseInt(currentDate) + 7);
	//currentDate + shelfLife 27/08 05/09  (31-27)+05
	//if(��ǰʱ��>�ϼ�ʱ��){
	//�ϼ�ʱ�� + �ϼ��������� - ��ǰʱ�� < 3�� �� ��ʼ����
	//}else if(��ǰʱ��<�ϼ�ʱ��){
//	  �ϼ��������� - ((31-�ϼ�ʱ��)+��ǰʱ��) < 3�죺 ��ʼ����
//
//	}
	//
	//
	//
	public Fruits(String fruitNumber, String fruitName, String fruitPrice, String shelfDate, String shelfLife) {
		super();
		this.fruitNumber = fruitNumber;
		this.fruitName = fruitName;
		this.fruitPrice = fruitPrice;
		this.shelfDate = shelfDate;
		this.shelfLife = shelfLife;
	}
	public Fruits() {
	}
	public String getFruitNumber() {
		return fruitNumber;
	}
	public void setFruitNumber(String fruitNumber) {
		this.fruitNumber = fruitNumber;
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public String getFruitPrice() {
		return fruitPrice;
	}
	public void setFruitPrice(String fruitPrice) {
		this.fruitPrice = fruitPrice;
	}
	public String getShelfDate() {
		return shelfDate;
	}
	public void setShelfDate(String shelfDate) {
		this.shelfDate = shelfDate;
	}
	public String getshelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
}
