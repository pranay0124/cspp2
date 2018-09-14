import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Item {

	private String name;
	private String quantity;
	private String price;

	Item(String name, String quantity, String price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	String getName() {
		return name;
	}

	String getQuantity() {
		return quantity;
	}

	String getPrice() {
		return price;
	}

	public String toString() {
		return name + "," + quantity + "," + price;
	}
}

class ShoppingCart {
	private ArrayList<Item> catalogList;
	private ArrayList<String> cartList;

	ShoppingCart() {
		catalogList = new ArrayList<>();
		cartList = new ArrayList<>();
	}

	void addToCatalog(Item item) {
		catalogList.add(item);
		System.out.println(catalogList);
	}

	void addToCart() {

	}

	void removeFromCart() {

	}

	void showCart() {

	}

	void showCatalog() {

	}

	void getTotalAmount() {

	}

	void getPayableAmount() {

	}

	void applyCoupon() {

	}

	void printInvoice() {

	}
}

class Solution {
	public static void main(String[] args) {
		ShoppingCart sc = new ShoppingCart();
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testcases; i++) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
				case "Item":
					String[] check = tokens[1].split(",");
					sc.addToCatalog(new Item(check[0],check[1],check[2]));
					break;

				case "catalog":

				case "Add":

				case "Show":

				case "totalAmount":

				case "payableAmount":

				case "Remove":

				case "Coupon":

				case "Print":
			}
		}
	}
}