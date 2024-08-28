package test3;

class Product<T1, T2, T3> {
	private T1 seialNumber;
	private T2 brand;
	private T3 price;
	
	public Product(T1 seialNumber, T2 brand, T3 price) {
		this.seialNumber = seialNumber;
		this.brand = brand;
		this.price = price;
	}

	public T1 getSeialNumber() {
		return seialNumber;
	}

	public void setSeialNumber(T1 seialNumber) {
		this.seialNumber = seialNumber;
	}

	public T2 getBrand() {
		return brand;
	}

	public void setBrand(T2 brand) {
		this.brand = brand;
	}

	public T3 getPrice() {
		return price;
	}

	public void setPrice(T3 price) {
		this.price = price;
	}
	
	
}

public class GenericProductTest1 {

	public static void main(String[] args) {
		Product <Long, String, Double> p = new Product<>(112233L, "LG Gram", 1700000.0);
		System.out.println(p.getBrand() + ", " + p.getPrice());
	}

}
