
import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			long res = binaryToDecimal(s); //Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static long binaryToDecimal(final String str) {
		int len = str.length();
		int sum = 0;
		int j = 0;
		for (int i = len - 1; i >= 0; i--) {
			sum += Character.getNumericValue(str.charAt(i)) * (Math.pow(2, j));
			j++;
		}
		return sum;
	}

}
