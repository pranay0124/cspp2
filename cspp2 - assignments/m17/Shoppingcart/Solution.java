import java.util.Scanner;

/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//Zero Parameter Constructor.
	}
	public static void main(String[] args) {
		ShoppingCart sc = new ShoppingCart();
		Scanner scan = new Scanner(System.in);
		boolean a = false;
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
				if (a == false) {
					if (sc.applyCoupon(tokens[1])) {
						a = true;
					}
				}
				break;
			case "print":
				sc.printInvoice();
				break;
			}
		}
	}
}