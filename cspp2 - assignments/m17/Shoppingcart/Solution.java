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

	String setQuantity(String qty) {
		return this.quantity = qty;
	}

	String setPrice(String price) {
		return this.price = price;
	}

	public String toString() {
		return name + "," + quantity + "," + price;
	}
}

class ShoppingCart {
	private ArrayList<Item> catalogList;
	private ArrayList<Item> cartList;

	ShoppingCart() {
		catalogList = new ArrayList<>();
		cartList = new ArrayList<>();
	}

	void addToCatalog(Item item) {
		catalogList.add(item);
	}

	void addToCart(Item item) {
		for (Item catalogitem : catalogList) {
			if ((catalogitem.getName()).equals(item.getName())) {
				cartList.add(item);
			}
		}
	}

	void removeFromCart(Item item) {
		for (Item cartitem : cartList) {
			if ((cartitem.getName()).equals(item.getName())) {
				int a = Integer.parseInt(cartitem.getQuantity());
				int b = Integer.parseInt(item.getQuantity());
				int c = a - b;
				cartitem.setQuantity(Integer.toString(c));
			}
		}
	}

	void showCart() {
		for (Item item : cartList) {
			System.out.println(item.getName() + " " + item.getQuantity());
		}

	}

	void showCatalog() {
		for (Item item : catalogList) {
			System.out.println(item.getName() + " " + item.getQuantity() + " " + Double.parseDouble(item.getPrice()));
		}
	}

	void getTotalAmount() {
		System.out.println("see me");
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
				String[] c1 = tokens[1].split(",");
				Item item = new Item(c1[0], c1[1], c1[2]);
				sc.addToCatalog(item);
				break;

			case "catalog":
				sc.showCatalog();
				break;

			case "add":
				String[] c2 = tokens[1].split(",");
				sc.addToCart(new Item(c2[0], c2[1], null));
				break;

			case "show":
				sc.showCart();
				break;

			case "totalAmount":

			case "payableAmount":

			case "remove":
				String[] c3 = tokens[1].split(",");
				sc.removeFromCart(new Item(c3[0], c3[1], null));
				break;

			case "Coupon":

			case "Print":
			}
		}
	}
}