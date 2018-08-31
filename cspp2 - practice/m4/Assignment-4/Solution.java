
import java.util.Scanner;
public class Solution {
	/*
	Do not modify the main function
	*/
	public static String reverseString(String str) {
		int len = str.length();
		String reverse = " ";
		for (int i = len - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		return reverse;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String reverse = reverseString(s);
		System.out.println(reverse);

	}
	//Write reverseString function

}
