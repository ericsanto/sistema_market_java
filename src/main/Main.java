package main;
import product.Product;
import service.Service;
import java.util.Scanner;
import java.lang.Thread;
import FinancialBox.FinancialBox;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Service service =  new Service();
		
		FinancialBox finance = new FinancialBox(0);
		
		try (Scanner opc = new Scanner(System.in)) {
			while (true) {
				displayMenu();
				try	{
					int choice = opc.nextInt();
					
				switch (choice) {
				case 1:
					Product newProduct = addProduct(opc);
					service.addProductInArrayList(newProduct);
					break;
				case 2:
					service.removeProductInArrayList(opc);
					break;
				case 3: 
					service.ListProductsInArrayList();
					break;
				case 4: 
					service.searchProductInArrayList(opc);
					break;
				case 5:
					service.updateProductInArrayList(opc);
					break;
				case 6:
					System.out.println("Exiting system...");
					Thread.sleep(1000);
					System.out.println("System close!");
					break;
				
				case 7: 
					service.sellProduct(opc, finance);
				default:
					System.out.println("Invalid option!");
					break;
					
					
				}
			
				if (choice >= 6) {
					break;
				}
				} catch (Exception e){
					System.out.println("The value digited not is valid. Enter only whole numbers that match "
							+ "the options below");
					opc.nextLine();
					continue;
				}
			}
		}
	}
	
	public static Product addProduct(Scanner scanner) {
		
		scanner.nextLine();
		System.out.println("Enter a product name");
		String nameProduct = scanner.nextLine();
		
		System.out.println("Enter a product category");
		String categoryProduct = scanner.nextLine();
		
		System.out.println("Enter a product code");
		String productCode = scanner.nextLine();
		
		System.out.println("Digite a product value");
		double priceProduct = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("Enter a product quantity in stock");
		int stockQuantityProduct = scanner.nextInt();
		
		Product product = new Product(nameProduct, categoryProduct, priceProduct, stockQuantityProduct, productCode);
		return product;
	}
	
	public static void displayMenu() {
		System.out.println("-----System Academy-----\n"
				+ "1 - To add Product\n"
				+ "2 - Remove Product\n"
				+ "3 - List Products\n"
				+ "4 - Search a Product\n"
				+ "5 - Update Product\n"
				+ "6 - Exit System\n"
				+ "7 - Sell Product");
			System.out.println("Enter one of the options above:");
	}
}


