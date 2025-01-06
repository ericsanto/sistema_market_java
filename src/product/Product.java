package product;

public class Product {
	private String name;
	private String category;
	private double price;
	private int stockQuantity;
	private String productCode;
	
	
	public Product(String name, String category, double price, int stockQuantity, String productCode) {
		setName(name);
		setCategory(category);
		setPrice(price);
		setStockQuantity(stockQuantity);
		setProductCode(productCode);
	};
	
	
	public String getName() {
		return name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		}
	}
	
	public void setStockQuantity(int stockQuantity) {
		if (stockQuantity >= 0) {
			this.stockQuantity = stockQuantity;
		} else {
			System.out.println("The products quantity in stock cannot less zero!");
		}
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public void showDetails() {
		System.out.format("-----------------------------\n"
				+ "Product name: %s\n"
				+ "Category: %s\n"
				+ "Price: %.2f\n"
				+ "Quantity in Stock: %d\n"
				+ "Product code: %s\n"
				+ "-----------------------------\n"
				, name, category, price, stockQuantity, productCode);
	}
	
}
