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

	//catalogitem = logitem
	//cartitem = caitem
	void addToCart(Item item1) {
		for (Item logitem : catalogList) {
			if ((logitem.getName()).equals(item1.getName())) {
				for (Item caitem : cartList) {
					if ((caitem.getName()).equals(item1.getName())) {
						int a = Integer.parseInt(caitem.getQuantity());
						int b = Integer.parseInt(item1.getQuantity());
						int c = a + b;
						caitem.setQuantity(Integer.toString(c));
						return;
					}
				}
				cartList.add(item1);
				return;
			}
		}
	}

	//cartitem = p
	void removeFromCart(Item item2) {
		int i = 0;
		boolean flag = false;
		for (Item p : cartList) {
			if ((p.getName()).equals(item2.getName())) {
				int a = Integer.parseInt(p.getQuantity());
				int b = Integer.parseInt(item2.getQuantity());
				int c = a - b;
				if (c == 0) {
					flag = true;
				} else {
					p.setQuantity(Integer.toString(c));
				}
				break;
			}
			i++;
		}
		if (flag) cartList.remove(i);
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

	//cartitem = x
	//catalogitem = y
	float getTotalAmount() {
		float amount = 0;
		for (Item x : cartList) {
			for (Item y : catalogList) {
				if ((x.getName()).equals(y.getName())) {
					float a = Integer.parseInt(x.getQuantity());
					float b = Integer.parseInt(y.getPrice());
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

	//cartitem = cart
	//catalogitem = catalog
	void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (Item cart : cartList) {
			for (Item catalog : catalogList) {
				if ((cart.getName()).equals(catalog.getName())) {
					String a = cart.getName();
					String b = cart.getQuantity();
					float c = Float.parseFloat(catalog.getPrice());
					System.out.println(a + " " + b + " " + c);
				}
			}
		}
		float total = getTotalAmount();
		System.out.println("Total:" + total);
		float disc = 0.01f * coupon * total;
		System.out.println("Disc%:" + Math.round(disc * 100.0) / 100.0);
		System.out.println("Tax:" + Math.round(0.15f * (total - disc) * 100.0) / 100.0);
		System.out.println("Payable amount: " + getPayableAmount());
	}
}
