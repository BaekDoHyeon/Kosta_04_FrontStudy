package web.servlet.vo;

public class Product {
	private int productNum;
	private String name;
	private int price;
	private String description;
	
	public Product() { }
	
	public Product(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public Product(int productNum, String name, int price, String description) {
		this.productNum = productNum;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public int getProductNum() {
		return productNum;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [productNum=" + productNum + ", name=" + name + ", price=" + price + ", description="
				+ description + "]";
	}
}
