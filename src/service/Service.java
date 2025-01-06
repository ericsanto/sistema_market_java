package service;
import  java.util.ArrayList;
import product.Product; 
import java.util.Scanner;
import FinancialBox.FinancialBox;

public class Service {

	ArrayList<Product> listProducts = new ArrayList<Product>();
	//<Product> é o tipo de dado que será salvo no arraylist
	
	public void addProductInArrayList(Product product) {
		
		if (listProducts.isEmpty() && product != null) {
			listProducts.add(product);
			System.out.println("Product successfully added");
		}
		
		for(Product existingProduct : listProducts) {
			if (product != null && product.getProductCode().equals(existingProduct.getProductCode())) {
				System.out.println("Error: Product exist with code.");
				return;
			} 
			
		listProducts.add(product);
		System.out.println("Product successfully added");
				
		}
	}
	
	public void removeProductInArrayList(Scanner scanner) {
		
		scanner.nextLine();
		System.out.print("Code Product: ");
		
		String code = scanner.nextLine();
		
		Product productToRemove = null;
		
		for (Product product : listProducts) {
			if (product.getProductCode().equals(code)){
				productToRemove = product;
				//listProducts.remove(productToRemove);
				break;
			}
			
		}
			
		if(productToRemove != null) {
			listProducts.remove(productToRemove);
			System.out.println("Produto Removido com sucesso!");
		} else {
			System.out.println("Produto não está cadastrado!");
			}
	}
	
	public void ListProductsInArrayList() {
		if (listProducts.isEmpty()) {
			System.out.println("Cannot possible list products. Not product registred in system");
		} else {
			for (Product product : listProducts) {
				product.showDetails();
			}
		}
	}
	
	public Product searchProductInArrayList(Scanner scanner) {
		scanner.nextLine();
		
		System.out.println("Enter a code product");
		
		String productCode = scanner.nextLine();
		
		Product productToSearching = null;
		
		for(Product product : listProducts) {
			if(!listProducts.isEmpty() && product.getProductCode().equals(productCode)) {
				productToSearching = product;
				System.out.println(productToSearching);
			}
		}
		
		if(productToSearching != null) {
			productToSearching.showDetails();
		} else if (listProducts.isEmpty()) {
			System.out.println("List products is empty. To add product in list.");
		} else {
			System.out.println("Does not exist product with code entered.");
		}
		
		return productToSearching;
	}
	
	public void verifyProduct(Product product, Scanner scanner) {
		if(product != null) {
			
			displayMenuUpdateProduct();
						
			int choice = scanner.nextInt();
			
			scanner.nextLine();
			switch(choice) {
			
			case 1:
				System.out.println("Define new a product name.");
				String name = scanner.nextLine();
				product.setName(name);
				System.out.println("Product name redefined.");
				product.showDetails();
				break;
			case 2:
				System.out.println("Define new a product price.");
				double price = scanner.nextInt();
				product.setPrice(price);
				scanner.nextLine();
				System.out.println("Product price redefined.");
				product.showDetails();
				break;
			case 3:
				System.out.println("Define new a product category.");
				String category = scanner.nextLine();
				product.setCategory(category);
				scanner.nextLine();
				System.out.println("Product category redefined.");
				product.showDetails();
				break;
			case 4:
				System.out.println("Define new a product quantity in stock.");
				int quantityInStock = scanner.nextInt();
				product.setStockQuantity(quantityInStock);
				scanner.nextLine();
				System.out.println("Product quantity in stock redefined.");
				product.showDetails();
				break;
				
			case 5:
				System.out.println("Define new a product name.");
				String newName = scanner.nextLine();
				product.setName(newName);
				scanner.nextLine();
				
				System.out.println("Define new a product price.");
				double newPrice = scanner.nextInt();
				product.setPrice(newPrice);
				scanner.nextLine();
				
				System.out.println("Define new a product category.");
				String newCategory = scanner.nextLine();
				product.setCategory(newCategory);
				scanner.nextLine();
				
				System.out.println("Define new a product quantity in stock.");
				int newQuantityInStock = scanner.nextInt();
				product.setStockQuantity(newQuantityInStock);
				scanner.nextLine();
				System.out.println("Product redefined.");
				product.showDetails();
				break;
				
			default:
				System.out.println("Invalid option!");
				break;
			}
		} 
	}
	
	public void updateProductInArrayList(Scanner scanner) {
		Product product = searchProductInArrayList(scanner);
		verifyProduct(product, scanner);
	}
	
	public void displayMenuUpdateProduct() {
		
		System.out.println("Which attribute do you want to update?\n"
				+ "1 - Name\n"
				+ "2 - Price\n"
				+ "3 - Categoty\n"
				+ "4 - Quantity in Stock"
				+ "5 - All");
	}
	
	public void sellProduct(Scanner scanner, FinancialBox finance) {
		
		//System.out.println("Enter product code");
		
		Product product = searchProductInArrayList(scanner);
		
		scanner.nextLine();
		
		if(product == null) {
			System.out.println("Product does not exist");
			return;
		}
		
		if(product.getStockQuantity() > 0) {
			int numberProductInStock = product.getStockQuantity() - 1;
			product.setStockQuantity(numberProductInStock);
			product.showDetails();;
			finance.deposit(product.getPrice());
		}
		
		System.out.println(finance.getBalance());
		
	}
}
