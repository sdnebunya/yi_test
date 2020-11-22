package bean;

public class ShohinBean{
	private String id;
	private String name;
	private int price;
	private int stock;
	private String imageUrl;
	private String lastDate;

	public ShohinBean() {

	}

	public ShohinBean(String id, String name, int price,
			int stock,String imageUrl, String lastDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.imageUrl = imageUrl;
		this.lastDate = lastDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStock() {
		return this.stock;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getLastDate() {
		return this.lastDate;
	}
}