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
	private int coupon = 0;
	private boolean flag = false;

	ShoppingCart() {
		catalogList = new ArrayList<>();
		cartList = new ArrayList<>();
	}

	void addToCatalog(Item item) {
		catalogList.add(item);
	}

	void addToCart(Item item) {
		for (Item logitem : catalogList) {
			if ((logitem.getName()).equals(item.getName())) {
				for (Item cartitem : cartList) {
					if ((cartitem.getName()).equals(item.getName())) {
						int a = Integer.parseInt(cartitem.getQuantity());
						int b = Integer.parseInt(item.getQuantity());
						int c = a + b;
						cartitem.setQuantity(Integer.toString(c));
						return;
					}
				}
				cartList.add(item);
				return;
			}
		}
	}

	void removeFromCart(Item item) {
		for (Item cartitem : cartList) {
			if ((cartitem.getName()).equals(item.getName())) {
				int a = Integer.parseInt(cartitem.getQuantity());
				int b = Integer.parseInt(item.getQuantity());
				int c = a - b;
				if (c == 0) {
					cartList.remove(cartitem);
				} else {
					cartitem.setQuantity(Integer.toString(c));
				}
			}
		}
	}

	void showCart() {
		for (Item item : cartList) {
			System.out.println(item.getName() + " " + item.getQuantity());
			//System.out.println(item);
		}

	}

	void showCatalog() {
		for (Item item : catalogList) {
			System.out.println(item.getName() + " " + item.getQuantity() + " " + Double.parseDouble(item.getPrice()));
			//System.out.println(item);
		}
	}

	float getTotalAmount() {
		float amount = 0;
		for (Item cartitem : cartList) {
			for (Item catalogitem : catalogList) {
				if ((cartitem.getName()).equals(catalogitem.getName())) {
					float a = Integer.parseInt(cartitem.getQuantity());
					float b = Integer.parseInt(catalogitem.getPrice());
					float c = a * b;
					amount = amount + c;
				}
			}
		}
		return amount;
		//System.out.println("totalAmount: " + amount);
	}

	float getPayableAmount() {
		float payableAmt = 0;
		float amt = getTotalAmount();
		float dscnt = (coupon * amt) / 100;
		float finalAmt = amt - dscnt;
		float tax = (15 * finalAmt) / 100;
		payableAmt = finalAmt + tax;
		return payableAmt;
	}

	boolean applyCoupon(String key) {
		String[] cou = key.split("D");
		int value = Integer.parseInt(cou[1]);
		if (value == 10 || value == 20 || value == 30 || value == 50) {
			coupon = value;
			flag = true;
			return flag;
		}
		System.out.println("Invalid coupon");
		return flag;
	}

	void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (Item cartitem : cartList) {
			for (Item catalogitem : catalogList) {
				if ((cartitem.getName()).equals(catalogitem.getName())) {
					String a = cartitem.getName();
					String b = cartitem.getQuantity();
					float c = Float.parseFloat(catalogitem.getPrice());
					System.out.println(a + " " + b + " " + c);
				}
			}
		}
		float total = getTotalAmount();
		System.out.println("Total:" + total);
		System.out.println("Disc%:" + 0.01f * coupon * total);
		System.out.println("Tax:" + 0.15f * total);
		System.out.println("Payable amount: " + getPayableAmount());
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
				System.out.println("totalAmount: " + sc.getTotalAmount());
				break;

			case "payableAmount":
				System.out.println("Payable amount: " + sc.getPayableAmount());
				break;
			case "remove":
				String[] c3 = tokens[1].split(",");
				sc.removeFromCart(new Item(c3[0], c3[1], null));
				break;

			case "coupon":
				sc.applyCoupon(tokens[1]);
				break;
			case "print":
				sc.printInvoice();
				break;
			}
		}
	}
}